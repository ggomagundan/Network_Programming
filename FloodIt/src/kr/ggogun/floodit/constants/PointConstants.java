package kr.ggogun.floodit.constants;

import org.cocos2d.nodes.CCSprite;
import org.cocos2d.types.CGPoint;

public class PointConstants {

	public static final CGPoint CENTER_POINT = CGPoint.make(BasicConstants.DISPLAY_WIDTH/2,BasicConstants.DISPLAY_HEIGHT/2);

	public static final CGPoint BACK_BUTTON_POSITION = CGPoint.make(BasicConstants.WIDTH_GAP + CCSprite.sprite(BasicConstants.BACK_BUTTON_IMG).getTexture().getWidth()/2,
			BasicConstants.DISPLAY_HEIGHT -(BasicConstants.HEIGHT_GAP + CCSprite.sprite(BasicConstants.BACK_BUTTON_IMG).getTexture().getHeight()/2));
	
	public static final CGPoint START_BUTTON_POSITION = CGPoint.make(BasicConstants.DISPLAY_WIDTH/2,BasicConstants.DISPLAY_HEIGHT/12*7);
	public static final CGPoint STORY_BUTTON_POSITION = CGPoint.make(BasicConstants.DISPLAY_WIDTH/2,BasicConstants.DISPLAY_HEIGHT/12*5);
	public static final CGPoint TUTORIAL_BUTTON_POSITION = CGPoint.make(BasicConstants.DISPLAY_WIDTH/2,BasicConstants.DISPLAY_HEIGHT/12*3);

	
	public static final CGPoint INFORMATION_BUTTON_POSITION = CGPoint.make(BasicConstants.GAME_WIDTH+ BasicConstants.WIDTH_GAP -  CCSprite.sprite(BasicConstants.MENU_INFO_BUTTON_IMG).getTexture().getWidth()/2,
			BasicConstants.HEIGHT_GAP+ CCSprite.sprite(BasicConstants.MENU_INFO_BUTTON_IMG).getTexture().getHeight()/2);
	public static final CGPoint CREDIT_EXIT_POSITION = CGPoint.make(CENTER_POINT.x,  CENTER_POINT.y - CCSprite.sprite(BasicConstants.CREDIT_BACKGROUND_IMG).getTexture().getHeight()/2 + CCSprite.sprite(BasicConstants.CREDIT_CLOSE_IMG).getTexture().getHeight()/2);

	public static final CGPoint PREVIOUS_BUTTON_POSITION = CGPoint.make(BasicConstants.WIDTH_GAP +  CCSprite.sprite(BasicConstants.PRE_BUTTON_IMG).getTexture().getWidth()/2,
			BasicConstants.HEIGHT_GAP+ CCSprite.sprite(BasicConstants.PRE_BUTTON_IMG).getTexture().getHeight()/2);
	public static final CGPoint NEXT_BUTTON_POSITION = CGPoint.make(BasicConstants.WIDTH_GAP +BasicConstants.GAME_WIDTH - CCSprite.sprite(BasicConstants.NEXT_BUTTON_IMG).getTexture().getWidth()/2,
			BasicConstants.HEIGHT_GAP+ CCSprite.sprite(BasicConstants.NEXT_BUTTON_IMG).getTexture().getHeight()/2);

	public static final CGPoint EASY_BUTTON_POSITION = CGPoint.make(BasicConstants.DISPLAY_WIDTH/2,BasicConstants.DISPLAY_HEIGHT/12*7);

	public static final CGPoint NORMAL_BUTTON_POSITION = CGPoint.make(BasicConstants.DISPLAY_WIDTH/2,BasicConstants.DISPLAY_HEIGHT/12*5);

	public static final CGPoint HARD_BUTTON_POSITION = CGPoint.make(BasicConstants.DISPLAY_WIDTH/2,BasicConstants.DISPLAY_HEIGHT/12*3);
	
	
	
}
