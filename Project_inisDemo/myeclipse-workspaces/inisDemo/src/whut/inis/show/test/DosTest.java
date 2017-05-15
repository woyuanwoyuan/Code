package whut.inis.show.test;

import java.io.*;
/**
 *  Java调用windows的DOS命令
 *  实现调用Windows的ipconfig命令，然后将输出的信息通过IO流输出到控制台。
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
//	        String[] cmd = new String[] { "cmd.exe", "/C", "winmsd" };  // 命令
//	        try {
//	            Process process = Runtime.getRuntime().exec(cmd);
//	            ins = process.getInputStream();  // 获取执行cmd命令后的信息
//	            BufferedReader reader = new BufferedReader(new InputStreamReader(ins));   
//	            String line = null;   
//	            while ((line = reader.readLine()) != null) {   
//	                System.out.println(line);  // 输出 
//	            } 
//	            int exitValue = process.waitFor();   
//	            System.out.println("返回值：" + exitValue);  
//	            process.getOutputStream().close();  // 不要忘记了一定要关
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

