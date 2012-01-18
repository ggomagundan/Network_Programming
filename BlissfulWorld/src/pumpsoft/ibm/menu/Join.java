package pumpsoft.ibm.menu;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import pumpsoft.ibm.R;
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

public class Join extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.join);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

		setBtnListener();

		reader = new Reading();
	}
	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		new AlertDialog.Builder(Join.this)
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
	private EditText nickEditText;
	private Button joinBtn;

	private void setBtnListener() {
		idEditText = (EditText)findViewById(R.id.ID_EditText);
		pwEditText = (EditText)findViewById(R.id.PW_EditText);
		nickEditText = (EditText)findViewById(R.id.Nick_EditText);

		joinBtn = (Button)findViewById(R.id.New_Join_Button);
		joinBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String id = idEditText.getText().toString();
				String pw = pwEditText.getText().toString();
				String nick = nickEditText.getText().toString();

				jsonData = reader.getText("http://211.109.180.43:9080/LoginWeb/InsertUser?id=" + id + "&nickname=" + nick + "&passwd=" + pw);

				int loginResult = 0;

				try {
					json = jsonData.getJSONObject(0);
					loginResult = json.getInt("result");
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				if( loginResult == 1 ) {
					Toast.makeText(Join.this, "회원가입 성공\n로그인을 해주세요", Toast.LENGTH_LONG).show();
					Intent intent = new Intent(Join.this, Login.class);
					startActivity(intent);
					overridePendingTransition(R.anim.fade, R.anim.hold);
					finish();
				} else {
					Toast.makeText(Join.this, "회원가입 실패!!\nID 또는 PW 를 확인해주세요\n중복이 있을 수도 있습니다", Toast.LENGTH_LONG).show();
				}
			}
		});
	}

}
