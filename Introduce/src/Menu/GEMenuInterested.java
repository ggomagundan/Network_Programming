package Menu;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class GEMenuInterested extends JMenu {
	
	private JMenuItem Android_Programming;
	private JMenuItem Studying_Major;
	private JMenuItem Studying_Original_Chinese;
	private JMenuItem Studying_Japaness;
	private JMenuItem Find_GirlFriends;
	
	
	public GEMenuInterested(String Label){
		
		super(Label);
		
		//AndroidAppProgramming, ��������, , �ѹ�, �Ͼ�, ��ģ�ޱ�
		
		Android_Programming = new JMenuItem("�ȵ���̵� ���α׷���");
		this.add(Android_Programming);
		
		Studying_Major = new JMenuItem("��������");
		this.add(Studying_Major);
		
		Studying_Original_Chinese = new JMenuItem("�ѹ�����");
		this.add(Studying_Original_Chinese);
		
		Studying_Japaness = new JMenuItem("�Ͼ����");
		this.add(Studying_Japaness);
		
		this.addSeparator();
		
		Find_GirlFriends = new JMenuItem("��ģ �ޱ�");
		this.add(Find_GirlFriends);
		
		
		
		
	}
}
