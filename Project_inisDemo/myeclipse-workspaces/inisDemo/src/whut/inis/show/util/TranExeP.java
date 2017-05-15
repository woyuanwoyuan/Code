package whut.inis.show.util;

public class TranExeP{

	


	public static  void openExe(String s1,String s2,String s3) 
{
		//s1是exe文件所在路径+文件名+.exe
		//s2是实验图片的路径+文件名+%06d.jpg
		//s3是输出图片的路径+文件名+%06d.jpg
		// TODO Auto-generated method stub
Runtime rn = Runtime.getRuntime();
Process p = null;

String []cmdstr={s1, s2,s3};
try
{

p = rn.exec(cmdstr);
}
catch (Exception e)
{
System.out.print("Error exec!");
 	
}
}
}


