package BJGUIFrame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import BJGUICard.BJCard;
import BJGUIConstant.BJConstant;
import BJGUIMenus.BJMenuBar;
import client.Client;


@SuppressWarnings("serial")
public class BJMainFrame extends JFrame{
	
	private static BJMainFrame MainFrame = new BJMainFrame(
			BJConstant.TITLE_MAINFRAME);
	private BJPanel blackJackPanel;
	private BJMenuBar menuBar;
	private BJToolbar toolBar;
	private BJChatPanel chatPanel;
	private BJCard card;
	private JButton button;
	private Client client;
	Socket socket;
	PrintWriter printWriter;
	BufferedReader bufferedReader;

	public BJMainFrame(String title) {
		super(title);
		
		try {
			socket = new Socket("117.17.158.171",9995);
			bufferedReader = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			printWriter = new PrintWriter(new OutputStreamWriter(
					socket.getOutputStream()));
			
			
			
		} catch (UnknownHostException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		blackJackPanel = new BJPanel();
		add(blackJackPanel);
		
	
		menuBar = new BJMenuBar();
		setJMenuBar(menuBar);
		toolBar = new BJToolbar(BJConstant.TITLE_TOOLBAR);
		add(BorderLayout.NORTH, toolBar);
		chatPanel = new BJChatPanel();
		add(BorderLayout.EAST,chatPanel);
		card = new BJCard();
		button = new JButton("Join");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// TODO Auto-generated method stub
				if(button.getText().equals("Join")){
					try {
						
						//String msg = bufferedReader.readLine();
						//System.out.println(msg);
												
						printWriter.println("( "
									+ InetAddress.getLocalHost().getHostAddress() + " ) "
									+ "> " + "join> yes");
						printWriter.flush();
						
					
						
					} catch (UnknownHostException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					button.setText("Start");
				}else if(button.getText().equals("Start")){
					try {
						printWriter.println("( "
								+ InetAddress.getLocalHost().getHostAddress() + " ) "
								+ "> " + "start> yes");
						printWriter.flush();
						button.setVisible(false);
					} catch (UnknownHostException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					
					
				}
			}
		});
		
		
		blackJackPanel.addButton(button);
				
	}

	public static BJMainFrame getInstance() {
		return MainFrame;
	}

	public void init() {
		
		
		blackJackPanel.setCard(card);
		menuBar.init(blackJackPanel);
		toolBar.init(blackJackPanel);
		chatPanel.init(blackJackPanel, printWriter, bufferedReader);
	
		card.init(blackJackPanel);
		
	
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(BJConstant.WIDTH_MAINFRAME, BJConstant.HEIGHT_MAINFRAME);
		setVisible(true);
		setResizable(false);
		
	}

	

}
