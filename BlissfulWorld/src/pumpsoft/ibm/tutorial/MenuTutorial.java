package pumpsoft.ibm.tutorial;

import pumpsoft.ibm.R;
import pumpsoft.ibm.menu.Writing;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

public class MenuTutorial extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menututorial);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

		Intent intent = getIntent();
		final String menuType = intent.getExtras().getString("type");

		LinearLayout layout = (LinearLayout)findViewById(R.id.Menu_Tutorial_LinearLayout);

		if(menuType.equals("일반")) {
			layout.setBackgroundResource(R.drawable.ilban);
		} else if(menuType.equals("특수")) {
			layout.setBackgroundResource(R.drawable.special);
		} else if(menuType.equals("피라이드")) {
			layout.setBackgroundResource(R.drawable.pyramid);
		} else if(menuType.equals("릴레이")) {
			layout.setBackgroundResource(R.drawable.relay);
		}

		Button okBtn = (Button)findViewById(R.id.OK_Button);
		okBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(menuType.equals("일반")) {
					Intent intent = new Intent(MenuTutorial.this, Writing.class);
					intent.putExtra("where", "일반 선행");
					startActivity(intent);
					overridePendingTransition(R.anim.fade, R.anim.hold);
					finish();
				}
			}
		});
	}

}
