package kr.ggogun.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Timer;
import java.util.TimerTask;

public class BJClient extends Thread {
	
	Socket socket;
	BufferedReader br;
	
	
	public BJClient(){
		
		try {
			
			socket = new Socket("117.17.158.171",9955);
			// Connect Server To Socket 9955 Port
				
			// run Main Thread
			Thread thread = new Thread(this);
			thread.start();
			
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
	}
	
	
	
	public class TimerPing extends TimerTask {
		
	    public void run() {
	    	
    	
	    	try {
				PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
				
				// Send Exit Msg And Exit Program
				pw.println("exit " + socket.getLocalPort());
				pw.flush();
				
				
							
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
	    	
	    }
	}

	// Client Chat Threads
	public class ClientChat extends Thread {
		
		
	    public void run() {
	    	System.out.println("IN the chat");
	    	// Make Console Reader
	    	BufferedReader talk = new BufferedReader(new InputStreamReader(System.in));
	    	PrintWriter sender = null;
	    	while(true){
	    		
	    		try {
					
					sender = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
					// Read the Console Msg
					String msg = talk.readLine();
					// Send Msg To Server
					sender.println(socket.getLocalPort() + "> " + msg);
					sender.flush();
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    		
	    	}
    	
	    	
	    }
	}

	
	// Main Thread
	public void run(){
		
		PrintWriter pw;
	/*	
	 * 	// Test Exit Msg
		TimerPing ping = new TimerPing();
		Timer userPing = new Timer();
		int time=(int)(Math.random()*30)*1000+5000;
		System.out.println("time is" + time/1000);
		userPing.schedule(ping, time);
	*/	
		new ClientChat().start();
		// Start Client Chat Send Msg
		
		while(true){
			
			try {
				
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
				
				String temp = br.readLine();
				// Recieve the Msg
			
			
				if(temp.substring(0, 4).equals("ping")){
				// Check Response Ping Msg And Send Ping Msg
					pw.println("ping live" + socket.getLocalPort());
					pw.flush();
				}else{
					// Print Recieve Msg
					System.out.println(temp);
				}
			
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}// end First while
		
		
	}
	
	public static void main(String[] args){
		
		new BJClient();
		
		
	}

}
