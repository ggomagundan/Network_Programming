package kr.ggogun.intentTest;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

public class FirIntent extends Activity implements OnClickListener  {
    EditText text;
	SeekBar sbar;
	RadioGroup rGroup;
	Spinner spinner;
	AlertDialog.Builder alert;
	private RadioButton rbtn1;
	private RadioButton rbtn2;
	private RadioButton rbtn3;
	int checkRadio;
	int checkSpinner;
	String items[] = { "No.1", "No. 2", "No. 3", "No. 4", "No. 5", "No. 6"};

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.main);
        
        ArrayAdapter<String> aa = new ArrayAdapter<String> (this,android.R.layout.simple_spinner_item, items );
        text = (EditText)findViewById(R.id.editText1);
        sbar = (SeekBar) findViewById(R.id.SBar);
        spinner = (Spinner) findViewById(R.id.spin);
        rGroup = (RadioGroup)findViewById(R.id.RGroup);
        rbtn1 = (RadioButton)findViewById(R.id.r1);
        rbtn2 = (RadioButton)findViewById(R.id.r2);
        rbtn3 = (RadioButton)findViewById(R.id.r3);
        
        Button btn = (Button)findViewById(R.id.sendBtn);
        
        TextView tv = (TextView)findViewById(R.id.result);
        ImageView iv = (ImageView) findViewById(R.id.Image1);
        
        
        spinner.setAdapter(aa);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
              
            	checkSpinner = pos;
            }
            public void onNothingSelected(AdapterView<?> parent) {
            	
            }
        });
        
        
        		
     
        		
        		
        Intent intent = getIntent();
        String txt = intent.getStringExtra("text");
        int seekValue = intent.getIntExtra("seek", 0);
        checkRadio = intent.getIntExtra("radio", 1);
        checkSpinner = intent.getIntExtra("spin", 0);
        if(txt != null)
        	text.setText(txt);
        sbar.setProgress(seekValue);
       
        switch(checkRadio){
	        case 1:
	        	rbtn1.setChecked(true);
	        	break;
	        case 2:
	        	rbtn2.setChecked(true);
	        	break;
	        case 3:
	        	rbtn3.setChecked(true);
	        	break;
        	
        }
        
        rGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				if(checkedId == R.id.r1) {
					checkRadio=1;
	            }
	            else if(checkedId == R.id.r2) {
	            	checkRadio=2;
	            }
	            else if(checkedId == R.id.r3) {
	            	checkRadio=3;
	            }
			}
		});
               
        spinner.setSelection(checkSpinner);
        
        
        tv.setText("String : " + text.getText().toString() + "\nProgress : " + seekValue + "\nSelectList : " + items[checkSpinner]  + "\nRadioButton : " + checkRadio);
        btn.setOnClickListener(this);
        
        iv.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				 Intent intent = new Intent();
			        intent.setAction(Intent.ACTION_VIEW);
			        intent.addCategory(Intent.CATEGORY_BROWSABLE);
			        intent.setData(Uri.parse("http://www.ggogun.kr"));
			        startActivity(intent);

			}
		});
    }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent = new Intent(this, SecIntent.class);
		intent.putExtra("text", text.getText().toString());
		intent.putExtra("seek", sbar.getProgress());
		intent.putExtra("radio", checkRadio);
		intent.putExtra("spin", checkSpinner);
		
		startActivity(intent);
	}

	
       
        		
        		
        
}