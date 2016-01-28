package cpsc3720;


import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;



public class OkHttpDemo {

	public static void main(String[] args) throws IOException {

		Request request = new Request.Builder()
				.url("https://openlibrary.org/search.json?q=java").get()
				.build();

		OkHttpClient client = new OkHttpClient();

		System.out.println("Sending request...");
		Response response = client.newCall(request).execute();

		System.out.println("Response code: " + response.code());
		System.out.println("Data:\n" + response.body().string());
	}
}
