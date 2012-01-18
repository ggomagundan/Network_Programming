package pack.ggogun.images;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.TextView;

public class images extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        box = new drawBox(this);
        ((AbsoluteLayout) findViewById(R.id.AbLayout)).addView(box);
        
        Button btn, btn1,btn2,btn3;
        
        btn = (Button) findViewById(R.id.leftbtn);
        btn.setOnClickListener(on_left);
        btn1 = (Button) findViewById(R.id.rigbtn);
        btn1.setOnClickListener(on_right);
        (btn2 = (Button) findViewById(R.id.btnup)).setOnClickListener(on_up);
        (btn3 = (Button) findViewById(R.id.btndown)).setOnClickListener(on_down);
        
     
        
        
        
        
    }
    
    private drawBox box;
    
    
    private View.OnClickListener on_left = new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			box.move_left(10);
			
			TextView text = (TextView)findViewById(R.id.text);
			text.setText("왼쪽 이동");
			
			
		}
	};
	
	private View.OnClickListener on_right = new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			
			box.move_right(10);
			TextView text = (TextView)findViewById(R.id.text);
			text.setText("오른쪽 이동");
			
		}
	};
	
	 private View.OnClickListener on_up = new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				box.move_up(10);
				TextView text = (TextView)findViewById(R.id.text);
				text.setText("위쪽 이동");
						
				
			}
		};
		
		 private View.OnClickListener on_down = new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
					box.move_down(10);
					TextView text = (TextView)findViewById(R.id.text);
					text.setText("아래쪽 이동");
						
					
				}
			};
}

