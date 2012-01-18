package pumpsoft.ibm.menu;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import pumpsoft.ibm.R;
import pumpsoft.ibm.data.ShopData;
import pumpsoft.ibm.net.LoginConstant;
import pumpsoft.ibm.net.Reading;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Shop extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.writinglist);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

		setBtnListener();

		reader = new Reading();
		jsonData = reader.getText("http://211.109.180.43:9080/Item/ItemList?start=0&end=100");

		shopList = new ArrayList<ShopData>();

		DisplayMetrics metrics = new DisplayMetrics();
		((Activity) this).getWindowManager().getDefaultDisplay().getMetrics(metrics);

		adapter = new MyListAdapter(this, R.layout.friendlist_item);

		listView = (ListView)findViewById(R.id.WritingList_ListView);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, final int position,	long id) {
				// TODO Auto-generated method stub
				new AlertDialog.Builder(Shop.this)
				.setTitle(shopList.get(position).getName())
				.setMessage("개수 : " + shopList.get(position).getCount() + "\n" + shopList.get(position).getDesc() + "\n가격: " + shopList.get(position).getPrice())
				.setIcon(R.drawable.icon)
				.setPositiveButton("구매", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						JSONArray jArray = reader.getText("http://211.109.180.43:9080/Item/BuyItem?count=1&user_id=" + LoginConstant.getId() + "&item_id=" + shopList.get(position).getId());

						boolean inputOK = false;

						try {
							inputOK = jArray.getJSONObject(0).getBoolean("result");
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						if(inputOK) {
							Toast.makeText(Shop.this, "아이템을 구입하였습니다", Toast.LENGTH_LONG).show();

							Intent intent = new Intent(Shop.this, Shop.class);
							startActivity(intent);
							overridePendingTransition(R.anim.fade, R.anim.hold);
							finish();
						} else {
							Toast.makeText(Shop.this, "아이템 구입에 실패하였습니다", Toast.LENGTH_LONG).show();
						}
					}
				})
				.setNegativeButton("닫기", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub

					}
				})
				.show();
			}
		});

		LinearLayout layout = (LinearLayout)findViewById(R.id.WritingList_Network_LinearLayout);
		layout.setVisibility(LinearLayout.INVISIBLE);

		listView.setVisibility(ListView.VISIBLE);
	}
	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		new AlertDialog.Builder(Shop.this)
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
	private ArrayList<ShopData> shopList;

	private ListView listView;
	private MyListAdapter adapter;

	private Button mypageBtn;
	private Button writinglistBtn;
	private Button doitBtn;

	private void setBtnListener() {
		mypageBtn = (Button)findViewById(R.id.MyPage_Button);
		mypageBtn.setTextColor(Color.RED);
		mypageBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Shop.this, MainMenu.class);
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
				Intent intent = new Intent(Shop.this, WritingList.class);
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
				Intent intent = new Intent(Shop.this, DoIt.class);
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
			ShopData data = null;

			try {
				json = jsonData.getJSONObject(position);
				data = new ShopData(json.getString("id"), json.getString("name"), json.getString("count"), json.getString("desc"), json.getString("url"), json.getString("effect"), json.getString("price"));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			shopList.add(data);

			TextView nameTextView = (TextView)convertView.findViewById(R.id.Friend_Nick_TextView);
			nameTextView.setText(shopList.get(position).getName());

			TextView countTextView = (TextView)convertView.findViewById(R.id.Friend_Id_TextView);
			countTextView.setText(shopList.get(position).getPrice() + " Bp");

			return convertView;
		}
	}

}
