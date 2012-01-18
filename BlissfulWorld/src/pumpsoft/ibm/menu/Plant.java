package pumpsoft.ibm.menu;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

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
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class Plant extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.plant);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

		TextView bottomBanner = (TextView)findViewById(R.id.Bottom_Banner_TextView);
		bottomBanner.setSelected(true);

		Intent intent = getIntent();
		id = intent.getExtras().getString("id");

		reader = new Reading();
		jsonData = reader.getText("http://211.109.180.43:9080/Plant/UserPlantList?id=" + id);
		Log.d("PBS",jsonData.toString());
		
		
		try {
			Log.d("PBS", jsonData.getJSONObject(0).toString());
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			data = jsonData.getJSONObject(0);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			Toast.makeText(Plant.this, "현재 키우고 있는 식물이 없습니다", Toast.LENGTH_LONG).show();

			Intent intentBack = new Intent(Plant.this, MainMenu.class);
			startActivity(intentBack);
			overridePendingTransition(R.anim.fade, R.anim.hold);
			finish();
		}

		setBtnListener();
		setView();
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		new AlertDialog.Builder(Plant.this)
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
	private JSONObject data;

	private String id;

	private Button mypageBtn;
	private Button writinglistBtn;
	private Button doitBtn;

	private Button inventoryOrViewBtn;
	private Button shopOrCommentBtn;

	private ImageView imgs;
	private TextView plantNameTextView;
	private TextView plantDescTextView;
	private ProgressBar progressBar;
	private TextView currentPointTextView;
	private TextView maxPointTextView;

	private void setBtnListener() {
		mypageBtn = (Button)findViewById(R.id.MyPage_Button);
		mypageBtn.setTextColor(Color.RED);
		mypageBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Plant.this, MainMenu.class);
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
				Intent intent = new Intent(Plant.this, WritingList.class);
				startActivity(intent);
				overridePendingTransition(R.anim.fade, R.anim.hold);
				finish();
			}
		});

		doitBtn = (Button)findViewById(R.id.Do_Button);
		doitBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Plant.this, DoIt.class);
				startActivity(intent);
				overridePendingTransition(R.anim.fade, R.anim.hold);
				finish();
			}
		});

		inventoryOrViewBtn = (Button)findViewById(R.id.Inventory_Or_View_Button);
		inventoryOrViewBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Plant.this, Inventory.class);
				startActivity(intent);
				overridePendingTransition(R.anim.fade, R.anim.hold);
				finish();
			}
		});

		shopOrCommentBtn = (Button)findViewById(R.id.Shop_Or_Comment_Button);
		shopOrCommentBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Plant.this, Shop.class);
				startActivity(intent);
				overridePendingTransition(R.anim.fade, R.anim.hold);
				finish();
			}
		});
	}

	private void setView() {
		try {
			imgs = (ImageView)findViewById(R.id.Plant_ImageView);

			URL imageURL;

			try {
				imageURL = new URL("http://211.109.180.43:9080/Image/" + data.getString("url"));

				HttpURLConnection conn = (HttpURLConnection)imageURL.openConnection();            
				BufferedInputStream bis = new BufferedInputStream(conn.getInputStream(), 10240);
				Bitmap bm = BitmapFactory.decodeStream(bis);
				bis.close(); 

				imgs.setImageBitmap(bm);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			plantNameTextView = (TextView)findViewById(R.id.Plant_Name_Button);
			plantNameTextView.setText(data.getString("name"));

			plantDescTextView = (TextView)findViewById(R.id.Plant_Desc_Button);
			plantDescTextView.setText(data.getString("desc"));

			progressBar = (ProgressBar)findViewById(R.id.Plant_ProgressBar);

			int progressValue = ( Integer.parseInt(data.getString("ap")) * 100 ) / Integer.parseInt(data.getString("mm"));
			progressBar.setProgress(progressValue);

			currentPointTextView = (TextView)findViewById(R.id.Plant_Current_Point_TextView);
			currentPointTextView.setText(data.getString("ap"));

			maxPointTextView = (TextView)findViewById(R.id.Plant_Max_Point_TextView);
			maxPointTextView.setText(data.getString("mm"));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
