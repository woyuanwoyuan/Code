package whut.inis.show.test;

import java.io.File;

public class deleteJpg {
	public static void main(String[] args) {
		File dir = new File("E:/new�������ֱ��� - ����/");//�ļ�Ŀ¼
		File [] files = dir.listFiles();
		String fileName = "";
		for(File f: files){
			fileName = f.getName();
			if(fileName.endsWith(".jpg")){
				if(f.delete()){
					System.out.println("��ɾ���ļ���"+fileName);
				}
			}
		}
		
		
	     }
	 
	    
}
