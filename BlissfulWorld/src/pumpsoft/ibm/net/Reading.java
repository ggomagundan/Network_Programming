package pumpsoft.ibm.net;

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

public class Reading {
	// JSON Parsing 
	// References By
	// http://damonsk.com/2010/01/jsonarray-httpclient-android/

	public JSONArray getText(String url) {
		JSONArray suggestions = null;

		// Create the http client
		HttpClient httpclient = new DefaultHttpClient();

		// Prepare a request object
		HttpGet httpget = new HttpGet(url);

		// Execute the request
		HttpResponse response;

		// return string
		@SuppressWarnings("unused")
		String returnString = null;

		try {
			// Open the webpage.
			response = httpclient.execute(httpget);

			if(response.getStatusLine().getStatusCode() == 200) {
				// Connection was established. Get the content.

				HttpEntity entity = response.getEntity();
				// If the response does not enclose an entity, there is no need
				// to worry about connection release

				if (entity != null) {
					// A Simple JSON Response Read
					InputStream instream = entity.getContent();

					// Load the requested page converted to a string into a JSONObject.
					JSONObject myAwway = new JSONObject(convertStreamToString(instream));
					suggestions = myAwway.getJSONArray("data");

					returnString = myAwway.toString();
					// Get JSON String Data

					instream.close();
				}
			} else {
				// code here for a response other than 200.  A response 200 means the webpage was OK
				// Other codes include 404 - not found, 301 - redirect etc...
				// Display the response line.
				returnString = "Unable to load page - " + response.getStatusLine();
			}
		} catch (IOException  ex) {
			// thrown by line 80 - getContent();
			// Connection was not established
			returnString = "Connection failed; " + ex.getMessage();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return suggestions;
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
