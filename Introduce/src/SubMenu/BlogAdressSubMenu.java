package SubMenu;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class BlogAdressSubMenu extends JMenu {
	
	private JMenuItem Blog_Address;
	
	public BlogAdressSubMenu(){
	
		super("��α� �ּ�");
		
		Blog_Address = new JMenuItem("http://www.ggogun.kr");
		this.add(Blog_Address);
		
	}

}
