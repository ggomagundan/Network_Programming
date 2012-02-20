package kr.ggogun.tcpthreadserver;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCP_Thread_Server {

	private final static int SERVER_PORT = 9800;

	public TCP_Thread_Server(int server_Port) throws IOException{

		System.out.println("Host name: " + InetAddress.getLocalHost());

		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(SERVER_PORT);
		} catch (IOException e) {
			System.err.println("Could not listen on port: " + SERVER_PORT);
			System.exit(1);
		}
		
		while(true){
			Socket clientSocket = null;
			System.out.println("Waiting for Client.....");
			try {
				clientSocket = serverSocket.accept();
			} catch (IOException e) {
				System.err.println("Accept failed.");
				System.exit(1);
			}
			System.out.println("Connected!!! ( " + clientSocket.getInetAddress().getHostAddress() + " [" + clientSocket.getPort() + "] )");
			ServerThread serverThread = new ServerThread(clientSocket);
			Thread t = new Thread(serverThread);
			t.start();


		}
	
	}

	
	public static void main(String args[]) throws IOException{
		new  TCP_Thread_Server(SERVER_PORT);
	}

}
