package pack.ggogun.core;

import ryulib.graphic.Boundary;

public class Enemy {
	
	public int ID = 0;
	public boolean Visible = false;

	// Boundary Property
	private Boundary _Boundary = new Boundary(0, 0, 32, 32);
	public Boundary getBoundary() {
		return _Boundary;		
	}
}
