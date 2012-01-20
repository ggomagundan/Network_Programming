package kr.ggogun.floodit;

import java.util.Calendar;

import kr.ggogun.floodit.source.GameManager;

import org.cocos2d.nodes.CCDirector;
import org.cocos2d.opengl.CCGLSurfaceView;
import org.cocos2d.sound.SoundEngine;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Toast;

import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;

public class GameBasicActivity extends Activity {

	private CCGLSurfaceView mGLSurfaceView;
	
	private GameManager gameManager;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
		
		
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		mGLSurfaceView = new CCGLSurfaceView(this);
		setContentView(mGLSurfaceView);
		
//		mGLSurfaceView.setId(1);
//		 int newID = mGLSurfaceView.getId();
//
//		AdView adView = new AdView(this, AdSize.BANNER, "a14f195582c3620");
////         Lookup your LinearLayout assuming it¡¯s been given
////         the attribute android:id="@+id/mainLayout"
//        LinearLayout layout = (LinearLayout)findViewById(newID);
//        // Add the adView to it
//        layout.addView(adView);
//       
//        adView.loadAd(new AdRequest());



    }
	
	
	
	@Override
	public void onStart() {
		super.onStart();

		// attach the OpenGL view to a window
		CCDirector.sharedDirector().attachInView(mGLSurfaceView);

		// show FPS
		CCDirector.sharedDirector().setDisplayFPS(false);

		// frames per second
		CCDirector.sharedDirector().setAnimationInterval(1.0f / 60);

		// set portrait
		CCDirector.sharedDirector().setDeviceOrientation(
				CCDirector.kCCDeviceOrientationPortrait);

		
		
		
		gameManager = GameManager.getGame();
		gameManager.initialize();
		gameManager.start();
	}

	@Override
	public void onPause() {
		super.onPause();
		SoundEngine.sharedEngine().pauseSound();
		CCDirector.sharedDirector().onPause();

	}

	@Override
	public void onResume() {
		super.onResume();
		SoundEngine.sharedEngine().resumeSound();
		CCDirector.sharedDirector().onResume();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();

		CCDirector.sharedDirector().end();
		
        finish();
	}

	
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/* If Pressing the Back key twice, shut down apps */																		//
	private static final int MSG_TIMER_EXPIRED = 1;																				//
																																//
	private static final int BACKKEY_TIMEOUT = 2;																				//
	private static final int MILLIS_IN_SEC = 1000;																				//
																																//
	private boolean mIsBackKeyPressed = false;																					//
	private long mCurrTimeInMillis = 0;																							//
																																//
	@Override																													//
	public void onBackPressed() {																								//
		// super.onBackPressed();																								//
																																//
		if (mIsBackKeyPressed == false) {																						//
			mIsBackKeyPressed = true;																							//
																																//
			mCurrTimeInMillis = Calendar.getInstance().getTimeInMillis();														//
																																//
			Toast.makeText(this, "If Press the Back key one more, shut down apps", Toast.LENGTH_SHORT).show();					//
																																//
			startTimer();																										//
		} else {																												//
			mIsBackKeyPressed = false;																							//
																																//
			if (Calendar.getInstance().getTimeInMillis() <= (mCurrTimeInMillis + (BACKKEY_TIMEOUT * MILLIS_IN_SEC))) {			//
				finish();																										//
			}																													//
		}																														//
	}																															//
																																//
	private void startTimer() {																									//
		mTimerHandler.sendEmptyMessageDelayed(MSG_TIMER_EXPIRED, BACKKEY_TIMEOUT * MILLIS_IN_SEC);								//
	}																															//
																																//
	private Handler mTimerHandler = new Handler() {																				//
		@Override																												//
		public void handleMessage(Message msg) {																				//
			// super.handleMessage(msg);																						//
																																//
			switch (msg.what) {																									//
			case MSG_TIMER_EXPIRED: {																							//
				mIsBackKeyPressed = false;																						//
			}																													//
																																//
				break;																											//
			}																													//
		}																														//
	};																															//
																																//	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	
	
}