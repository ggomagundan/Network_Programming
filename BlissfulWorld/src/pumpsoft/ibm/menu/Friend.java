package pumpsoft.ibm.menu;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import pumpsoft.ibm.R;
import pumpsoft.ibm.data.FriendData;
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
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Friend extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.writinglist);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

		setBtnListener();

		reader = new Reading();
		jsonData = reader.getText("http://211.109.180.43:9080/Frined/FriendsList?id=" + LoginConstant.getId() + "&start=0&end=100");

		friendList = new ArrayList<FriendData>();

		FriendData data = new FriendData("현재 " + Integer.toString(jsonData.length()) + " 명", "친구 추가", " ", " ");
		friendList.add(data);

		for(int i=0;i<jsonData.length();++i) {
			JSONObject json;
			FriendData jsonInData = null;

			try {
				json = jsonData.getJSONObject(i);
				jsonInData = new FriendData(json.getString("id"), json.getString("nickname"), json.getString("point"), json.getString("pdc"));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			friendList.add(jsonInData);
		}

		DisplayMetrics metrics = new DisplayMetrics();
		((Activity) this).getWindowManager().getDefaultDisplay().getMetrics(metrics);

		adapter = new MyListAdapter(this, R.layout.friendlist_item);

		listView = (ListView)findViewById(R.id.WritingList_ListView);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, final int position,	long id) {
				// TODO Auto-generated method stub
				if(position != 0) {
					new AlertDialog.Builder(Friend.this)
					.setTitle(friendList.get(position).getFriendNick())
					.setMessage("완료한 미션 : " + friendList.get(position).getFriendDonationCount() + "\n포인트 : " + friendList.get(position).getFriendPoint())
					.setIcon(R.drawable.icon)
					.setPositiveButton("식물보기", new DialogInterface.OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							Intent intent = new Intent(Friend.this, Plant.class);
							intent.putExtra("id", friendList.get(position).getFriendId());
							startActivity(intent);
							overridePendingTransition(R.anim.fade, R.anim.hold);
							finish();
						}
					})
					.setNeutralButton("완료된 선행", new DialogInterface.OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							//						reader.getText("http://211.109.180.43:9080/Mission/HadMission?id=" + friendList.get(position).getFriendId() + "&start=0&end=100");
							//						intent 처리.
							//						j.put("name", comment[0]);
							//						j.put("type", comment[1]);
							//						j.put("goal", comment[2]);
							//						j.put("point", comment[3]);
							//						j.put("desc", comment[4]);
							//						j.put("url", comment[5]);
							//						j.put("ap", comment[6]);
							//						j.put("st", comment[7]);
							//						j.put("et", comment[8]);
							//						j.put("rownum", comment[9]);
						}
					})
					.setNegativeButton("심은 식물", new DialogInterface.OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							//						reader.getText("http://211.109.180.43:9080/Plant/UserPlantList?id=" + friendList.get(position).getFriendId());
							//						intent 처리.
							//						j.put("name", comment[0]);
							//						j.put("desc", comment[1]);
							//						j.put("url", comment[2]);
							//						j.put("mm", comment[3]);
							//						j.put("step", comment[4]);
							//						j.put("ap", comment[5]);
							//						j.put("lat", comment[6]);
							//						j.put("pa", comment[7]);
						}
					})
					.show();
				} else if(position == 0) {
					final EditText ev = new EditText(Friend.this);

					new AlertDialog.Builder(Friend.this)
					.setTitle(friendList.get(position).getFriendNick())
					.setMessage("등록할 친구의 ID 를 입력하세요")
					.setPositiveButton("추가", new DialogInterface.OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							JSONArray resultJSONArray = reader.getText("http://211.109.180.43:9080/Frined/InsertFriend?id=" + LoginConstant.getId() + "&f_id=" + ev.getText().toString());

							boolean result = false;

							try {
								result = resultJSONArray.getJSONObject(0).getBoolean("result");
							} catch (JSONException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

							if(result) {
								Toast.makeText(Friend.this, "새로운 친구가 등록되었습니다", Toast.LENGTH_LONG).show();

								Intent intent = new Intent(Friend.this, Friend.class);
								startActivity(intent);
								overridePendingTransition(R.anim.fade, R.anim.hold);
								finish();
							} else {
								Toast.makeText(Friend.this, "친구 등록이 실패하였습니다\nID 를 확인해주세요", Toast.LENGTH_LONG).show();
							}
						}
					})
					.setNegativeButton("닫기", new DialogInterface.OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub

						}
					})
					.setView(ev)
					.show();
				}
			}
		});

		LinearLayout layout = (LinearLayout)findViewById(R.id.WritingList_Network_LinearLayout);
		layout.setVisibility(LinearLayout.INVISIBLE);

		listView.setVisibility(ListView.VISIBLE);
	}
	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		new AlertDialog.Builder(Friend.this)
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
	private ArrayList<FriendData> friendList;

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
				Intent intent = new Intent(Friend.this, MainMenu.class);
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
				Intent intent = new Intent(Friend.this, WritingList.class);
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
				Intent intent = new Intent(Friend.this, DoIt.class);
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
			return friendList.size();
		}

		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return friendList.get(position);
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

			TextView nickTextView = (TextView)convertView.findViewById(R.id.Friend_Nick_TextView);
			nickTextView.setText(friendList.get(position).getFriendNick());

			TextView subjectTextView = (TextView)convertView.findViewById(R.id.Friend_Id_TextView);
			subjectTextView.setText(friendList.get(position).getFriendId());

			if(position != 0) {
				LinearLayout layout = (LinearLayout)convertView.findViewById(R.id.FriendList_Item_LinearLayout);
				layout.setBackgroundColor(Color.argb(44, 255, 140, 0));
			}

			return convertView;
		}
	}

}
