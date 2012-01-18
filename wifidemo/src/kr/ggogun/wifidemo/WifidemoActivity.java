package kr.ggogun.wifidemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import android.app.Activity;
import android.app.ListActivity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class WifidemoActivity  extends ListActivity 
{      
	private static final String			ITEM_KEY	= "key";
	ArrayList<HashMap<String, String>>	list		= new ArrayList<HashMap<String, String>>();
	private SimpleAdapter				adapter;
	private EditText					newValue;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		newValue = (EditText) findViewById(R.id.new_value_field);

		this.adapter = new SimpleAdapter(this, list, R.layout.row, new String[] { ITEM_KEY }, new int[] { R.id.list_value });
		setListAdapter(this.adapter);

		((ImageButton) findViewById(R.id.button)).setOnClickListener(getBtnClickListener());
	}

	private OnClickListener getBtnClickListener() {
		return new OnClickListener() {
			public void onClick(View view) {
				try {
					HashMap<String, String> item = new HashMap<String, String>();
					item.put(ITEM_KEY, newValue.getText().toString());
					list.add(item);
					adapter.notifyDataSetChanged();
				} catch (NullPointerException e) {
					Log.i("[Dynamic Items]", "Tried to add null value");
				}
			}
		};
	}  
}
