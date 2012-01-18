package kr.ggogun.wifidemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import android.app.Activity;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class WifiDemosActivity extends Activity {
	 WifiManager wifi;       
	   ListView lv;
	   TextView textStatus;
	   Button buttonScan;
	   int size = 0;
	   List<ScanResult> results;

	   String ITEM_KEY = "key";
	   ArrayList<HashMap<String, String>> arraylist = new ArrayList<HashMap<String, String>>();
	   SimpleAdapter adapter;

	   /* Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        textStatus = (TextView) findViewById(R.id.textStatus);
    }
}