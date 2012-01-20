package kr.ggogun.floodit.logic;

public class LogicManager {

	public static LogicManager manager;
	public static LogicEngine engine;
	

	public static LogicManager getManager() {
		if(manager == null){
			manager = new LogicManager();
		}
		
		return manager;
	}


	public void initialize(int difficulty) {
		
		engine = new LogicEngine();
		engine.intialize(difficulty);
		
		
	}


	public void stratGame() {

		engine.start();
		
	}


	public void setDifficulty(int difficulty) {

		initialize(difficulty);
	}

}
