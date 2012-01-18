package kr.ggogun.json;

import org.apache.http.HttpConnection;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class JsonREadActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		Reading reads = new Reading();				// Server -> JSON Data Reading Object
		//Send send = new Send();						// Device -> JSON Data Sending Object



		TextView tv = (TextView)findViewById(R.id.tv);
		TextView js = (TextView)findViewById(R.id.jsonstr);

		
		ddef.setId("wer");
		Log.d("PBS",ddef.getId());

		//String jsonData = reads.getText("http://211.109.180.43:9080/SampleWeb/JSON");
		// Get JSON Data And Translate String Type
		JSONArray jsonData = reads.getText("http://211.109.180.43:9080/LoginWeb/Login?id=park&passwd=kikiki");
		// Send Data And Get JSONArray
		
		
		
		js.setText("JSON Data :  \n" + jsonData + "\n");
		// Print JSON Data To 'js' 
		
		String result = "";
		
		// Split Data Using JsonArray(Using connect Method)
//		for(int i =0;i < jsonData.length();i++){
//			try {
//				result += reads.connect(jsonData.getString(i));
//			} catch (JSONException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		
//		tv.setText(result);
		// Split JSON Data By Map's Key

		
		
		
		
		
		
		
		
		
		
		/*
		WebView wv = (WebView)findViewById(R.id.web);
		wv.getSettings().setJavaScriptEnabled(true);
		wv.loadUrl("http://211.109.180.43:9080/SampleWeb/JGet");
		*/
		// Seding JSON Data And Check Sendig Data

		
		
		
		
		
		
		
		

	}



	 
	
	


// Temporary JSON Parsing Soure
	
	
	// JSON Parsing 
	// References By
	// http://p-xr.com/android-tutorial-how-to-parse-read-json-data-into-a-android-listview/

	/*
    public static JSONObject getJSONfromURL(String url){

    	//initialize
    	InputStream is = null;
    	String result = "";
    	JSONObject jArray = null;

    	//http post
    	try{
    		HttpClient httpclient = new DefaultHttpClient();
    		HttpPost httppost = new HttpPost(url);
    		HttpResponse response = httpclient.execute(httppost);
    		HttpEntity entity = response.getEntity();
    		is = entity.getContent();

    	}catch(Exception e){
    		Log.e("PBS", "Error in http connection "+e.toString());
    	}

    	//convert response to string
    	try{
    		BufferedReader reader = new BufferedReader(new InputStreamReader(is,"euc-kr"),8);
    		StringBuilder sb = new StringBuilder();
    		String line = null;

    		Log.d("PBS","JSON OBJECT startqqq "+ reader.readLine());
    		while ((line = reader.readLine()) != null) {
    			Log.d("PBS","JSON OBJECT start "+ line);
    			sb.append(line + "\n");
    			Log.d("PBS","JSON OBJECT startss "+ sb);
    		}
    		is.close();
    		result=sb.toString();
    	}catch(Exception e){
    		Log.e("PBS", "Error converting result "+e.toString());
    	}
    	Log.d("PBS","JSON OBJECT is "+ result);
    	//try parse the string to a JSON object
    	try{
            	jArray = new JSONObject(result);
    	}catch(JSONException e){
    		Log.e("PBS", "Error parsing data "+e.toString());
    	}

    	Log.d("PBS","JSON OBJECT is1 "+ result);
    	return jArray;
    }*/

}