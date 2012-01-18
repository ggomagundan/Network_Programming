/*
 * OOP2(Java) Programming-B (0903)
 * Student Number : 60072402
 * Name : �ں���
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
			System.out.print("��� �Է� : ");
			path = input.next();
			
			fileList = indexer.getFilesList(path);
			
			if(fileList.isEmpty()) {
				System.out.println("��ΰ� �߸� �Ǿ����ϴ�. �ٽ� �Է��� �ּ���.");
				continue;
			} else {
				break;
			}
		}
		
		while(true) {
			System.out.print("ã���� �ϴ� ���� �̸�(exit�Է� �� ����) : ");
			String info = input.next();
				
			if (command.equals(info)) {   
				System.out.println("���α׷� ����");
				break;
			}
			
			
			findList = indexer.fileFind(fileList, info);
			
			System.out.println(indexer.MAX_FILE_COUNT + "���� ���Ͽ��� �˻� ��.....");
			for(int i=0;i<findList.size();i++){
				System.out.println(findList.get(i).toString());
			}

			findList.clear();
		}
	}
}