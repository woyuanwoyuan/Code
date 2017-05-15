package whut.inis.show.web.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;



import org.json.JSONException;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.xml.XMLSerializer;
import net.sf.json.JSONObject;
import whut.inis.show.po.Result;
import whut.inis.show.util.ImageCut;
import whut.inis.show.util.CreateDirUtil;

public class ImgDealServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ImgDealServlet() {
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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
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

		   File file1 = null;  
	        response.setCharacterEncoding("UTF-8");  
	        request.setCharacterEncoding("UTF-8");  
	        response.setContentType("text/html");  
	        
	    	
	     String  avatar_src=null;
	     String  avatar_data=null;
	     FileItem   avatar_file=null;
	     float x=0;
	     float y=0;
	     float w=0;
	     float h=0;
		String path = request.getRealPath("/users")+ "/"+ "admin" + "/tx";;
		
		  CreateDirUtil.createDir(path); 
			//以当前日期为文件夹名称，创建新目录
		//	String dirName3 =
	    	
	         DiskFileItemFactory factory = new DiskFileItemFactory();  
               ServletFileUpload upload = new ServletFileUpload(factory);  
	                 
        try {  
	            List<FileItem> list = upload.parseRequest(request); //解析request请求  
	           System.out.println(list.size());
	            for (FileItem fileItem : list) {  
	                System.out.println(fileItem.getFieldName());  
	            	if(fileItem.isFormField())
				{	if("avatar_src".equals(fileItem.getFieldName())){
					
					avatar_src=fileItem.getString("UTF-8");
						System.out.println(avatar_src);
				}else if("avatar_data".equals(fileItem.getFieldName())){
					
					avatar_data=fileItem.getString("UTF-8");
			        JSONObject joData =JSONObject.fromObject(avatar_data);
			          // 用户经过剪辑后的图片的大小  
		    String    x1 = joData.getString("x");
		    x=Float.parseFloat(x1);
		    System.out.println("x1="+x1);
		    String    y1 = joData.getString("y");
		    System.out.println("y1="+y1);
		    y=Float.parseFloat(y1);
		    String    h1 = joData.getString("height");
		    System.out.println("h1="+h1);
		    h=Float.parseFloat(h1);
		    String    w1 = joData.getString("width");
		    System.out.println("w1="+w1);
		    w=Float.parseFloat(w1);
//			        x = joData.getFloatValue("x");
//			         y = joData.getFloatValue("y");
//			        w =  joData.getFloatValue("width");
//			         h =  joData.getFloatValue("height");
					System.out.println(avatar_data);
			}
				}
	                if (fileItem.getFieldName().equals("avatar_file")) {  
	                	
	               //     file1 = new File(getServletContext().getRealPath("picCache"),"touxiang.jpg");  
	                 
               //     file1.getParentFile().mkdirs();  
                 //   file1.createNewFile();  
	                     //                   System.out.println(fileItem.getName()+" psd");  
	                	
	                	File targetFile = new File(path, "touxiang.jpg");
	                //	targetFile.getParentFile().mkdirs();  
	             targetFile.createNewFile();  
	                //	 targetFile.mkdirs();  
	                    InputStream ins = fileItem.getInputStream();  
	              //      ImageCut.cut(ins, targetFile, 65,273,520,520);  
	                    ImageCut.cut(ins, targetFile, (int)x,(int)y,(int)w,(int)h);  
	                   
		                ins.close();
	                }  
	  
  
	            }  
        
        } catch (FileUploadException e) {  
	            e.printStackTrace();  
        }  
          
  
 
        JSONObject jsonObject = new JSONObject();    
        jsonObject.put("result1", new Result(true,"上传成功!",request.getSession().getServletContext().getContextPath()));  
      
        response.getWriter().write(jsonObject.toString());  


	   //     String name = avatar_file.getOriginalFilename();
	        //判断文件的MIMEtype
	    //    String type = avatar_file.getContentType();
	  //      if(type==null || !type.toLowerCase().startsWith("image/")) return  JSON.toJSONString(new Result(false,"不支持的文件类型，仅支持图片！"));
	  //      System.out.println("file type:"+type);
	   //     String fileName = new Date().getTime()+""+new Random().nextInt(10000)+"_"+name.substring(name.lastIndexOf('.'));
	    //    System.out.println("文件路径："+path+":"+fileName); 

//	        JSONObject joData = (JSONObject) JSONObject.parse(avatar_data);
//	          // 用户经过剪辑后的图片的大小  
//	        float x = joData.getFloatValue("x");
//	        float y = joData.getFloatValue("y");
//	        float w =  joData.getFloatValue("width");
//	        float h =  joData.getFloatValue("height");

//	        //开始上传
//	        File targetFile = new File(path, dirName3);
//	        //保存  
//	        try {  
//	            if(!targetFile.exists()){  
//	                targetFile.mkdirs();  
//	                InputStream is = avatar_file.getInputStream();
//	                ImageCut.cut(is, targetFile, (int)x,(int)y,(int)w,(int)h);  
//	                is.close();
//	            }  
//	        } catch (Exception e) {  
//	            e.printStackTrace();  
//	         //   return  JSON.toJSONString(new Result(false,"上传失败，出现异常："+e.getMessage(), e));
//	        }  
//	  //      return  JSON.toJSONString(new Result(true,"上传成功!",request.getSession().getServletContext().getContextPath()+fileName));
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