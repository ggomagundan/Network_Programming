package BlackJack;

import java.util.HashMap;
import java.util.Random;

/*
 * 작 성 자 : 박병웅
 * 작 성 일 : 2008-10-15
 * 
 * 클래스 설명 ==================================================================
 * 네가지 카드 종류를 갖는 카드 한 셋트
 * ===========================================================================
 */
public class CardSet {
	private Random rn = new Random();

	// 초기 사용 가능한 카드 셋트는 52장 (1~10, J, Q, K 의 총 13장 * 4세트)
	private int availCount = 52;

	private HashMap<String, Cards> hm = new HashMap<String, Cards>();

	CardSet() {
		hm.put(Card.CARD_SPADE, new Cards(Card.CARD_SPADE));
		hm.put(Card.CARD_DIAMOND, new Cards(Card.CARD_DIAMOND));
		hm.put(Card.CARD_HART, new Cards(Card.CARD_HART));
		hm.put(Card.CARD_CLOVER, new Cards(Card.CARD_CLOVER));
	}

	public Cards getCards(String type) {
		return hm.get(type);
	}

	public Card getRamdomCard() {
		Cards cards = null;
		Card card = null;

		if (getAvailCount() == 0) {
			return null;
		}

		while (card == null) {

			switch (rn.nextInt(4)) {
			case 0:
				cards = hm.get(Card.CARD_SPADE);
				break;
			case 1:
				cards = hm.get(Card.CARD_DIAMOND);
				break;
			case 2:
				cards = hm.get(Card.CARD_HART);
				break;
			case 3:
				cards = hm.get(Card.CARD_CLOVER);
				break;
			}

			if (cards.getAvailCount() == 0)
				continue; // 선택된 종류의 가용 카드수가 0이면 다른 카드가 선택 되도록 한다.
			else {
				card = cards.getRandomCard();
				if (card != null)
					availCount--; // 가용 카드 리턴시 가용 카드수 -1
				return card;
			}
		}
		return null;
	}

	public int getAvailCount() {
		return availCount;
	}
}
