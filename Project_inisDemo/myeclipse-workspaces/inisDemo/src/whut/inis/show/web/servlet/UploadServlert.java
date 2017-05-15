package whut.inis.show.web.servlet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sound.sampled.Port.Info;

import net.sf.json.JSONObject;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import whut.inis.show.dao.ShareSpaceDao;
import whut.inis.show.dao.ShareSpaceInfoDao;
import whut.inis.show.dao.UserInfoDao;
import whut.inis.show.po.AlertInfo;
import whut.inis.show.po.InisInfo;
import whut.inis.show.po.IntroductionInfo;
import whut.inis.show.po.LunWenInfo;
import whut.inis.show.po.ShareSpaceInfo;
import whut.inis.show.po.UserInfo;
import whut.inis.show.util.CommonsUtil;
import whut.inis.show.util.Constants;
import whut.inis.show.util.CreateDirUtil;


public class UploadServlert extends HttpServlet {
	int i=1;
	int picnum=0;
	
	/**
	 * Constructor of the object.
	 */
	public UploadServlert() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
		String flag = request.getParameter("flag");
		
	
		switch (Integer.parseInt(flag)) {
		case 1:
			/*
			 * �ϴ�˵˵
			 */
			upload(request,response);
			break;
		case 2:
			/*
			 * �ϴ�˵˵ͼƬ
			 */
			uploadFile(request,response);
			
			break;
		case 3:
			/*
			 * ����ͼƬ��Ŀ
			 */
			qingling(request,response); 
			
			break;
		case 4:
			/*
			 * �ϴ�����
			 */
			uploadFile3(request,response); 
			
			break;
		case 5:
			/*
			 * �༭������Ϣ
			 */
			bianjiGeRen(request,response); 
			
			break;
		case 6:
			/*
			 * �༭ʵ������Ϣ
			 */
			bianjiINIS(request,response); 
			
			break;
		case 7:
			/*
			 * �ϴ���ҳͼƬ
			 */
			uploadZhuYePic(request,response);
			
			break;
		default:
			break;
		}
		
     
    }  

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void upload(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");	//���ñ���
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		UserInfo userinfo=(UserInfo) session.getAttribute(Constants.SESSION_USER_INFO);
		String username=userinfo.getUsername();
		String content= new String(request.getParameter("content").getBytes("ISO-8859-1"),"UTF-8");
		//SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
		
		//df.format(new Date());// new Date()Ϊ��ȡ��ǰϵͳʱ��
		
		String path = request.getRealPath("/users");
	
      //  String dirName2 = path + "/"+ username + "/pic";  
       
      //  String dirName4 = path + "/"+ username + "/vid";  

      //��ȡ��ǰ����
		Date day=new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String date= df.format(day);
		SimpleDateFormat df1 = new SimpleDateFormat("HH-mm-ss");
		String time=df1.format(day);
		System.out.println(time);

		
		//�Ե�ǰ����Ϊ�ļ������ƣ�������Ŀ¼
		String dirName3 = path + "/"+ username + "/pic/"+date+"/"+time;  
		String purl="users/"+ username + "/pic/"+date+"/"+time;  
		System.out.println(dirName3);
	    CreateDirUtil.createDir(dirName3); 
	    
	  //  String dirName5 = path + "/"+ username + "/vid/"+date+"/"+time;  
   //    CreateDirUtil.createDir(dirName5); 
		copy(getServletContext().getRealPath("picCache"), dirName3);
		
		
		System.out.println(username);
		System.out.println(content);

		System.out.println(dirName3);
		
		// ʵ����UserInfoDao����
		ShareSpaceInfoDao shareDao = new ShareSpaceInfoDao();
		if(username != null && !username.isEmpty()){
			
				// ʵ����һ��User����
			ShareSpaceInfo share = new ShareSpaceInfo();		
				// ���û������е����Ը�ֵ
				share.setUsername(username);
				share.setContent(content);

				share.setPicnum(picnum);
				share.setPurl(purl);
				shareDao.pubShare(share);
				request.setAttribute("info", "��ϲ������ɹ���<br>");
		}else{
			request.setAttribute("info", "���󣺷���ʧ�ܣ�");
		}
		response.sendRedirect("ShowServlet?flag=4");
	//	request.getRequestDispatcher("ShowServlet?flag=1&num=1").forward(request, response);
		
	//	 String username1= new String(request.getParameter("xixi").getBytes("ISO-8859-1"),"UTF-8");;
		 
		// System.out.println(username1);
		 
//		
//				JSONObject jsonObject = new JSONObject();
//
//					jsonObject.put("Rows1",username);
//					
//					response.setCharacterEncoding("utf-8");
//					response.getWriter().write(jsonObject.toString());
			
	
	}
	
	public void uploadFile(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		   File file1 = null;  
	        response.setCharacterEncoding("UTF-8");  
	        request.setCharacterEncoding("UTF-8");  
	        response.setContentType("text/html");  
	    	
	    	int  number=Integer.parseInt(request.getParameter("number")) ;
	    	
	         DiskFileItemFactory factory = new DiskFileItemFactory();  
	               ServletFileUpload upload = new ServletFileUpload(factory);  
	                 
	        try {  
	            List<FileItem> list = upload.parseRequest(request); //����request����  
	           System.out.println(list.size());
	            for (FileItem fileItem : list) {  
	                System.out.println(fileItem.getFieldName());  
	            	if(fileItem.isFormField())
					{	if("content".equals(fileItem.getFieldName())){
						String content=null;
						content=fileItem.getString("UTF-8");
						System.out.println(content);
					}
					}
	                if (fileItem.getFieldName().equals("file_data")) {  
	                	
	                    file1 = new File(getServletContext().getRealPath("picCache"),i+".jpg");  
	                    i++;
	                  if(i>number){
	                	  i=1;
	                  }
	                    file1.getParentFile().mkdirs();  
	                    file1.createNewFile();  
	                                        System.out.println(fileItem.getName()+" psd");  
	                    InputStream ins = fileItem.getInputStream();  
	                    OutputStream ous = new FileOutputStream(file1);  
	                    try {  
	                        byte[] buffer = new byte[1024];  
	                        int len = 0;  
	                        while ((len = ins.read(buffer)) > -1)  
	                            ous.write(buffer, 0, len);  
	                    } finally {  
	                        ous.close();  
	                        ins.close();  
	                    }  
	                }  
	  
	  
	            }  
	        
	        } catch (FileUploadException e) {  
	            e.printStackTrace();  
	        }  
	          
	  
	  
	         JSONObject jsonObject = new JSONObject();    
	         jsonObject.put("result", "ok");  
	       
	         response.getWriter().write(jsonObject.toString());  
	}
	public void uploadZhuYePic(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		   File file1 = null;  
	        response.setCharacterEncoding("UTF-8");  
	        request.setCharacterEncoding("UTF-8");  
	        response.setContentType("text/html");  
	    	
	    	int  number=Integer.parseInt(request.getParameter("number")) ;
	    	
	         DiskFileItemFactory factory = new DiskFileItemFactory();  
	               ServletFileUpload upload = new ServletFileUpload(factory);  
	                 
	        try {  
	            List<FileItem> list = upload.parseRequest(request); //����request����  
	           System.out.println(list.size());
	            for (FileItem fileItem : list) {  
	                System.out.println(fileItem.getFieldName());  
	            	if(fileItem.isFormField())
					{	if("content".equals(fileItem.getFieldName())){
						String content=null;
						content=fileItem.getString("UTF-8");
						System.out.println(content);
					}
					}
	                if (fileItem.getFieldName().equals("file_data")) {  
	                	
	                    file1 = new File(getServletContext().getRealPath("image"),"slide_"+i+".jpg");  
	                    i++;
	                  if(i>number){
	                	  i=1;
	                  }
	              //  file1.getParentFile().mkdirs();  
	                    file1.createNewFile();  
	                                        System.out.println(fileItem.getName()+" psd");  
	                    InputStream ins = fileItem.getInputStream();  
	                    OutputStream ous = new FileOutputStream(file1);  
	                    try {  
	                        byte[] buffer = new byte[1024];  
	                        int len = 0;  
	                        while ((len = ins.read(buffer)) > -1)  
	                            ous.write(buffer, 0, len);  
	                    } finally {  
	                        ous.close();  
	                        ins.close();  
	                    }  
	                }  
	  
	  
	            }  
	        
	        } catch (FileUploadException e) {  
	            e.printStackTrace();  
	        }  
	          
	  
	  
	         JSONObject jsonObject = new JSONObject();    
	         jsonObject.put("result", "ok");  
	       
	         response.getWriter().write(jsonObject.toString());  
	}
	
	public void qingling(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int  number=Integer.parseInt(request.getParameter("number")) ;
		 i=1;
	         JSONObject jsonObject = new JSONObject();    
	         jsonObject.put("result", "ok");  
	       picnum=number;
	         response.getWriter().write(jsonObject.toString());  
	}

	
