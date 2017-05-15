package whut.inis.show.test;
import java.io.*;
public class TransferExe {

	


	public static  void openExe(String s1,String s2,String s3) 
{
		//s1是exe文件所在路径+文件名+.exe
		//s2是实验视频的路径+文件名+.exe
		//s3是结果保存路径
		// TODO Auto-generated method stub
Runtime rn = Runtime.getRuntime();
Process p = null;
//int returnValue;
String []cmdstr={s1, s2,s3};
try
{

p = rn.exec(cmdstr);
int returnValue=p.waitFor();
}
catch (Exception e)
{
System.out.print("Error exec!");
 	
}
//returnValue=p.exitValue();



}
	
}


