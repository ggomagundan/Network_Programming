package kr.ggogun.floodit.source;

import kr.ggogun.floodit.constants.BasicConstants;
import kr.ggogun.floodit.constants.PointConstants;

import org.cocos2d.layers.CCLayer;
import org.cocos2d.menus.CCMenu;
import org.cocos2d.menus.CCMenuItemImage;
import org.cocos2d.nodes.CCSprite;

public class InfoLayer extends CCLayer {
	
	private CCSprite creditSprite;
	
	private CCMenuItemImage creditExitSprite;

	public InfoLayer() {
		super();
		
		

		creditSprite = CCSprite.sprite(BasicConstants.CREDIT_BACKGROUND_IMG);
		creditSprite.setPosition(PointConstants.CENTER_POINT);

		creditSprite.setOpacity(225);
		

		
		creditExitSprite = CCMenuItemImage.item(BasicConstants.CREDIT_CLOSE_IMG,BasicConstants.CREDIT_CLOSE_IMG,this,"creditExitCallback");
		creditExitSprite.setPosition(PointConstants.CREDIT_EXIT_POSITION);
		
		
		
		CCMenu menu = CCMenu.menu(creditExitSprite);
		menu.setPosition(0, 0);
		
		
		

		
		addChild(creditSprite);	
		addChild(menu);
		setVisible(BasicConstants.isShowCredit);
	}
	
	
	public void creditExitCallback(Object sender){
		
		BasicConstants.isShowCredit = false;
		this.setVisible(BasicConstants.isShowCredit);
		
	}


}
