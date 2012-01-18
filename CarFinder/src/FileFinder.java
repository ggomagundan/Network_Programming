/*
 * OOP2(Java) Programming-B (0903)
 * Student Number : 60072402
 * Name : 박병상
 * 
 */

import java.util.ArrayList;
import java.util.Scanner;

public class FileFinder {
	static ArrayList<String> result;
	
	public static void main(String[] args) {
		String command = "exit";                
		FileIndexer indexer = new FileIndexer();
		Scanner input = new Scanner(System.in);
		String path;
		
	
		ArrayList<String> fileList = new ArrayList<String>();
	
		ArrayList<String> findList = new ArrayList<String>();
		
		while(true) {
			System.out.print("경로 입력 : ");
			path = input.next();
			
			fileList = indexer.getFilesList(path);
			
			if(fileList.isEmpty()) {
				System.out.println("경로가 잘못 되었습니다. 다시 입력해 주세요.");
				continue;
			} else {
				break;
			}
		}
		
		while(true) {
			System.out.print("찾고자 하는 파일 이름(exit입력 시 종료) : ");
			String info = input.next();
				
			if (command.equals(info)) {   
				System.out.println("프로그램 종료");
				break;
			}
			
			
			findList = indexer.fileFind(fileList, info);
			
			System.out.println(indexer.MAX_FILE_COUNT + "개의 파일에서 검색 중.....");
			for(int i=0;i<findList.size();i++){
				System.out.println(findList.get(i).toString());
			}

			findList.clear();
		}
	}
}