package kr.ggogun.ttstest;

import java.util.Locale;

import kr.ggogun.ttstest.R.id;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TTSTestActivity extends Activity implements OnInitListener {
    /** Called when the activity is first created. */
   
    
    EditText read_text;
    Button read_button;
    TextToSpeech mTts;
    TextView tv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Log.w("PBS","Start App Activity");
        
      
        
        read_text = (EditText)findViewById(R.id.RText);
        read_button = (Button)findViewById(R.id.read);
        tv = (TextView)findViewById(R.id.text);
        
        mTts = new TextToSpeech(this, this);
      
       
        
        read_button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
					
				
				if(read_text.getText().toString().equals("")){
					// Check for Empty EditText
					Log.e("PBS","Text is null");
					
					Toast toast = Toast.makeText(getApplicationContext(), "EditText is Empty\nPlease typing Text", Toast.LENGTH_LONG);
					toast.show();
					mTts.speak("EditText is Empty Please typing Text", TextToSpeech.QUEUE_FLUSH, null);
				}else{
					
					mTts.speak(read_text.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
				}
				tv.setText(read_text.getText().toString());

			}
		});
        
    }

	@Override
	public void onInit(int status) {
		// TODO Auto-generated method stub
		 if (status == TextToSpeech.SUCCESS) {
	           
	           int result = mTts.setLanguage(Locale.US);
	           
	           
	           if (result == TextToSpeech.LANG_MISSING_DATA ||
	               result == TextToSpeech.LANG_NOT_SUPPORTED) {
	              // Lanuage data is missing or the language is not supported.
	               Log.e("PBS", "Language is not available.");
	           } else {
	        	   Log.w("PBS", "Language is available and can read Text");
	               
	              
	           }
	       } else {
	           // Initialization failed.
	           Log.e("PBS", "Could not initialize TextToSpeech.");
	       }
	   
	}
}