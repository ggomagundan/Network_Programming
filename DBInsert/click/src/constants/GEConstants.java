package constants;

import java.awt.Color;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class GEConstants {
	
	// GEMainFrame
	public static final int WIDTH_MAINFRAME				= 500;
	public static final int HEIGHT_MAINFRAME			= 300;
	public static final String TITLE_MAINFRAME			= "그래픽 에디터 - 일정표";
	
	// GEMenu
	public static final String TITLE_FILEMENU			= "파일(F)";
	public static final String TITLE_EDITMENU			= "편집(E)";
	public static final String TITLE_COLOTMENU			= "컬러(C)";
	public static final String TITLE_INFOMENU			= "도움말(H)";
	
	// GEMenuItems
	public static enum EFileMenuItems { 새로만들기, 열기, 저장, 다른이름으로저장, 종료};
	public static enum EEditMenuItems { Undo, Redo, 삭제, 잘라내기, 복사, 붙이기, group, Ungroup };
	public static enum EColorMenuItems { SetLineColor, ClearLineColor, SetFillColor, ClearFillColor};
	public static enum EInfoMenuItems { 프로그램정보 };
	
	// GEToolbar
	public static final String TITLE_SHAPETOOLBAR		= "Shape Tools";
	public static int WIDTH_SHAPETOOLBAR				= 30;
	public static int HEIGHT_SHAPETOOLBAR				= 200;
	public static enum EToolBarButtons { New, Open, Save, Select, Rectangle, Line, Ellipse, Polygon, Arc, Triangle, 
										Five, Six, Star, Rectangle3D, Triangle3D, Ellipse3D};
	public static final String IMG_URL = "images/";
	public static final String SUFFIX_TOOLBAR_BTN = ".gif";
	public static final String SUFFIX_TOOLBAR_BTN_SLT = "SLT.gif";
	
	// GEDrawingPanel
	public static final Color FOREGROUND_COLOR	=	Color.BLACK;
	public static final Color BACKGROUND_COLOR	=	Color.RED;
	public enum EState { Idle, TwoPointsDrawing, NPointsDrawing, Moving, Resize, Selecting }
	public final static Color COLOR_LINE_DEFAULT 		= Color.BLACK;
	public final static Color COLOR_FILL_DEFAULT 		= Color.WHITE;
	
	// GEAnchorList
	public static final int ANCHOR_W = 6;
	public static final int ANCHOR_H = 6;
	public static final int RR_OFFSET = 40;
	public static final Color ANCHOR_LINECOLOR = Color.BLACK; 
	public static final Color ANCHOR_FILLCOLOR = Color.WHITE;
	public static enum EAnchorTypes {NW, NN, NE, WW, EE, SW, SS, SE, RR, NONE}
	
	// GECMenuColor
	public static final String FILLCOLOR_TITLE = "Selected Fill Color";
	public static final String LINECOLOR_TITLE = "Selected Line Color";
	
	// GETransfromer
	public final static int DEFAULT_DASH_OFFSET = 4;
	public final static int DEFAULT_DASHEDLINE_WIDTH = 1;
	
	//GECal
	static Calendar calendar = new GregorianCalendar();
	public final static int ThisYear = calendar.get(Calendar.YEAR);
    public final static int ThisMonth = calendar.get(Calendar.MONTH);
    public static final String INFO = 
		"GE Calendar Ver. 1.0\n만든이 :\n 60072402  박병상,\n 60072415  오세도,\n 60072416  오재일\n만든날짜 : 2010-12-05";	
}
