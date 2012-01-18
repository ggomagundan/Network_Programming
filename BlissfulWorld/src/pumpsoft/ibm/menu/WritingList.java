package pumpsoft.ibm.menu;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.StringTokenizer;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import pumpsoft.ibm.R;
import pumpsoft.ibm.data.WritingData;
import pumpsoft.ibm.net.Reading;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

public class WritingList extends Activity {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.writinglist);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

		setBtnListener();
		
		reader = new Reading();
		jsonData = reader.getText("http://211.109.180.43:9080/Article/ArticleList?start=0&end=100");

		dataList = new ArrayList<WritingData>();

		DisplayMetrics metrics = new DisplayMetrics();
		((Activity) this).getWindowManager().getDefaultDisplay().getMetrics(metrics);

		popupView = View.inflate(this, R.layout.menu_search_list_popup, null);
		popup = new PopupWindow(popupView, metrics.widthPixels - 25, metrics.heightPixels - metrics.heightPixels/10, true);
		final LinearLayout linearLayout = (LinearLayout)findViewById(R.id.WritingList_LinearLayout);

		adapter = new MyListAdapter(this, R.layout.writinglist_item);

		listView = (ListView)findViewById(R.id.WritingList_ListView);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,	long id) {
				// TODO Auto-generated method stub
				jsonData2 = reader.getText("http://211.109.180.43:9080/Article/ArticleContent?id=" + dataList.get(position).getAticleId());

				String content = null;

				try {
					JSONObject json = jsonData2.getJSONObject(0);
					content = json.getString("content");
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				setPopupView(content, position);
				popup.showAtLocation(linearLayout, Gravity.CENTER, 0, 0);
			}
		});

		LinearLayout layout = (LinearLayout)findViewById(R.id.WritingList_Network_LinearLayout);
		layout.setVisibility(LinearLayout.INVISIBLE);

		listView.setVisibility(ListView.VISIBLE);
	}
	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		new AlertDialog.Builder(WritingList.this)
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
	private JSONArray jsonData2;
	private ArrayList<WritingData> dataList;

	private View popupView;
	private PopupWindow popup;

	private ListView listView;
	private MyListAdapter adapter;

	private Button mypageBtn;
	private Button writinglistBtn;
	private Button doitBtn;

	private void setBtnListener() {
		mypageBtn = (Button)findViewById(R.id.MyPage_Button);
		mypageBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(WritingList.this, MainMenu.class);
				startActivity(intent);
				overridePendingTransition(R.anim.fade, R.anim.hold);
				finish();
			}
		});

		writinglistBtn = (Button)findViewById(R.id.WritingList_Button);
		writinglistBtn.setTextColor(Color.RED);
		writinglistBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

			}
		});

		doitBtn = (Button)findViewById(R.id.Do_Button);
		doitBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(WritingList.this, DoIt.class);
				startActivity(intent);
				overridePendingTransition(R.anim.fade, R.anim.hold);
				finish();
			}
		});
	}

	class MyListAdapter extends BaseAdapter {
		Context mainContext;
		LayoutInflater inflater;
		int layout;

		public MyListAdapter(Context context, int alayout) {
			mainContext = context;
			inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			layout = alayout;
		}

		public int getCount() {
			// TODO Auto-generated method stub
			return jsonData.length();
		}

		public Object getItem(int position) {
			// TODO Auto-generated method stub
			JSONObject json = null;

			try {
				json = (JSONObject)jsonData.get(position);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return (Object)json;
		}

		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			if(convertView == null) {
				convertView = inflater.inflate(layout, parent, false);
			}

			JSONObject json;
			WritingData data = null;

			try {
				json = jsonData.getJSONObject(position);
				data = new WritingData(json.getString("article_id"), json.getString("user_id"), json.getString("nickname"), json.getString("title"), json.getString("time"), json.getString("rc"), json.getString("oc"), json.getString("type"), json.getString("m_name"));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			dataList.add(data);
			StringTokenizer tokenizer = new StringTokenizer(dataList.get(position).getDate());

			TextView numTextView = (TextView)convertView.findViewById(R.id.Number_TextView);
			numTextView.setText(dataList.get(position).getAticleId());

			TextView subjectTextView = (TextView)convertView.findViewById(R.id.Subject_TextView);
			subjectTextView.setText(dataList.get(position).getSubject());

			TextView dateTextView = (TextView)convertView.findViewById(R.id.Date_TextView);
			dateTextView.setText(tokenizer.nextToken());

			TextView goodTextView = (TextView)convertView.findViewById(R.id.Good_TextView);
			goodTextView.setText(dataList.get(position).getGood());

			TextView badTextView = (TextView)convertView.findViewById(R.id.Bad_TextView);
			badTextView.setText(dataList.get(position).getBad());

			if(dataList.get(position).getType().equals("3")) {
				TextView pyramid = (TextView)convertView.findViewById(R.id.Pyramid_TextView);
				pyramid.setVisibility(TextView.VISIBLE);
			} else if(dataList.get(position).getType().equals("2")) {
				TextView relay = (TextView)convertView.findViewById(R.id.Relay_TextView);
				relay.setVisibility(TextView.VISIBLE);
			}

			return convertView;
		}
	}

	private void setPopupView(String content, final int position) {
		// TODO Auto-generated method stub
		setImage();
		TextView popupText1 = (TextView)popupView.findViewById(R.id.popup_textView3);
		popupText1.setText(dataList.get(position).getSubject());
		
		TextView popupText2 = (TextView)popupView.findViewById(R.id.popup_textView6);
		popupText2.setText(dataList.get(position).getUser());
		TextView popupText3 = (TextView)popupView.findViewById(R.id.popup_textView9);
		popupText3.setText(dataList.get(position).getGood());
		TextView popupText4 = (TextView)popupView.findViewById(R.id.popup_textView12);
		popupText4.setText(dataList.get(position).getBad());
		TextView popupText5 = (TextView)popupView.findViewById(R.id.popup_textView15);
		popupText5.setText(content);
		
		Button btnPlus = (Button)popupView.findViewById(R.id.menu_search_list_Popup_Plus_button);
		btnPlus.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				reader.getText("http://211.109.180.43:9080/Article/UpdateArticleRC?article_id=" + dataList.get(position).getAticleId());
				popup.dismiss();
				Intent intent = new Intent(WritingList.this, WritingList.class);
				startActivity(intent);
				overridePendingTransition(R.anim.fade, R.anim.hold);
				finish();
			}
		});

		Button btnMinus = (Button)popupView.findViewById(R.id.menu_search_list_Popup_Minus_button);
		btnMinus.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				reader.getText("http://211.109.180.43:9080/Article/UpdateArticleOC?article_id=" + dataList.get(position).getAticleId());
				popup.dismiss();
				Intent intent = new Intent(WritingList.this, WritingList.class);
				startActivity(intent);
				overridePendingTransition(R.anim.fade, R.anim.hold);
				finish();
			}
		});

		Button btnClose = (Button)popupView.findViewById(R.id.menu_search_list_Popup_Exit_button);
		btnClose.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				popup.dismiss();
			}
		});

		JSONArray jArray = reader.getText("http://211.109.180.43:9080/Article/ArticlePhotos?id=" + dataList.get(position).getAticleId());

		if(jArray != null) {
			String imgUrl = null;

			try {
				JSONObject jData = jArray.getJSONObject(0);
				imgUrl = jData.getString("url");
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			 
			
				
		}
		
	}

	private void setImage() {
		// TODO Auto-generated method stub
		URL imageURL;ImageView imgs;
		imgs = (ImageView)findViewById(R.id.menu_search_list_Popup_ImageView);
		try {
			imageURL = new URL("http://211.109.180.43:9080/Image/76_4_18_25.jpg");

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
		} catch (Exception e){
			Log.d("PBS",e.toString());
		}
	
	}

}
