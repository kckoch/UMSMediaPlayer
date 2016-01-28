package cpsc3720;

import java.awt.PageAttributes.MediaType;
import java.io.IOException;
import java.util.ArrayList;

import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class SOAP {

	static String SOAPString = "<?xml version=\"1.0\" encoding=\"utf-8\" standalone=\"yes\"?>"+
"<s:Envelope s:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\"" +
"	xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\">" +
"	<s:Body>" +
"		<u:Browse xmlns:u=\"urn:schemas-upnp-org:service:ContentDirectory:1\">" +
"			<ObjectID>{OBJECT_ID}</ObjectID>" +
"			<BrowseFlag>BrowseDirectChildren</BrowseFlag>" +
"			<Filter></Filter>" +
"			<StartingIndex>0</StartingIndex>" +
"			<RequestedCount>999</RequestedCount>" +
"			<SortCriteria></SortCriteria>" +
"		</u:Browse>" +
"	</s:Body>" +
"</s:Envelope>";

	public ArrayList<Object>  browse(String objectId, String URL) throws IOException{
		
		System.err.println("Sending request for container ID: " + objectId);
		System.out.println(URL);
		String soapMsg = SOAPString.replace("{OBJECT_ID}", objectId);

		okhttp3.MediaType XML = okhttp3.MediaType.parse("text/xml; charset=utf-8");
		RequestBody body = RequestBody.create(XML, soapMsg);
		Request request = new Request.Builder()
			.url(URL)
			.header("Soapaction", "\"urn:schemas-upnp-org:service:ContentDirectory:1#Browse\"")
			.post(body)
			.build();
		
		OkHttpClient client = new OkHttpClient();
		Response response = client.newCall(request).execute();
		String asdf = " ";
		return null;
	}
	
	public static ArrayList<Container> getItems(String msg, String txt) {
		ArrayList<Container> cont = new ArrayList<Container>();
		int index=0;
		while (index !=-1){
			String IDstr, PIDstr, ChStr, Title, Url;
			int id, pid, childCount;
			pid = 0;

			index = msg.indexOf("<container id=", index);
			if (index !=-1){			
				IDstr = msg.substring(index+14, index+20);
				String intValue = IDstr.replaceAll("[^0-9]", "");
				//System.out.println(intValue);
				id = Integer.parseInt(intValue);

				index = msg.indexOf("childCount=", index);
				ChStr = msg.substring(index+11, index+15);
				intValue = ChStr.replaceAll("[^0-9]", "");
				//System.out.println(intValue);
				childCount = Integer.parseInt(intValue);

				
				index = msg.indexOf("title>", index);
				Title = msg.substring(index+6, msg.indexOf("</dc:title>", index));
				//System.out.println(Title);
				
				Url = "";
			
				Container newContainer = new Container(id, pid, childCount, Title, Url);
				cont.add(newContainer);
			}
		
		}
		
		index = 0;
		while (index !=-1){
			String IDstr, PIDstr, Title, url;
			int id, pid, childCount;
			index = msg.indexOf("item id=", index);				
			if (index !=-1){

				System.out.println("index2 " +index);
				IDstr = msg.substring(index+7, index+12);
				String intValue = IDstr.replaceAll("[^0-9]", "");
				System.out.println(intValue);
				id = Integer.parseInt(intValue);
				
				System.out.println("index3 " +index);
				childCount = 0;
				
				index = msg.indexOf("parentID=", index);
				System.out.println("index4 " +index);
				PIDstr = msg.substring(index+9, index+14);
				intValue = PIDstr.replaceAll("[^0-9]", "");
				System.out.println(intValue);
				pid = Integer.parseInt(intValue);
				
				index = msg.indexOf("title>", index);
				System.out.println("index5 " +index);
				Title = msg.substring(index+6, msg.indexOf("</dc:title>", index));
				System.out.println(Title);
				
				index = msg.indexOf(">http://127.0.0.1:5001", index);
				url = txt;
				
				Container newContainer = new Container(id, pid, childCount, Title, url);
				cont.add(newContainer);
			
			}
		}
		for (int i=0; i<cont.size(); i++){
			System.out.println(cont.get(i).getTitle() + " " + cont.get(i).getID() + " " + cont.get(i).getChildCount() + " " +cont.get(i).getPid());
		}
		return cont;
	}
}
