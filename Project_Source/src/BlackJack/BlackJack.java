package BlackJack;

/*
 * 블랙잭
 * 
 * 기본 규칙
 * 1. 카드는 A, 2~10, Q, J, K 이며 A 는 1 또는 11이 될 수 있다.
 * 	(Q, J, K은 모두 10으로 계산한다.)
 * 2. 카드는 네종류 각 13장씩 총 52장을 한 셋트로 한 게임에 한 셋트만 사용한다.
 * 	(새로운 게임이 시작되면 한 셋트를 새로 구성한다.)
 * 3. 소유한 카드의 합이 21을 넘으면 패배, 21에 가장 근접한 사람이 승리한다.
 * 4. 2장을 초과하는 게임 옵션인 경우 딜러는 17미만인 경우 카드를 계속 받는다.
 * 5. 게임 초기 시작시 2장 게임 또는 2장 초과 게임을 선택한다.
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

		dealer = new User("Dealer", 100000 * 10); // 딜러는 유저 자금의 10배를
		// 가지고 시작한다.

		msg = "딜러 준비 완료. 잔액 = " + dealer.getMoney();
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

		String msg = "사용자 준비 완료. 잔액 = " + gambler.getMoney();
		print(msg, this.playerList);
	}

	private void startGame() throws IOException {
		card = new CardSet();
		dealer.initCard();
		for (User user : gamer)
			user.initCard();

		String msg = "카드세트 생성 완료.";
		print(msg, this.playerList);

		game();
	}

	public void game() throws IOException {
		try {
			// 베팅액 입력
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
						// 2장 이상 받는 게임 방식일 경우
						// 유저 카드가 21이 안넘은 경우만 더 받을지 결정
						if (getValue(user.getCard()) <= 21) {
							// 카드를 2장 이상 보유했을 경우에만 추가 카드를 받을 지 결정한다.
							if (user.getCard().size() >= 2) {
								showCard(false);
								print(user.getUserName()
										+ "님. 카드를 더 받으시겠습니까? (Y/N)",
										playerList.get(gamer.indexOf(user)));
								do {
									System.out.println("  ");
								} while (!(inputStr.equals("y") || inputStr
										.equals("n")));
							}

							if (inputStr.equals("n")) {
								print((user.getUserName() + "님. 계속 하시겠습니까? (Y/N)"),
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
							print((user.getUserName() + "님. 계속 하시겠습니까? (Y/N)"),
									this.playerList);
							do {
								System.out.println("  ");
							} while (!(okNo.equals("y") || okNo.equals("n")));
							user.setBetting(0);
							newGame();
							return;
						}
					} else {
						print((user.getUserName() + "님, 잔액이 없습니다. 게임을 다시 실행시켜 주십시오."),
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
			System.out.println("숫자만 입력하셔야 합니다.");
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
		System.out.println("딜러 잔고 = " + dealer.getMoney());
		msg += "딜러 잔고 = " + dealer.getMoney() + "\n";
		for (User user : gamer) {
			System.out.println(user.getUserName() + " 잔고 = " + user.getMoney());
			msg += user.getUserName() + " 잔고 = " + user.getMoney() + "\n";
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

			msg = "합 = " + getValue(dealer.getCard()) + "\n";
			println(msg, this.playerList);

		} else {
			msg = ((Card) dealerCard.get(0)).getCardName() + "\n";// + " 안보이는 카드\n";
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
			msg = "\n합 = " + getValue(user.getCard()) + "\n";
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
				// 유저가 21을 초과하거나 , 둘 다 21을 넘지 않으면서 딜러가 높은 수 일때
				String msg = user.getUserName() + "과의 싸움, 딜러 승";
				print(showCard(true), playerList);
				print(msg, playerList);
				dealer.addMoney(bettingMoney);
				System.out.println("betting" + bettingMoney);
				System.out.println(user.getMoney() + " "
						+ (user.getMoney() - bettingMoney));
			} else if (userValue > dealerValue || dealerValue > 21) {
				System.out.println(user.getUserName() + " 승");
				print(showCard(true), playerList);
				String msg = user.getUserName() + " 승";
				print(msg, playerList);
				System.out.println("betting" + bettingMoney);
				System.out.println(user.getMoney() + " "
						+ (user.getMoney() + (int) (bettingMoney * 1.5)));
				dealer.minusMoney(bettingMoney);
				user.addMoney((int) (bettingMoney * 1.5));
			} else if (userValue == dealerValue) {
				System.out.println(user.getUserName() + "무승부");
				print(showCard(true), playerList);
				String msg = user.getUserName() + "무승부";
				print(msg, playerList);
				user.addMoney(bettingMoney);
			} else {
				print(showCard(true), playerList);
				System.out.println("조건 성립 안되어있음.");
			}
		}
		return true;
	}

	// betting check
	private void inputMoney() {
		int betting = 0;

		for (User user : gamer) {
			String msg = user.getUserName() + " 베팅액을 입력하세요 (보유 금액 : "
					+ user.getMoney() + "): ";
			print(msg, playerList.get(gamer.indexOf(user)));

			do {
				if ((user.getBetting() != 0) && (user.getBetting() < 1)) {
					msg = "금액은 1원 이상 가능합니다.";
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
					msg = user.getUserName() + "보유금액 이상 베팅은 불가합니다.";
					System.out.println(user.getMoney() + " "
							+ user.getBetting() + " ");
					print(msg + ("보유금액 : " + user.getMoney() + " , 배팅금액 : " + user
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
