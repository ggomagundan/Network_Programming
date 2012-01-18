package pack.ggogun.view;

import ryulib.mvc.ValueList;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

public class MissileView extends ImageView {

	public MissileView(Context context) {
		super(context);

		ViewList.Obj().Add(this);
	}

	public MissileView(Context context, AttributeSet attrs) {
		super(context, attrs);

		ViewList.Obj().Add(this);
	}

	public MissileView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);

		ViewList.Obj().Add(this);
	}

	public void rp_MissileMoved(ValueList APacket) {
		layout(APacket.getInt("Left"), APacket.getInt("Top"), APacket.getInt("Left")+10, APacket.getInt("Top")+10);
	}
	
}
