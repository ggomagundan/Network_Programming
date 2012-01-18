package BJGUIFrame;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import BJGUICard.BJCard;
import BlackJack.Card;


@SuppressWarnings("serial")
public class BJPanel extends JPanel {
	
	Graphics2D g2d;
	BJCard card;
	private ArrayList<Point> pointList = new ArrayList<Point>();
	private ArrayList<String> cardList = new ArrayList<String>();
	
	
	public BJPanel() {
		super();
	
		
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
	    ImageIcon icon;
		icon = new ImageIcon("images/rePan1.gif");
		pointList = card.getPointList();
		cardList = card.getCardList();
		 //  Approach 1: Display image at at full size
        g.drawImage(icon.getImage(), 0, 0, null);
       
       card.setG2d((Graphics2D)g);
        setOpaque(false);
       // System.out.println(getGraphics());
     //card.drawCard("Clover_10", 860, 330);
        //player 1
        
        //card.drawCard("Clover_10", 630, 400);
        // player2
        
       // card.drawCard("Clover_10", 350, 400);
        // player3
        
      //  card.drawCard("Clover_10", 130, 325);
        // player4
        for(int i =0;i < cardList.size();i++){
//			ImageIcon cardImage1;
//			cardImage1 = new ImageIcon("images/Card/"+cardList.get(i)+".png");
//			System.out.println("images/Card/"+cardList.get(i)+".png");
			String tempStr = cardList.get(i);
			Point tempPoint = pointList.get(i);
			card.drawCard(tempStr,(int)tempPoint.getX()-i*20, (int)tempPoint.getY());
//			g2d.finalize();
//			
		}
        repaint();
	}

	
	
	public void setCard(BJCard card) {
		// TODO Auto-generated method stub
		this.card = card;
	}

	
	
	public void addButton(JButton button) {
		// TODO Auto-generated method stub
		button.setLocation(500,500);
		
		this.add(button);
		
	}
	
	public BJCard getCard() {
		// TODO Auto-generated method stub
		return card;
	}

	
	
}