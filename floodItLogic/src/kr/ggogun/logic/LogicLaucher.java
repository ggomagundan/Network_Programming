package kr.ggogun.logic;

public class LogicLaucher {
	
	public static void main(String[] args){
		
		LogicManager manager = LogicManager.getManager();
		manager.initialize();
		manager.stratGame();
		
	}

}
