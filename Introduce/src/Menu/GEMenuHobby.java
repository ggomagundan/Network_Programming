package Menu;

import javax.swing.JMenu;
import javax.swing.JMenuItem;



public class GEMenuHobby extends JMenu{
	
	
	private JMenuItem Listen_Music;
	private JMenuItem See_Movie;
	
	public GEMenuHobby(String Label){
		
		// ���� ����, ��� ����
		
		super(Label);
			
			
		Listen_Music = new JMenuItem("���� ����");
		this.add(Listen_Music);
		
		See_Movie = new JMenuItem("��� ����");
		this.add(See_Movie);
		
		
	}
	
}
