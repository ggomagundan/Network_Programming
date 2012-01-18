package SubMenu;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class LikeMovieSubMenu extends JMenu {
	
	private JMenuItem Like_Melo;
	private JMenuItem Like_Adult;
	
	public LikeMovieSubMenu(){
		
		super("øµ»≠");
		
		Like_Melo = new JMenuItem("∏·∑Œ");
		this.add(Like_Melo);
		
		Like_Adult = new JMenuItem("π«»Ó«—");
		this.add(Like_Adult);
		
		
	}

}
