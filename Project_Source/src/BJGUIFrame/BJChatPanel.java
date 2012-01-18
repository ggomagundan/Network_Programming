package BJGUIFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import BJGUICard.BJCard;

public class BJChatPanel extends JPanel {

	private BJChatComponent compo;
	
	private BJPanel blackJackPanel;

	
	
	public BJChatPanel(){
		super(new BorderLayout());
		
		
		this.setPreferredSize(new Dimension(200, 700));	
		
	}
	
	

	


	public void init(BJPanel blackJackPanel, PrintWriter printWriter,
			BufferedReader bufferedReader) {
		// TODO Auto-generated method stub
		this.blackJackPanel = blackJackPanel;
		
		
		compo  = new BJChatComponent();
		compo.init(this, printWriter, bufferedReader);
	}






	public void showButton() {
		// TODO Auto-generated method stub
		
	}






	public BJPanel getPanel() {
		// TODO Auto-generated method stub
		return blackJackPanel;
	}






	



	
}
