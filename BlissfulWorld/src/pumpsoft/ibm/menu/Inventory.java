package pumpsoft.ibm.menu;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import pumpsoft.ibm.R;
import pumpsoft.ibm.data.InvenData;
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

public class Inventory extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.writinglist);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

		setBtnListener();

		reader = new Reading();
		jsonData = reader.getText("http://211.109.180.43:9080/Item/InventoryGet?id=" + LoginConstant.getId() + "&start=0&end=100");

		invenList = new ArrayList<InvenData>();

		DisplayMetrics metrics = new DisplayMetrics();
		((Activity) this).getWindowManager().getDefaultDisplay().getMetrics(metrics);

		adapter = new MyListAdapter(this, R.layout.friendlist_item);

		listView = (ListView)findViewById(R.id.WritingList_ListView);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, final int position,	long id) {
				// TODO Auto-generated method stub
				new AlertDialog.Builder(Inventory.this)
				.setTitle(invenList.get(position).getName())
				.setMessage("개수 : " + invenList.get(position).getCount() + "\n" + invenList.get(position).getDesc())
				.setIcon(R.drawable.icon)
				.setPositiveButton("사용", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						JSONArray jsonArray = reader.getText("http://211.109.180.43:9080/Plant/CurrentUserPlant?id=" + LoginConstant.getId());
						JSONArray jArray = null;

						boolean inputOK = false;

						try {
							jArray = reader.getText("http://211.109.180.43:9080/Item/UseItem?count=1&user_id=" + LoginConstant.getId() + "&item_id=" + invenList.get(position).getId() + "&point=" + invenList.get(position).getEffect() + "&user_plant_id="
									+ jsonArray.getJSONObject(0).getString("id"));
							inputOK = jArray.getJSONObject(0).getBoolean("result");
						} catch (JSONException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

						if(inputOK) {
							Toast.makeText(Inventory.this, "아이템을 사용하였습니다", Toast.LENGTH_LONG).show();
							
							Intent intent = new Intent(Inventory.this, Inventory.class);
							startActivity(intent);
							overridePendingTransition(R.anim.fade, R.anim.hold);
							finish();
						} else {
							Toast.makeText(Inventory.this, "아이템 사용 실패", Toast.LENGTH_LONG).show();
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
		new AlertDialog.Builder(Inventory.this)
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
	private ArrayList<InvenData> invenList;

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
				Intent intent = new Intent(Inventory.this, MainMenu.class);
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
				Intent intent = new Intent(Inventory.this, WritingList.class);
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
				Intent intent = new Intent(Inventory.this, DoIt.class);
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
			InvenData data = null;

			try {
				json = jsonData.getJSONObject(position);
				data = new InvenData(json.getString("id"), json.getString("name"), json.getString("count"), json.getString("desc"), json.getString("url"), json.getString("effect"));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			invenList.add(data);

			TextView nameTextView = (TextView)convertView.findViewById(R.id.Friend_Nick_TextView);
			nameTextView.setText(data.getName());

			TextView countTextView = (TextView)convertView.findViewById(R.id.Friend_Id_TextView);
			countTextView.setText(data.getCount() + " 개");

			return convertView;
		}
	}

}
