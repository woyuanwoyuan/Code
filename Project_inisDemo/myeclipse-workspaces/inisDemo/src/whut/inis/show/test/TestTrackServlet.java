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
		request.setCharacterEncoding("utf-8");	//���ñ���
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
		 * ������ʾ����runSTC����
		 * 
		 * ��Ƶ��ŵ�ַinputSorce��
		 * ͼ�����е�֡��imgFrameNum��
		 * ͼ�����еı���λ��video2sequenceSavePath
		 * init:Ŀ���ʼλ��
		 *	% paddingval ����������������Ĭ����1.0���������ͣ�double
		 *	% rhoval ��ѧϰ������Ĭ����0.075���������ͣ�double
		 *  scaleval ����ʼ�߶ȣ�Ĭ����1���������ͣ�double
		 *	% lambdaval ����״����0.25���������ͣ�double
		 *	% numval ��ƽ����߶�֡����Ĭ��Ϊ5���������ͣ�double
		 *	% alaphaval ����״����2.25���������ͣ�double
		 *	% result: ���ٽ��
		 * 	���㷨������������result[0]��һ��txt���ļ����������㷨���е�Ч��������Ŀ������꣩��result[1]��һ����Ƶ�ļ����������û�ֱ�۵ÿ�������Ч��
		 */
		
		//String img_path = "D:\\MatLabWorkSpace\\matlabgui\\FeiTeng_code\\imgs\\";
		try {
			long starTime=System.currentTimeMillis();// ����������������ĵ�ʱ�䣬��δ�����ڳ���ִ��ǰ
			
			STC test = new STC();
			
			String inputSorce = request.getRealPath("/upload")+"/"+inputVideo;
			String video2sequenceSavePath = inputSorce.substring(0, inputSorce.length()-4)+"/";
			
			result=test.STC(2,inputSorce,imgFrameNum,video2sequenceSavePath,init,paddingval,rhoval,scaleval,lambdaval,numval,alaphaval);
			
			long endTime=System.currentTimeMillis();
			long Time=endTime-starTime;     // ��δ�����ڳ���ִ�к�
			System.out.println("���иó����ʱ"+Time+"����"); 
			
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
