package kr.ggogun.json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class Reading {


	// JSON Parsing 
	// References By
	// http://damonsk.com/2010/01/jsonarray-httpclient-android/

	public JSONArray getText(String url){
		

		JSONArray suggestions = null;

		// Create the httpclient
		HttpClient httpclient = new DefaultHttpClient();

		// Prepare a request object
		HttpGet httpget = new HttpGet(url);

		// Execute the request
		HttpResponse response;

		// return string
		String returnString = null;

		try {

			// Open the webpage.
			response = httpclient.execute(httpget);

			if(response.getStatusLine().getStatusCode() == 200){
				// Connection was established. Get the content.

				HttpEntity entity = response.getEntity();
				// If the response does not enclose an entity, there is no need
				// to worry about connection release

				if (entity != null) {
					// A Simple JSON Response Read
					InputStream instream = entity.getContent();

					// Load the requested page converted to a string into a JSONObject.
					Log.d("PBS","JSONOBJECT parsing");
					JSONObject myAwway = new JSONObject(convertStreamToString(instream));
					Log.d("PBS","JSONOBJECT : " + myAwway.toString());
					suggestions = myAwway.getJSONArray("data");
					
					
					

					returnString = myAwway.toString();
					// Get JSON String Data



					instream.close();
				}
			}
			else {
				// code here for a response other than 200.  A response 200 means the webpage was ok
				// Other codes include 404 - not found, 301 - redirect etc...
				// Display the response line.
				returnString = "Unable to load page - " + response.getStatusLine();
			}
		}
		catch (IOException  ex) {
			// thrown by line 80 - getContent();
			// Connection was not established
			returnString = "Connection failed; " + ex.getMessage();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return suggestions;

	}


	public String connect(String str){

		String returnString;

		try {



			JSONObject myAwway = new JSONObject(str);
			// make Received JSON Object
			Log.d("PBS","JSONOBJECT : " + myAwway.toString());

			
			returnString = "id -> " + myAwway.getString("content") + ", ";
//			returnString += "user_id -> " + myAwway.getString("user_id") + ", ";
//			returnString += "title -> " + myAwway.getString("title") + ", ";
//			returnString += "time -> " + myAwway.getString("time") + ", ";
//			returnString += "rc -> " + myAwway.getString("rc") + ", ";
//			returnString += "oc -> " + myAwway.getString("oc") + ", ";
//			returnString += "rownum -> " + myAwway.getString("rownum") + "\n";
			// Get Values By Map's Key

			// Make array of the suggestions
			//  JSONArray suggestions = myAwway.getJSONArray("suggestions");

			// Build the return string.
			//  returnString = "Found: " + suggestions.length() + " locations for " + query;
			//  for (int i = 0; i < suggestions.length(); i++) {
			//      returnString += "\n\t" + suggestions.getString(i);
			//  }

			// if receive JSON Array, Using this Source 



		}
		catch (JSONException ex){
			// JSON errors
			returnString = "JSON failed; " + ex.getMessage();
		}
		return returnString;
	}

	private static String convertStreamToString(InputStream is) {
		/*
		 * To convert the InputStream to String we use the BufferedReader.readLine()
		 * method. We iterate until the BufferedReader return null which means
		 * there's no more data to read. Each line will appended to a StringBuilder
		 * and returned as String.
		 */
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();

		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}

}
