package SubMenu;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class LikeMovieSubMenu extends JMenu {
	
	private JMenuItem Like_Melo;
	private JMenuItem Like_Adult;
	
	public LikeMovieSubMenu(){
		
		super("��ȭ");
		
		Like_Melo = new JMenuItem("���");
		this.add(Like_Melo);
		
		Like_Adult = new JMenuItem("������");
		this.add(Like_Adult);
		
		
	}

}
