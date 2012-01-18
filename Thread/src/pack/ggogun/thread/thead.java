package pack.ggogun.thread;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class thead extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        btn = (Button)findViewById(R.id.Button01);
        btn.setOnClickListener(btn_click);
(new plusThread()).start();
(new minusThread()).start();
        
    }
    int count = 0;
    private void plusorminus(int value){
    	
    	synchronized (this) {
		
      	
        	int temp;
    	
    		temp = getcount();
    		try {
    			Thread.sleep(10);
    		} catch (InterruptedException e) {
    		
    		}
    		setcount(temp +value);
    	}
    	
    		
		
    	
    }
    public int getcount(){
    	return count;
    }
    
    public void setcount(int value){
    	count = value;
    }
    private Button btn = null;
    
    private View.OnClickListener btn_click = new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			btn.setText(Integer.toString(count));
		}
	};
	
	class plusThread extends Thread{
		public void run(){
			
			for(int i = 0;i < 100;i++){
			plusorminus(1);
			}
		}
	}
	
	class minusThread extends Thread{
		public void run(){
			for(int i = 0;i < 100;i++){
				plusorminus(-1);
				}
		}
	}
    
}