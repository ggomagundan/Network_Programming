package BlackJack;

import java.util.Random;

/*
 * �� �� �� : �ں���
 * �� �� �� : 2008-10-15
 * 
 * Ŭ���� ���� ==================================================================
 * �Ѱ��� Ÿ��(�����̵�, ���̾�, ��Ʈ, ũ�ι�)�� ���� ī�� Ŭ����
 * ===========================================================================
 */
public class Cards {
	private Card c[] = new Card[13];
	private int availCount = 13;

	private Random rn = new Random();

	private Cards() {
		// �Ķ���� ���� �����ڴ� ������� ���ϵ��� �Ѵ�.
	}

	// ī�� �� ��Ʈ�� �����Ѵ�.
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

	// �������� ī�带 �̴´�.
	public Card getRandomCard() {

		Card result = c[rn.nextInt(13)];

		// ���� ī�尡 ��� ���� ī���̸� ��ȯ.
		if (!result.getUsed()) {
			availCount--; // ���� ī�� ���Ͻ� ���� ī��� -1
			return result;
		}

		return null;
	}

	public int getAvailCount() {
		return availCount;
	}
}
