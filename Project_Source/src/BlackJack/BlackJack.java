package BlackJack;

/*
 * ����
 * 
 * �⺻ ��Ģ
 * 1. ī��� A, 2~10, Q, J, K �̸� A �� 1 �Ǵ� 11�� �� �� �ִ�.
 * 	(Q, J, K�� ��� 10���� ����Ѵ�.)
 * 2. ī��� ������ �� 13�徿 �� 52���� �� ��Ʈ�� �� ���ӿ� �� ��Ʈ�� ����Ѵ�.
 * 	(���ο� ������ ���۵Ǹ� �� ��Ʈ�� ���� �����Ѵ�.)
 * 3. ������ ī���� ���� 21�� ������ �й�, 21�� ���� ������ ����� �¸��Ѵ�.
 * 4. 2���� �ʰ��ϴ� ���� �ɼ��� ��� ������ 17�̸��� ��� ī�带 ��� �޴´�.
 * 5. ���� �ʱ� ���۽� 2�� ���� �Ǵ� 2�� �ʰ� ������ �����Ѵ�.
 */

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Vector;

import chatting.ChattingRoom;

public class BlackJack extends Thread {

	private CardSet card = null;
	private User dealer = null;
	private ArrayList<User> gamer = new ArrayList<User>();
	public String inputStr = "";
	public String okNo = "";
	private ArrayList<Socket> playerList = new ArrayList<Socket>();
	private ChattingRoom chatRoom;

	public BlackJack(ArrayList<Socket> playerList, chatting.ChattingRoom chat)
			throws IOException {
		this.playerList = playerList;
		this.chatRoom = chat;
		init(playerList);
	}

	public void print(String msg, ArrayList<Socket> playerList) {
		for (Socket s : playerList) {
			try {
				PrintWriter printWriter = null;
				printWriter = new PrintWriter(new OutputStreamWriter(
						s.getOutputStream()));
				printWriter.println(msg);
				printWriter.flush();
			} catch (IOException e) {
				playerList.remove(s);
			}
		}
	}

	public void println(String msg, ArrayList<Socket> playerList) {
		for (Socket s : playerList) {
			try {
				PrintWriter printWriter = null;
				printWriter = new PrintWriter(new OutputStreamWriter(
						s.getOutputStream()));
				printWriter.print(msg);
				printWriter.flush();
			} catch (IOException e) {
				playerList.remove(s);
			}
		}
	}

	public void print(String msg, Socket player) {
		try {
			PrintWriter printWriter = null;
			printWriter = new PrintWriter(new OutputStreamWriter(
					player.getOutputStream()));
			printWriter.println(msg);
			System.out.println(msg + " sending");
			printWriter.flush();
		} catch (IOException e) {
			// System.out.println("IOException");
		}
	}

	private void init(ArrayList<Socket> playerList) throws IOException {

		String msg = "Welcome to the BlackJack World!!!";
		print(msg, this.playerList);

		dealer = new User("Dealer", 100000 * 10); // ������ ���� �ڱ��� 10�踦
		// ������ �����Ѵ�.

		msg = "���� �غ� �Ϸ�. �ܾ� = " + dealer.getMoney();
		print(msg, this.playerList);

		for (Socket socket : this.playerList) {
			adduser(socket.getInetAddress().getHostAddress());
		}
	}

