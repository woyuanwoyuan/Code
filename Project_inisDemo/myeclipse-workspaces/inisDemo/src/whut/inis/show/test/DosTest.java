package whut.inis.show.test;

import java.io.*;
/**
 *  Java����windows��DOS����
 *  ʵ�ֵ���Windows��ipconfig���Ȼ���������Ϣͨ��IO�����������̨��
 */
public class DosTest {
//	public static void main(String[] args) throws InterruptedException{
//		String dosString = "cmd /k ipconfig";
//		Runtime rt = Runtime.getRuntime();
//		Process ps;
//		try {
//			ps = rt.exec(dosString);
//			int exitVal = ps.waitFor();
//	        System.out.println("Exited with error code " + exitVal);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
	
	 public static void main(String[] args) throws IOException {
//	        InputStream ins = null;
//	        String[] cmd = new String[] { "cmd.exe", "/C", "winmsd" };  // ����
//	        try {
//	            Process process = Runtime.getRuntime().exec(cmd);
//	            ins = process.getInputStream();  // ��ȡִ��cmd��������Ϣ
//	            BufferedReader reader = new BufferedReader(new InputStreamReader(ins));   
//	            String line = null;   
//	            while ((line = reader.readLine()) != null) {   
//	                System.out.println(line);  // ��� 
//	            } 
//	            int exitValue = process.waitFor();   
//	            System.out.println("����ֵ��" + exitValue);  
//	            process.getOutputStream().close();  // ��Ҫ������һ��Ҫ��
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	        } 
		 String command = "ipconfig";
	        Runtime r = Runtime.getRuntime();
	        Process p = r.exec(command);
	    //    System.out.println(p.getClass().getName());
	        BufferedReader br = new BufferedReader(new InputStreamReader(
	                p.getInputStream()));
	        StringBuffer sb = new StringBuffer();
	        String inline;
	        while (null != (inline = br.readLine())) {
	            sb.append(inline).append("\n");
	        }
	        System.out.println(sb.toString());
	    }
		 
}

