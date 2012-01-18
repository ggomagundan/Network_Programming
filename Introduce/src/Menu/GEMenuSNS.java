package Menu;

import javax.swing.JMenu;

import SubMenu.BlogAdressSubMenu;
import SubMenu.MailAdressSubMenu;
import SubMenu.MessengerIDSubMenu;
import SubMenu.SNSIDSubMenu;

public class GEMenuSNS extends JMenu {
	

	public GEMenuSNS(String Label){
		super(Label);
		
	//	Mail, Messenger, SNS, Blog
		
	
		this.add(new MailAdressSubMenu());
		// �����ּ� ���� �޴� ȣ��
	
		this.add(new MessengerIDSubMenu());
		// �޽��� �ּ� ���� �޴� ȣ��
		
		this.add(new SNSIDSubMenu());
		// SNS �ּ� ���� �޴� ȣ��
		
		this.add(new BlogAdressSubMenu());
		// ��α� �ּ� ���� �޴� ȣ��
		
		
		
	}
}
