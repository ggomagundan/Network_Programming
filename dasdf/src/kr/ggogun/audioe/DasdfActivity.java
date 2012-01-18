package kr.ggogun.audioe;



import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DasdfActivity extends Activity {
    /** Called when the activity is first created. */
	MediaPlayer mp;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
       Button b1 = (Button)findViewById(R.id.play1);
       Button b2 = (Button)findViewById(R.id.play2);
      b1.setOnClickListener(new Button.OnClickListener() {
      	public void onClick(View v) {
      		 mp = MediaPlayer.create(DasdfActivity.this, R.raw.song1);
      		mp.start();
      		mp.setOnCompletionListener(new OnCompletionListener() {
      			public void onCompletion(MediaPlayer arg0) { 
      				Toast.makeText(getApplicationContext(),"Happy Hollidays!",Toast.LENGTH_LONG).show(); 
      				mp.start();
      			}
      		});
      		mp.release();
      		
      	}
      });
      
      
      
      b2.setOnClickListener(new Button.OnClickListener() {
        	public void onClick(View v) {
        		Toast.makeText(getApplicationContext(),"Happy Hollidays!",Toast.LENGTH_LONG).show(); 
        		
        		mp.stop();
        		mp.release();
        	}
        });
        
     
    }
}