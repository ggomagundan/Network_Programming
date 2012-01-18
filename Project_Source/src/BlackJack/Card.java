package BlackJack;


/*
 * �� �� �� : �ں���
 * �� �� �� : 2008-10-15
 * 
 * Ŭ���� ���� ==================================================================
 * ���� ī�� Ŭ������ Ʈ��Ʈ ī���� ������ ������ ������ �ִ�.
 * ===========================================================================
 */
public class Card {
	final static String CARD_SPADE = "S";
	final static String CARD_DIAMOND = "D";
	final static String CARD_HART = "H";
	final static String CARD_CLOVER = "C";

	private String cardName = "";
	private int cardValue = 0;
	private boolean used = false;

	private Card() {
		// �Ķ���� ���� �����ڴ� ������� ���ϵ��� �Ѵ�.
	}

	Card(String type, String name, int value) {
		this.cardName = type + name;
		this.cardValue = value;
	}

	public String getCardName() {
		return cardName;
	}

	public int getCardValue() {
		return cardValue;
	}

	public boolean getUsed() {
		return used;
	}

	public void setUsed(boolean tf) {
		this.used = tf;
	}
}
