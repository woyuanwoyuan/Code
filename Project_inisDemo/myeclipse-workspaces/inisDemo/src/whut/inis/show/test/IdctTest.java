package whut.inis.show.test;
import IDCT.*;

import com.mathworks.toolbox.javabuilder.*;
public class IdctTest {

	public static void main(String[] args) {
		Object [] result=null;
	/*
	 * 	result=IDCT(videoname,firstbbox,firstimgname,resultpath,framenum);
	 *  videoname：视频名称，数据类型：String
	 *  firstbbox：目标船舶的初始坐标，一维数组，数据类型double[]
		firstimgname：第一帧图像的名称(含路径）数据类型：String
		resultpath：结果的存放位置(带“\”)数据类型：String
		framenum：图像帧数,数据类型：double
		result: 跟踪结果
	 * 
	 * 
	 */
		String videoname="11111";
		double[] firstbbox= {391.0,677.0,488.0,164.0};
		String firstimgname="E:/inis_videolib/tracking_lib/0005_01000001000/0005_01000001000/000001.jpg";
		String	resultpath="E:/新建文件夹/";
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
