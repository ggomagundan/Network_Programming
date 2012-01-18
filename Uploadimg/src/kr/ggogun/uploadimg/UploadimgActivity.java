package kr.ggogun.uploadimg;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

public class UploadimgActivity extends Activity {
	
	String lineEnd = "\r\n";
	String twoHyphens = "--";
	String boundary = "*****";	
	  InputStream is;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		  //super.onCreate(icicle);
		

		      
	        setContentView(R.layout.main);
	        //Bitmap bitmapOrg = BitmapFact0ory.decodeResource(getResources(),
	        //R.drawable.a1);
	        Bitmap bitmapOrg = BitmapFactory.decodeFile("/sdcard/dcim/camera/11.jpg");
//	        ByteArrayOutputStream bao = new ByteArrayOutputStream();
//	        bitmapOrg.compress(Bitmap.CompressFormat.JPEG, 90, bao);
//	        byte [] ba = bao.toByteArray();
//	       
//	        String ba1 = null;
//	        ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
//	        nameValuePairs.add(new BasicNameValuePair("image",ba1));
//	        try
//	        {
//	             ba1=Base64.encodeBytes(ba);
//
//	            HttpClient httpclient = new DefaultHttpClient();
//	            HttpPost httppost = new
//	            HttpPost("http://211.109.180.43:9080/Image/ImageUpload");
//	            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
//	            HttpResponse response = httpclient.execute(httppost);
//	            HttpEntity entity = response.getEntity();
//	            is = entity.getContent();
//	            Log.d("PBS","end");
//	        }catch(Exception e){
//	            Log.e("log_tag", "Error in http connection "+e.toString());
//	        }
	    }

}

	












