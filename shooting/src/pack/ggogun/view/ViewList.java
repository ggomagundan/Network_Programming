package pack.ggogun.view;

import ryulib.mvc.ObserverList;
import ryulib.mvc.ValueList;

public class ViewList extends ObserverList {
	
	static private ViewList _Views = null;
	
	static public ViewList Obj() {
		if (_Views == null) _Views = new ViewList();
		return _Views;
	}
	
	public void sp_AirCraftMoved(int ALeft, int ATop) {
		ValueList APacket = new ValueList();
		APacket.put("Code", "AirCraftMoved");
		APacket.put("Left", ALeft);
		APacket.put("Top", 	ATop);
		Broadcast(APacket);
	}
	
	public void sp_MissileMoved(int ALeft, int ATop) {
		ValueList APacket = new ValueList();
		APacket.put("Code", "MissileMoved");
		APacket.put("Left", ALeft);
		APacket.put("Top", 	ATop);
		Broadcast(APacket);
	}
	
	public void sp_EnemyCreated(int AEnemyID, int ALeft, int ATop) {
		ValueList APacket = new ValueList();
		APacket.put("Code", "EnemyCreated");
		APacket.put("EnemyID", AEnemyID);
		APacket.put("Left", ALeft);
		APacket.put("Top", 	ATop);
		Broadcast(APacket);
	}
	
	public void sp_EnemyMoved(int AEnemyID, int ALeft, int ATop) {
		ValueList APacket = new ValueList();
		APacket.put("Code", "EnemyMoved");
		APacket.put("EnemyID", AEnemyID);
		APacket.put("Left", ALeft);
		APacket.put("Top", 	ATop);
		Broadcast(APacket);
	}
	
	public void sp_EnemyCrashed(int AEnemyID) {
		ValueList APacket = new ValueList();
		APacket.put("Code", "EnemyCrashed");
		APacket.put("EnemyID", AEnemyID);
		Broadcast(APacket);
	}
	
}
