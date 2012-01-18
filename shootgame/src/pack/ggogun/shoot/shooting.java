package pack.ggogun.shoot;

import pack.ggogun.core.Core;
import pack.ggogun.core.OnAirCraftMoved;
import pack.ggogun.global.global;
import pack.ggogun.view.EnemyView;
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class shooting extends Activity {
	private ViewGroup _alGameScreen = null;
    private Button _btStartGame = null;

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        _alGameScreen = (ViewGroup) findViewById(R.id.GameScreen);
        _alGameScreen.setFocusable(true);
        _alGameScreen.setFocusableInTouchMode(true);
        _alGameScreen.setOnKeyListener(on_KeyPressed);
    
        _btStartGame = (Button) findViewById(R.id.GameStart);
        _btStartGame.setFocusable(false);
        _btStartGame.setFocusableInTouchMode(false);
        _btStartGame.setOnClickListener(on_StartGame);
        
        int i;
        for (i=0; i<10; i++) {
        	EnemyView _EnemyView = new EnemyView(this, i);
        	_alGameScreen.addView(_EnemyView);
        }
    }

	private View.OnKeyListener on_KeyPressed = new View.OnKeyListener() {
		public boolean onKey(View v, int keyCode, KeyEvent event) {
			switch (keyCode) {
				case KeyEvent.KEYCODE_DPAD_LEFT:					
					if (event.getAction() == KeyEvent.ACTION_DOWN) Core.Obj().MoveAirCraft(-1);
					else if (event.getAction() == KeyEvent.ACTION_UP) Core.Obj().MoveAirCraft(0);
					break;
					
				case KeyEvent.KEYCODE_DPAD_RIGHT:  
					if (event.getAction() == KeyEvent.ACTION_DOWN) Core.Obj().MoveAirCraft(1);
					else if (event.getAction() == KeyEvent.ACTION_UP) Core.Obj().MoveAirCraft(0);
					break;

				case KeyEvent.KEYCODE_DPAD_CENTER: 
				case KeyEvent.KEYCODE_SPACE: 
					Core.Obj().FireMissile(); 
					break; 
			}

			return true;
		}
	};
    
    private View.OnClickListener on_StartGame = new View.OnClickListener() {
		public void onClick(View v) {
			global.Obj().getScreenBoundary().setBoundary(_alGameScreen.getLeft(), _alGameScreen.getTop(), _alGameScreen.getRight(), _alGameScreen.getBottom());
			Core.Obj().StartGame();
		}
	};

}
