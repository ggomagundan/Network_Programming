/*
 * OOP2(Java) Programming-B (0903)
 * Student Number : 60072402
 * Name : 박병상
 * 
 */

import java.io.File;
import java.util.ArrayList;

public class FileIndexer {
	
	private ArrayList<String> result = new ArrayList<String>(); 
	public final int MAX_FILE_COUNT = 1000;
	
	public ArrayList<String> fileFind(ArrayList<String> list, String name) {
	
		String reg = "";
	
		if(name.length() >= 3 && (name.substring(0, 2).equals("*."))){
			reg = name.replace("*", "");			
			for(int i=0;i<list.size();i++){
				if(list.get(i).endsWith(reg)){
					
					result.add(list.get(i));
					
				}
			}			
		} else {
	
			reg = ".*";
			reg += name;
			reg += ".*";
			for(int i=0;i<list.size();i++){
				
				if(list.get(i).matches(reg)){
				
					result.add(list.get(i));
				}
			}
		}		
		return result;
	}
	
	
	public ArrayList<String> getFilesList(String path) {

		ArrayList<String> fileList = new ArrayList<String>();
		
		String dirName = path;
		
		File dir = new File(dirName);
		String directories[] = null;
		if(dir.isDirectory()){
			directories = dir.list();
			for(int i=0;i<directories.length;i++){
				File f = new File(dirName + "/" + directories[i]);
				if(f.isDirectory()){
					
					findFile(fileList, f.getAbsolutePath() + File.separator);
					
				} else {
					if(!fileEqualsCheck(fileList, f.getName())){
						
						fileList.add(f.getAbsolutePath());		
						
					}
				}
			}
		}
		return fileList;
	}
	
	
	public void findFile(ArrayList<String> fileList, String dirName){
		
		if(fileList.size() >= MAX_FILE_COUNT){
			return;
		}
		File dir = new File(dirName);
		String directories[] = null;
		if(dir.isDirectory()){
			
			directories = dir.list();
			
			if(directories != null){
				for(int i=0;i<directories.length;i++){
					File f = new File(dirName + "/" + directories[i]);
					if(f.isDirectory()){
						
						findFile(fileList, f.getAbsolutePath() + File.separator);
						
					} else {
						
						if(!fileEqualsCheck(fileList, f.getName())){
							
							fileList.add(f.getAbsolutePath());	
							
						}
					}
				}
			}
		}
	}
	
	//	중복파일 체크 메서드(검색을 통해 중복된 파일이 있을 경우 이를 제거하기 위한 메서드)
	public boolean fileEqualsCheck(ArrayList<String> fileList, String fileName){
		for(int i=0;i<fileList.size();i++){
			if(fileList.get(i).toString().equals(fileName.toString())){
				
				return true;
				
			}
		}
		
		return false;
	}
}
