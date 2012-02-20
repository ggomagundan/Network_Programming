package kr.ggogun.tcpthradclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCP_Thread_Client {

	private final static String SERVER_ADDRESS = "127.0.0.1";
	private final static int SERVER_PORT = 9800;

	public TCP_Thread_Client(String serverAddress, int serverPort) throws IOException {
		// TODO Auto-generated constructor stub
		Socket socket = null;
		PrintWriter out = null;
		BufferedReader in = null;
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));


		try {
			socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (UnknownHostException e) {
			System.err.println("Don't know about host");
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for the connection");
			System.exit(1);
		}
		System.out.println("Server Connected!!!");

		String num1;
		
		while(true){
	
		System.out.print("Message -->");
		num1=read.readLine();
		out.println(num1);
		
		
		System.out.println("Receive From Server : " + in.readLine());
		}
//		out.close();
//		in.close();
//		read.close();
//		socket.close();
		
	}

	

	
	public static void main(String[] args) throws IOException {
		new TCP_Thread_Client(SERVER_ADDRESS, SERVER_PORT);
	}
}
