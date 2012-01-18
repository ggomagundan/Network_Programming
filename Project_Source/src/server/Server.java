package server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import client.State;

import chatting.ChattingRoom;

public class Server {

	private ServerSocket serverSocket;
	private static int card_Count = 52;
	State crState = new State();
	@SuppressWarnings("unused")
	private ArrayList<Socket> userList, playerList;

	public Server() {

		userList = new ArrayList<Socket>();
		playerList = new ArrayList<Socket>();

		try {
			serverSocket = new ServerSocket(9995);

			while (true) {
				System.out.println("플레이어의 입장을 기다리는 중...");
				Socket socket = serverSocket.accept();

				if (!userList.contains(socket)) {
					userList.add(socket);
					System.out.println(userList.size());
					ChattingRoom cr = new ChattingRoom(socket, userList);
					cr.start();
					System.out.println("채팅시작");
				}

				OutputStream out = socket.getOutputStream();
				PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				serverSocket.close();
			} catch (Exception ignored) {
			}
		}
	}

	public static void main(String[] args) {
		new Server();
	}

	public static void wantCard(Socket socket) throws IOException {
		OutputStream out = socket.getOutputStream();
		InputStream in = socket.getInputStream();
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		System.out.println(br.readLine());
		card_Count -= 1;
		pw.println("I Bring 1 card you");
		pw.flush();
		System.out.println("I Have " + card_Count + " Cards");
	}
}