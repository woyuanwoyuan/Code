package whut.inis.show.test;
import IDCT.*;

import com.mathworks.toolbox.javabuilder.*;
public class IdctTest {

	public static void main(String[] args) {
		Object [] result=null;
	/*
	 * 	result=IDCT(videoname,firstbbox,firstimgname,resultpath,framenum);
	 *  videoname����Ƶ���ƣ��������ͣ�String
	 *  firstbbox��Ŀ�괬���ĳ�ʼ���꣬һά���飬��������double[]
		firstimgname����һ֡ͼ�������(��·�����������ͣ�String
		resultpath������Ĵ��λ��(����\��)�������ͣ�String
		framenum��ͼ��֡��,�������ͣ�double
		result: ���ٽ��
	 * 
	 * 
	 */
		String videoname="11111";
		double[] firstbbox= {391.0,677.0,488.0,164.0};
		String firstimgname="E:/inis_videolib/tracking_lib/0005_01000001000/0005_01000001000/000001.jpg";
		String	resultpath="E:/�½��ļ���/";
		int framenum=101;
		try {
			IDCT info=new IDCT();
			result=info.IDCT(0,videoname,firstbbox,firstimgname,resultpath,framenum);
			
			
		} catch (MWException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
