package kr.ggogun.gamebasic.source;

import kr.ggogun.gamebasic.constants.BasicConstants;

import org.cocos2d.layers.CCScene;
import org.cocos2d.nodes.CCDirector;




public class GameManager {

	public static GameManager gamemanager;
	
	private CCScene mainScene;
	private CCScene gameScene;
	private CCScene storyScene;
	private CCScene tutorialScene;

	private MenuLayer mainLayer;
	private GameLayer gameLayer;
	private StoryLayer storyLayer;
	private TutorialLayer tutorialLayer;
	
	
	public static GameManager getGame() {
		
		if(gamemanager == null){
			gamemanager = new GameManager();
		}
		
		return gamemanager;
	}

	
	public void start() {

		CCDirector.sharedDirector().runWithScene(mainScene);
		
	}


	public void initialize() {
		
		mainScene = CCScene.node();
		gameScene = CCScene.node();
		storyScene = CCScene.node();
		tutorialScene = CCScene.node();
		
		mainLayer = new MenuLayer();
		gameLayer = new GameLayer();
		storyLayer = new StoryLayer();
		tutorialLayer = new TutorialLayer();

		
		mainScene.setScale(BasicConstants.scale);
		//gameLayer.setScale(BasicConstants.scale);
		//storyLayer.setScale(BasicConstants.scale);
		//tutorialLayer.setScale(BasicConstants.scale);
		
		mainScene.addChild(mainLayer);
		gameScene.addChild(gameLayer);
		storyScene.addChild(storyLayer);
		tutorialScene.addChild(tutorialLayer);
		
		
	}


	public void ChangeScene(String sceneName) {

		
		CCDirector.sharedDirector().pushScene(CCDirector.sharedDirector().getRunningScene());
		
		if(sceneName.equals("game")){
			CCDirector.sharedDirector().replaceScene(gameScene);
		}else if(sceneName.equals("story")){
			CCDirector.sharedDirector().replaceScene(storyScene);
		}else if(sceneName.equals("tutorial")){
			CCDirector.sharedDirector().replaceScene(tutorialScene);
		}
		
		
		
				
	}

}
