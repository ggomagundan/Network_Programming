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
		// 메일주소 서브 메뉴 호출
	
		this.add(new MessengerIDSubMenu());
		// 메신져 주소 서브 메뉴 호출
		
		this.add(new SNSIDSubMenu());
		// SNS 주소 서브 메뉴 호출
		
		this.add(new BlogAdressSubMenu());
		// 블로그 주소 서브 메뉴 호출
		
		
		
	}
}
