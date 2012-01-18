package pack.ggogun.db;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

public class dbActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
     
        
        _TvCaption = (TextView) findViewById(R.id.tvCaption);
        _db = this.openOrCreateDatabase("ggogun", MODE_PRIVATE, null);
        // db Create 
        
        
        _db.execSQL("Create Table If Not  EXISTS TodoList (Title varchar)");
        // Table Create
        
        _db.execSQL("Insert into TodoList (Title) values ('study')");
        _db.execSQL("Insert into TodoList (Title) values ('android study')");
        // into Record
        
        Cursor _cursor = _db.rawQuery("Select Title from TodoList", null);
        //DB Connect
        
        String	_Result = "";
        
        if(_cursor.moveToFirst()){
        	do{
        		_Result = _Result + _cursor.getString(0) + "\n";
        		
        	}while(_cursor.moveToNext());
        }
        _TvCaption.setText(_Result);
        
        
    }
    
    private TextView _TvCaption = null;
    private SQLiteDatabase _db = null;
    
    
    
}