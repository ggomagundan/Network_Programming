package pack.ggogun.thread01;


import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

public class thread extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        tv = (TextView) findViewById(R.id.Textview);
        //(new countThread()).start();
        countThread _countThread = new countThread();
        _countThread.setDaemon(true);
        _countThread.start();
        
        
        
        
    }
    private TextView tv = null;
    
    private Handler handler = new Handler(){
    	public void handleMessage(Message msg){
    		tv.setText(Integer.toString(count));
    	}
    };
    
    int count=0;
    class countThread extends Thread{
    	public void run(){
    		
    		while(true){
    			count++;
    			if(count %10 ==0)
    				handler.sendEmptyMessage(0);
    			try{
    				Thread.sleep(200);
    			}catch(Exception e){}
    		}
    	}
    	
    }
}