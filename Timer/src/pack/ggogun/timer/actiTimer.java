package pack.ggogun.timer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

public class actiTimer extends Activity {
   

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(find);
        
             
     
    }
    
    private View.OnClickListener find = new View.OnClickListener() {
		
    	@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
    		
    		DatePicker date = (DatePicker) findViewById(R.id.date);
    		EditText day = (EditText) findViewById(R.id.day);
    		TextView text = (TextView) findViewById(R.id.text);
    		
    		Calendar _calendar = new GregorianCalendar(
    				date.getYear(),
    				date.getMonth(),
    				date.getDayOfMonth()
    		);
    		
    		_calendar.add(Calendar.DATE,(Integer.parseInt(day.getText().toString())));
    		
			SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
			
			text.setText("찾으시는 날짜 : " + dateformat.format(_calendar.getTime()) + "입니다. ");
		
			
		}
	};
    	
    	
    
    	
    	
    
    	
    	
    
}