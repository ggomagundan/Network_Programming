package pack.ggogun.player;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class MediaPlayerView extends View implements MediaPlayer.OnCompletionListener{
	
	private MediaPlayer player;
	
	public MediaPlayerView(Context context){
		super(context);
		setBackgroundColor(Color.WHITE);
		setFocusable(true);
		player = null;
	}
	
	@Override
	public void onDraw(Canvas canvas){
		Paint paint = new Paint();
		paint.setAntiAlias(true);
		paint.setTextSize(32);
		canvas.drawText("MediaPlayerEx", 0, 40, paint);
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event){
		if(event.getAction() == MotionEvent.ACTION_DOWN){
			if(player == null){
				playSound();
			} else {
				stopSound();
			}
		}
		return true;
	}
	
	public void playSound(){
		try{
			stopSound();
			player = MediaPlayer.create(getContext(), R.raw.mad);
			player.seekTo(0);
			player.start();
			
			player.setOnCompletionListener(this);
		} catch(Exception e){
			Log.d("error log", e.getMessage());
		}
	}
	
	public void stopSound(){
		try{
			if(player == null){
				return;
			}
			player.stop();
			player.setOnCompletionListener(null);
			player.release();
			player = null;
		} catch(Exception e){
			Log.d("error log", e.getMessage());
		} 
	}
	
	@Override
	public void onCompletion(MediaPlayer mediaplayer) {
		// TODO Auto-generated method stub
		stopSound();
	}
}