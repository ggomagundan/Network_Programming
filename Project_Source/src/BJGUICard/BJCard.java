package BJGUICard;

import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import BJGUIFrame.BJPanel;



public class BJCard {
	
	private BJPanel bjPanel;
	private static Graphics2D g2d;	
	private ArrayList<Point> pointList = new ArrayList<Point>();
	private ArrayList<String> cardList = new ArrayList<String>();
	
	public void drawCard(String card, int x, int y){
		
		
		
		ImageIcon cardImage;
		cardImage = new ImageIcon("images/Card/"+card+".png");
		
		//System.out.println(g2d);
		g2d.drawImage(cardImage.getImage(),x, y, null);
		
//		cardImage = new ImageIcon("images/Card/Clover_9"+".png");
//		g2d.drawImage(cardImage.getImage(),x-20, y,  null);
//		
//		cardImage = new ImageIcon("images/Card/Clover_8"+".png");
//		g2d.drawImage(cardImage.getImage(),x-40, y,  null);
//		
//		cardImage = new ImageIcon("images/Card/Clover_8"+".png");
//		g2d.drawImage(cardImage.getImage(),x-60, y,  null);
//		
//		//cardImage = new ImageIcon("images/Card/Clover_8"+".png");
//		//g2d.drawImage(cardImage.getImage(),x-80, y,  null);
//		//
		g2d.finalize();
		
		//bjPanel.repaint();
	        
	//	drawCard() ;  
	        
		
		
	}

	public void init(BJPanel bjPanel) {
		// TODO Auto-generated method stub
		this.bjPanel = bjPanel;
		
		
	}

	public void setG2d(Graphics2D g) {
		// TODO Auto-generated method stub
		g2d = g;
	}

	public void drawCard() {
		// TODO Auto-generated method stub
		ImageIcon cardImage;

		for(int i =0;i < cardList.size();i++){
			ImageIcon cardImage1;
			cardImage1 = new ImageIcon("images/Card/"+cardList.get(i)+".png");
			//String tempStr = cardList.get(i);
			Point tempPoint = pointList.get(i);
			g2d.drawImage(cardImage1.getImage(),(int)tempPoint.getX()-i*20, (int)tempPoint.getY(), null);
			
		}
		
		
		//g2d.finalize();
		
		
		
	}

	public ArrayList<Point> getPointList() {
		// TODO Auto-generated method stub
		return pointList;
	}

	public ArrayList<String> getCardList() {
		// TODO Auto-generated method stub
		return cardList;
	}

	public void addCard(String ta, int x, int y) {
		// TODO Auto-generated method stub
		if(!cardList.contains(ta)){
			pointList.add(new Point(x,y));
			cardList.add(ta);
		}
	}

}
