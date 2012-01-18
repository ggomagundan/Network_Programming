package pack.ggogun.DBInsert;


import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

public class main extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        _todo = new Todolist(this);
     
        _edit = (EditText) findViewById(R.id.text);
        _edit.setOnKeyListener(on_KeyEvent);
        
        _list = (ListView) findViewById(R.id.list);
        
        
        
        
    }
    
    private Todolist _todo = null;
    private EditText _edit = null;
    private ListView _list = null;
    
    
    private View.OnKeyListener on_KeyEvent = new View.OnKeyListener() {
		public boolean onKey(View arg0, int arg1, KeyEvent arg2) {
			// TODO Auto-generated method stub
			return false;
		}
    	
    			
	};

}