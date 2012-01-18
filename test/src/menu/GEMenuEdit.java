package menu;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import constants.GEconstants.EColorMenuItems;
import constants.GEconstants.EEditMenuItems;
import constants.GEconstants.EFileMenuItems;

public class GEMenuEdit extends JMenu{

	public GEMenuEdit(String Label){
		super(Label);
		
		for(EEditMenuItems btn: EEditMenuItems.values()){
			
			JMenuItem MenuItem = new JMenuItem(btn.toString());
			this.add(MenuItem);
			
		}
	}
}
