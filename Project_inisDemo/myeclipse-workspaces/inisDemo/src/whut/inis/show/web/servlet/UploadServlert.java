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
			 * 上传说说
			 */
			upload(request,response);
			break;
		case 2:
			/*
			 * 上传说说图片
			 */
			uploadFile(request,response);
			
			break;
		case 3:
			/*
			 * 清零图片数目
			 */
			qingling(request,response); 
			
			break;
		case 4:
			/*
			 * 上传论文
			 */
			uploadFile3(request,response); 
			
			break;
		case 5:
			/*
			 * 编辑个人信息
			 */
			bianjiGeRen(request,response); 
			
			break;
		case 6:
			/*
			 * 编辑实验室信息
			 */
			bianjiINIS(request,response); 
			
			break;
		case 7:
			/*
			 * 上传主页图片
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

		request.setCharacterEncoding("utf-8");	//设置编码
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		UserInfo userinfo=(UserInfo) session.getAttribute(Constants.SESSION_USER_INFO);
		String username=userinfo.getUsername();
		String content= new String(request.getParameter("content").getBytes("ISO-8859-1"),"UTF-8");
		//SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		
		//df.format(new Date());// new Date()为获取当前系统时间
		
		String path = request.getRealPath("/users");
	
      //  String dirName2 = path + "/"+ username + "/pic";  
       
      //  String dirName4 = path + "/"+ username + "/vid";  

      //获取当前日期
		Date day=new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String date= df.format(day);
		SimpleDateFormat df1 = new SimpleDateFormat("HH-mm-ss");
		String time=df1.format(day);
		System.out.println(time);

		
		//以当前日期为文件夹名称，创建新目录
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
		
		// 实例化UserInfoDao对象
		ShareSpaceInfoDao shareDao = new ShareSpaceInfoDao();
		if(username != null && !username.isEmpty()){
			
				// 实例化一个User对象
			ShareSpaceInfo share = new ShareSpaceInfo();		
				// 对用户对象中的属性赋值
				share.setUsername(username);
				share.setContent(content);

				share.setPicnum(picnum);
				share.setPurl(purl);
				shareDao.pubShare(share);
				request.setAttribute("info", "恭喜，发表成功！<br>");
		}else{
			request.setAttribute("info", "错误：发表失败！");
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
	            List<FileItem> list = upload.parseRequest(request); //解析request请求  
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
	            List<FileItem> list = upload.parseRequest(request); //解析request请求  
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

	
//复制文件夹
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
					} //调用文件拷贝的方法  
	            }else if(f.isDirectory()){  
	                copy(f.getPath(),des+"\\"+f.getName());  
	            }  
	        }  
	          
	    }  
	   /** 
	     * 字符流文件拷贝的方法 
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
	     *使用缓冲字节流进行文件的复制
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
			request.setCharacterEncoding("utf-8");	//设置编码
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
			//获得磁盘文件条目工厂
			DiskFileItemFactory factory = new DiskFileItemFactory();
			//获取文件需要上传到的路径
			String uploadtime=null;
	      //  String username = ((UserInfo)request.getSession().getAttribute(Constants.SESSION_USER_INFO)).getUsername();
			String username=((UserInfo)request.getSession().getAttribute(Constants.SESSION_USER_INFO)).getUsername();
		//	String url=((UserInfo)request.getSession().getAttribute(Constants.SESSION_USER_INFO)).getUrl();
			String path1=request.getRealPath("/users");
			String path = path1 + "/"+ username+"/touxiang"; 
		 fileurl="users/"+ username +"/touxiang"; 
			//如果没以下两行设置的话，上传大的 文件 会占用 很多内存，
			//设置暂时存放的 存储室 , 这个存储室，可以和 最终存储文件 的目录不同
			/**
			 * 原理 它是先存到 暂时存储室，然后在真正写到 对应目录的硬盘上， 
			 * 按理来说 当上传一个文件时，其实是上传了两份，第一个是以 .tem 格式的 
			 * 然后再将其真正写到 对应目录的硬盘上
			 */
			factory.setRepository(new File(path));
			//设置 缓存的大小，当上传文件的容量超过该缓存时，直接放到 暂时存储室
			factory.setSizeThreshold(100*1024*1024) ;
			
			//高水平的API文件上传处理
			ServletFileUpload upload = new ServletFileUpload(factory);
			
			String filename = "";
			try {
				//可以上传多个文件
				List<FileItem> list = (List<FileItem>)upload.parseRequest(request);
				
				for(FileItem item : list)
				{
					//获取表单的属性名字
					//String name = item.getFieldName();
					
					//如果获取的 表单信息是普通的 文本 信息
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
				
						//获取用户具体输入的字符串 ，名字起得挺好，因为表单提交过来的是 字符串类型的
						//String value = item.getString() ;
						
						//request.setAttribute(name, value);
					}
					//对传入的非 简单的字符串进行处理 ，比如说二进制的 图片，电影这些
					else
					{
						/**
						 * 以下三步，主要获取 上传文件的名字
						 */
						//获取路径名
						
					path1=request.getRealPath("/users");
						
					
						
						String name = item.getFieldName();
						String value = item.getName() ;
						//索引到最后一个反斜杠
						int start = value.lastIndexOf("\\");
						//截取 上传文件的 字符串名字，加1是 去掉反斜杠，
						filename= value.substring(start+1);
						System.out.println("文件叫："+filename);
						request.setAttribute(name, filename);
						if(!filename.equals("")){//如果更改头像，即有上传新的头像，就上传头像 ,否则不做修改
							
						
						//真正写到磁盘上
						//它抛出的异常 用exception 捕捉
						
						//item.write( new File(path,filename) );//第三方提供的
						
						//手动写的
						OutputStream out = new FileOutputStream(new File(path,"touxiang.jpg"));
						
						InputStream in = item.getInputStream() ;
						
						int length = 0 ;
						byte [] buf = new byte[1024] ;
						
						System.out.println("获取上传文件的总共的容量："+item.getSize()+" Byte");

						// in.read(buf) 每次读到的数据存放在   buf 数组中
						while( (length = in.read(buf) ) != -1)
						{
							//在   buf 数组中 取出数据 写到 （输出流）磁盘上
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
//			pw.print("alert('上传文件成功');");
//			pw.print("window.history.go(-1);");
//			pw.print("</script>");
//			pw.flush();
//			pw.close();
			
			// 实例化UserInfoDao对象
			ShareSpaceInfoDao shareDao = new ShareSpaceInfoDao();
			ShareSpaceDao dao = new ShareSpaceDao();
		//	if(username != null && !username.isEmpty()){
				
					// 实例化一个User对象
				IntroductionInfo indroInfo = new IntroductionInfo();	
					// 对用户对象中的属性赋值
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
		
			
				
				
			if(	dao.IsexistIntroduction(indroInfo)){  //若存在introduction，即更新
				System.out.println("已存在introduction");
					if(filename.equals("")){//若无文件上传，则不更新filename和fileurl
						System.out.println("已存在introduction且无图片");
					 		shareDao.updateIntroductionWithoutPic(indroInfo);
					 		shareDao.updateUserInfo(uname,username);
							alertInfo.setInfoContent("修改个人信息(不包含头像)成功！");
					 }else{//若有文件上传，则更新filename和fileurl
							shareDao.updateIntroduction(indroInfo);
							shareDao.updateUserInfo(uname,username);
							alertInfo.setInfoContent("修改个人信息(包含头像)成功！");
					 	}
			 	}else{//若不存在introduction，即编辑上传
			 		System.out.println("不存在introduction");
						
							shareDao.bianjiIntroduction(indroInfo);
							shareDao.updateUserInfo(uname,username);
							alertInfo.setInfoContent("编辑个人信息成功！");
			 	}
					//request.setAttribute("info", "恭喜，发表成功！<br>");
		//	}else{
				//request.setAttribute("info", "错误：发表失败！");
			//}
			request.setAttribute("alertInfo", alertInfo);
	//	response.sendRedirect("ShowServlet?flag=4&uname="+username);
		CommonsUtil.forward("ShowServlet?flag=4&uname="+username, request, response);
			
		}
	     
	 	
	 	public void uploadFile3(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("utf-8");	//设置编码
			File file=null;
			String leibie=null;
			String gongkai="off";
			String timu=null;	
			String author=null;
			String time=null;
			String beizhu=null;
			String fileurl=null;
			//获得磁盘文件条目工厂
			DiskFileItemFactory factory = new DiskFileItemFactory();
			//获取文件需要上传到的路径
			String uploadtime=null;
	        String username = ((UserInfo)request.getSession().getAttribute(Constants.SESSION_USER_INFO)).getUsername();
			String url=((UserInfo)request.getSession().getAttribute(Constants.SESSION_USER_INFO)).getUrl();
			String path1=request.getRealPath("/users");
			String path = path1 + "/"+ username+"/lunwen"; 
		 fileurl="users/"+ username +"/lunwen"; 
			//如果没以下两行设置的话，上传大的 文件 会占用 很多内存，
			//设置暂时存放的 存储室 , 这个存储室，可以和 最终存储文件 的目录不同
			/**
			 * 原理 它是先存到 暂时存储室，然后在真正写到 对应目录的硬盘上， 
			 * 按理来说 当上传一个文件时，其实是上传了两份，第一个是以 .tem 格式的 
			 * 然后再将其真正写到 对应目录的硬盘上
			 */
			factory.setRepository(new File(path));
			//设置 缓存的大小，当上传文件的容量超过该缓存时，直接放到 暂时存储室
			factory.setSizeThreshold(100*1024*1024) ;
			
			//高水平的API文件上传处理
			ServletFileUpload upload = new ServletFileUpload(factory);
			
			String filename = "";
			try {
				//可以上传多个文件
				List<FileItem> list = (List<FileItem>)upload.parseRequest(request);
				
				for(FileItem item : list)
				{
					//获取表单的属性名字
					//String name = item.getFieldName();
					
					//如果获取的 表单信息是普通的 文本 信息
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
						System.out.println("公开："+gongkai);
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
				
						//获取用户具体输入的字符串 ，名字起得挺好，因为表单提交过来的是 字符串类型的
						//String value = item.getString() ;
						
						//request.setAttribute(name, value);
					}
					//对传入的非 简单的字符串进行处理 ，比如说二进制的 图片，电影这些
					else
					{
						/**
						 * 以下三步，主要获取 上传文件的名字
						 */
						//获取路径名
						
					path1=request.getRealPath("/users");
						
					
						
						String name = item.getFieldName();
						String value = item.getName() ;
						//索引到最后一个反斜杠
						int start = value.lastIndexOf("\\");
						//截取 上传文件的 字符串名字，加1是 去掉反斜杠，
						filename= value.substring(start+1);
						System.out.println(filename);
						request.setAttribute(name, filename);
						
						//真正写到磁盘上
						//它抛出的异常 用exception 捕捉
						
						//item.write( new File(path,filename) );//第三方提供的
						
						//手动写的
						OutputStream out = new FileOutputStream(new File(path,filename));
						
						InputStream in = item.getInputStream() ;
						
						int length = 0 ;
						byte [] buf = new byte[1024] ;
						
						System.out.println("获取上传文件的总共的容量："+item.getSize()+" Byte");

						// in.read(buf) 每次读到的数据存放在   buf 数组中
						while( (length = in.read(buf) ) != -1)
						{
							//在   buf 数组中 取出数据 写到 （输出流）磁盘上
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
//			pw.print("alert('上传文件成功');");
//			pw.print("window.history.go(-1);");
//			pw.print("</script>");
//			pw.flush();
//			pw.close();
			
			// 实例化UserInfoDao对象
			ShareSpaceInfoDao shareDao = new ShareSpaceInfoDao();
			if(username != null && !username.isEmpty()){
				
					// 实例化一个User对象
				LunWenInfo lwInfo = new LunWenInfo();	
					// 对用户对象中的属性赋值
				lwInfo.setTimu(timu);
				lwInfo.setLeibie(leibie);
				lwInfo.setAuthor(author);

				lwInfo.setUploadtime(time);
				lwInfo.setBeizhu(beizhu);
				lwInfo.setFilename(filename);
				lwInfo.setFlieurl(fileurl);
				lwInfo.setGongkai(gongkai);
					shareDao.pubLunwen(lwInfo);
					request.setAttribute("info", "恭喜，发表成功！<br>");
			}else{
				request.setAttribute("info", "错误：发表失败！");
			}
		
			response.sendRedirect("ShowServlet?flag=3&num=1");
			
			
		}
	     
	 	
		public void bianjiINIS(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("utf-8");	//设置编码
			
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
	
			// 实例化UserInfoDao对象
			ShareSpaceInfoDao shareDao = new ShareSpaceInfoDao();
			if(username != null && !username.isEmpty()){
				
					// 实例化一个User对象
		
					// 对用户对象中的属性赋值
				Info.setJianjie(jianjie);
				Info.setYanjiu1(yanjiu1);
				Info.setYanjiu2(yanjiu2);
				Info.setYanjiu3(yanjiu3);
				Info.setYanjiu4(yanjiu4);
				Info.setYanjiu5(yanjiu5);
				
				shareDao.pubBianjiJianjie(Info);
				
					request.setAttribute("info", "恭喜，发表成功！<br>");
			}else{
				request.setAttribute("info", "错误：发表失败！");
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
