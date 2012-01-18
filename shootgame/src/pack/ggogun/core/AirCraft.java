package pack.ggogun.core;

import pack.ggogun.global.global;
import ryulib.graphic.Boundary;



public class AirCraft {
	
	private void move_AirCraft(int ALeft, int ATop) {
		_Boundary.setLeft(ALeft);
		if (_Boundary.getLeft() < 0) _Boundary.setLeft(0);

		Boundary _ScreenBoundary = global.Obj().getScreenBoundary();
		_Boundary.setTop (ATop);
		if (_Boundary.getRight() > _ScreenBoundary.getRight()) _Boundary.setRight(_ScreenBoundary.getRight());		

		if (_OnAirCraftMoved != null) _OnAirCraftMoved.Moved(_Boundary);
	}

	private void do_SetAirCraftPosition() {
		Boundary _ScreenBoundary = global.Obj().getScreenBoundary();
		int iLeft = (_ScreenBoundary.getWidth() / 2) - (_Boundary.getWidth() / 2);
		int iTop  = _ScreenBoundary.getHeight() - _Boundary.getHeight();
		
		move_AirCraft(iLeft, iTop);
	}
	
	public void Initialize() {
		do_SetAirCraftPosition();
	}
	
	public void Tick(long ATick) {
		if (_DX == 0) return;
		
		int _Speed = (int) (100*ATick/1000);  
		int iLeft = _Boundary.getLeft() + (_DX * _Speed);
		
		move_AirCraft(iLeft, _Boundary.getTop());
	}
	
	public void MoveAirCraft(int dx) {
		_DX = dx;
	}
	
	public Boundary getBoundary() {
		return _Boundary;
	}
	
	public boolean CheckCollision(Boundary ABoundary) {
		return _Boundary.CheckCollision(ABoundary);
	}
	
	private OnAirCraftMoved _OnAirCraftMoved = null;
	public void setOnAirCraftMoved(OnAirCraftMoved AValue) {
		_OnAirCraftMoved = AValue;
	}
	
	private Boundary _Boundary = new Boundary(0, 0, 32, 32);
	private int _DX = 0;

}

