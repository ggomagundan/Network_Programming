package pack.ggogun.now.activity;


import pack.ggogun.now.R;
import android.app.Activity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;



public class now extends Activity implements CompoundButton.OnCheckedChangeListener{
    /** Called when the activity is first created. */
    CheckBox cb;
	@Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.main);
        
        cb=(CheckBox)findViewById(R.id.chk);
       
		cb.setOnCheckedChangeListener(this);
	}
	
	public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
		if (isChecked) {
			cb.setText( "체크 상태" );
		}
		else {
			cb.setText( "체크되지 않은 상태" );
		}
	}
}