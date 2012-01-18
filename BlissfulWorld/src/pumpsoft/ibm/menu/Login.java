package pumpsoft.ibm.menu;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import pumpsoft.ibm.R;
import pumpsoft.ibm.net.LoginConstant;
import pumpsoft.ibm.net.Reading;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

		setBtnListener();

		reader = new Reading();
	}
	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		new AlertDialog.Builder(Login.this)
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

	private Reading reader;
	private JSONArray jsonData;
	private JSONObject json;

	private EditText idEditText;
	private EditText pwEditText;
	private Button loginBtn;
	private Button joinBtn;

	private void setBtnListener() {
		idEditText = (EditText)findViewById(R.id.ID_EditText);
		pwEditText = (EditText)findViewById(R.id.PW_EditText);

		loginBtn = (Button)findViewById(R.id.Login_Button);
		loginBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				LoginConstant.setId(idEditText.getText().toString());
				LoginConstant.setPw(pwEditText.getText().toString());

				jsonData = reader.getText("http://211.109.180.43:9080/LoginWeb/Login?id=" + LoginConstant.getId() + "&passwd=" + LoginConstant.getPw());

				int loginResult = 0;

				try {
					json = jsonData.getJSONObject(0);
					loginResult = json.getInt("result");
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				if( loginResult == 1 ) {
					Toast.makeText(Login.this, "로그인 성공", Toast.LENGTH_LONG).show();
					Intent intent = new Intent(Login.this, MainMenu.class);
					startActivity(intent);
					overridePendingTransition(R.anim.fade, R.anim.hold);
					finish();
				} else {
					Toast.makeText(Login.this, "로그인 실패!!\nID 또는 PW 를 확인해주세요", Toast.LENGTH_LONG).show();
				}
			}
		});

		joinBtn = (Button)findViewById(R.id.Join_Button);
		joinBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Login.this, Join.class);
				startActivity(intent);
				overridePendingTransition(R.anim.fade, R.anim.hold);
				finish();
			}
		});

	}

}
