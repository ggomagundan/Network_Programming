package kr.ggogun.test;

import java.util.ArrayList;
import java.util.HashMap;


import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class TesteActivity extends Activity {
    /** Called when the activity is first created. */
	private ArrayList <HashMap<String, Object>> myBooks;
	private static final String BOOKKEY = "bookname";
	private static final String PRICEKEY = "bookprice";
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ListView listView = (ListView)findViewById(R.id.list);
        myBooks = new ArrayList<HashMap<String,Object>>();
        HashMap<String, Object> hm;
        
       
        //With the help of HashMap add Key, Values of Book, like name,price and icon path 
        hm = new HashMap<String, Object>();
        hm.put(BOOKKEY, "Android");
        hm.put(PRICEKEY, "Price Rs: 500");
      
     
        myBooks.add(hm);
        
        hm = new HashMap<String, Object>();
        hm.put(BOOKKEY, "PHP");
        hm.put(PRICEKEY, "Price Rs: 250");
      
        
        myBooks.add(hm);
        
        hm = new HashMap<String, Object>();
        hm.put(BOOKKEY, "Java");
        hm.put(PRICEKEY, "Price Rs: 399");
      
        
        myBooks.add(hm);
        
        hm = new HashMap<String, Object>();
        hm.put(BOOKKEY, "C++");
        hm.put(PRICEKEY, "Price Rs: 450");
      
     
        myBooks.add(hm);
      // Define SimpleAdapter and Map the values with Row view R.layout.listbox
       SimpleAdapter adapter = new SimpleAdapter(this, myBooks, R.layout.listbox, 
        		new String[]{BOOKKEY,PRICEKEY}, new int[]{R.id.text1, R.id.text2});
       		
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE); 
    }
    

	
}