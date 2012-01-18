package kr.ggogun.audio;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;

public class AudiotestActivity extends Activity {
    /** Called when the activity is first created. */
	MediaPlayer mp;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button b1 = (Button)findViewById(R.id.play1);
//        b1.setOnClickListener(new Button.OnClickListener() {
//        	public void onClick(View v) {
//        		 mp = MediaPlayer.create(AudiotestActivity.this, R.raw.song1);
//        		mp.start();
//        		mp.setOnCompletionListener(new OnCompletionListener() {
//        			public void onCompletion(MediaPlayer arg0) { 
//        				Toast.makeText(getApplicationContext(),"Happy Hollidays!",Toast.LENGTH_LONG).show(); 
//        				mp.stop();
//        			}
//        		});
//        		//mp.release();
//        	}
//        });
//        
//       
        
      
        
        
        
        
        
        
        
        
        
        
        
    }
}


