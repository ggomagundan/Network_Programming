package Menu;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class GEMenuIntro extends JMenu{

	private JMenuItem Name;
	private JMenuItem Student_Num;
	private JMenuItem Living_Location;
	
	
	public GEMenuIntro(String Label){
		super(Label);
		
		//�̸�, �й�, ��� ��
		
		Name = new JMenuItem("�̸� : �ں���");
		this.add(Name);
		
		Student_Num = new JMenuItem("�й� : 60072402");
		this.add(Student_Num);
		
		Living_Location = new JMenuItem("��� �� : ����� 547ȣ");
		this.add(Living_Location);
		
		
		
		
		
	
			
			
			
		}
	}


