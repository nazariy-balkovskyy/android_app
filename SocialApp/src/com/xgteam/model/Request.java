package com.xgteam.model;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class Request {
	public static JSONObject forge(String url){
		Log.i("URL_STRING", url);
		HttpClient httpClient = new DefaultHttpClient();  
		HttpGet httpGet = new HttpGet(url);
		JSONObject jObject=new JSONObject();
		try {
		    HttpResponse response = httpClient.execute(httpGet);		    
		    HttpEntity entity = response.getEntity();
		    ByteArrayOutputStream out = new ByteArrayOutputStream();
		    entity.writeTo(out);
	        out.close();
	        String responseStr = out.toString();
	        Log.i("MESSAGE", responseStr);
		        try {
					jObject = new JSONObject(responseStr);
				} catch (JSONException e) {
					e.printStackTrace();
				}
		} catch (ClientProtocolException e) {

		} catch (IOException e) {
			
		}
		return jObject;
	}
}
