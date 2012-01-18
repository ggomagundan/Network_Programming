package frames;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import constants.GEConstants;

public class GEMainFrame extends JFrame {
	
	private static GEMainFrame uniqueMainFrame = new GEMainFrame(
			GEConstants.TITLE_MAINFRAME);
	private GEDrawingPanel drawingPanel;

	
	public GEMainFrame(String title) {
		super(title);
		//this.setSize(Toolkit.getDefaultToolkit().getScreenSize().width,100);
		drawingPanel = new GEDrawingPanel();
		
		drawingPanel.panel = drawingPanel;
		add(drawingPanel);
		
	
		
	
	}

	public static GEMainFrame getInstance() {
		return uniqueMainFrame;
	}

	public void init() {
	
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(Toolkit.getDefaultToolkit().getScreenSize().width,Toolkit.getDefaultToolkit().getScreenSize().height);
		setVisible(true);
	}
}