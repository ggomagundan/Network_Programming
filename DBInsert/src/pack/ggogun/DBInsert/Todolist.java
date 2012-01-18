package pack.ggogun.DBInsert;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.widget.BaseAdapter;
import android.widget.SimpleAdapter;

public class Todolist {
	
	public Todolist(Activity A){
		
		super();
		
		_Act1 = A;
		_DB = _Act1.openOrCreateDatabase("ggoma", _Act1.MODE_PRIVATE,null);
		_DB.execSQL("Create Table IF NOT EXISTS Todolist (Title varchar)");
		adapter = new SimpleAdapter(
				_Act1, _Data, android.R.layout.simple_list_item_2, 
				new String[]( "Title", "Title" ), 
				new int[]( android.R.id.text1, android.R.id.text2 )
				);
				
		
		refresh();
		
	
	}
	
	public void append(String title){
		
		_DB.execSQL("Insert into Todolist (Title) values ('" + title + "')");
		
		
		
	}
	
	public void refresh(){
		
		
	}
	
	
	public BaseAdapter adapter = null;
		
	private ArrayList<HashMap<String,String>> _Data = new ArrayList<HashMap<String,String>>();
	private SQLiteDatabase _DB = null;
	
	private Activity _Act1 = null;
	
	
	

}
