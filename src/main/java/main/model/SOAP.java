/*
 * This is the only class that directly interacts with the UPNP server.
 * Sends and Reads messages to/from the server
 */
package main.model;

import java.io.IOException;
import java.util.*;


import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class SOAP {
    private static ArrayList<Container> list = new ArrayList<Container>();
	static String SOAP = "<?xml version=\"1.0\" encoding=\"utf-8\" standalone=\"yes\"?>"+
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
	
	/*
	 * Sends a request to the server for a certain container of a given objID
	 */
	public static void sendRequest(String objID) throws IOException{
		String objectId = objID;

		String soapMsg = SOAP.replace("{OBJECT_ID}", objectId);

		MediaType XML = MediaType.parse("text/xml; charset=utf-8");
		RequestBody body = RequestBody.create(XML, soapMsg);
		Request request = new Request.Builder()
			.url("http://127.0.0.1:5001/upnp/control/content_directory")
			.header("Soapaction", "\"urn:schemas-upnp-org:service:ContentDirectory:1#Browse\"")
			.post(body)
			.build();
		
		OkHttpClient client = new OkHttpClient();
		Response response = client.newCall(request).execute();
		
		if (response.code() == 200) {
			list.clear();
			String resultStr = response.body().string();
			processResults(resultStr);
		} else {
			System.err.println("Response code: " + response.code());
			System.err.println("Response: " + response.message());
		}		
		
	}
	
	/*
	 * Reads in the response and extracts the relevant information
	 * Will update the internal ArrayList
	 */
	static void processResults(String soapResponse) {
		final String START_TAG = "<Result>";
		final String END_TAG = "</Result>";
		final String URL_START = "</res>";
		int id = 0;
		int pid = 0;
		int start = 0;
		int end = 0;
		String title = "";
		String url = "";
		int startIndex = soapResponse.indexOf(START_TAG) + START_TAG.length();
		int endIndex = soapResponse.indexOf(END_TAG);
		String resultStr = soapResponse.substring(startIndex, endIndex);
		resultStr = resultStr.replace("&lt;", "<").replace("&gt;",">");
		int index=0;
		
		while (index !=-1){
			String tempid;
			
			index = resultStr.indexOf("<container id=", index);
			if (index != -1){			
				tempid = resultStr.substring(index+14, index+20);
				String intValue = tempid.replaceAll("[^0-9]", "");
				id = Integer.parseInt(intValue);
				
				index = resultStr.indexOf("title>", index);
				title = resultStr.substring(index+6, resultStr.indexOf("</dc:title>", index));

				list.add(new Container(id, pid, 0, "", title, ""));
			}
		}
		
		index = 0;
		while (index != -1){
			String tempid, temppid, artist;
			long duration = 0;
			index = resultStr.indexOf("item id=", index);
			tempid = resultStr.substring(index+7, index+12);
			String intValue = tempid.replaceAll("[^0-9]", "");
			id = Integer.parseInt(intValue);
			
			index = resultStr.indexOf("parentID=", index);
			temppid = resultStr.substring(index+9, index+14);
			intValue = temppid.replaceAll("[^0-9]", "");
			pid = Integer.parseInt(intValue);
			
			index = resultStr.indexOf("title>", index);
			title = resultStr.substring(index+6, resultStr.indexOf("</dc:title>", index));

			start = resultStr.indexOf("upnp:artist>", index) + "upnp:artist>".length();
			end = resultStr.indexOf("</upnp:artist>", start);
			artist = resultStr.substring(start, end);
			
			start = resultStr.indexOf("duration=", index) + "duration=".length() + 1;
			end = resultStr.indexOf("\"", start);
			String dur = resultStr.substring(start, end);
			int hours = Integer.parseInt(dur.substring(0, 2));
			int min = Integer.parseInt(dur.substring(3, 5));
			double seconds = Double.parseDouble(dur.substring(6));
			duration = (long)hours*3600 + (long)min*60 + (long)Math.round(seconds);
			
			index = resultStr.indexOf(">http://127.0.0.1:5001", index);
			start = resultStr.lastIndexOf("\">", resultStr.indexOf(URL_START)) + "\">".length();
			end = resultStr.indexOf("</res");
			url = resultStr.substring(start, end);
			
			list.add(new Container(id, pid, duration, url, title, artist));
		}
        return;
	}
	
	/*
	 * Allows for the calling classes to have access to the updated ArrayList
	 */
	public static ArrayList<Container> getList() {
		return list;
	}
}
