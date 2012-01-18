/*package test;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;








class panel extends JFrame{
	
	JButton btn1;
	Menu Main_Menu;
	MenuBar Main_Menuba_Elements;
	
	
	
	public static final int Width_of_MainFrame=400;
	public static final int Height_of_MainFrame=600;
	
	
	
	
	
	panel(String ti){
		super(ti);
		init();
		start();
		
	}
	
	
	
	
	
	
	
	public void init(){
		
		this.setAlwaysOnTop(true);
		this.setVisible(true);
		this.setResizable(false);
		
		this.setSize(Width_of_MainFrame,Height_of_MainFrame);
		Dimension screen= Toolkit.getDefaultToolkit().getScreenSize();
		Dimension scr = this.getSize();
		int xpos, ypos;
		
		xpos = (int)(screen.getWidth() - scr.getWidth())/2;
		ypos = (int)(screen.getHeight()- scr.getHeight())/2;
		this.setLocation(xpos,ypos);
		
		
	  
	       
	   		
	}
	
	public void start(){
		
	}
	
	
}


public class test {
	public static void main(String[] ar){
		panel p = new panel("title");
		
		
	}
	
	
	
}*/
