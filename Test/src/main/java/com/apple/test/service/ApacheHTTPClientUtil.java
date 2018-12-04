package com.apple.test.service;


import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

public class ApacheHTTPClientUtil {
	
	public static HttpResponse sendAndReceiveGETResponse(String url) throws ClientProtocolException, IOException {
		HttpClient client = getHTTPClient();
		// create the request msg
		HttpGet request = new HttpGet(url);
		// send and recieve
		HttpResponse response = client.execute(request);
		return response;
		
	}
	
	public static HttpResponse sendAndReceiveGetResponse(String url, String requestMsg) {
		//TODO
		return null;
	}
	
	public static HttpResponse sendAndReceivePOSTResponse(String url, String requestMsg) {
		//TODO
		return null;
	}
	
	
	public static HttpResponse sendAndReceivePUTResponse(String url, String requestMsg) {
		//TODO
		return null;
	}

	private static  HttpClient getHTTPClient() {
		// create http client
		HttpClient client = HttpClientBuilder.create().build();
		return client;
	}
}
