package menu;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import constants.GEconstants.EColorMenuItems;
import constants.GEconstants.EFileMenuItems;

public class GEMenuColor extends JMenu{

	public GEMenuColor(String Label){
		super(Label);
		
		for(EColorMenuItems btn: EColorMenuItems.values()){
			
			JMenuItem MenuItem = new JMenuItem(btn.toString());
			this.add(MenuItem);
			
			
		}
	}
}
