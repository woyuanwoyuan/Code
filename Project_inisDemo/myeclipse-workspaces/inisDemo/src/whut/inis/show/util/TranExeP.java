package whut.inis.show.util;

public class TranExeP{

	


	public static  void openExe(String s1,String s2,String s3) 
{
		//s1��exe�ļ�����·��+�ļ���+.exe
		//s2��ʵ��ͼƬ��·��+�ļ���+%06d.jpg
		//s3�����ͼƬ��·��+�ļ���+%06d.jpg
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


