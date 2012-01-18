package menu;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import constants.GEconstants.EFileMenuItems;

public class GEMenuFile extends JMenu{

	public GEMenuFile(String Label){
		super(Label);
		
		for(EFileMenuItems btn: EFileMenuItems.values()){
			
			JMenuItem MenuItem = new JMenuItem(btn.toString());
			this.add(MenuItem);
			
			
			
		}
	}
}
