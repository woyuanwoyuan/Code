package whut.inis.show.test;

import whut.inis.show.util.ZipCompressorByAnt;

public class TestZip {
	public static void main(String[] args) {  
        
          
        ZipCompressorByAnt zca = new ZipCompressorByAnt("C:/Users/Asus/Desktop/3/1.zip");//目录+名字.zip  
        zca.compressExe("C:/Users/Asus/Desktop/1"); //被压缩文件
    }  
}
