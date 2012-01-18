package BlackJack;

import java.util.Random;

/*
 * 작 성 자 : 박병웅
 * 작 성 일 : 2008-10-15
 * 
 * 클래스 설명 ==================================================================
 * 한가지 타입(스페이드, 다이아, 하트, 크로버)을 갖는 카드 클래스
 * ===========================================================================
 */
public class Cards {
	private Card c[] = new Card[13];
	private int availCount = 13;

	private Random rn = new Random();

	private Cards() {
		// 파라미터 없는 생성자는 사용하지 못하도록 한다.
	}

	// 카드 한 셋트를 생성한다.
	Cards(String type) {

		int i = 0;
		int value = 1;
		String name = "";

		for (i = 0; i < 13; i++, value++) {

			name = Integer.toString(i+1);

			if (name.equals("1")){
				name = "A";
				
				c[i] = new Card(type, name, 11);
			
				continue;
			}
			else if (name.equals("11")){
				name = "J";
				
			}
			else if (name.equals("12")){
				name = "Q";
			}
			else if (name.equals("13")){
				name = "K";
			}
			

			c[i] = new Card(type, name, value > 10 ? 10 : value);
		}
	}

	// 랜덤으로 카드를 뽑는다.
	public Card getRandomCard() {

		Card result = c[rn.nextInt(13)];

		// 랜덤 카드가 사용 가능 카드이면 반환.
		if (!result.getUsed()) {
			availCount--; // 가용 카드 리턴시 가용 카드수 -1
			return result;
		}

		return null;
	}

	public int getAvailCount() {
		return availCount;
	}
}
