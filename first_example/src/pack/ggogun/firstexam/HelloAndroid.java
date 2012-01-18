package pack.ggogun.firstexam;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class HelloAndroid extends View {

	
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		canvas.drawText("hello dddAndroid",0,12,new Paint());
	}

	public HelloAndroid(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	

}
