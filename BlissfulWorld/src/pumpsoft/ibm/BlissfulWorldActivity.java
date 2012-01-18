package pumpsoft.ibm;

import java.util.Timer;
import java.util.TimerTask;

import pumpsoft.ibm.tutorial.Tutorial;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

public class BlissfulWorldActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

		timer.schedule(menuCall, 3000); // 3 seconds
	}

	TimerTask menuCall = new TimerTask() {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			Intent intent = new Intent(BlissfulWorldActivity.this, Tutorial.class);
			startActivity(intent);
			finish();
		}
	};

	Timer timer = new Timer();

}