//�����ļ���
	   private static void copy(String src, String des) {  
	        File file1=new File(src);  
	        File[] fs=file1.listFiles();  
	        File file2=new File(des);  
	        if(!file2.exists()){  
	            file2.mkdirs();  
	        }  
	        for (File f : fs) {  
	            if(f.isFile()){  
	                try {
						fileCopy1(f.getPath(),des+"\\"+f.getName());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} //�����ļ������ķ���  
	            }else if(f.isDirectory()){  
	                copy(f.getPath(),des+"\\"+f.getName());  
	            }  
	        }  
	          
	    }  
	   /** 
	     * �ַ����ļ������ķ��� 
	     */  
	    private static void fileCopy(String src, String des) {  
	      
	        BufferedReader br=null;  
	        PrintStream ps=null;  
	          
	        try {  
	            br=new BufferedReader(new InputStreamReader(new FileInputStream(src)));  
	            ps=new PrintStream(new FileOutputStream(des));  
	            String s=null;  
	            while((s=br.readLine())!=null){  
	                ps.println(s);  
	                ps.flush();  
	            }  
	              
	        } catch (FileNotFoundException e) {  
	            // TODO Auto-generated catch block  
	            e.printStackTrace();  
	        } catch (IOException e) {  
	            // TODO Auto-generated catch block  
	            e.printStackTrace();  
	        }finally{  
	              
	                try {  
	                    if(br!=null)  br.close();  
	                    if(ps!=null)  ps.close();  
	                } catch (IOException e) {  
	                    // TODO Auto-generated catch block  
	                    e.printStackTrace();  
	                }  
	                  
	        }  
	          
	          
	    }  
	
	
	    /**
	     *ʹ�û����ֽ��������ļ��ĸ���
	     */
	     public static void fileCopy1(String src, String des) throws IOException {
	         FileOutputStream writer = null;
	         FileInputStream reader = null;
	         BufferedInputStream bufR = null;
	         BufferedOutputStream bufW = null;
	         try {
	             reader = new FileInputStream(src);
	             writer = new FileOutputStream(des);
	             bufR = new BufferedInputStream(reader);
	             bufW = new BufferedOutputStream(writer);
	             
	      
	             
	             int temp = 0;
	             while ((temp = bufR.read()) != -1) {
	                 bufW.write(temp);
	             }
	         } catch (FileNotFoundException e) {
	             e.printStackTrace();
	         } finally {
	             if (bufR != null) {
	                 reader.close();
	                 bufR.close();
	             }
	             if (bufW != null) {
	                 writer.close();
	                 bufW.close();
	             }
	         }

	     }
	     
	 	public void bianjiGeRen(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("utf-8");	//���ñ���
			File file=null;
			String uname=null;	
			String xingbie=null;
			String xuewei=null;
			String startyear=null;
			String birthday=null;
			String address=null;
			String email=null;
			String tel=null;
			String beizhu=null;
			String fileurl=null;
			//��ô����ļ���Ŀ����
			DiskFileItemFactory factory = new DiskFileItemFactory();
			//��ȡ�ļ���Ҫ�ϴ�����·��
			String uploadtime=null;
	      //  String username = ((UserInfo)request.getSession().getAttribute(Constants.SESSION_USER_INFO)).getUsername();
			String username=((UserInfo)request.getSession().getAttribute(Constants.SESSION_USER_INFO)).getUsername();
		//	String url=((UserInfo)request.getSession().getAttribute(Constants.SESSION_USER_INFO)).getUrl();
			String path1=request.getRealPath("/users");
			String path = path1 + "/"+ username+"/touxiang"; 
		 fileurl="users/"+ username +"/touxiang"; 
			//���û�����������õĻ����ϴ���� �ļ� ��ռ�� �ܶ��ڴ棬
			//������ʱ��ŵ� �洢�� , ����洢�ң����Ժ� ���մ洢�ļ� ��Ŀ¼��ͬ
			/**
			 * ԭ�� �����ȴ浽 ��ʱ�洢�ң�Ȼ��������д�� ��ӦĿ¼��Ӳ���ϣ� 
			 * ������˵ ���ϴ�һ���ļ�ʱ����ʵ���ϴ������ݣ���һ������ .tem ��ʽ�� 
			 * Ȼ���ٽ�������д�� ��ӦĿ¼��Ӳ����
			 */
			factory.setRepository(new File(path));
			//���� ����Ĵ�С�����ϴ��ļ������������û���ʱ��ֱ�ӷŵ� ��ʱ�洢��
			factory.setSizeThreshold(100*1024*1024) ;
			
			//��ˮƽ��API�ļ��ϴ�����
			ServletFileUpload upload = new ServletFileUpload(factory);
			
			String filename = "";
			try {
				//�����ϴ�����ļ�
				List<FileItem> list = (List<FileItem>)upload.parseRequest(request);
				
				for(FileItem item : list)
				{
					//��ȡ������������
					//String name = item.getFieldName();
					
					//�����ȡ�� ����Ϣ����ͨ�� �ı� ��Ϣ
					if(item.isFormField())
					{	if("name".equals(item.getFieldName())){
						
						uname=item.getString("UTF-8");
						System.out.println(uname);
						
					}		if("optionsRadios".equals(item.getFieldName())){
						xingbie=item.getString("UTF-8");
						System.out.println(xingbie);
					}	
					if("time2".equals(item.getFieldName())){
						startyear=item.getString("UTF-8");
						System.out.println(startyear);
					}	
					if("time".equals(item.getFieldName())){
						birthday=item.getString("UTF-8");
						System.out.println(birthday);
					}	
					if("xuewei".equals(item.getFieldName())){
						xuewei=item.getString("UTF-8");
						System.out.println(xuewei);
					}	
					if("address".equals(item.getFieldName())){
						address=item.getString("UTF-8");
						System.out.println(address);
					}	
					if("email".equals(item.getFieldName())){
						email=item.getString("UTF-8");
						System.out.println(email);
					}	
					if("tel".equals(item.getFieldName())){
						tel=item.getString("UTF-8");
						System.out.println(tel);
					}	
					if("beizhu".equals(item.getFieldName())){
						beizhu=item.getString("UTF-8");
						System.out.println(beizhu);
					}	
				
						//��ȡ�û�����������ַ��� ���������ͦ�ã���Ϊ���ύ�������� �ַ������͵�
						//String value = item.getString() ;
						
						//request.setAttribute(name, value);
					}
					//�Դ���ķ� �򵥵��ַ������д��� ������˵�����Ƶ� ͼƬ����Ӱ��Щ
					else
					{
						/**
						 * ������������Ҫ��ȡ �ϴ��ļ�������
						 */
						//��ȡ·����
						
					path1=request.getRealPath("/users");
						
					
						
						String name = item.getFieldName();
						String value = item.getName() ;
						//���������һ����б��
						int start = value.lastIndexOf("\\");
						//��ȡ �ϴ��ļ��� �ַ������֣���1�� ȥ����б�ܣ�
						filename= value.substring(start+1);
						System.out.println("�ļ��У�"+filename);
						request.setAttribute(name, filename);
						if(!filename.equals("")){//�������ͷ�񣬼����ϴ��µ�ͷ�񣬾��ϴ�ͷ�� ,�������޸�
							
						
						//����д��������
						//���׳����쳣 ��exception ��׽
						
						//item.write( new File(path,filename) );//�������ṩ��
						
						//�ֶ�д��
						OutputStream out = new FileOutputStream(new File(path,"touxiang.jpg"));
						
						InputStream in = item.getInputStream() ;
						
						int length = 0 ;
						byte [] buf = new byte[1024] ;
						
						System.out.println("��ȡ�ϴ��ļ����ܹ���������"+item.getSize()+" Byte");

						// in.read(buf) ÿ�ζ��������ݴ����   buf ������
						while( (length = in.read(buf) ) != -1)
						{
							//��   buf ������ ȡ������ д�� ���������������
							out.write(buf, 0, length);
						    
						}
						
						in.close();
						out.close();
						
						}
						
					}
				}
				
				
				
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				
				//e.printStackTrace();
			}
//			PrintWriter pw = response.getWriter();
//			pw.print("<script type='text/javascript'>");
//			pw.print("alert('�ϴ��ļ��ɹ�');");
//			pw.print("window.history.go(-1);");
//			pw.print("</script>");
//			pw.flush();
//			pw.close();
			
			// ʵ����UserInfoDao����
			ShareSpaceInfoDao shareDao = new ShareSpaceInfoDao();
			ShareSpaceDao dao = new ShareSpaceDao();
		//	if(username != null && !username.isEmpty()){
				
					// ʵ����һ��User����
				IntroductionInfo indroInfo = new IntroductionInfo();	
					// ���û������е����Ը�ֵ
				indroInfo.setUname(uname);
				indroInfo.setXingbie(xingbie);
				indroInfo.setXuewei(xuewei);
				indroInfo.setBirthday(birthday);
				indroInfo.setStartyear(startyear);
				indroInfo.setAddress(address);
				indroInfo.setEmail(email);
				indroInfo.setTel(tel);
				indroInfo.setBeizhu(beizhu);

				
			
				indroInfo.setFilename(filename);
				indroInfo.setFileurl(fileurl);
				indroInfo.setUsername(username);
			
				AlertInfo alertInfo=new AlertInfo();
				alertInfo.setInfoLei("success");
		
			
				
				
			if(	dao.IsexistIntroduction(indroInfo)){  //������introduction��������
				System.out.println("�Ѵ���introduction");
					if(filename.equals("")){//�����ļ��ϴ����򲻸���filename��fileurl
						System.out.println("�Ѵ���introduction����ͼƬ");
					 		shareDao.updateIntroductionWithoutPic(indroInfo);
					 		shareDao.updateUserInfo(uname,username);
							alertInfo.setInfoContent("�޸ĸ�����Ϣ(������ͷ��)�ɹ���");
					 }else{//�����ļ��ϴ��������filename��fileurl
							shareDao.updateIntroduction(indroInfo);
							shareDao.updateUserInfo(uname,username);
							alertInfo.setInfoContent("�޸ĸ�����Ϣ(����ͷ��)�ɹ���");
					 	}
			 	}else{//��������introduction�����༭�ϴ�
			 		System.out.println("������introduction");
						
							shareDao.bianjiIntroduction(indroInfo);
							shareDao.updateUserInfo(uname,username);
							alertInfo.setInfoContent("�༭������Ϣ�ɹ���");
			 	}
					//request.setAttribute("info", "��ϲ������ɹ���<br>");
		//	}else{
				//request.setAttribute("info", "���󣺷���ʧ�ܣ�");
			//}
			request.setAttribute("alertInfo", alertInfo);
	//	response.sendRedirect("ShowServlet?flag=4&uname="+username);
		CommonsUtil.forward("ShowServlet?flag=4&uname="+username, request, response);
			
		}
	     
	 	
	 	public void uploadFile3(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("utf-8");	//���ñ���
			File file=null;
			String leibie=null;
			String gongkai="off";
			String timu=null;	
			String author=null;
			String time=null;
			String beizhu=null;
			String fileurl=null;
			//��ô����ļ���Ŀ����
			DiskFileItemFactory factory = new DiskFileItemFactory();
			//��ȡ�ļ���Ҫ�ϴ�����·��
			String uploadtime=null;
	        String username = ((UserInfo)request.getSession().getAttribute(Constants.SESSION_USER_INFO)).getUsername();
			String url=((UserInfo)request.getSession().getAttribute(Constants.SESSION_USER_INFO)).getUrl();
			String path1=request.getRealPath("/users");
			String path = path1 + "/"+ username+"/lunwen"; 
		 fileurl="users/"+ username +"/lunwen"; 
			//���û�����������õĻ����ϴ���� �ļ� ��ռ�� �ܶ��ڴ棬
			//������ʱ��ŵ� �洢�� , ����洢�ң����Ժ� ���մ洢�ļ� ��Ŀ¼��ͬ
			/**
			 * ԭ�� �����ȴ浽 ��ʱ�洢�ң�Ȼ��������д�� ��ӦĿ¼��Ӳ���ϣ� 
			 * ������˵ ���ϴ�һ���ļ�ʱ����ʵ���ϴ������ݣ���һ������ .tem ��ʽ�� 
			 * Ȼ���ٽ�������д�� ��ӦĿ¼��Ӳ����
			 */
			factory.setRepository(new File(path));
			//���� ����Ĵ�С�����ϴ��ļ������������û���ʱ��ֱ�ӷŵ� ��ʱ�洢��
			factory.setSizeThreshold(100*1024*1024) ;
			
			//��ˮƽ��API�ļ��ϴ�����
			ServletFileUpload upload = new ServletFileUpload(factory);
			
			String filename = "";
			try {
				//�����ϴ�����ļ�
				List<FileItem> list = (List<FileItem>)upload.parseRequest(request);
				
				for(FileItem item : list)
				{
					//��ȡ������������
					//String name = item.getFieldName();
					
					//�����ȡ�� ����Ϣ����ͨ�� �ı� ��Ϣ
					if(item.isFormField())
					{	if("timu".equals(item.getFieldName())){
						
						timu=item.getString("UTF-8");
						System.out.println(timu);
						
					}	
					if("leibie".equals(item.getFieldName())){
						leibie=item.getString("UTF-8");
						System.out.println(leibie);
					}	
					if("my-checkbox".equals(item.getFieldName())){
						gongkai=item.getString("UTF-8");
						System.out.println("������"+gongkai);
						if(!gongkai.equals("on")){
							gongkai="off";
						}
					}	
					if("author".equals(item.getFieldName())){
						author=item.getString("UTF-8");
						System.out.println(author);
					}	
					if("time".equals(item.getFieldName())){
						time=item.getString("UTF-8");
						System.out.println(time);
					}	
					if("beizhu".equals(item.getFieldName())){
						beizhu=item.getString("UTF-8");
						System.out.println(beizhu);
					}	
				
						//��ȡ�û�����������ַ��� ���������ͦ�ã���Ϊ���ύ�������� �ַ������͵�
						//String value = item.getString() ;
						
						//request.setAttribute(name, value);
					}
					//�Դ���ķ� �򵥵��ַ������д��� ������˵�����Ƶ� ͼƬ����Ӱ��Щ
					else
					{
						/**
						 * ������������Ҫ��ȡ �ϴ��ļ�������
						 */
						//��ȡ·����
						
					path1=request.getRealPath("/users");
						
					
						
						String name = item.getFieldName();
						String value = item.getName() ;
						//���������һ����б��
						int start = value.lastIndexOf("\\");
						//��ȡ �ϴ��ļ��� �ַ������֣���1�� ȥ����б�ܣ�
						filename= value.substring(start+1);
						System.out.println(filename);
						request.setAttribute(name, filename);
						
						//����д��������
						//���׳����쳣 ��exception ��׽
						
						//item.write( new File(path,filename) );//�������ṩ��
						
						//�ֶ�д��
						OutputStream out = new FileOutputStream(new File(path,filename));
						
						InputStream in = item.getInputStream() ;
						
						int length = 0 ;
						byte [] buf = new byte[1024] ;
						
						System.out.println("��ȡ�ϴ��ļ����ܹ���������"+item.getSize()+" Byte");

						// in.read(buf) ÿ�ζ��������ݴ����   buf ������
						while( (length = in.read(buf) ) != -1)
						{
							//��   buf ������ ȡ������ д�� ���������������
							out.write(buf, 0, length);
						    
						}
						
						in.close();
						out.close();
					}
				}
				
				
				
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				
				//e.printStackTrace();
			}
//			PrintWriter pw = response.getWriter();
//			pw.print("<script type='text/javascript'>");
//			pw.print("alert('�ϴ��ļ��ɹ�');");
//			pw.print("window.history.go(-1);");
//			pw.print("</script>");
//			pw.flush();
//			pw.close();
			
			// ʵ����UserInfoDao����
			ShareSpaceInfoDao shareDao = new ShareSpaceInfoDao();
			if(username != null && !username.isEmpty()){
				
					// ʵ����һ��User����
				LunWenInfo lwInfo = new LunWenInfo();	
					// ���û������е����Ը�ֵ
				lwInfo.setTimu(timu);
				lwInfo.setLeibie(leibie);
				lwInfo.setAuthor(author);

				lwInfo.setUploadtime(time);
				lwInfo.setBeizhu(beizhu);
				lwInfo.setFilename(filename);
				lwInfo.setFlieurl(fileurl);
				lwInfo.setGongkai(gongkai);
					shareDao.pubLunwen(lwInfo);
					request.setAttribute("info", "��ϲ������ɹ���<br>");
			}else{
				request.setAttribute("info", "���󣺷���ʧ�ܣ�");
			}
		
			response.sendRedirect("ShowServlet?flag=3&num=1");
			
			
		}
	     
	 	
		public void bianjiINIS(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("utf-8");	//���ñ���
			
			String jianjie=null;
			String yanjiu1=null;	
			String yanjiu2=null;	
			String yanjiu3=null;	
			String yanjiu4=null;	
			String yanjiu5=null;	

		
			String uploadtime=null;
	        String username = ((UserInfo)request.getSession().getAttribute(Constants.SESSION_USER_INFO)).getUsername();
	jianjie=new String(request.getParameter("jianjie").getBytes("iso8859-1"),"utf-8");
	yanjiu1=new String(request.getParameter("yanjiu1").getBytes("iso8859-1"),"utf-8");
	yanjiu2=new String(request.getParameter("yanjiu2").getBytes("iso8859-1"),"utf-8");
	yanjiu3=new String(request.getParameter("yanjiu3").getBytes("iso8859-1"),"utf-8");
	yanjiu4=new String(request.getParameter("yanjiu4").getBytes("iso8859-1"),"utf-8");
	yanjiu5=new String(request.getParameter("yanjiu5").getBytes("iso8859-1"),"utf-8");
	System.out.println(jianjie);
	System.out.println(yanjiu1);
	System.out.println(yanjiu2);
	System.out.println(yanjiu3);
	System.out.println(yanjiu4);
	System.out.println(yanjiu5);
	InisInfo Info = new InisInfo();	
	
			// ʵ����UserInfoDao����
			ShareSpaceInfoDao shareDao = new ShareSpaceInfoDao();
			if(username != null && !username.isEmpty()){
				
					// ʵ����һ��User����
		
					// ���û������е����Ը�ֵ
				Info.setJianjie(jianjie);
				Info.setYanjiu1(yanjiu1);
				Info.setYanjiu2(yanjiu2);
				Info.setYanjiu3(yanjiu3);
				Info.setYanjiu4(yanjiu4);
				Info.setYanjiu5(yanjiu5);
				
				shareDao.pubBianjiJianjie(Info);
				
					request.setAttribute("info", "��ϲ������ɹ���<br>");
			}else{
				request.setAttribute("info", "���󣺷���ʧ�ܣ�");
			}
			HttpSession session = request.getSession();
		     session.setAttribute("inisInfo", Info);
		        response.sendRedirect("../index.jsp");
		
			
			
		}
	 	
	     
	    
	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
