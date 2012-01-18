package ggogun.puzzle;

import java.util.Random;

import android.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class puzzle_act extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        buttons[0] = (Button) findViewById(R.id.one);
        buttons[1] = (Button) findViewById(R.id.two);
        buttons[2] = (Button) findViewById(R.id.three);
        buttons[3] = (Button) findViewById(R.id.four);
        buttons[4] = (Button) findViewById(R.id.five);
        buttons[5] = (Button) findViewById(R.id.six);
        buttons[6] = (Button) findViewById(R.id.seven);
        buttons[7] = (Button) findViewById(R.id.eight);
        buttons[8] = (Button) findViewById(R.id.blank);
        
       
        
        ((Button) findViewById(R.id.start)).setOnClickListener(on_start);
    
        int lup;
        for(lup=0; lup<9;lup++) buttons[lup].setOnClickListener(on_click);
        
        
    }	
    private Button buttons[] = new Button[9];
    
    private void swap(Button A, Button B){
    		int left = A.getLeft();
    		int right = A.getRight();
    		int top = A.getTop();
    		int bottom = A.getBottom();
    		
    		A.layout(B.getLeft(),B.getTop(), B.getRight(),  B.getBottom());
    		B.layout(left, top,right, bottom);
    }
    
    private boolean is_ver(Button A, Button B){
    
    	return ((A.getLeft() == B.getLeft()) && (Math.abs(A.getTop()-B.getTop())< 100));
    }
    
    private boolean is_hori(Button A, Button B){
    	return ((A.getTop()==B.getTop()) && (Math.abs(A.getLeft()-B.getLeft())<100));
    }
    
    private boolean is_end(){
    	return (buttons[0].getLeft()==0 && buttons[0].getTop()==0 && buttons[0].getRight()==48 && buttons[0].getBottom()==48
    			&& buttons[1].getLeft()==48 && buttons[1].getTop()==0 && buttons[1].getRight()==96 && buttons[1].getBottom()==48
    			&& buttons[2].getLeft()==96 && buttons[2].getTop()==0 && buttons[2].getRight()==144 && buttons[2].getBottom()==48
    			&& buttons[3].getLeft()==0 && buttons[3].getTop()==48 && buttons[3].getRight()==48 && buttons[3].getBottom()==96
    			&& buttons[4].getLeft()==48 && buttons[4].getTop()==48 && buttons[4].getRight()==96 && buttons[4].getBottom()==96
    			&& buttons[5].getLeft()==96 && buttons[5].getTop()==48 && buttons[5].getRight()==144 && buttons[5].getBottom()==96
    			&& buttons[6].getLeft()==0 && buttons[6].getTop()==96 && buttons[6].getRight()==48 && buttons[6].getBottom()==144
    			&& buttons[7].getLeft()==48 && buttons[7].getTop()==96 && buttons[7].getRight()==96 && buttons[7].getBottom()==144
    			);
    }
    
    /* 1 0 0 48 48
     * 2 48 0 96 48
     * 3 96 0 144 48
     * 4 0 48 48 96
     * 5 48 48 96 96
     * 6 96 48 144 96
     * 7 0 96 48 144
     * 8 48 96 96 144
     */
    
    private View.OnClickListener on_click = new View.OnClickListener() {
		
	
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Button A = (Button) v;
			Button blk = (Button)findViewById(R.id.blank);
			if(is_ver(A,blk) || is_hori(A,blk)){
			swap(A,blk);
			}
			
			if(is_end()){
				((TextView) findViewById(R.id.hello)).setText("끝났습니다"); 
				

				}
			else{
				((TextView) findViewById(R.id.hello)).setText("분발하세요");
			}
			
			
			
			
		}
	};
    
    
    private View.OnClickListener on_start = new View.OnClickListener() {
		
	
		public void onClick(View v) {
			int i,j;	
			
			for(j =0; j <3; j++){
				for(i =0; i <3;i++){
					buttons[j*3+i].layout(i*80, j*80, i*80+80, j*80+80);
					
					
	
				}
			}
			
			Random random = new Random();
			
			
			for(i =0 ;i < 1000;i++){
				on_click.onClick(buttons[random.nextInt(8)]);
				
			}
			
			
		}
	};
    			
    }




