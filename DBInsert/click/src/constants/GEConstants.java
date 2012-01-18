package constants;

import java.awt.Color;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class GEConstants {
	
	// GEMainFrame
	public static final int WIDTH_MAINFRAME				= 500;
	public static final int HEIGHT_MAINFRAME			= 300;
	public static final String TITLE_MAINFRAME			= "�׷��� ������ - ����ǥ";
	
	// GEMenu
	public static final String TITLE_FILEMENU			= "����(F)";
	public static final String TITLE_EDITMENU			= "����(E)";
	public static final String TITLE_COLOTMENU			= "�÷�(C)";
	public static final String TITLE_INFOMENU			= "����(H)";
	
	// GEMenuItems
	public static enum EFileMenuItems { ���θ����, ����, ����, �ٸ��̸���������, ����};
	public static enum EEditMenuItems { Undo, Redo, ����, �߶󳻱�, ����, ���̱�, group, Ungroup };
	public static enum EColorMenuItems { SetLineColor, ClearLineColor, SetFillColor, ClearFillColor};
	public static enum EInfoMenuItems { ���α׷����� };
	
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
		"GE Calendar Ver. 1.0\n������ :\n 60072402  �ں���,\n 60072415  ������,\n 60072416  ������\n���糯¥ : 2010-12-05";	
}
