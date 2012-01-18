package BJGUIMenus;

import javax.swing.JMenuBar;

import BJGUIConstant.BJConstant;
import BJGUIFrame.BJPanel;


public class BJMenuBar extends JMenuBar{

	private BJMenuFile fileMenu;
	private BJMenuInfo infoMenu;
	
	public BJMenuBar(){
		fileMenu = new BJMenuFile(BJConstant.TITLE_FILEMENU);
		add(fileMenu);
		infoMenu = new BJMenuInfo(BJConstant.TITLE_INFOMENU);
		add(infoMenu);
	}
	
	// �ʱ�ȭ �޼ҵ�
	public void init(BJPanel dp){
		
		
		fileMenu.init(dp);
		infoMenu.init(dp);
	}
}
