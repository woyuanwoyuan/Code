package whut.inis.show.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import whut.inis.show.util.CommonsUtil;
import STC.*;

import com.mathworks.toolbox.javabuilder.*;

public class TestTrackServlet extends HttpServlet {

	
	public TestTrackServlet() {
		super();
	}



	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);

	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");	//设置编码
		String inputVideo = request.getParameter("fileName");
		double imgFrameNum = Double.parseDouble(request.getParameter("imgFrameNum"));
		System.out.println("inputVideo = "+inputVideo+",imgFrameNum = " +imgFrameNum);
		double paddingval = Double.parseDouble(request.getParameter("paddingval"));
		double rhoval = Double.parseDouble(request.getParameter("rhoval"));
		double scaleval = Double.parseDouble(request.getParameter("scaleval"));
		double lambdaval = Double.parseDouble(request.getParameter("lambdaval"));
		double numval = Double.parseDouble(request.getParameter("numval"));
		double alaphaval = Double.parseDouble(request.getParameter("alaphaval"));
		
		double x = Double.parseDouble(request.getParameter("x_num"));
		double y = Double.parseDouble(request.getParameter("y_num"));
		double w = Double.parseDouble(request.getParameter("w_num"));
		double h = Double.parseDouble(request.getParameter("h_num"));
		
		double[] init = {x,y,w,h};
		System.out.println("init = " + init[0]+","+init[1]+","+init[2]+","+init[3]);
		Object[] result = null;
				
		/*
		 * 跟踪演示函数runSTC（）
		 * 
		 * 视频存放地址inputSorce，
		 * 图像序列的帧数imgFrameNum，
		 * 图像序列的保存位置video2sequenceSavePath
		 * init:目标初始位置
		 *	% paddingval ：几倍上下文区域，默认是1.0，数据类型：double
		 *	% rhoval ：学习参数，默认是0.075，数据类型：double
		 *  scaleval ：初始尺度，默认是1，数据类型：double
		 *	% lambdaval ：形状参数0.25，数据类型：double
		 *	% numval ：平均求尺度帧数，默认为5，数据类型：double
		 *	% alaphaval ：形状参数2.25，数据类型：double
		 *	% result: 跟踪结果
		 * 	本算法有两个输出结果result[0]是一个txt的文件，保存了算法运行的效果（跟踪目标的坐标）；result[1]是一个视频文件，可以让用户直观得看到跟踪效果
		 */
		
		//String img_path = "D:\\MatLabWorkSpace\\matlabgui\\FeiTeng_code\\imgs\\";
		try {
			long starTime=System.currentTimeMillis();// 计算程序运行所消耗的时间，这段代码放在程序执行前
			
			STC test = new STC();
			
			String inputSorce = request.getRealPath("/upload")+"/"+inputVideo;
			String video2sequenceSavePath = inputSorce.substring(0, inputSorce.length()-4)+"/";
			
			result=test.STC(2,inputSorce,imgFrameNum,video2sequenceSavePath,init,paddingval,rhoval,scaleval,lambdaval,numval,alaphaval);
			
			long endTime=System.currentTimeMillis();
			long Time=endTime-starTime;     // 这段代码放在程序执行后
			System.out.println("运行该程序耗时"+Time+"毫秒"); 
			
			//
			String txtName = inputVideo.substring(0,inputVideo.length()-4)+"_STC.txt";
			request.setAttribute("txtName", txtName);
			CommonsUtil.forward("downloadResult.jsp", request, response);
		} catch (MWException e) {
		
			e.printStackTrace();
			
		}
			}


	public void init() throws ServletException {
		// Put your code here
	}

}
