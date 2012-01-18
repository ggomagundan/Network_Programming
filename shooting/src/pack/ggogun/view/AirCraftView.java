package pack.ggogun.view;

import ryulib.mvc.ValueList;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

public class AirCraftView extends ImageView {

	public AirCraftView(Context context) {
		super(context);

		ViewList.Obj().Add(this);
	}

	public AirCraftView(Context context, AttributeSet attrs) {
		super(context, attrs);

		ViewList.Obj().Add(this);
	}

	public AirCraftView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);

		ViewList.Obj().Add(this);
	}
	
	public void rp_AirCraftMoved(ValueList APacket) {
		layout(APacket.getInt("Left"), APacket.getInt("Top"), APacket.getInt("Left")+32, APacket.getInt("Top")+32);
	}

}
