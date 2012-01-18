package kr.ggogun.tutorial;

import kr.ggogun.R;
import kr.ggogun.scrollview.ScrollViewActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Tutorial extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tutorial);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

		Button okBtn = (Button)findViewById(R.id.tutorialOkButton);
		okBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Tutorial.this, ScrollViewActivity.class);
				//onDestroy();finish();
				startActivity(intent);
				//overridePendingTransition(R.anim.fade, R.anim.hold);
				
			}
		});
	}

}
