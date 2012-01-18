package kr.ggogun.imgurl;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class LoadURLImageActivity extends Activity {
    /** Called when the activity is first created. */
	 ImageView imgs;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        imgs = (ImageView)findViewById(R.id.img);
        imgs.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				 set();
			}
		});
        
       
        
       
        
        
    }

	private void set() {
		// TODO Auto-generated method stub
		

			URL imageURL;

			try {
				imageURL = new URL("http://211.109.180.43:9080/Image/76_4_18_25.jpg");

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
			} catch (Exception e){
				Log.d("PBS",e.toString());
			}
	}
}