package BlackJack;


/*
 * 작 성 자 : 박병웅
 * 작 성 일 : 2008-10-15
 * 
 * 클래스 설명 ==================================================================
 * 단일 카드 클래스로 트럼트 카드의 한장의 정보를 가지고 있다.
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
		// 파라미터 없는 생성자는 사용하지 못하도록 한다.
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
