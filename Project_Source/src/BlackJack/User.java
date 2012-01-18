package BlackJack;

import java.util.Vector;

public class User {
	private String userName = "";
	private int money = 0;
	private int betting = 0;
	private Vector<Card> card = null;

	User(String name, int money) {
		this.userName = name;
		this.money = money;
		card = new Vector<Card>();
	}

	public void initCard() {
		card.clear();
	}

	public void addCard(Card c) {
		card.add(c);
	}

	public String getUserName() {
		return userName;
	}

	public int getMoney() {
		return money;
	}

	public void addMoney(int money) {
		this.money += money;
	}

	public void minusMoney(int money) {
		this.money -= money;
		setBetting(money);
	}

	public Vector<Card> getCard() {
		return card;
	}

	public void setBetting(int betting) {
		this.betting = betting;
	}

	public int getBetting() {
		return betting;
	}
}
