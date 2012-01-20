package kr.ggogun.logic;

import java.util.Scanner;

import javax.swing.plaf.SliderUI;

public class LogicEngine {
	
	private int countOfCells=20;
	private int countOfColors = 6;
	private int[][] gameBoard;
	private int[][] checkBoard;
	private int currentSelectColor ;
	private int countOfClicks=0;
	public Scanner scan;

	public void intialize() {
		
		gameBoard = new int[countOfCells][countOfCells];
		checkBoard = new int[countOfCells][countOfCells];
		
		fillZero(checkBoard);
		
		for(int i =0 ;i < countOfCells;i++){
			for(int j =0 ; j < countOfCells;j++){
		      int n = (int) (Math.random() * countOfColors) + 1;
		      gameBoard[i] [j] = n;
		     //System.out.println(n);
			}
		}

		printCurrent();
		
		currentSelectColor = gameBoard[0][0];
	
		countOfClicks=0;
		scan = new Scanner(System.in);
	}
	
	private void printCurrent() {
		for(int i =0 ;i < countOfCells;i++){
			for(int j =0 ; j < countOfCells;j++)
				System.out.print(gameBoard[i][j] + " ");
			
			System.out.println();
		}		
		System.out.println();
	}

	private void checkSpread(int i, int j, int selectColor) {
		
		
		
		if(gameBoard[i][j] == currentSelectColor){
			gameBoard[i][j] = selectColor;
			
			//printCurrent();
			if(i != 0 && gameBoard[i-1][j] == currentSelectColor){
				
				checkSpread(i-1, j, selectColor);
			}
			
			if(i < countOfCells-1 && gameBoard[i+1][j] == currentSelectColor){
				checkSpread(i+1, j, selectColor);
			}
			
			if(j != 0 && gameBoard[i][j-1] == currentSelectColor){
				checkSpread(i, j-1, selectColor);
			}
			
			if(j < countOfCells-1  && gameBoard[i][j+1] == currentSelectColor){
				checkSpread(i, j+1, selectColor);
			}
			
			
				
				
		}
		
		
	}
	
	
	


	private void checkSurface(int i, int j) {

		if(i == 0 && j ==0 && gameBoard[i][j] == gameBoard[i+1][j] && gameBoard[i][j] == gameBoard[i][j+1]){
			checkBoard[i][j] = 2;
		}else if(i == 0 && j == countOfCells-1 && gameBoard[i][j] == gameBoard[i+1][j] && gameBoard[i][j] == gameBoard[i][j-1]){
			checkBoard[i][j] = 2;
		}else if(i ==  countOfCells-1 && j == 0 && gameBoard[i][j] == gameBoard[i-1][j] && gameBoard[i][j] == gameBoard[i][j+1]){
			checkBoard[i][j] = 2;
		}else if(i ==  countOfCells-1 && j == countOfCells-1 && gameBoard[i][j] == gameBoard[i-1][j] && gameBoard[i][j] == gameBoard[i][j-1]){
			checkBoard[i][j] = 2;
		}else if(i == 0 && gameBoard[i][j] == gameBoard[i+1][j] && gameBoard[i][j] == gameBoard[i][j+1] && gameBoard[i][j] == gameBoard[i][j-1]){
			checkBoard[i][j] = 2;
		}else if(i == countOfCells-1 && gameBoard[i][j] == gameBoard[i-1][j] && gameBoard[i][j] == gameBoard[i][j+1] && gameBoard[i][j] == gameBoard[i][j-1]){
			checkBoard[i][j] = 2;
		}else if(j == 0 && gameBoard[i][j] == gameBoard[i+1][j] && gameBoard[i][j] == gameBoard[i][j+1] && gameBoard[i][j] == gameBoard[i-1][j]){
			checkBoard[i][j] = 2;
		}else if(j == countOfCells-1 && gameBoard[i][j] == gameBoard[i+1][j] && gameBoard[i][j] == gameBoard[i][j-1] && gameBoard[i][j] == gameBoard[i-1][j]){
			checkBoard[i][j] = 2;
		}else if(gameBoard[i][j] == gameBoard[i+1][j] && gameBoard[i][j] == gameBoard[i][j-1] && gameBoard[i][j] == gameBoard[i-1][j]&& gameBoard[i][j] == gameBoard[i][j+1]){
			checkBoard[i][j] = 2;
		}
		
		
			
		
	}

	private void fillZero(int[][] array) {
		

		for(int i = 0 ; i < countOfCells;i++){
			for(int j = 0;j < countOfCells; j ++){
				array[i][j] = 0;
			}
		}
		
	}


	public void start() {
		
		int selectColor;
		
		while(true){
			selectColor = scan.nextInt();
			if(currentSelectColor != selectColor){
				checkSpread(0, 0, selectColor);
				currentSelectColor = selectColor;
				printCountClicks();
				printCurrent();
				//checkSurface(0, 0);
				if(checkEnd() == true){System.out.println("End Game"); break;}
			}
		}
			
		

		
		
		
		
		
	}

	private boolean checkEnd() {

		for(int i = 0 ; i < countOfCells;i++){
			for(int j = 0;j < countOfCells; j ++){
				if(gameBoard[i][j] != currentSelectColor){
					return false;
					
				}
			}
		}
			
		return true;
		
	}

	private void printCountClicks() {

		System.out.println("Total Click : " + (++countOfClicks));
		
	}

}
