package kr.ggogun.gamebasic.constants;

import org.cocos2d.nodes.CCDirector;
import org.cocos2d.types.CGSize;

public class BasicConstants {
	
	private final static CGSize s = CCDirector.sharedDirector().winSize();
		
	public final static float GAME_WIDTH = 480;
	public final static float GAME_HEIGHT = 800;
	
	public final static float DISPLAY_WIDTH =  s.width;
	public final static float DISPLAY_HEIGHT = s.height;
	
	public final static float WIDTH_GAP = (DISPLAY_WIDTH - GAME_WIDTH)/2;
	public final static float HEIGHT_GAP = (DISPLAY_HEIGHT - GAME_HEIGHT)/2;
	
	public final static float scale = DISPLAY_WIDTH / GAME_WIDTH;
	
	public static boolean isShowCredit = false;
	
	public final static String BACK_BUTTON_IMG = "img/back.png";
	
	public final static String MENU_BACKGROUND_IMG = "img/main/menulayer.png";
	public final static String MENU_START_BUTTON_IMG = "img/main/menu_start.png";
	public final static String MENU_STORY_BUTTON_IMG = "img/main/menu_story.png";
	public final static String MENU_TUTORIAL_BUTTON_IMG = "img/main/menu_tutorial.png";
	
	public final static String MENU_INFO_BUTTON_IMG = "img/main/menu_info.png";

	public final static String CREDIT_BACKGROUND_IMG = "img/main/credit_bg.png";
	public final static String CREDIT_CLOSE_IMG = "img/main/credit_close_button.png";
	
	public final static String GAME_BACKGROUND_IMG = "img/game/game_background.png";
	
	
	public final static String[] TUTORIAL_IMG_LIST = 
		{
			"img/tutorial/tutorial_first.png",
			"img/tutorial/tutorial_second.png",
			"img/tutorial/tutorial_third.png",
		};
	public final static String NEXT_BUTTON_IMG = "img/tutorial/next.png";
	public final static String PRE_BUTTON_IMG = "img/tutorial/previous.png";
	
	
	public final static String STORY_BACKGROUND_IMG = "img/story/story_background.png";

}

