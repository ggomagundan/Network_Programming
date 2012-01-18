package BJGUIFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import BJGUICard.BJCard;


public class BJChatComponent extends Thread {
	
	
	public static JTextField chatLine;
	public static JTextArea chatText;
	private BJChatPanel bjChatPanel;
	private String name;
	Socket socket;
	BJCard card;
	PrintWriter printWriter;
	BufferedReader bufferedReader ;
	BJChatComponent chatcomp;
	
	public BJChatComponent(){
		
		chatcomp = this;
		
		
	}
	
	
	
	public void setBlank(){
		
		String cmd = chatLine.getText().split(">")[0];
		
		
		
		if(!(cmd.equals("more") || cmd.equals("bet")))
		chatText.append(chatLine.getText()+ "\n");
		chatLine.setText("");
		
		 
	        
	}
	



	private void makeChat() {
		// TODO Auto-generated method stub
		chatText = new JTextArea(5, 20);
		
		
	      
		chatText.setEditable(true);
	 	chatText.setForeground(Color.blue);
	 	chatText.setBackground(Color.red);
	      
	      
	      JScrollPane chatTextPane = new JScrollPane(chatText,
	         JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
	         JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	      
	      
	      chatLine = new JTextField();
	      chatLine.setEnabled(true);
	      chatLine.setEditable(true);
	      chatText.setEditable(false);
	      chatLine.setText("");
	      chatText.setText("");
	      
	      
	     
	      chatLine.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				int key = e.getKeyCode();
				
				
				if(chatLine.getText().length() != 0 && key == KeyEvent.VK_ENTER){
					
					try {
						System.out.println("send msg");
						printWriter.println(name + " ( "
								+ InetAddress.getLocalHost().getHostAddress() + " ) "
								+ "> " + chatLine.getText());
						printWriter.flush();
						card.drawCard();
						setBlank();
					} catch (UnknownHostException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					Thread thread = new Thread(chatcomp);
					thread.start();
					
					
						
				}
			}
	      });
							
						
			
	      
	    bjChatPanel.add(chatTextPane,BorderLayout.CENTER);
	    bjChatPanel.add(chatLine,BorderLayout.SOUTH);
		
	}
	
	public void run(){
		
		String str;
		while(true){
		try {
				String temp[] = new String[4];
				String tmp[] = new String[5];
				str = bufferedReader.readLine();
				if(str != null)
				System.out.println(str);
				temp = str.split(" : ");
				if(temp[0].equals("Dealer")){
					tmp = temp[1].split(" ");
					for(String t : tmp){
						String ta = makeCard(t.substring(0, 1),t.substring(1, t.length()));
						
						System.out.println("recieve card" + ta );
						card.addCard(ta, 560, 200);
						
					}
				}else if(temp[0].equals("User")){
					tmp = temp[1].split(" ");
					for(String t : tmp){
						String ta = makeCard(t.substring(0, 1),t.substring(1, t.length()));
						System.out.println("recieve card" + ta );
						
						card.addCard(ta, 860, 400);
						
					}
				}
			
				
		} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		


		
			
		
	}



	private String makeCard(String substring, String substring2) {
		// TODO Auto-generated method stub
		String cardName= null;
		switch(substring.charAt(0)){
		case 'C':
			cardName = "Clover_"+substring2;
			break;
		case 'H':
			cardName = "Heart_"+substring2;
			break;
		case 'S':
			cardName = "Spade_"+substring2;
			break;
		case 'D':
			cardName = "Diamond_"+substring2;
			break;
		}
		return cardName;
	}



	public void init(BJChatPanel bjChatPanel, PrintWriter printWriter,
			BufferedReader bufferedReader) {
		// TODO Auto-generated method stub
		this.bjChatPanel = bjChatPanel;
		this.printWriter = printWriter;
		this.bufferedReader =bufferedReader;
		card = bjChatPanel.getPanel().getCard();
		makeChat();
		name = JOptionPane.showInputDialog(null, "Enter Your Name : ", 
				"Name Input", 1);
	}

}