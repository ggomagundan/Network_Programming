package Panel;

import javax.swing.*;
import constants.*;
import menu.GEMenuBar;





public class GEMainFrame extends JFrame{

	private static GEMainFrame uniqueMainFrame= 
		new GEMainFrame(GEconstants.Title_MainFrame);
	
	private GEdrawing DrawingPanel;

	private GEMenuBar MenuBar;
	
	private GEMainFrame(String title){
		super(title);
		DrawingPanel = new GEdrawing();
		add(DrawingPanel);
		
		MenuBar = new GEMenuBar();
		setJMenuBar(MenuBar);
		
	}

public static GEMainFrame getinstance(){
	
	return uniqueMainFrame;
	
}

public void init(){
	setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	setSize(GEconstants.Width_MainFrame,GEconstants.Height_MainFrame);
	setVisible(true);
}
}