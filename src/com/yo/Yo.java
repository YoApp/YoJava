package com.yo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

public class Yo {
	private String server = "http://api.justyo.co/";
	private String apikey;

	private final String USER_AGENT = "Mozilla/5.0";

	private HttpClient client = HttpClientBuilder.create().build();
	
	public Yo(String apikey) {
		this.apikey = apikey;
	}

	public void yoall() throws Exception {
		String request = server + "yoall/";
		
		HttpPost post = new HttpPost(request);
		post.addHeader("User-Agent", USER_AGENT);
		
		List<NameValuePair> params = new ArrayList<NameValuePair>(1);
		params.add(new BasicNameValuePair("api_key", apikey));
		
		post.setEntity(new UrlEncodedFormEntity(params));
		
		HttpResponse res = client.execute(post);
		System.out.println("Response Code: " + res.getStatusLine().getStatusCode());
		
		BufferedReader rd = new BufferedReader(new InputStreamReader(res.getEntity().getContent()));
		StringBuffer result = new StringBuffer();
		String ln = "";
		while ((ln = rd.readLine()) != null) result.append(ln);
		
		System.out.println(result.toString());
	}
}
