package Menu;

import javax.swing.JMenu;

import SubMenu.LikeMovieSubMenu;
import SubMenu.LikeMusicSubMenu;
import SubMenu.LikeTalentsSubMenu;

public class GEMenuLike extends JMenu {
	

	public GEMenuLike(String Label){
		super(Label);
		
		// ������,����,��ȭ
		
	
		this.add(new LikeTalentsSubMenu());
		// ������ ���� �޴� ȣ��
			
		this.add(new LikeMusicSubMenu());
		// ���� ���� �޴� ȣ�� 
				
		this.add(new LikeMovieSubMenu());
		// ��ȭ ���� �޴� ȣ�� 
		
		
	}
}
