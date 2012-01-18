package kr.ggogun.network;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class Network_testActivity extends Activity {
	
	private ArrayList <HashMap<String, Object>> wifilist;
	private static final String NAMEKEY = "name";
	private static final String DESC_STR = "description";
	private static final String IMGKEY = "IMG";
	int size =0;
    List<ScanResult> results;
    WifiManager wfmgr;
    SimpleAdapter adapter;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        ListView listView = (ListView)findViewById(R.id.list);
        wifilist = new ArrayList<HashMap<String,Object>>();
        wfmgr = (WifiManager)getSystemService(Context.WIFI_SERVICE);
  	  //tv = (TextView)findViewById(R.id.text);
  	  ImageButton btn = (ImageButton)findViewById(R.id.btn);
        Button btns = (Button) findViewById(R.id.scanbtn);
        
        adapter = new SimpleAdapter(this, wifilist, R.layout.listbox, 
        		new String[]{NAMEKEY,DESC_STR,IMGKEY}, new int[]{R.id.text1,R.id.text2,R.id.img});
       		
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE); 
 
        listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				
				int position = arg0.getPositionForView(arg1);
				HashMap<String, Object> item = new HashMap<String, Object>();  
				item = wifilist.get(position);
				
				AlertDialog.Builder alert = new AlertDialog.Builder(Network_testActivity.this);
				alert.setTitle(item.get(NAMEKEY).toString());
				alert.setMessage(item.get(NAMEKEY).toString()+ "에 연결 하시겠습니까?");
				alert.setPositiveButton("연결",
	                    new DialogInterface.OnClickListener() {
	                        public void onClick(DialogInterface dialog, int id) {

	                        	dialog.cancel();

	                        }
	                    });
				alert.setNegativeButton("취소",
	                    new DialogInterface.OnClickListener() {
	                        public void onClick(DialogInterface dialog, int id) {
	                            dialog.cancel();
	                        }
	                    });

				alert.show();
			}
		
        
        });
     
        
        
        if(!wfmgr.isWifiEnabled()){
        	//tv.setText("Wifi off");
        	btn.setImageResource(R.drawable.wifioff);
        	
        } else {
        	//tv.setText("Wifi On");
        	btn.setImageResource(R.drawable.wifion);
        	searchingWifi();
        	
        
        }
        
       
        
        
       
   
       
        
        
        btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				 
			   
			
			  	  ImageButton btn = (ImageButton)findViewById(R.id.btn);
				 if(!wfmgr.isWifiEnabled()){
			        	//tv.setText("Wifi On");
			        	wfmgr.setWifiEnabled(true);
			        	btn.setImageResource(R.drawable.wifion);
			        	searchingWifi();     
			        
			        } else {
			        	//tv.setText("Wifi Off");
			        	wfmgr.setWifiEnabled(false);
			        	btn.setImageResource(R.drawable.wifioff);
			        	
			        
			        }
			}
		});

        btns.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				// wfmgr = (WifiManager)getSystemService(Context.WIFI_SERVICE);
			
					 if(!wfmgr.isWifiEnabled()){
						 
						 Toast.makeText(getApplicationContext(), "Wifi is disable plz able to wifi", Toast.LENGTH_SHORT).show();
				        	
				        }else{  
				        	
				        		searchingWifi();
		        
		        
		       
				        }

			}
		});
        
        
        registerReceiver(new BroadcastReceiver()
        {
            @Override
            public void onReceive(Context c, Intent intent) 
            {
               results = wfmgr.getScanResults();
               size = results.size();
            }
        }, new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION)); 
        
    }
    
    
    
    
    
   
    
    
    
    
    
    void searchingWifi(){
    	wifilist.clear();
    	wfmgr.startScan();
    	
    	 Toast.makeText(getApplicationContext(), "Start Scanning", Toast.LENGTH_LONG).show();
    	try 
        {
            size = size - 1;
            while (size >= 0) 
            {   
                HashMap<String, Object> item = new HashMap<String, Object>();                       
                item.put(NAMEKEY, results.get(size).SSID );
                item.put(DESC_STR, results.get(size).capabilities+ "\n" + results.get(size).frequency+"MHz" + "\n"+  results.get(size).level);
                
                int srcname = getImgSrc(results.get(size).capabilities, results.get(size).level);
                switch(srcname){
                case 1:
                	item.put(IMGKEY,R.raw.wifi_4);
                	break;
                case 2:
                	item.put(IMGKEY,R.raw.wifi_3);
                	break;
                case 3:
                	item.put(IMGKEY,R.raw.wifi_2);
                	break;
                case 4:
                	item.put(IMGKEY,R.raw.wifi_1);
                	break;
                case 5:
                	item.put(IMGKEY,R.raw.wifi_s_4);
                	break;
                case 6:
                	item.put(IMGKEY,R.raw.wifi_s_3);
                	break;
                case 7:
                	item.put(IMGKEY,R.raw.wifi_s_2);
                	break;
                case 8:
                	item.put(IMGKEY,R.raw.wifi_s_1);
                	break;
            	
                		
                }
                
                wifilist.add(item);
                size--;
                adapter.notifyDataSetChanged();    
               
        }}
        catch (Exception e)
        { } 
    	 Toast.makeText(getApplicationContext(), "Scaniing enddddd", Toast.LENGTH_LONG).show();
    }











	private int getImgSrc(String capabilities, int level) {
		// TODO Auto-generated method stub
		
		if(capabilities.equals("")){
			if(level > -60)
				return 1;
			else if(level > -70){
				return 2;
			}else if(level > -80){
				return 3;
			}else{
				return 4;
			}
		}else{
			if(level > -60)
				return 5;
			else if(level > -70){
				return 6;
			}else if(level > -80){
				return 7;
			}else{
				return 8;
			}
		}
		
	}
    
    
    
    
    
    
    
    
    
    
    
    
}