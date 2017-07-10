package com.example.pgh.API;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import android.util.Log;

public class HTTPCall {
	 public static String convertToString (InputStream is) 
	 {

	        BufferedReader reader;

	        try {
	            reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
	            StringBuilder builder = new StringBuilder();
	            String line = null;

	            while ( (line = reader.readLine()) != null  ) 
	            {
	                builder.append(line +"\n");
	            }

	            return builder.toString();

	        }
	        catch (UnsupportedEncodingException e) 
	        {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	            Log.d("HTTPCALL", e.getMessage());
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	            Log.d("HTTPCALL", e.getMessage());
	        }
	        return null;

	    }
	    public static String postData (String url, ArrayList<NameValuePair> nameValuePairs) {

	        String result = null;

	        try {

	            HttpClient httpClient = new DefaultHttpClient();  // get the default http client
	            HttpPost request = new HttpPost(url);
	            request.setEntity(new UrlEncodedFormEntity(nameValuePairs));
	            HttpResponse response = httpClient.execute(request);
	            InputStream content = response.getEntity().getContent();
	            result = convertToString(content);
	            content.close();

	        } catch (ClientProtocolException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	            Log.d("HTTPCALL", e.getMessage());
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	            Log.d("HTTPCALL", e.getMessage());
	        }

	        return result;

	    }

	    public static String getData (String url) {

	        String result = null;

	        try {

	            HttpClient httpClient = new DefaultHttpClient();  // get the default http client
	            HttpGet request = new HttpGet(url);
	            HttpResponse response = httpClient.execute(request);
	            InputStream content = response.getEntity().getContent();
	            result = convertToString(content);
	            content.close();

	        } catch (ClientProtocolException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	            Log.d("HTTPCALL", e.getMessage());
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	            Log.d("HTTPCALL", e.getMessage());
	        }
	        return result;

	    }


}
