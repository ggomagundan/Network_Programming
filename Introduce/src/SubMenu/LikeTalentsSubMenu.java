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
		
		super("������");
		
		Like_Kitano = new JMenuItem("ŰŸ�� Ű��");
		this.add(Like_Kitano);
		
		Like_Horikita = new JMenuItem("ȣ��ŰŸ ��Ű");
		this.add(Like_Horikita);
		
		
		this.addSeparator();
		
		Like_GangHee = new JMenuItem("�ְ���");
		this.add(Like_GangHee);
		
		Like_DooNa = new JMenuItem("��γ�");
		this.add(Like_DooNa);
		
		Like_HyunGyeong = new JMenuItem("������");
		this.add(Like_HyunGyeong);
		
		
		
		
	}
}
