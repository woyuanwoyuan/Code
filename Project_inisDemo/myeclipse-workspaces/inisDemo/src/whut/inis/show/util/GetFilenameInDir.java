package whut.inis.show.util;

import java.io.File;

//获取文件下所有文件的名称
public class GetFilenameInDir {
	final static void showAllFiles(File dir) throws Exception{
		  File[] file = dir.listFiles();
			 
		  for(int i=0; i<file.length; i++){
			  System.out.println("path=" + file[i].getPath());
	          System.out.println("absolutepath=" + file[i].getAbsolutePath());
	          System.out.println("name=" + file[i].getName());
		   if(file[i].isDirectory()){
		    try{
		     showAllFiles(file[i]);
		    }catch(Exception e){}
		   }
		  }
		 }
}
