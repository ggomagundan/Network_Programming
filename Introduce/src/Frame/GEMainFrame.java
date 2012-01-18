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
		// X ��ư Ȱ��ȭ
		setSize(GEConstants.Width_MainFrame,GEConstants.Height_MainFrame);
		// �������� ������ ����
		
		setResizable(false);
		// ������ ���� ���� 
		
		Dimension Screen_Size = Toolkit.getDefaultToolkit().getScreenSize();
		// ��ũ���� ũ�� ȹ��
		
		Frame_x_Position = (int)((Screen_Size.getWidth() - GEConstants.Width_MainFrame)/2);
		Frame_y_Position = (int)((Screen_Size.getHeight()- GEConstants.Height_MainFrame)/2);
		// �������� �߾���ġ ��ǥ ȹ��
		
		setLocation(Frame_x_Position, Frame_y_Position);
		// ������ �߾� ��ġ
		
		setVisible(true);
		// ������ ����ȭ ����
			
	}
}
