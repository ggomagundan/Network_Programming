package kr.ggogun.udpserver;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDP_Server {

	private final static int PORT_NUMBER = 9800;

	public UDP_Server(int port){

		try{
			// Create New DatagramSocket for Receive Data
			DatagramSocket ds = new DatagramSocket(port);

			while(true){

				// Receive Data Buffer, Generally make size 512 Or 1024 
				byte[] buffer = new byte[512];
				// The constructor for the reception of Datagram Packet Data
				DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
				System.out.println("ready for Receive Data");
				// Recieve the Data 
				ds.receive(dp);
				
				// Transform Datagram data to String
				String str = new String(dp.getData());
				// Getting Datagram InetAddress
				InetAddress ia = dp.getAddress();
				// Getting Datagram Port Number
				port = dp.getPort();
				
				System.out.println("Receive Data : "+str);
				System.out.println("Client IP : "+ia+", Client Port : "+ port +"\n");
				// Create new Object for sending Datagram Packet from received IP and Port Number
				dp = new DatagramPacket(dp.getData(), dp.getData().length, ia, port);
				ds.send(dp);
			}

		}catch(IOException e){
			e.printStackTrace();
		}
	}

	public static void main(String[] args){
		
		new UDP_Server(PORT_NUMBER);
		
	}

}
