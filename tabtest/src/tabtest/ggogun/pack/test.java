//package tabtest.ggogun.pack;
//
//
//
//import java.util.ArrayList;
//
//import android.app.TabActivity;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
//import android.widget.ListView;
//import android.widget.TabHost;
//import android.widget.Toast;
// 
//public class test extends TabActivity 
//{ 
//    /** Called when the activity is first created. */ 
//    @Override 
//    public void onCreate(Bundle savedInstanceState) 
//    { 
//        super.onCreate(savedInstanceState); 
//        setContentView(R.layout.main); 
//        
//        TabHost tabHost = getTabHost(); 
//        
//        TabHost.TabSpec spec;
//        
//        // Ã¹ ¹øÂ° ÅÇ
//        spec = tabHost.newTabSpec( "Tab 01" );
//        spec.setIndicator( "Tab 01", 
//        		getResources().getDrawable( R.drawable.icon ) );
//        spec.setContent( R.id.TabView1 );
//        tabHost.addTab( spec );
//        
//        
//        ArrayList<String> listArrray = new ArrayList<String>();
//		listArrray.add("±èÀ¯½Å");
//		listArrray.add("ÀÌ¼ø½Å");
//		listArrray.add("°­°¨Âù");
//		listArrray.add("À»Áö¹®´ö");
//
//		final ArrayAdapter<String> adapter;
//		adapter = new ArrayAdapter<String>(this,
//				android.R.layout.simple_list_item_1, listArrray);
//
//		final ListView list = (ListView) findViewById(R.id.TabView2);
//		list.setAdapter(adapter);
//
//		list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//			@Override
//			public void onItemClick(AdapterView listview, View view,
//					int position, long id) {
//				// TODO Auto-generated method stub
//				
//				Toast awesomeToast = Toast.makeText(test.this, adapter.getItem(position),Toast.LENGTH_SHORT);
//				awesomeToast.show();
//			}
//		});
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        // µÎ ¹øÂ° ÅÇ
//        spec = tabHost.newTabSpec( "Tab 02" );
//        spec.setIndicator( "Tab 02" );
//        spec.setContent( R.id.TabView2 );
//        tabHost.addTab( spec );
//        
//        // ¼¼ ¹øÂ° ÅÇ
//        spec = tabHost.newTabSpec( "Tab 03" );
//        spec.setIndicator( "Tab 03" );
//        spec.setContent( R.id.TabView3 );
//        tabHost.addTab( spec );
//        
//        tabHost.setCurrentTab( 0 );
//    } 
//} 

 
