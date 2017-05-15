package whut.inis.show.test;
import com.mathworks.toolbox.javabuilder.*;
import dehazeByPolar.*;
/*这是java调用matlab函数的过程，本函数是针对图像处理
 * 1：首先导入两个jar包com.mathworks.toolbox.javabuilder（此包是在matlab的安装文件里面的）和dehazeByPolar（此包是在matlab里面通过deploytool工具打包而成）
 * 			dehazeByPolar.jar包含了以下函数：dehazeByPolar.m、img_read.m、img_show.m、img_write.m、aircom.m、bilateralFilter.m、hjy_darkcom.m、Polar_Jones.m、transcom.m
 * 			其中dehazeByPolar.m是主函数，包括三个输出参数和五个输入参数，eg：[colorimg, freeImg, c] = dehazeByPolar(colorimg,johns,filter,maxAirLight,winSize)
 * 			输出参数：freeImg处理后的图像矩阵，其他两个不用管
 * 			输入参数：colorimg是输入的图像矩阵，johns是琼斯矩阵参数，filter是滤波方式，maxAirLight大气光亮度最大值，winSize暗通道半径
 * 			img_read.m、img_show.m、img_write.m分别是对图像的读取，显示和保存函数；
 * 			其余五个函数不需多做考虑，他们是作为主函数的输入参数存在的；
 * 2：然后编写测试类dehazeByPolarTest.java
 * 			需要注意的是：img_write()函数中的图像保存路径为"D:\MatLabWorkSpace\matlabgui\imgclear\"
 * JAVA中int转String类型有三种方法
 * 		1：String.valueOf(i)
 * 		2： Integer.toString(i) 
 * 		3： i+""      （变量后直接加双引号，就可以把其他的数据类型转化为String类型）  
 * 		本人在调用img_write()时需要用到类型转换，选择的是第三种方法。
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
			long starTime=System.currentTimeMillis();// 计算程序运行所消耗的时间，这段代码放在程序执行前
			
			//创建一个测试类对象info，该对象包含dehazeByPolar.jar里面的所有函数，并对输入参数进行初始化
			dehazeByPolar info = new dehazeByPolar();
			
			//在JAVA中“\”是转义字符，所以要表示一个字符串“\”就要用“\\”，所以，两个连续的“\\”就需要用“\\\\”来表示
			//或者用反斜杠“/”来表示
			input_img_path = "F:/MatLabWorkSpace/matlabgui/PastWork/IMG_2795.bmp" ;
			johns = 0.04;
			maxAirLight = 200;
			winSize = 14;
			filter = "导向滤波";
			
			//该函数把图像转化为矩阵，1代表只有一个输出参数，input_img_path代表输入的图像路径地址
			img_read = info.img_read(1, input_img_path);
			
			//主函数dehazeByPolar(),其中3代表有三个输出参数，colorimg是输入的图像矩阵，johns是琼斯矩阵参数，filter是滤波方式，maxAirLight大气光亮度最大值，winSize暗通道半径
			dehazeByPolar_result =  info.dehazeByPolar(3,img_read[0],johns,filter,maxAirLight,winSize);
			
			//img_show()为显示图像函数，其中参数dehazeByPolar_result[1]为处理后的图像矩阵，dehazeByPolar_result[0]和dehazeByPolar_result[2]参考说明文档
			hazeFree = info.img_show(1,dehazeByPolar_result[1] );
			
			/*
			 * img_write()函数为图像保存函数，保存处理过的图像矩阵，
			 * 中间三个输入参数是String类型，所以要转化为String类型，本人选用开头说明文档里面的第三种方法，变量后直接加双引号""。
			 * 图像保存路径为"D:\MatLabWorkSpace\matlabgui\imgclear\"
			 */
//			info.img_write(dehazeByPolar_result[1],maxAirLight+"",winSize+"",johns+"",filter);
			
			long endTime=System.currentTimeMillis();
			long Time=endTime-starTime;     // 这段代码放在程序执行后
			System.out.println("运行该程序耗时"+Time+"毫秒"); 

		} catch (MWException e) {

			e.printStackTrace();
		}
		
	}
}
