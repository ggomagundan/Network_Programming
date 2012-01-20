package kr.ggogun.logic;

public class LogicManager {

	public static LogicManager manager;
	public static LogicEngine engine;
	

	public static LogicManager getManager() {
		if(manager == null){
			manager = new LogicManager();
		}
		
		return manager;
	}


	public void initialize() {
		
		engine = new LogicEngine();
		engine.intialize();
		
		
	}


	public void stratGame() {

		engine.start();
		
	}

}
