package menu;

import javax.swing.JMenuBar;

import constants.GEconstants;

public class GEMenuBar extends JMenuBar{

	private GEMenuFile FileMenu;
	private GEMenuEdit EditMenu;
	private GEMenuColor ColorMenu;
	
	public GEMenuBar(){
		FileMenu = new GEMenuFile(GEconstants.Title_FileMenu);
		this.add(FileMenu);
		this.
		EditMenu = new GEMenuEdit(GEconstants.Title_EditMenu);
		this.add(EditMenu);
		ColorMenu = new GEMenuColor(GEconstants.Title_colorMenu);
		this.add(ColorMenu);
		
	}
	
	
	
}
