package SubMenu;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class SNSIDSubMenu extends JMenu {
	
	private JMenuItem Twitter_ID;
	private JMenuItem Me2Day_ID;
	private JMenuItem Talktiny_ID;
	
	public SNSIDSubMenu(){
		
		super("SNS ID");
		
		Twitter_ID = new JMenuItem("twitter.com/ggomagundan");
		this.add(Twitter_ID);
		
		Me2Day_ID = new JMenuItem("me2day.net/ggogun");
		this.add(Me2Day_ID);
		
		Talktiny_ID = new JMenuItem("talktiny.com/ggogun");
		this.add(Talktiny_ID);
		
		
	}

}
