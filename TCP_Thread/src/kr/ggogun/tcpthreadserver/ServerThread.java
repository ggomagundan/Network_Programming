package kr.ggogun.tcpthreadserver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ServerThread implements Runnable {

	 private Socket socket;
	 private BufferedReader bufferR;
	 private BufferedWriter bufferW;
	 private InputStream is;
	 private OutputStream os;
	
	public ServerThread(Socket clientSocket) {
		this.socket = clientSocket;
	}

	 public void run(){
		  
		  boolean isStop = false;   //스레드 루프의 실행 및 중지에 관한 boolean
		  
		  try{
		   is = socket.getInputStream();
		   os = socket.getOutputStream();
		   bufferR = new BufferedReader(new InputStreamReader(is));
		   bufferW = new BufferedWriter(new OutputStreamWriter(os));
		   
		  }catch(IOException ioe){
		   isStop = true;   //스트림 생성에 실패하면 스레드 루프를 중지한다.
		  }
		 
		  try{

		   while(! isStop){

		    String message = bufferR.readLine();
		    if(message.equals("exit")) isStop = true;
		    System.out.println("received message (" + socket.getInetAddress() + " [" + socket.getPort() + "] ) : " + message);
		    message += System.getProperty("line.separator");
		    bufferW.write(message);
		    bufferW.flush();
		    
		   }//end while
		   
		  }catch(IOException ioe){
		   System.out.println("클라이언트가 강제로 종료되었습니다.");
		   isStop = true;   //클라이언트가 exit 메세지 없이 임의로 종료해도 스레드가 종료되도록 설정
		  }finally{
		   try{
		    if(bufferR!=null)bufferR.close();
		    if(bufferW!=null)bufferW.close();
		    if(socket!=null)socket.close();
		   }catch(IOException ioe){
		    ioe.printStackTrace();
		   }
		  }//end finally
		  
		 }//end run()

}
