package pack.ggogun.core;

import ryulib.graphic.Boundary;

public class AirCraft {
	
	public void Initialize(){
		
	}
	
	public void MoveAirCraft(int dx){
		// Todo : 움직일수 있는 지 검사
		_Boundary.setLeft(_Boundary.getLeft()+ dx);
		if(_OnAirCraftMoved != null)
			_OnAirCraftMoved.Moved(_Boundary);
		
	}
	
	public Boundary getBoundary(){
		return _Boundary;
	}
	
	private boolean check_Vert(Boundary ABoundary){
		return 
			(ABoundary.getBottom() >= _Boundary.getTop())&&
			(ABoundary.getBottom() <= _Boundary.getBottom());
		
		
	}
	
	private boolean check_Hori(Boundary ABoundary){
		return 
			((ABoundary.getLeft() >= _Boundary.getLeft() &&
			 (ABoundary.getLeft() <= _Boundary.getRight())) ||
			 (ABoundary.getRight() >= _Boundary.getLeft() &&
			 (ABoundary.getRight() <- _Boundary.getRight())));
	}
	
	public boolean CheckCollision(Boundary ABoundary){
		return check_Vert(ABoundary) && check_Hori(ABoundary);
	}
	
	public void setOnAirCraftMoved(OnAirCraftMoved AOnAirCraftMoved){
		_OnAirCraftMoved = AOnAirCraftMoved;
		
	}
	
	private Boundary _Boundary = new Boundary(0, 0, 32, 32);
	private OnAirCraftMoved _OnAirCraftMoved = null;
	
}
`