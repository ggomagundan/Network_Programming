package client;

import java.net.Socket;
import java.util.ArrayList;

public class State {
	public boolean myState = true;
	private int bettingMoney = 0;
	private int money = 0;
	private ArrayList<Socket> superList = new ArrayList<Socket>();
	
	public void setMoney(int money){
		this.money = money;
	}
	
	public int getMoney(){
		return money;
	}
	
	public void setBetting(int money){
		this.bettingMoney  = money;
	}
	
	public int getBetting(){
		if(bettingMoney != 0)
			return bettingMoney;
		else
			return 0;
	}

	public void setSuperList(ArrayList<Socket> superList) {
		this.superList = superList;
	}

	public ArrayList<Socket> getSuperList() {
		return superList;
	}

	public void addSuperList(Socket socket) {
		// TODO Auto-generated method stub
		superList.add(socket);
	}
}
