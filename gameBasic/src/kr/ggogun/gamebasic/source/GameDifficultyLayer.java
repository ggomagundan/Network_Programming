package kr.ggogun.gamebasic.source;

import kr.ggogun.gamebasic.constants.BasicConstants;
import kr.ggogun.gamebasic.constants.PointConstants;

import org.cocos2d.layers.CCLayer;
import org.cocos2d.menus.CCMenu;
import org.cocos2d.menus.CCMenuItemImage;
import org.cocos2d.nodes.CCSprite;

public class GameDifficultyLayer extends CCLayer {
	
	CCSprite background;
	CCMenuItemImage backButton;
	
	CCMenuItemImage easyButton;
	CCMenuItemImage normalButton;
	CCMenuItemImage hardButton;
	
	public GameDifficultyLayer(){
		
		background = CCSprite.sprite(BasicConstants.DIFFICULTY_BACKGROUND_IMG);
		
		easyButton = CCMenuItemImage.item(BasicConstants.DIFFICULTY_EASY_IMG, BasicConstants.DIFFICULTY_EASY_IMG, this, "easyCallback");
		normalButton = CCMenuItemImage.item(BasicConstants.DIFFICULTY_NORMAL_IMG, BasicConstants.DIFFICULTY_NORMAL_IMG, this, "normalCallback");
		hardButton = CCMenuItemImage.item(BasicConstants.DIFFICULTY_HARD_IMG, BasicConstants.DIFFICULTY_HARD_IMG, this, "hardCallback");
		
		backButton = CCMenuItemImage.item(BasicConstants.BACK_BUTTON_IMG, BasicConstants.BACK_BUTTON_IMG,this,"backCallback");
		
		CCMenu menu = CCMenu.menu(easyButton,normalButton,hardButton, backButton);
		
		background.setPosition(PointConstants.CENTER_POINT);
		backButton.setPosition(PointConstants.BACK_BUTTON_POSITION);
		easyButton.setPosition(PointConstants.EASY_BUTTON_POSITION);
		normalButton.setPosition(PointConstants.NORMAL_BUTTON_POSITION);
		hardButton.setPosition(PointConstants.HARD_BUTTON_POSITION);
		
		menu.setPosition(0,0);
		
		
		addChild(background);
		
		addChild(menu);
	}
	
	public void easyCallback(Object sender){
		
		GameManager.getGame().setGameDifficulty(0);
		GameManager.getGame().ChangeScene("game");
		
	}

	public void normalCallback(Object sender){
		
		GameManager.getGame().setGameDifficulty(1);
		GameManager.getGame().ChangeScene("game");
	}

	public void hardCallback(Object sender){
		
		GameManager.getGame().setGameDifficulty(2);
		GameManager.getGame().ChangeScene("game");
	}

	public void backCallback(Object sender){
		GameManager.getGame().backScene();
	}
}
