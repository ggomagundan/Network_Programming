package kr.ggogun.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;



public class BJServer extends Thread {
	
	ServerSocket serverSocket;
	
	ArrayList<Socket> userList = new ArrayList<Socket>();
	ArrayList<Socket> delUserList = new ArrayList<Socket>();
	PrintWriter pw;
	
	public BJServer(){
		
		
		System.out.println("Start Server!!!");
		try {
			serverSocket = new ServerSocket(9955);
			
			while(true){
				Socket socket = serverSocket.accept();
				System.out.println(socket + " is Come in");
				
				
				if (!userList.contains(socket)) {
					
					
					userList.add(socket);
					System.out.println(userList.size() + "add : "+socket);
					pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
					pw.println("Connect Server!!!");
					pw.flush();
					
					
					Thread thread = new ChatReciever(socket);
					thread.start();	// Start Main Thread()
					
					//ChattingRoom cr = new ChattingRoom(socket);
					// socket을 보내고 없는 소켓이면 추가를 시킨다.
					
				//	System.out.println("채팅시작");
				}
				
				
			}
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			try {
				serverSocket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	public class TimerPing extends TimerTask {
		
	    public void run() {
	    	
	    	for(Socket s:userList){
		    	try {
					pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
					
					if(!delUserList.contains(s)){
						pw.println("ping " + userList.indexOf(s) + "user ");
						pw.flush();
					}
					
						//System.out.println(s.getPort());
					
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
	    	}
	    	    }
	}
	
	
	public void printMsg(String msg){
		PrintWriter printer;
		
		for(Socket s:userList){
	    	
	    		
			try {	
				
	    		printer = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
				
				printer.println(msg);
				printer.flush();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public class ChatReciever extends Thread{ 

		Socket socket;
		public ChatReciever(Socket socket){
			this.socket = socket;
		}
		
		// Main Thread
		public void run(){
			
			// For Ping Thread
			TimerPing ping = new TimerPing();
			ping.run();
			Timer userPing = new Timer();
			userPing.scheduleAtFixedRate(ping,0, 3000);
			// Ping Method to Check Connect Or DisConnect
			/*
			 * http://blog.naver.com/PostView.nhn?blogId=majongyi&logNo=120124830805
			 * 인용
			 */
			
			while(true){
				
				
				try {
					
					BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					String temp = br.readLine();
					if(temp.substring(0, 4).equals("exit")){
						// Recieve DisConnect Msg
						
						int port = Integer.parseInt(temp.split(" ")[1]);
						// Split Port Check LocalPort  m
						// cause This Game Test Only One Compuer
						// Must Change Checking IP Address
						
						for(Socket s:userList){
							if(s.getPort() == port){
								
								delUserList.add(s);
								
							}
							
						}
						
					}else if(temp.contains(">")){
						
						System.out.println(temp);
						printMsg(temp);
						// Print Recieved Msg
						
					}
					
					// Check Delete List And Delte UserList
					for(Socket s:delUserList){
						if(userList.contains(s)){
							userList.remove(s);
							// Cause make ConcurrentModificationException 
							// at the same Time
						}
					}
					
					delUserList.clear();
					// Initiallize delList
					
					// if userList is Null Or Size 0, Not Print userList's size
					if(userList.size()!=0)
						System.out.println("duser Size is " + userList.size());
					
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
			
			}// end First while
					
		}
	}
	
	
	
	public static void main(String[] args){
		
		new BJServer();
		
		
	}
}
