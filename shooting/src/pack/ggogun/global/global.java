package pack.ggogun.global;

import ryulib.graphic.Boundary;

public class global {

	static private global _Globals = null;
	
	static public global Obj() {
		if (_Globals == null) _Globals = new global();
		return _Globals;
	}
	
	private Boundary _ScreenBoundary = new Boundary(0, 0, 0, 0);
	public Boundary getScreenBoundary() {
		return _ScreenBoundary;
	}

}
