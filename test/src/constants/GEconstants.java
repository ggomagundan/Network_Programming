package constants;

public class GEconstants {
	
	public static final int Width_MainFrame=400;
	public static final int Height_MainFrame=600;
	public static final String Title_MainFrame="나의 소개";
	
	public static final String Title_FileMenu="파일";
	public static final String Title_EditMenu="편집";
	public static final String Title_colorMenu="컬러";
	
	public static enum EFileMenuItems{ 새로만들기,열기,저장,다른이름으로저장,종료};
	public static enum EEditMenuItems{ Undo,redo,삭제, 잘라내기,복사,붙이기,그룹,그룹해제};
	public static enum EColorMenuItems{ SetLineColor,ClearLineColor,SetFillColor,ClearFillColor};	
		
		
}
