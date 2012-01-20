package kr.ggogun.gamebasic.source;

import kr.ggogun.gamebasic.constants.BasicConstants;
import kr.ggogun.gamebasic.constants.PointConstants;

import org.cocos2d.layers.CCLayer;
import org.cocos2d.menus.CCMenu;
import org.cocos2d.menus.CCMenuItemImage;
import org.cocos2d.nodes.CCSprite;

public class MenuLayer extends CCLayer {
	
	InfoLayer info;
	
	CCSprite main_background;
	
	CCMenuItemImage startButton;
	CCMenuItemImage storyButton;
	CCMenuItemImage tutorialButton;
	
	CCMenuItemImage informationButton;
	
	
	public MenuLayer(){
		super();
		
		info = new InfoLayer();
		
		main_background = CCSprite.sprite(BasicConstants.MENU_BACKGROUND_IMG);
		
		main_background.setPosition(PointConstants.CENTER_POINT);
		
		startButton = CCMenuItemImage.item(BasicConstants.MENU_START_BUTTON_IMG, BasicConstants.MENU_START_BUTTON_IMG,this,"startCallback");
		storyButton = CCMenuItemImage.item(BasicConstants.MENU_STORY_BUTTON_IMG, BasicConstants.MENU_STORY_BUTTON_IMG,this,"storyCallback");
		tutorialButton = CCMenuItemImage.item(BasicConstants.MENU_TUTORIAL_BUTTON_IMG, BasicConstants.MENU_TUTORIAL_BUTTON_IMG,this,"tutorialCallback");
		
		informationButton = CCMenuItemImage.item(BasicConstants.MENU_INFO_BUTTON_IMG, BasicConstants.MENU_INFO_BUTTON_IMG,this,"infoCallback");
		
		startButton.setPosition(PointConstants.START_BUTTON_POSITION);
		storyButton.setPosition(PointConstants.STORY_BUTTON_POSITION);
		tutorialButton.setPosition(PointConstants.TUTORIAL_BUTTON_POSITION);
		
		informationButton.setPosition(PointConstants.INFORMATION_BUTTON_POSITION);
		
		CCMenu menu = CCMenu.menu(startButton, storyButton, tutorialButton, informationButton);
		
		
		menu.setPosition(0, 0);
		addChild(main_background);
		addChild(menu);
		addChild(info);
		
		this.setIsTouchEnabled(true);
	}

	
	public void startCallback(Object sender){
		
		GameManager.getGame().ChangeScene("game");
		
	}
	
	public void storyCallback(Object sender){
		
		GameManager.getGame().ChangeScene("story");
			
	}
	
	public void tutorialCallback(Object sender){
		
		GameManager.getGame().ChangeScene("tutorial");
		
	}
	
	public void infoCallback(Object sender){
		BasicConstants.isShowCredit = true;
		info.setVisible(BasicConstants.isShowCredit);
	}
}
