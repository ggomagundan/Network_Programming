package pack.ggogun.images;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.AttributeSet;
import android.view.View;

public class drawBox extends View {

	public drawBox(Context context) {
		super(context);

		shdraw = new ShapeDrawable (new OvalShape());
		shdraw.getPaint().setColor(0xffFF0000);
		
	}

	public drawBox(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}
/*
	public drawBox(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}
*/
	protected void onDraw(Canvas canvas){
		// 모형 그릴 시 자동 실행
		canvas.drawRect(_x,_y,_x+len,_y+hei,shdraw.getPaint());
	}

	private ShapeDrawable shdraw;
	
	public void move_left(int distance){
			if(_x > 0){
			_x = _x-distance;
			}
			invalidate();
	}
	
	public void move_right(int distance){
			if(_x< 250){
			_x  = _x + distance;
			}
			invalidate();
	}
	
	public void move_up(int distance){
		if(_y > 0){
		_y = _y-distance;
		}
		invalidate();
}
	
	public void move_down(int distance){
		if(_y < 200){
		_y = _y+distance;
		}
		invalidate();
}	
	
	
	
	private int _x = 0;
	private int _y = 0;
	private int len = 50;
	private int hei = 50;
	
	
	
	
	
	
}


