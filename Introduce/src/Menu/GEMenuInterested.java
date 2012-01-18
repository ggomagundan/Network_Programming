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
		
		//AndroidAppProgramming, 전공공부, , 한문, 일어, 여친급구
		
		Android_Programming = new JMenuItem("안드로이드 프로그래밍");
		this.add(Android_Programming);
		
		Studying_Major = new JMenuItem("전공공부");
		this.add(Studying_Major);
		
		Studying_Original_Chinese = new JMenuItem("한문공부");
		this.add(Studying_Original_Chinese);
		
		Studying_Japaness = new JMenuItem("일어공부");
		this.add(Studying_Japaness);
		
		this.addSeparator();
		
		Find_GirlFriends = new JMenuItem("여친 급구");
		this.add(Find_GirlFriends);
		
		
		
		
	}
}
