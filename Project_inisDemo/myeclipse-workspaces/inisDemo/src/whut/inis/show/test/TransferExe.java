package whut.inis.show.test;
import java.io.*;
public class TransferExe {

	


	public static  void openExe(String s1,String s2,String s3) 
{
		//s1��exe�ļ�����·��+�ļ���+.exe
		//s2��ʵ����Ƶ��·��+�ļ���+.exe
		//s3�ǽ������·��
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


