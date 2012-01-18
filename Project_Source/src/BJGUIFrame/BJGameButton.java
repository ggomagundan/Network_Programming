package BJGUIFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;

public class BJGameButton extends JButton{

	private BJButtonHandler bjButtonHandler = new BJButtonHandler();
	private BJPanel blackJackPanel;
	private JButton rButton;
	public BJGameButton(){
		// TODO Auto-generated constructor stub
	
				
	
	
			rButton = new JButton();
			
			rButton.setSize(100, 100);
			
			rButton.setText("Join");
			rButton.addActionListener(bjButtonHandler);
			rButton.setActionCommand("Join");
			
			
		
			
		//}
	}
	
	private class BJButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			System.out.println("Click");
		}
		
	}

	public void init(BJPanel blackJackPanel) {
		this.blackJackPanel = blackJackPanel;
	}
}
