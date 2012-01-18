package SubMenu;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class LikeTalentsSubMenu extends JMenu {
	
	private JMenuItem Like_Kitano;
	private JMenuItem Like_Horikita;
	private JMenuItem Like_GangHee;
	private JMenuItem Like_DooNa;
	private JMenuItem Like_HyunGyeong;
	
	public LikeTalentsSubMenu(){
		
		super("연예인");
		
		Like_Kitano = new JMenuItem("키타노 키이");
		this.add(Like_Kitano);
		
		Like_Horikita = new JMenuItem("호리키타 마키");
		this.add(Like_Horikita);
		
		
		this.addSeparator();
		
		Like_GangHee = new JMenuItem("최강희");
		this.add(Like_GangHee);
		
		Like_DooNa = new JMenuItem("배두나");
		this.add(Like_DooNa);
		
		Like_HyunGyeong = new JMenuItem("류현경");
		this.add(Like_HyunGyeong);
		
		
		
		
	}
}
