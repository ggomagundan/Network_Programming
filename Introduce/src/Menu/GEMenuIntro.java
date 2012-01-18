package Menu;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class GEMenuIntro extends JMenu{

	private JMenuItem Name;
	private JMenuItem Student_Num;
	private JMenuItem Living_Location;
	
	
	public GEMenuIntro(String Label){
		super(Label);
		
		//이름, 학번, 사는 곳
		
		Name = new JMenuItem("이름 : 박병상");
		this.add(Name);
		
		Student_Num = new JMenuItem("학번 : 60072402");
		this.add(Student_Num);
		
		Living_Location = new JMenuItem("사는 곳 : 명덕관 547호");
		this.add(Living_Location);
		
		
		
		
		
	
			
			
			
		}
	}


