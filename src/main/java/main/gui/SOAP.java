package main.gui;

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
	
	static void processResults(String soapResponse) {
		//parsing normal containers
		final String START_TAG = "<Result>";
		final String END_TAG = "</Result>";
		final String ID_START = "<container id=\"";
		final String TITLE_START = "<dc:title>";
		final String TITLE_END = "</dc:title>";
		//parsing mp3
		final String SONG_ID_START = "<item id=\"";
		final String ARTIST_START = "<upnp:artist>";
		final String ARTIST_END = "</upnp:artist>";
		final String URL_START = "</res>";
		int id = 0;
		int start = 0;
		int end = 0;
		String title = "";
		int startIndex = soapResponse.indexOf(START_TAG) + START_TAG.length();
		int endIndex = soapResponse.indexOf(END_TAG);
		String resultStr = soapResponse.substring(startIndex, endIndex);
		resultStr = resultStr.replace("&lt;", "<").replace("&gt;",">");
	    /*
		while(resultStr.length() > 0) {
			idStartIndex = resultStr.indexOf(ID_START) + ID_START.length();
			idEndIndex = idStartIndex + 2;
			id = Integer.parseInt(resultStr.substring(idStartIndex, idEndIndex));
			
			titleStartIndex = resultStr.indexOf(TITLE_START) + TITLE_START.length();
			titleEndIndex = resultStr.indexOf(TITLE_END);
			title = resultStr.substring(titleStartIndex, titleEndIndex);

            resultStr = resultStr.substring(titleEndIndex + 50);
            if(resultStr.indexOf(ID_START) < 0)
                resultStr = "";
            list.add(new Container(id, title));
		}
		
		*/
		int index=0;
		while (index !=-1){
			String tempid;

			index = resultStr.indexOf("<container id=", index);
			if (index !=-1){			
				tempid = resultStr.substring(index+14, index+20);
				String intValue = tempid.replaceAll("[^0-9]", "");
				id = Integer.parseInt(intValue);
				
				index = resultStr.indexOf("title>", index);
				title = resultStr.substring(index+6, resultStr.indexOf("</dc:title>", index));

				list.add(new Container(id, title));
			}
		
		}
		
		index = 0;
		while (index !=-1){
			String tempid, artist, url;
			index = resultStr.indexOf("item id=", index);
			tempid = resultStr.substring(index+7, index+12);
			String intValue = tempid.replaceAll("[^0-9]", "");
			id = Integer.parseInt(intValue);
			
			index = resultStr.indexOf("title>", index);
			title = resultStr.substring(index+6, resultStr.indexOf("</dc:title>", index));
			System.out.println(title);

			/*
			start = resultStr.indexOf(ARTIST_START + ARTIST_START.length());
			end = resultStr.indexOf(ARTIST_END);
			artist = resultStr.substring(start, end);
			System.out.println(artist);*/
			
			index = resultStr.indexOf(">http://127.0.0.1:5001", index);
			start = resultStr.lastIndexOf("\">", resultStr.indexOf(URL_START)) + "\">".length();
			end = resultStr.indexOf("</res");
			url = resultStr.substring(start, end);
			System.out.println(url);
			
			list.add(new Container(id, title));
		}
        return;
	}
	
	static ArrayList<Container> getList() {
		return list;
	}
}
