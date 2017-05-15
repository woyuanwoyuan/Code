package whut.inis.show.test;

import java.io.File;

public class deleteJpg {
	public static void main(String[] args) {
		File dir = new File("E:/new跟踪数字编码 - 副本/");//文件目录
		File [] files = dir.listFiles();
		String fileName = "";
		for(File f: files){
			fileName = f.getName();
			if(fileName.endsWith(".jpg")){
				if(f.delete()){
					System.out.println("已删除文件："+fileName);
				}
			}
		}
		
		
	     }
	 
	    
}
