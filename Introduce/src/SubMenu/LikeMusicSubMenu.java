package SubMenu;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class LikeMusicSubMenu extends JMenu {
	
	private JMenuItem Like_Ballad;
	private JMenuItem Like_Indi;
	
	public LikeMusicSubMenu(){
		
		super("����");
		
		Like_Ballad = new JMenuItem("�߶��");
		this.add(Like_Ballad);
				
		Like_Indi = new JMenuItem("�ε�");
		this.add(Like_Indi);
		
		
	}

}
