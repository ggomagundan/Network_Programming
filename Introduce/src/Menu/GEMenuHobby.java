package Menu;

import javax.swing.JMenu;
import javax.swing.JMenuItem;



public class GEMenuHobby extends JMenu{
	
	
	private JMenuItem Listen_Music;
	private JMenuItem See_Movie;
	
	public GEMenuHobby(String Label){
		
		// 음악 감상, 드라마 감상
		
		super(Label);
			
			
		Listen_Music = new JMenuItem("음악 감상");
		this.add(Listen_Music);
		
		See_Movie = new JMenuItem("드라마 감상");
		this.add(See_Movie);
		
		
	}
	
}
