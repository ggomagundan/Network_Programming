package SubMenu;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class LikeMusicSubMenu extends JMenu {
	
	private JMenuItem Like_Ballad;
	private JMenuItem Like_Indi;
	
	public LikeMusicSubMenu(){
		
		super("음악");
		
		Like_Ballad = new JMenuItem("발라드");
		this.add(Like_Ballad);
				
		Like_Indi = new JMenuItem("인디");
		this.add(Like_Indi);
		
		
	}

}
