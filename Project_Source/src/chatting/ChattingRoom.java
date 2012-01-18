package chatting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

import BlackJack.BlackJack;
import BlackJack.CardSet;
import BlackJack.User;

public class ChattingRoom extends Thread {

	private ArrayList<Socket> socketList;
	public ArrayList<Socket> playerList = new ArrayList<Socket>();
	private Socket socket;
	private static String msg = null;
	BlackJack bj;
	CardSet card;
	public int playerCount = 0;

	ArrayList<User> gamer;

	public ChattingRoom(Socket socket, ArrayList<Socket> socketList
			) throws IOException {
		this.socket = socket;
		this.socketList = socketList;
		
	}
	
	public Socket toSocket(){
		return socket;
	}

	public void run() {
		BufferedReader bufferedReader = null;
		PrintWriter printWriter = null;
		try {
			bufferedReader = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			String[] list = null;
			while (true) {
				msg = bufferedReader.readLine();

				if (msg == null || msg.equals("null")) {
					throw new IOException(" Client Socket Error : ");
				}
				list = msg.split("> ");

				if (list.length >= 3 && list[1].equals("join")
						&& list[2].equals("yes")) {

					if (!playerList.contains(socket)) {
						playerList.add(socket);
					}
					if(bj != null){
						bj.okNo = "y";	
					}
					
				} else if (list.length >= 3 && list[1].equals("join")
						&& list[2].equals("no")) {

					if(bj != null){
						bj.okNo = "n";						
					}
					
				} else if (list.length >= 3 && list[1].equals("start")
						&& list[2].equals("yes")) {

					System.out.println(socket);
					playerCount++;
					if (playerCount == playerList.size()) {
						System.out
								.println("playersize is " + playerList.size());
						bj = new BlackJack(playerList, this);
						bj.start();
						init();
					}

				} else if (list.length >= 3 && list[1].equals("bet")) {
					System.out.println(list[0] + "," +  list[1]+ ","+list[2]+ ","+ msg);
					gamer.get(playerList.indexOf(socket)).setBetting(
							Integer.parseInt(list[2].toString()));
					

				} else if (list.length >= 3 && list[1].equals("more")) {
					if (list[2].equals("yes")) {
						card = bj.getCard();
						System.out.println("Throw one card");
						
						bj.getUser().addCard(card.getRamdomCard());
						bj.inputStr = "y";
						
					} else if (list[2].equals("no")) {
						
						bj.checkCard();
						bj.inputStr = "n";
					}
				} else {
					System.out.println(msg);

					for (Socket s : socketList) {
						// 나에게는 뿌려주지 않는다.
						
						if (s == socket) {
							continue;
						}
						// 뿌리기 시작.
						try {
							printWriter = new PrintWriter(
									new OutputStreamWriter(s.getOutputStream()));

							
							printWriter.flush();
							
						} catch (IOException e) {
							socketList.remove(s);
						}
					}
				}
			}
		} catch (IOException e) {
			socketList.remove(socket);
		} finally {
			try {
				if (bufferedReader != null) {
					bufferedReader.close();
				}
			} catch (Exception ignored) {
			}
			try {
				if (socket != null) {
					socket.close();
				}
			} catch (Exception ignored) {
			}
		}
	}

	private void init() {
		// TODO Auto-generated method stub
		gamer = bj.getGamer();
	}
}
