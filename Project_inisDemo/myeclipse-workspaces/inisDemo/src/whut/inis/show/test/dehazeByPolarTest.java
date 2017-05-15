package whut.inis.show.test;
import com.mathworks.toolbox.javabuilder.*;
import dehazeByPolar.*;
/*����java����matlab�����Ĺ��̣������������ͼ����
 * 1�����ȵ�������jar��com.mathworks.toolbox.javabuilder���˰�����matlab�İ�װ�ļ�����ģ���dehazeByPolar���˰�����matlab����ͨ��deploytool���ߴ�����ɣ�
 * 			dehazeByPolar.jar���������º�����dehazeByPolar.m��img_read.m��img_show.m��img_write.m��aircom.m��bilateralFilter.m��hjy_darkcom.m��Polar_Jones.m��transcom.m
 * 			����dehazeByPolar.m���������������������������������������eg��[colorimg, freeImg, c] = dehazeByPolar(colorimg,johns,filter,maxAirLight,winSize)
 * 			���������freeImg������ͼ����������������ù�
 * 			���������colorimg�������ͼ�����johns����˹���������filter���˲���ʽ��maxAirLight�������������ֵ��winSize��ͨ���뾶
 * 			img_read.m��img_show.m��img_write.m�ֱ��Ƕ�ͼ��Ķ�ȡ����ʾ�ͱ��溯����
 * 			���������������������ǣ���������Ϊ������������������ڵģ�
 * 2��Ȼ���д������dehazeByPolarTest.java
 * 			��Ҫע����ǣ�img_write()�����е�ͼ�񱣴�·��Ϊ"D:\MatLabWorkSpace\matlabgui\imgclear\"
 * JAVA��intתString���������ַ���
 * 		1��String.valueOf(i)
 * 		2�� Integer.toString(i) 
 * 		3�� i+""      ��������ֱ�Ӽ�˫���ţ��Ϳ��԰���������������ת��ΪString���ͣ�  
 * 		�����ڵ���img_write()ʱ��Ҫ�õ�����ת����ѡ����ǵ����ַ�����
 */
public class dehazeByPolarTest {
	public static void main(String[] args) {
		Object[] img_read = null;
		Object[] hazeFree = null;
		Object[] dehazeByPolar_result = null;
		String input_img_path ;
		double johns ;
		int maxAirLight;
		int winSize ;
		String filter;
		try {
			long starTime=System.currentTimeMillis();// ����������������ĵ�ʱ�䣬��δ�����ڳ���ִ��ǰ
			
			//����һ�����������info���ö������dehazeByPolar.jar��������к�������������������г�ʼ��
			dehazeByPolar info = new dehazeByPolar();
			
			//��JAVA�С�\����ת���ַ�������Ҫ��ʾһ���ַ�����\����Ҫ�á�\\�������ԣ����������ġ�\\������Ҫ�á�\\\\������ʾ
			//�����÷�б�ܡ�/������ʾ
			input_img_path = "F:/MatLabWorkSpace/matlabgui/PastWork/IMG_2795.bmp" ;
			johns = 0.04;
			maxAirLight = 200;
			winSize = 14;
			filter = "�����˲�";
			
			//�ú�����ͼ��ת��Ϊ����1����ֻ��һ�����������input_img_path���������ͼ��·����ַ
			img_read = info.img_read(1, input_img_path);
			
			//������dehazeByPolar(),����3�������������������colorimg�������ͼ�����johns����˹���������filter���˲���ʽ��maxAirLight�������������ֵ��winSize��ͨ���뾶
			dehazeByPolar_result =  info.dehazeByPolar(3,img_read[0],johns,filter,maxAirLight,winSize);
			
			//img_show()Ϊ��ʾͼ���������в���dehazeByPolar_result[1]Ϊ������ͼ�����dehazeByPolar_result[0]��dehazeByPolar_result[2]�ο�˵���ĵ�
			hazeFree = info.img_show(1,dehazeByPolar_result[1] );
			
			/*
			 * img_write()����Ϊͼ�񱣴溯�������洦�����ͼ�����
			 * �м��������������String���ͣ�����Ҫת��ΪString���ͣ�����ѡ�ÿ�ͷ˵���ĵ�����ĵ����ַ�����������ֱ�Ӽ�˫����""��
			 * ͼ�񱣴�·��Ϊ"D:\MatLabWorkSpace\matlabgui\imgclear\"
			 */
//			info.img_write(dehazeByPolar_result[1],maxAirLight+"",winSize+"",johns+"",filter);
			
			long endTime=System.currentTimeMillis();
			long Time=endTime-starTime;     // ��δ�����ڳ���ִ�к�
			System.out.println("���иó����ʱ"+Time+"����"); 

		} catch (MWException e) {

			e.printStackTrace();
		}
		
	}
}
