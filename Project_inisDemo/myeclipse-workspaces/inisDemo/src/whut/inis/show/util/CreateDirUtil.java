package whut.inis.show.util;

import java.io.File;

public class CreateDirUtil {
	 public static boolean createDir(String destDirName) {  
	        File dir = new File(destDirName);  
	        if (dir.exists()) {  
	              
	            return false;  
	        }  
	        if (!destDirName.endsWith(File.separator)) {  
	            destDirName = destDirName + File.separator;  
	        }  
	        //´´½¨Ä¿Â¼  
	        if (dir.mkdirs()) {  
	              
	            return true;  
	        } else {  
	           
	            return false;  
	        }  
	    }  

}
