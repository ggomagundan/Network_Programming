package frames;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;

import constants.GEConstants;
import constants.GEConstants.EState;

public class GEDrawingPanel extends JPanel {

	private MouseDrawingHandler drawingHandler;
	public static GEDrawingPanel panel;
	public int r=0,g=0,b=0;
	
	public GEDrawingPanel() {
		super();
	
		drawingHandler = new MouseDrawingHandler();
		
		
		addMouseListener(drawingHandler);
		this.setBackground(new Color(r,g,b));
		
	
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	
		}

	
	

	private class MouseDrawingHandler extends MouseInputAdapter {
		
		
		public void mouseClicked(MouseEvent e) {
			if (e.getButton() == MouseEvent.BUTTON1) {
			
				
					if(r < 250) 
						r+=50;
					else if(g < 250)
						g += 50;
					else if(b < 250)
						b += 50;
					else return;
					
					System.out.println(r+ " "+  g + " " +b);
					
					panel.setBackground(new Color(r,g,b));
					panel.getGraphics().drawString("asdf", 10, 10);
				
				
			}
				
		}

	
	}

}