package cpsc3720;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3. *;

public class SOAP {
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
	public void getId() throws IOException {
		String objectId = "0";
		
		System.err.println("Sending request for container ID: " + objectId);
	
		String soapMsg = SOAP.replace("{OBJECT_ID}", objectId);
	
		okhttp3.MediaType XML = okhttp3.MediaType.parse("text/xml; charset=utf-8");
		RequestBody body = RequestBody.create(XML, soapMsg);
		Request request = new Request.Builder()
			.url("http://127.0.0.1:5001/upnp/control/content_directory")
			.header("Soapaction", "\"urn:schemas-upnp-org:service:ContentDirectory:1#Browse\"")
			.post(body)
			.build();
		
		OkHttpClient client = new OkHttpClient();
		Response response = client.newCall(request).execute();
		
		if (response.code() == 200) {
			String resultStr = response.body().string();
			processResults(resultStr);
		} else {
			System.err.println("Response code: " + response.code());
			System.err.println("Response: " + response.message());
		}		
		
	}
	
	static void processResults(String soapResponse) {
		final String START_TAG = "<Result>";
		final String END_TAG = "</Result>";
		int startIndex = soapResponse.indexOf(START_TAG) + START_TAG.length();
		int endIndex = soapResponse.indexOf(END_TAG);
		String resultStr = soapResponse.substring(startIndex, endIndex);
		
		resultStr = resultStr.replace("&lt;", "<").replace("&gt;",">");
		
		System.out.println(resultStr);		
	}
	
	public static ArrayList<Object> getItems(String msg, String txt) {
		return new ArrayList<Object>();
	}
}
