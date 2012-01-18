package kr.ggogun.postdata;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.StringTokenizer;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.ByteArrayBody;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
	 
	public class PostdataActivity extends Activity {
	    Bitmap bm;
	    TextView tv;
	    private String selectedImagePath;
	    private ImageView img;
	    private static final int SELECT_PICTURE = 1;
	    String imgPath="";
	    String filename;
	    /** Called when the activity is first created. */
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.main);
	        tv = (TextView)findViewById(R.id.text);
	       img = (ImageView)findViewById(R.id.ImageView01);
			ImageView imgs = (ImageView)findViewById(R.id.ImageView02);
			
			URL imageURL;
			try {
				imageURL = new URL("http://211.109.180.43:9080/Image/first_1.png");
				HttpURLConnection conn = (HttpURLConnection)imageURL.openConnection();            
				BufferedInputStream bis = new BufferedInputStream(conn.getInputStream(), 10240);
				Bitmap bm = BitmapFactory.decodeStream(bis);
				bis.close(); 
				
				imgs.setImageBitmap(bm);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			
			
		
			
			
			
	        ((Button) findViewById(R.id.Button01))
	                .setOnClickListener(new OnClickListener() {
	                    public void onClick(View arg0) {
	                    	imgPath="";
	                        Intent intent = new Intent();
	                        intent.setType("image/*");
	                        intent.setAction(Intent.ACTION_GET_CONTENT);
	                        startActivityForResult(Intent.createChooser(intent,"Select Picture"), SELECT_PICTURE);
	                       
	            	       
	                    }
	                });
	       
	    }
	 
	    public void executeMultipartPost() throws Exception {
	        try {
	        	// Referenced By
	        	// http://blog.daum.net/_blog/BlogTypeView.do?blogid=0I7g7&articleno=7655082#ajax_history_home
	        
	            ByteArrayOutputStream bos = new ByteArrayOutputStream();
	            
	            tv.setText("Ready Files");
	            bm.compress(CompressFormat.JPEG, 60, bos);
	            tv.setText("Sending Files");
	            Log.d("PBS","start");
	            byte[] data = bos.toByteArray();
	            Log.d("PBS",data.toString());
	            HttpClient httpClient = new DefaultHttpClient();
	            HttpPost postRequest = new HttpPost(
	                    "http://211.109.180.43:9080/Image/ImageUpload");
	            ByteArrayBody bab = new ByteArrayBody(data, filename);
	            Log.d("PBS","bab " + bab.toString());
	            // File file= new File("/mnt/sdcard/forest.png");
	            // FileBody bin = new FileBody(file);
	            MultipartEntity reqEntity = new MultipartEntity(
	                    HttpMultipartMode.BROWSER_COMPATIBLE);
	            reqEntity.addPart("uploaded", bab);
	            Log.d("PBS",bab.toString());
	           // reqEntity.addPart("photoCaption", new StringBody("ll"));
	            postRequest.setEntity(reqEntity);
	            Log.d("PBS","Start Sending response");
	            HttpResponse response = httpClient.execute(postRequest);
	            BufferedReader reader = new BufferedReader(new InputStreamReader(
	                    response.getEntity().getContent(), "UTF-8"));
	            String sResponse;
	            StringBuilder s = new StringBuilder();
	 
	            while ((sResponse = reader.readLine()) != null) {
	                s = s.append(sResponse);Log.d("PBS","Response: " + s);
	            }
	            
	            
	        } catch (Exception e) {
	            // handle exception here
	            Log.e(e.getClass().getName(), e.getMessage());
	            Log.d("PBS","Exception  " + e.getMessage());
	        }
	    }
	
	 public void onActivityResult(int requestCode, int resultCode, Intent data) {
		 	// Referenced By
		 	// http://stackoverflow.com/questions/2169649/open-an-image-in-androids-built-in-gallery-app-programmatically
	        if (resultCode == RESULT_OK) {
	            if (requestCode == SELECT_PICTURE) {
	                Uri selectedImageUri = data.getData();
	                selectedImagePath = getPath(selectedImageUri);
	                Log.d("PBS","Image Path : " + selectedImagePath);
	                StringTokenizer tokenizer = new StringTokenizer(selectedImagePath, "/");
	                tokenizer.nextToken();
	                while(tokenizer.hasMoreTokens()){
	                		filename = tokenizer.nextToken();
	                		imgPath += "/"+filename;
	                		
	                	
	                	
	                }
	                	
	                
                    
                    Log.d("PBS", "IMG PATH" + imgPath );
                    Log.d("PBS", "file name : " + filename);
                    try {
                    	
                 	   
                        

        	            bm = BitmapFactory.decodeFile(imgPath);
        	            tv.setText("Working");
        	            executeMultipartPost();
        	            
        	          tv.setText("end");
        	        } catch (Exception e) {
        	            Log.d("PBS",e.getClass().getName()+ " " +  e.getMessage());
        	            
        	            
        	        }
	                img.setImageURI(selectedImageUri);
	            }
	        }
	    }
	 
	    public String getPath(Uri uri) {
	        String[] projection = { MediaStore.Images.Media.DATA };
	        Cursor cursor = managedQuery(uri, projection, null, null, null);
	        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
	        cursor.moveToFirst();
	        return cursor.getString(column_index);
	    }
	}


	














//public class PostdataActivity extends Activity {
//    /** Called when the activity is first created. */
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.main);
//        postData();
//        TextView tv = (TextView)findViewById(R.id.text);
//        tv.setText("end");
//    }
//    
//    public void postData() {
//    	
//    	
//    	       
//		try {
//			HttpClient client = new DefaultHttpClient();  
//	        String postURL = "http://211.109.180.43:9080/Image/ImageUpload";
//	        HttpPost post = new HttpPost(postURL);
//            List<NameValuePair> params = new ArrayList<NameValuePair>();
//            params.add(new BasicNameValuePair("user", "kris"));
//            params.add(new BasicNameValuePair("pass", "xyz"));
//            UrlEncodedFormEntity ent;
//			ent = new UrlEncodedFormEntity(params,HTTP.UTF_8);
//			post.setEntity(ent);
//            HttpResponse responsePOST = client.execute(post);  
//            HttpEntity resEntity = responsePOST.getEntity();  
//            if (resEntity != null) {    
//                Log.i("RESPONSE",EntityUtils.toString(resEntity));
//            }
//		}catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			Log.d("PBS","ioii");
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			Log.d("PBS","iopp");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			Log.d("PBS","io");
//		}
//        
//  
//    	            
//    }
//    	     
//    	
//     
//    
//    
//}