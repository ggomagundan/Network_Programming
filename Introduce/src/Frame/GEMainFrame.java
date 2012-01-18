package Frame;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import Constants.GEConstants;
import Menu.GEMenuBar;



public class GEMainFrame extends JFrame{
	
	private static GEMainFrame uniqueMainFrame= 
		new GEMainFrame(GEConstants.Title_MainFrame);
	
	private GEDrawing DrawingFrame;

	private GEMenuBar MenuBar;
	
	private GEMainFrame(String Title){
		
		super(Title);
		
		DrawingFrame = new GEDrawing();
		add(DrawingFrame);
		
		MenuBar = new GEMenuBar();
		setJMenuBar(MenuBar);
		
	}

	
	
	public static GEMainFrame getInstance(){
	
		return uniqueMainFrame;
	
	}

	
	
	public void init(){
		
		int Frame_x_Position, Frame_y_Position;
		
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		// X 버튼 활성화
		setSize(GEConstants.Width_MainFrame,GEConstants.Height_MainFrame);
		// 프레임의 사이즈 정의
		
		setResizable(false);
		// 사이즈 변경 금지 
		
		Dimension Screen_Size = Toolkit.getDefaultToolkit().getScreenSize();
		// 스크린의 크기 획득
		
		Frame_x_Position = (int)((Screen_Size.getWidth() - GEConstants.Width_MainFrame)/2);
		Frame_y_Position = (int)((Screen_Size.getHeight()- GEConstants.Height_MainFrame)/2);
		// 프레임의 중앙위치 좌표 획득
		
		setLocation(Frame_x_Position, Frame_y_Position);
		// 프레임 중앙 배치
		
		setVisible(true);
		// 프레임 가시화 설정
			
	}
}
