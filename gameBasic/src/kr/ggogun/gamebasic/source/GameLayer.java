package kr.ggogun.gamebasic.source;

import kr.ggogun.gamebasic.constants.BasicConstants;
import kr.ggogun.gamebasic.constants.PointConstants;

import org.cocos2d.layers.CCLayer;
import org.cocos2d.menus.CCMenu;
import org.cocos2d.menus.CCMenuItemImage;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.nodes.CCSprite;

import android.util.Log;

public class GameLayer extends CCLayer {
	
	private CCSprite background;

	private CCMenuItemImage backButton;
	
	public GameLayer(){
		
		background = CCSprite.sprite(BasicConstants.GAME_BACKGROUND_IMG);
		
		background.setPosition(PointConstants.CENTER_POINT);
		
		backButton = CCMenuItemImage.item(BasicConstants.BACK_BUTTON_IMG, BasicConstants.BACK_BUTTON_IMG, this, "backCallback");
		
		backButton.setPosition(PointConstants.BACK_BUTTON_POSITION);
		
		CCMenu menu = CCMenu.menu(backButton);
		
		menu.setPosition(0, 0);
		
		addChild(background);
		addChild(menu);
		
		
		this.setIsTouchEnabled(true);
	}
	
	public void backCallback(Object sender){
		
		GameManager.getGame().backScene();
	}

}

