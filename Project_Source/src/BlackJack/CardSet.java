package BlackJack;

import java.util.HashMap;
import java.util.Random;

/*
 * �� �� �� : �ں���
 * �� �� �� : 2008-10-15
 * 
 * Ŭ���� ���� ==================================================================
 * �װ��� ī�� ������ ���� ī�� �� ��Ʈ
 * ===========================================================================
 */
public class CardSet {
	private Random rn = new Random();

	// �ʱ� ��� ������ ī�� ��Ʈ�� 52�� (1~10, J, Q, K �� �� 13�� * 4��Ʈ)
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
				continue; // ���õ� ������ ���� ī����� 0�̸� �ٸ� ī�尡 ���� �ǵ��� �Ѵ�.
			else {
				card = cards.getRandomCard();
				if (card != null)
					availCount--; // ���� ī�� ���Ͻ� ���� ī��� -1
				return card;
			}
		}
		return null;
	}

	public int getAvailCount() {
		return availCount;
	}
}
