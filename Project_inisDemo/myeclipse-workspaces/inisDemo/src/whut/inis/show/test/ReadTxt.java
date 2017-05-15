package whut.inis.show.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class ReadTxt {
	/**
	 * 功能：Java读取txt文件的内容
	 * 步骤：1：先获得文件句柄
	 * 2：获得文件句柄当做是输入一个字节码流，需要对这个输入流进行读取
	 * 3：读取到输入流后，需要读取生成字节流
	 * 4：一行一行的输出。readline()。
	 * 备注：需要考虑的是异常情况
	 * @param filePath
	 */
	public  String readTxtFile(String filePath){
		String firstlinestr = null;
		try {
				String encoding="GBK";
				
		        File file=new File(filePath);
		        if(file.isFile() && file.exists()){ //判断文件是否存在
		        	InputStreamReader read = new InputStreamReader(
					new FileInputStream(file),encoding);//考虑到编码格式
		        	BufferedReader bufferedReader = new BufferedReader(read);
		        	String lineTxt = null;
		        	
		        	while((lineTxt = bufferedReader.readLine()) != null){
		        		
		        		//System.out.println(lineTxt);
		        		firstlinestr = lineTxt;
		        		//读取到第一行之后添加break，跳出循环，此时只获取到txt文本的第一行数据，如果要获取所有行信息，删除break即可
		        		break;
		        	}
		        	
		        	read.close();
		        	
		}else{
			System.out.println("找不到指定的文件");
		}
		} catch (Exception e) {
			System.out.println("读取文件内容出错");
			e.printStackTrace();
		}
		return firstlinestr;
	}
	
	public static void main(String argv[]){
		String filePath = "D:/新建文件夹/groundtruth.txt";
//		"res/";
		ReadTxt test = new ReadTxt();
		String firstlinestr = test.readTxtFile(filePath);

		String[] arStr = firstlinestr.trim().split("  ");
		Double[] arr = new Double[4]; 
		/*
		 *  BigDecimal 由任意精度的整数非标度值 和32 位的整数标度 (scale) 组成。
		 *  如果为零或正数，则标度是小数点后的位数。如果为负数，则将该数的非标度值乘以 10 的负scale 次幂。
		 *  因此，BigDecimal表示的数值是(unscaledValue × 10^-scale)。 
		 *  
		 *  此处是将科学计数法转换成double类型
		 */
		for(int i=0; i<4; i++){
			 BigDecimal bd = new BigDecimal(arStr[i]); 
			 String str = bd.toPlainString();
			 arr[i] = Double.parseDouble(str);
			 System.out.print(arr[i]+"  ");
		}
		
		
         
	}
}
