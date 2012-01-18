package Menu;

import javax.swing.JMenuBar;

import Constants.GEConstants;

public class GEMenuBar extends JMenuBar{
	
	private GEMenuIntro IntroduceMenu;
	private GEMenuHobby HobbyMenu;
	private GEMenuLike LikeMenu;
	private GEMenuSNS SNSMenu;
	private GEMenuInterested InterestedMenu;
	
	public GEMenuBar(){
		
		IntroduceMenu = new GEMenuIntro(GEConstants.Title_IntroduceMe_Intro);
		this.add(IntroduceMenu);
		
		HobbyMenu = new GEMenuHobby(GEConstants.Title_IntroduceMe_Hobby);
		this.add(HobbyMenu);
		
		LikeMenu = new GEMenuLike(GEConstants.Title_IntroduceMe_LikeIt);
		this.add(LikeMenu);
		
		SNSMenu = new GEMenuSNS(GEConstants.Title_IntroduceMe_Internet_Id);
		this.add(SNSMenu);
		
		InterestedMenu = new GEMenuInterested(GEConstants.Title_IntroduceMe_Interested);
		this.add(InterestedMenu);
		
		
	}

}
