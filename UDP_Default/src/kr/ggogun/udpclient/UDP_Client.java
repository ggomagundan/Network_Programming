package kr.ggogun.udpclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDP_Client {

	private String str;
	private BufferedReader file;
	private final static String SERVER_IP = "127.0.0.1";
	private final static int SERVER_PORT_NUMBER = 9800;
	private final static int SENDING_PORT_NUMBER = 2000;

	public UDP_Client(String ip, int port){

		try{
			// Create new InetAddress Object
			InetAddress ia = InetAddress.getByName(ip);
			// Create new DatagramSocket Object
			DatagramSocket ds = new DatagramSocket(port);
			System.out.print("message : ");
			file = new BufferedReader(new InputStreamReader(System.in));   //키보드로부터
			str = file.readLine();
			// Transform Input String to Byte Object
			byte[] buffer = str.getBytes();   
			// Create DatagramPacket for Sending Data
			DatagramPacket dp = new DatagramPacket(buffer, buffer.length, ia, SERVER_PORT_NUMBER);
			// Sending DatagramPacket
			ds.send(dp);

			buffer = new byte[512];
			// Create DatagramPacket for Receiving Data
			dp = new DatagramPacket(buffer, buffer.length);
			ds.receive(dp);
			System.out.println("Server IP : " + dp.getAddress() + ", Server Port : "+dp.getPort());
			System.out.println("Receive Data : "+new String(dp.getData()).trim());


		}catch(IOException ioe){
			ioe.printStackTrace();
		}
	}

	public static void main(String[] args){
		
		new UDP_Client(SERVER_IP, SENDING_PORT_NUMBER);
		
	}

}
