package Menu;

import javax.swing.JMenu;

import SubMenu.LikeMovieSubMenu;
import SubMenu.LikeMusicSubMenu;
import SubMenu.LikeTalentsSubMenu;

public class GEMenuLike extends JMenu {
	

	public GEMenuLike(String Label){
		super(Label);
		
		// 연예인,음악,영화
		
	
		this.add(new LikeTalentsSubMenu());
		// 연예인 서브 메뉴 호출
			
		this.add(new LikeMusicSubMenu());
		// 음악 서브 메뉴 호출 
				
		this.add(new LikeMovieSubMenu());
		// 영화 서브 메뉴 호출 
		
		
	}
}
