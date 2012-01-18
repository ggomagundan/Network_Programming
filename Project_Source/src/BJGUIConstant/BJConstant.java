package BJGUIConstant;

import java.awt.Color;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class BJConstant {
	
	// GEMainFrame
	public static final int WIDTH_MAINFRAME				= 1200;
	public static final int HEIGHT_MAINFRAME			= 700;
	public static final String TITLE_MAINFRAME			= "Network BlackJack - Ver. 1.0";
	
	// GEMenu
	public static final String TITLE_FILEMENU			= "파일(F)";
	public static final String TITLE_INFOMENU			= "도움말(H)";
	
	public static final String TITLE_TOOLBAR			= "Tools";
	public static int WIDTH_SHAPETOOLBAR				= 30;
	public static int HEIGHT_SHAPETOOLBAR				= 200;
	
	
	
	// GEMenuItems
	public static enum EFileMenuItems { 종료};
	public static enum EToolBarButtons { New, Open, Save};
	public static enum EInfoMenuItems { 프로그램정보 };
	
	
	public static final String IMG_URL = "images/";
	public static final String SUFFIX_TOOLBAR_BTN = ".gif";
	public static final String SUFFIX_TOOLBAR_BTN_SLT = "SLT.gif";
	
		// GEDrawingPanel
	public static final Color FOREGROUND_COLOR	=	Color.BLACK;
	public static final Color BACKGROUND_COLOR	=	Color.WHITE;
	
	public final static Color COLOR_LINE_DEFAULT 		= Color.BLACK;
	public final static Color COLOR_FILL_DEFAULT 		= Color.WHITE;
	


	
    public static final String INFO = 
		"BlackJack Ver. 1.0\n만든이 :\n 60072402  박병상,\n 60072415  오세도\n만든날짜 : 2011-05-20";	


}
