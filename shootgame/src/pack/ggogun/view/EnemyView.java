package pack.ggogun.view;

import ryulib.mvc.ValueList;
import android.content.Context;
import android.widget.ImageView;
import pack.ggogun.shoot.R;

public class EnemyView extends ImageView {
	
	private int _EnemyID = -1;

	public EnemyView(Context context, int AEnemyID) {
		super(context);
		
		_EnemyID = AEnemyID;
    	setImageDrawable(getResources().getDrawable(R.drawable.enemy));
    	ViewList.Obj().Add(this);
	}
	
	public void rp_EnemyCreated(ValueList APacket) {
    	if (APacket.getInt("EnemyID") == _EnemyID)
			layout(APacket.getInt("Left"), APacket.getInt("Top"), APacket.getInt("Left")+32, APacket.getInt("Top")+32);
	}
	
	public void rp_EnemyMoved(ValueList APacket) {
		if (APacket.getInt("EnemyID") == _EnemyID)
			layout(APacket.getInt("Left"), APacket.getInt("Top"), APacket.getInt("Left")+32, APacket.getInt("Top")+32);
	}
	
	public void rp_EnemyCrashed(ValueList APacket) {
		if (APacket.getInt("EnemyID") == _EnemyID)
			layout(-100, -100, -100, -100);
	}
}

