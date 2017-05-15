package whut.inis.show.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class ReadTxt {
	/**
	 * ���ܣ�Java��ȡtxt�ļ�������
	 * ���裺1���Ȼ���ļ����
	 * 2������ļ��������������һ���ֽ���������Ҫ��������������ж�ȡ
	 * 3����ȡ������������Ҫ��ȡ�����ֽ���
	 * 4��һ��һ�е������readline()��
	 * ��ע����Ҫ���ǵ����쳣���
	 * @param filePath
	 */
	public  String readTxtFile(String filePath){
		String firstlinestr = null;
		try {
				String encoding="GBK";
				
		        File file=new File(filePath);
		        if(file.isFile() && file.exists()){ //�ж��ļ��Ƿ����
		        	InputStreamReader read = new InputStreamReader(
					new FileInputStream(file),encoding);//���ǵ������ʽ
		        	BufferedReader bufferedReader = new BufferedReader(read);
		        	String lineTxt = null;
		        	
		        	while((lineTxt = bufferedReader.readLine()) != null){
		        		
		        		//System.out.println(lineTxt);
		        		firstlinestr = lineTxt;
		        		//��ȡ����һ��֮�����break������ѭ������ʱֻ��ȡ��txt�ı��ĵ�һ�����ݣ����Ҫ��ȡ��������Ϣ��ɾ��break����
		        		break;
		        	}
		        	
		        	read.close();
		        	
		}else{
			System.out.println("�Ҳ���ָ�����ļ�");
		}
		} catch (Exception e) {
			System.out.println("��ȡ�ļ����ݳ���");
			e.printStackTrace();
		}
		return firstlinestr;
	}
	
	public static void main(String argv[]){
		String filePath = "D:/�½��ļ���/groundtruth.txt";
//		"res/";
		ReadTxt test = new ReadTxt();
		String firstlinestr = test.readTxtFile(filePath);

		String[] arStr = firstlinestr.trim().split("  ");
		Double[] arr = new Double[4]; 
		/*
		 *  BigDecimal �����⾫�ȵ������Ǳ��ֵ ��32 λ��������� (scale) ��ɡ�
		 *  ���Ϊ���������������С������λ�������Ϊ�������򽫸����ķǱ��ֵ���� 10 �ĸ�scale ���ݡ�
		 *  ��ˣ�BigDecimal��ʾ����ֵ��(unscaledValue �� 10^-scale)�� 
		 *  
		 *  �˴��ǽ���ѧ������ת����double����
		 */
		for(int i=0; i<4; i++){
			 BigDecimal bd = new BigDecimal(arStr[i]); 
			 String str = bd.toPlainString();
			 arr[i] = Double.parseDouble(str);
			 System.out.print(arr[i]+"  ");
		}
		
		
         
	}
}