	public void run() {
		try {
			startGame();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void adduser(String name) {
		User gambler = new User(name, 100000);
		gamer.add(gambler);

		print(gamer.toString(), this.playerList);
		print(playerList.toString(), this.playerList);

		gambler.initCard();

		String msg = "����� �غ� �Ϸ�. �ܾ� = " + gambler.getMoney();
		print(msg, this.playerList);
	}

	private void startGame() throws IOException {
		card = new CardSet();
		dealer.initCard();
		for (User user : gamer)
			user.initCard();

		String msg = "ī�弼Ʈ ���� �Ϸ�.";
		print(msg, this.playerList);

		game();
	}

	public void game() throws IOException {
		try {
			// ���þ� �Է�
			dealer.addCard(card.getRamdomCard());
			dealer.addCard(card.getRamdomCard());
			for (User user : gamer) {
				inputMoney();
				user.addCard(card.getRamdomCard());
				user.addCard(card.getRamdomCard());
			}

			// showCard(true);
			do {
				inputStr = "";
				okNo = "";
				for (User user : gamer) {
					if (user.getMoney() >= 0) {
						// 2�� �̻� �޴� ���� ����� ���
						// ���� ī�尡 21�� �ȳ��� ��츸 �� ������ ����
						if (getValue(user.getCard()) <= 21) {
							// ī�带 2�� �̻� �������� ��쿡�� �߰� ī�带 ���� �� �����Ѵ�.
							if (user.getCard().size() >= 2) {
								showCard(false);
								print(user.getUserName()
										+ "��. ī�带 �� �����ðڽ��ϱ�? (Y/N)",
										playerList.get(gamer.indexOf(user)));
								do {
									System.out.println("  ");
								} while (!(inputStr.equals("y") || inputStr
										.equals("n")));
							}

							if (inputStr.equals("n")) {
								print((user.getUserName() + "��. ��� �Ͻðڽ��ϱ�? (Y/N)"),
										this.playerList);
								do {
									System.out.println("  ");
								} while (!(okNo.equals("y") || okNo.equals("n")));
								user.setBetting(0);
								newGame();
								return;
							} else if (inputStr.equals("y")) {
								continue;
							}
						} else {
							checkCard();
							print((user.getUserName() + "��. ��� �Ͻðڽ��ϱ�? (Y/N)"),
									this.playerList);
							do {
								System.out.println("  ");
							} while (!(okNo.equals("y") || okNo.equals("n")));
							user.setBetting(0);
							newGame();
							return;
						}
					} else {
						print((user.getUserName() + "��, �ܾ��� �����ϴ�. ������ �ٽ� ������� �ֽʽÿ�."),
								playerList.get(gamer.indexOf(user)));
						try {
							chatRoom.toSocket().close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			} while (true);
		} catch (NumberFormatException e) {
			System.out.println("���ڸ� �Է��ϼž� �մϴ�.");
		}
	}

	public void newGame() throws IOException {
		int myNumber = 1;
		if (okNo.equals("y")) {
			startGame();
		} else if (okNo.equals("n")) {
			for (int i = 0; i < playerList.size(); i++) {
				if (playerList.get(i) == chatRoom.toSocket()) {
					myNumber = i;
				}
			}
			playerList.remove(myNumber);
			chatRoom.playerCount--;
			try {
				chatRoom.toSocket().close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void showMoney() {
		String msg = "===========================\n";
		System.out.println("===========================");
		System.out.println("���� �ܰ� = " + dealer.getMoney());
		msg += "���� �ܰ� = " + dealer.getMoney() + "\n";
		for (User user : gamer) {
			System.out.println(user.getUserName() + " �ܰ� = " + user.getMoney());
			msg += user.getUserName() + " �ܰ� = " + user.getMoney() + "\n";
		}
		System.out.println("===========================");
		msg += "===========================" + "\n";
		print(msg, playerList);
	}

	public String showCard(boolean isDealerCardShow) {
		Vector<Card> dealerCard = dealer.getCard();

		String msg = "Dealer : ";
		println(msg, this.playerList);
		if (isDealerCardShow) {

			for (int i = 0; i < dealerCard.size(); i++) {
				msg = ((Card) dealerCard.get(i)).getCardName() + " ";
				println(msg, this.playerList);
				msg += ((Card) dealerCard.get(i)).getCardName() + " ";
			}

			msg = "�� = " + getValue(dealer.getCard()) + "\n";
			println(msg, this.playerList);

		} else {
			msg = ((Card) dealerCard.get(0)).getCardName() + "\n";// + " �Ⱥ��̴� ī��\n";
			println(msg, this.playerList);
		}

		for (User user : gamer) {

			Vector<Card> userCard = user.getCard();
			msg = "User : ";
			println(msg, this.playerList);

			for (int i = 0; i < userCard.size(); i++) {
				msg = ((Card) userCard.get(i)).getCardName() + " ";
				println(msg, this.playerList);
				msg += ((Card) userCard.get(i)).getCardName() + " ";
			}
			msg = "\n�� = " + getValue(user.getCard()) + "\n";
			println(msg, this.playerList);
		}
		return msg;
	}

	private int getValue(Vector<Card> card) {
		int i = 0;
		int value = 0;
		int aceCount = 0;

		for (i = 0; i < card.size(); i++) {
			value += ((Card) card.get(i)).getCardValue();
			if (((Card) card.get(i)).getCardValue() == 1) {
				aceCount++;
			}
		}

		for (i = 0; i < aceCount; i++) {
			if (value <= 11) {
				aceCount--;
				value += 10;
			}
		}
		return value;
	}

	private boolean getResult() {
		int bettingMoney;
		int dealerValue = getValue(dealer.getCard());
		for (User user : gamer) {
			int userValue = getValue(user.getCard());
			bettingMoney = user.getBetting();
			if (userValue > 21
					|| (dealerValue <= 21 && userValue < 21 && dealerValue > userValue)) {
				// ������ 21�� �ʰ��ϰų� , �� �� 21�� ���� �����鼭 ������ ���� �� �϶�
				String msg = user.getUserName() + "���� �ο�, ���� ��";
				print(showCard(true), playerList);
				print(msg, playerList);
				dealer.addMoney(bettingMoney);
				System.out.println("betting" + bettingMoney);
				System.out.println(user.getMoney() + " "
						+ (user.getMoney() - bettingMoney));
			} else if (userValue > dealerValue || dealerValue > 21) {
				System.out.println(user.getUserName() + " ��");
				print(showCard(true), playerList);
				String msg = user.getUserName() + " ��";
				print(msg, playerList);
				System.out.println("betting" + bettingMoney);
				System.out.println(user.getMoney() + " "
						+ (user.getMoney() + (int) (bettingMoney * 1.5)));
				dealer.minusMoney(bettingMoney);
				user.addMoney((int) (bettingMoney * 1.5));
			} else if (userValue == dealerValue) {
				System.out.println(user.getUserName() + "���º�");
				print(showCard(true), playerList);
				String msg = user.getUserName() + "���º�";
				print(msg, playerList);
				user.addMoney(bettingMoney);
			} else {
				print(showCard(true), playerList);
				System.out.println("���� ���� �ȵǾ�����.");
			}
		}
		return true;
	}

	// betting check
	private void inputMoney() {
		int betting = 0;

		for (User user : gamer) {
			String msg = user.getUserName() + " ���þ��� �Է��ϼ��� (���� �ݾ� : "
					+ user.getMoney() + "): ";
			print(msg, playerList.get(gamer.indexOf(user)));

			do {
				if ((user.getBetting() != 0) && (user.getBetting() < 1)) {
					msg = "�ݾ��� 1�� �̻� �����մϴ�.";
					System.out.println(user.getMoney() + " "
							+ user.getBetting() + " ");
					print(msg, this.playerList);
					user.setBetting(0);
					continue;
				} else if ((user.getBetting() != 0)
						&& (user.getBetting() > user.getMoney())) {
					System.out.println(user.getBetting() + " "
							+ gamer.get(0).getMoney() + " " + user.getMoney()
							+ (user.getBetting() > user.getMoney()));
					msg = user.getUserName() + "�����ݾ� �̻� ������ �Ұ��մϴ�.";
					System.out.println(user.getMoney() + " "
							+ user.getBetting() + " ");
					print(msg + ("�����ݾ� : " + user.getMoney() + " , ���ñݾ� : " + user
							.getBetting()), this.playerList);
					user.setBetting(0);
					continue;
				}
			} while (user.getBetting() == 0);
			System.out.println("");
			betting += user.getBetting();
			user.minusMoney(user.getBetting());
		}
	}

	public Vector<Card> getCard(int i) {
		// TODO Auto-generated method stub
		return gamer.get(i).getCard();
	}

	public User getUser() {
		// TODO Auto-generated method stub
		return gamer.get(0);
	}

	public CardSet getCard() {
		// TODO Auto-generated method stub

		return card;
	}

	public ArrayList<Socket> getPlayerList() {
		// TODO Auto-generated method stub
		return playerList;
	}

	public ArrayList<User> getGamer() {
		// TODO Auto-generated method stub
		return gamer;
	}

	public void checkCard() {
		// TODO Auto-generated method stub
		getResult();
		showMoney();
	}
}
