package pack.ggogun.core;

public class Boundary {

	 Boundary(int Left, int Top, int Right, int Bottom){
		setBoundary(Left, Top, Right, Bottom);
		
		
		
	}
	
	private int _Left;
	private int _Right;
	private int _Top;
	private int _Bottom;
	
	public void setLeft(int Left){
		int temp = _Left;
		
		_Left = Left;
		_Right = _Right + _Left - temp;
		
		
	}
	
	public void setBoundary(int Left, int Top, int Right, int Bottom){
		
		_Left= Left;
		_Right= Right;
		_Top= Top;
		_Bottom= Bottom;
		
	}
	
	public int getLeft(){
		return _Left;
		
	}
	
	public int getRight(){
		return _Right;
		
	}
	
	public int getTop(){
		return _Top;
		
	}
	
	public int getBottom(){
		return _Bottom;
		
	}
}
