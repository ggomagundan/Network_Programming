package pack.ggogun.core;

import ryulib.graphic.Boundary;

public class Missile {
	
	public void Initialize() {
		setVisible(false);
	}
	
	public void Tick(long ATick) {
		if (getVisible() == false) return;
		
		int _Speed = (int) (300*ATick/1000);  
		_Boundary.setTop(_Boundary.getTop() - _Speed);
		if (_Boundary.getTop() < (-_Boundary.getHeight())) setVisible(false); 
		
		if (_OnMissileMoved != null) _OnMissileMoved.Moved(_Boundary);
	}
	
	public void FireMissile(Boundary AAirCraftBoundary) {
		
		if (getVisible()) return;
		
		_Boundary.setLeft(
				AAirCraftBoundary.getLeft() 
				+ (AAirCraftBoundary.getWidth() / 2)
				- (_Boundary.getWidth() / 2)
		);
		
		_Boundary.setTop(AAirCraftBoundary.getTop() - _Boundary.getHeight());

		setVisible(true);
		if (_OnMissileMoved != null) _OnMissileMoved.Moved(_Boundary);
	}
	
	public void Bang() {
		setVisible(false);
	}
	
	// Visible Property
	private boolean _Visible = false;
	public boolean getVisible() {
		return _Visible;		
	}
	public void setVisible(boolean AValue) {
		_Visible = AValue;
		if (AValue == false) {
			_Boundary.setTop(-100);
			if (_OnMissileMoved != null) _OnMissileMoved.Moved(_Boundary);
		}
	}
	
	// OnMissileMoved Event
	private OnMissileMoved _OnMissileMoved = null;
	public void setOnMissileMoved(OnMissileMoved AValue) {
		_OnMissileMoved = AValue;		
	}

	private Boundary _Boundary = new Boundary(0, 0, 10, 10);
	
}
