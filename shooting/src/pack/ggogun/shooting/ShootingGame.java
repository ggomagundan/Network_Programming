package pack.ggogun.shooting;

import pack.ggogun.core.core;
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnKeyListener;
import android.widget.Button;

public class ShootingGame extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    
        _alGameScreen = (ViewGroup) findViewById(R.id.alGameScreen);
        _alGameScreen.setFocusable(true);
        _alGameScreen.setFocusableInTouchMode(true);
        _alGameScreen.setOnKeyListener(on_KeyPressed);
        
        
        
        _btStartGame = (Button) findViewById(R.id.alGameScreen);
        _btStartGame.setFocusable(false);
        _btStartGame.setFocusableInTouchMode(false);
        _btStartGame.setOnClickListener(on_StartGame);
        
     /*  _TextView = (TextView) findViewById(R.id.TextView);
        
        
        _btLeft = (Button) findViewById(R.id.Button01);
        _btLeft.setOnClickListener(on_Left);
        
        _btRight = (Button) findViewById(R.id.Button02);
        _btRight.setOnClickListener(on_Right);
        _Core.setOnAirCraftMoved(on_AirCraftMoved);
       */ 
    }
    private View.OnKeyListener on_KeyPressed = new View.OnKeyListener() {
		
		
		public boolean onKey(View arg0, int arg1, KeyEvent arg2) {
			// TODO Auto-generated method stub
			return false;
		}
	};
	
	private View.OnClickListener on_StartGame = new View.OnClickListener() {
		
		
		public void onClick(View v) {
			core.Obj().StartGame();
			
			
		
			
		}
	};
    private ViewGroup _alGameScreen = null;
    private Button _btStartGame = null;
    

    
    
     /*   
    private core _Core = new core();
    
    
    private TextView _TextView = null;
    private Button _btLeft = null;
    private Button _btRight = null;
    
    private View.OnClickListener on_Left = new  View.OnClickListener(){
    	public void onClick(View v){
    		_Core.MoveAirCraft(-1);
    	}
    };
    
    private View.OnClickListener on_Right = new View.OnClickListener(){
    	public void onClick(View v){
    		_Core.MoveAirCraft(1);
    	}
    };
    
    private OnAirCraftMoved on_AirCraftMoved = new OnAirCraftMoved(){
    	public void moved(Boundary ABoundary) {
    		_TextView.setText(String.format("%d", ABoundary.getLeft()));
    		
			
		}

		
    };
    
*/
}