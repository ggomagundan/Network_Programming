package kr.ggogun.scrollTab;


import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
 
public class ScrollTabActivity extends TabActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
 
        HorizontalScrollView sView = (HorizontalScrollView) findViewById(R.id.horizontalScrollView);
        //sView.setVerticalScrollBarEnabled(false);
       sView.setHorizontalScrollBarEnabled(false);
 
        TabHost mTabHost = getTabHost();
        mTabHost.setBackgroundDrawable(getResources().getDrawable( R.drawable.back));
 
        
        
        TabSpec spec = mTabHost.newTabSpec("Tab_Text1");
        spec.setIndicator("Artist",getResources().getDrawable( R.drawable.menu ));
        
        spec.setContent(new Intent(ScrollTabActivity.this, Tab1.class));
        mTabHost.addTab(spec);
        
        
        spec = mTabHost.newTabSpec("Tab_Text2");
        spec.setIndicator("Album",getResources().getDrawable( R.drawable.menu ));
        spec.setContent(new Intent(ScrollTabActivity.this, Tab2.class));
        mTabHost.addTab(spec);
        
        spec = mTabHost.newTabSpec("Tab_Text3");
        spec.setIndicator("Music",getResources().getDrawable( R.drawable.menu ));
        spec.setContent(new Intent(ScrollTabActivity.this, Tab3.class));
        mTabHost.addTab(spec);
        
        spec = mTabHost.newTabSpec("Tab_Text4");
        spec.setIndicator("Music",getResources().getDrawable( R.drawable.menu ));
        spec.setContent(new Intent(ScrollTabActivity.this, Tab3.class));
        mTabHost.addTab(spec);
       
     
        
       
        
        mTabHost.setCurrentTab(0);
    }
 
}