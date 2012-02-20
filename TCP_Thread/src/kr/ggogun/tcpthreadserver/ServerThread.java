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
		  
		  boolean isStop = false;   //������ ������ ���� �� ������ ���� boolean
		  
		  try{
		   is = socket.getInputStream();
		   os = socket.getOutputStream();
		   bufferR = new BufferedReader(new InputStreamReader(is));
		   bufferW = new BufferedWriter(new OutputStreamWriter(os));
		   
		  }catch(IOException ioe){
		   isStop = true;   //��Ʈ�� ������ �����ϸ� ������ ������ �����Ѵ�.
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
		   System.out.println("Ŭ���̾�Ʈ�� ������ ����Ǿ����ϴ�.");
		   isStop = true;   //Ŭ���̾�Ʈ�� exit �޼��� ���� ���Ƿ� �����ص� �����尡 ����ǵ��� ����
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
