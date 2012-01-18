package pumpsoft.ibm.menu;

import pumpsoft.ibm.R;
import pumpsoft.ibm.tutorial.MenuTutorial;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class DoIt extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.doit);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

		TextView bottomBanner = (TextView)findViewById(R.id.Bottom_Banner_TextView);
		bottomBanner.setSelected(true);

		setBtnListener();
	}
	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		new AlertDialog.Builder(DoIt.this)
		.setTitle("종료 하시겠습니까?")
		.setIcon(R.drawable.shutdownicon)
		.setCancelable(false)
		.setPositiveButton("예", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int whichButton) {
				// TODO Auto-generated method stub
				finish();
			}
		})
		.setNegativeButton("아니요", null)
		.show();
	}

	private Button mypageBtn;
	private Button writinglistBtn;
	private Button doitBtn;

	private Button normalBtn;
	private Button specialBtn;
	private Button relayBtn;
	private Button pyramidBtn;

	private void setBtnListener() {
		mypageBtn = (Button)findViewById(R.id.MyPage_Button);
		mypageBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(DoIt.this, MainMenu.class);
				startActivity(intent);
				overridePendingTransition(R.anim.fade, R.anim.hold);
				finish();
			}
		});

		writinglistBtn = (Button)findViewById(R.id.WritingList_Button);
		writinglistBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(DoIt.this, WritingList.class);
				startActivity(intent);
				overridePendingTransition(R.anim.fade, R.anim.hold);
				finish();
			}
		});

		doitBtn = (Button)findViewById(R.id.Do_Button);
		doitBtn.setTextColor(Color.RED);
		doitBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

			}
		});

		normalBtn = (Button)findViewById(R.id.Nomal_Do_Button);
		normalBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(DoIt.this, MenuTutorial.class);
				intent.putExtra("type", "일반");
				startActivity(intent);
				overridePendingTransition(R.anim.fade, R.anim.hold);
				finish();
			}
		});

		specialBtn = (Button)findViewById(R.id.Special_Do_Button);
		specialBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(DoIt.this, MissionList.class);
				intent.putExtra("type", "특수");
				startActivity(intent);
				overridePendingTransition(R.anim.fade, R.anim.hold);
				finish();
			}
		});

		relayBtn = (Button)findViewById(R.id.Relay_Do_Button);
		relayBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(DoIt.this, MenuTutorial.class);
				intent.putExtra("type", "릴레이");
				startActivity(intent);
				overridePendingTransition(R.anim.fade, R.anim.hold);
				finish();
			}
		});

		pyramidBtn = (Button)findViewById(R.id.Pyramid_Do_Button);
		pyramidBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(DoIt.this, MenuTutorial.class);
				intent.putExtra("type", "피라미드");
				startActivity(intent);
				overridePendingTransition(R.anim.fade, R.anim.hold);
				finish();
			}
		});
	}

}
