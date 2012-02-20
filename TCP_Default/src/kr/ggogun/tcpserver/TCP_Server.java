package kr.ggogun.tcpserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCP_Server {

	private final static int SERVER_PORT = 9800;

	public TCP_Server(int server_Port) throws IOException{

		System.out.println("Host name: " + InetAddress.getLocalHost());

		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(SERVER_PORT);
		} catch (IOException e) {
			System.err.println("Could not listen on port: " + SERVER_PORT);
			System.exit(1);
		}

		System.out.println("Waiting Client....");
		
		while(true){
			Socket clientSocket = null;
			
			try {
				clientSocket = serverSocket.accept();
			} catch (IOException e) {
				System.err.println("Accept failed.");
				System.exit(1);
			}
			System.out.println("Connected");

			
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

			String num1;

			num1 = in.readLine();
			System.out.println("Receive :  " + num1);

			out.println(num1);

			out.close();
			in.close();
			clientSocket.close();

		}
		//   serverSocket.close();


	}

	
	public static void main(String args[]) throws IOException{
		new  TCP_Server(SERVER_PORT);
	}

}
