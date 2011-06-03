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
				
				pw.println("exit " + socket.getLocalPort());
				pw.flush();
				
				
							
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
	    	
	    }
	}

	public class ClientChat extends Thread {
		
		
	    public void run() {
	    	System.out.println("IN the chat");
	    	BufferedReader talk = new BufferedReader(new InputStreamReader(System.in));
	    	PrintWriter sender = null;
	    	while(true){
	    		
	    		try {
					
					sender = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
					String msg = talk.readLine();
					sender.println(socket.getLocalPort() + "> " + msg);
					sender.flush();
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    		
	    	}
    	
	    	
	    }
	}

	
	
	public void run(){
		
		PrintWriter pw;
	/*	
		TimerPing ping = new TimerPing();
		Timer userPing = new Timer();
		int time=(int)(Math.random()*30)*1000+5000;
		System.out.println("time is" + time/1000);
		userPing.schedule(ping, time);
	*/	
		new ClientChat().start(); 
		
		while(true){
			
			try {
				
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
				
				String temp = br.readLine();
			
				if(temp.substring(0, 4).equals("ping")){
				//	System.out.println(socket.getLocalPort());
					pw.println("ping live" + socket.getLocalPort());
					pw.flush();
				}else{
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
