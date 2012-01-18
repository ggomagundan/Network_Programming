package pack.ggogun.player;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class player extends Activity{
	
	private MediaPlayerView view;
	
	@Override
	public void onCreate(Bundle icicle){
		super.onCreate(icicle);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		view = new MediaPlayerView(this);
		setContentView(view);
	}
	
	@Override
	public void onStop(){
		super.onStop();
		view.stopSound();
	}
}