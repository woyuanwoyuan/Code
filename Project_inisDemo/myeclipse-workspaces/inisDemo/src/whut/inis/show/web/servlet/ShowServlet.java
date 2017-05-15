package whut.inis.show.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import whut.inis.show.dao.ShareSpaceDao;
import whut.inis.show.po.IntroductionInfo;
import whut.inis.show.po.LunWenInfo;
import whut.inis.show.po.ShareSpaceInfo;
import whut.inis.show.po.UserInfo;
import whut.inis.show.util.CommonsUtil;
import whut.inis.show.util.Constants;
import whut.inis.show.util.PageUtil;


public class ShowServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ShowServlet() {
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
		
		String flag = request.getParameter("flag");
		switch (Integer.parseInt(flag)) {

		case 1:
			/*
			 * 展示说说页
			 */
			findShuoShuoList(request,response);
			break;
		case 2:
			/*
			 * 展示首页的说说栏
			 */
			findShuoShuoIndexList(request,response); 
			break;
		case 3:
			/*
			 * 展示论文信息
			 */
			findLunWenList(request,response);
			break;
		case 4:
			/*
			 * 展示个人信息
			 */
			findintroductionList(request,response);
			break;
		default:
			break;
		}
		
		
	}

	





	public void findShuoShuoList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	//	String videoatt = request.getParameter("att");
		
		String num = request.getParameter("num");
	    ShareSpaceDao shareDao = new ShareSpaceDao(); 
     
		
		
		int rowCount = ShareSpaceDao.getInstance().getShuoShuoByPag();
		System.out.println(rowCount);
		PageUtil page =  new PageUtil(Constants.PAGE_SIZE, num, rowCount);
		request.setAttribute("page", page);
		//List<VideoInfo> videolist = new ArrayList<VideoInfo>();
		  ArrayList<ShareSpaceInfo> shuoshuolist = shareDao.getAllShareInfo(page.getStartRow(), page.getSize());
		//  System.out.println(shuoshuolist.get(0).getUsername());
		//request.setAttribute("videoatt", videoatt);
		request.setAttribute("shuoshuolist", shuoshuolist);
		
		
		/*
		 * 将浏览次数加一
		 */
		
		CommonsUtil.forward("../bootstrap-fileinput-master/index.jsp", request, response);
	}


	public ArrayList<ShareSpaceInfo> findShuoShuoIndexList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	//	String videoatt = request.getParameter("att");
		
		String num = request.getParameter("num");
	    ShareSpaceDao shareDao = new ShareSpaceDao(); 
     
		
		
	//	int rowCount = ShareSpaceDao.getInstance().getShuoShuoByPag();
	//	System.out.println(rowCount);
		//PageUtil page =  new PageUtil(Constants.PAGE_SIZE, num, rowCount);
	//	request.setAttribute("page", page);
		//List<VideoInfo> videolist = new ArrayList<VideoInfo>();
		 // ArrayList<ShareSpaceInfo> shuoshuolist = shareDao.getAllShareInfo(page.getStartRow(), page.getSize());
	    
	    
	    
		  ArrayList<ShareSpaceInfo> shuoshuolist = shareDao.getAllShareInfo(0, 7);
		  System.out.println(shuoshuolist.get(0).getUsername());
		//request.setAttribute("videoatt", videoatt);
		request.setAttribute("shuoshuolist", shuoshuolist);
		
		return shuoshuolist;
		/*
		 * 将浏览次数加一
		 */
		 
		//CommonsUtil.forward("../bootstrap-fileinput-master/index.jsp", request, response);
	}
	
	
//分页展示论文，并可以通过检索词来缩小范围
/*
 * 因为分页请求的servlet是没有检索条件的，所有应将第一页的检索条件存入session，以便进入下一页时可以获取检索条件
 * 
 */
	public void findLunWenList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	//	String videoatt = request.getParameter("att");
		 request.setCharacterEncoding("utf-8");
		   response.setCharacterEncoding("utf-8");
		  HttpSession session = request.getSession();
		String tiaojian="all"; //最初将tiaojian设置为all，即没有检索的情况下，条件为all，检索所有的论文
		String num = request.getParameter("num");
	    ShareSpaceDao shareDao = new ShareSpaceDao(); 
	    if(session.getAttribute("tiaojian")!=null){//如果tiaojian的session不为空，说明此时有检索条件存在，
	    tiaojian=(String) session.getAttribute("tiaojian");
	    }
    if(request.getParameter("tiaojian")!=null){//如果request请求里有tiaojian，说明此时有人发起检索；
//	tiaojian= new String(request.getParameter("tiaojian").getBytes("ISO-8859-1"),"UTF-8");
	tiaojian=request.getParameter("tiaojian");
    if(tiaojian.equals(new String(tiaojian.getBytes("iso8859-1"), "iso8859-1"))) //如果tiaojian是iso-8859-1编码的话，转为为utf-8
    {
    	System.out.println("此时编码："+new String(tiaojian.getBytes("iso8859-1"), "iso8859-1"));
    	tiaojian=new String(request.getParameter("tiaojian").getBytes("iso8859-1"),"utf-8");
    }
	System.out.println(tiaojian);
    }
  
	session.setAttribute("tiaojian", tiaojian);//将这次的检索条件存入session中，以便待会分页使用
		int rowCount = ShareSpaceDao.getInstance().getLunWenByPag(tiaojian);
		System.out.println(rowCount);
		PageUtil page =  new PageUtil(Constants.PAGE_SIZE, num, rowCount);
		request.setAttribute("page", page);
		//List<VideoInfo> videolist = new ArrayList<VideoInfo>();
		System.out.println(tiaojian);
		  ArrayList<LunWenInfo> lunwenlist = shareDao.getAllLunWenInfo(page.getStartRow(), page.getSize(),tiaojian);
		//  System.out.println(shuoshuolist.get(0).getUsername());
		//request.setAttribute("videoatt", videoatt);
		request.setAttribute("lunwenlist", lunwenlist);
		
		
		/*
		 * 将浏览次数加一
		 */
		CommonsUtil.forward("../lunwenTable.jsp", request, response);
	
	}
	
	
	public ArrayList<LunWenInfo> findLunWenIndexList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	//	String videoatt = request.getParameter("att");
		
		String num = request.getParameter("num");
	    ShareSpaceDao shareDao = new ShareSpaceDao(); 
     
		
		
	//	int rowCount = ShareSpaceDao.getInstance().getShuoShuoByPag();
	//	System.out.println(rowCount);
		//PageUtil page =  new PageUtil(Constants.PAGE_SIZE, num, rowCount);
	//	request.setAttribute("page", page);
		//List<VideoInfo> videolist = new ArrayList<VideoInfo>();
		 // ArrayList<ShareSpaceInfo> shuoshuolist = shareDao.getAllShareInfo(page.getStartRow(), page.getSize());
	    
	    
	    
		  ArrayList<LunWenInfo> lunwenlist = shareDao.getAllLunWenInfo(0, 4,"all");
		  System.out.println(lunwenlist.get(0).getTimu());
		//request.setAttribute("videoatt", videoatt);
	//	request.setAttribute("lunwenlist", lunwenlist);
		
		return lunwenlist;
		/*
		 * 将浏览次数加一
		 */
		 
		//CommonsUtil.forward("../bootstrap-fileinput-master/index.jsp", request, response);
	}
	
	
	public void findintroductionList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	//	String videoatt = request.getParameter("att");
		
		String uname = request.getParameter("uname");
		System.out.println("我叫"+uname);
	    ShareSpaceDao shareDao = new ShareSpaceDao(); 
     
		String username=((UserInfo)request.getSession().getAttribute(Constants.SESSION_USER_INFO)).getUsername();
		
		System.out.println(username);
	//	int rowCount = ShareSpaceDao.getInstance().getShuoShuoByPag();
	//	System.out.println(rowCount);
//		PageUtil page =  new PageUtil(Constants.PAGE_SIZE, num, rowCount);
//		request.setAttribute("page", page);
		//List<VideoInfo> videolist = new ArrayList<VideoInfo>();
	    
	    if(uname==null){
	    	uname=username;
	    }
	    
	    
	   
	    boolean isexist=shareDao.IsexistIntroduction2(uname);
	    IntroductionInfo introduction =null;
	    String classinfo=null;
	    String title=null;
	    request.setAttribute("introduction", "");
	    if(isexist){ //判断是否已编辑过个人信息，若是则显示
		  introduction = shareDao.getintroductionInfo(uname);
		
		  System.out.println("此时哈哈哈为："+introduction);
		 if(introduction.getUsername().equals(username)){ //判断该用户是否进入自己的个人空间，若是，
			 classinfo="";//，啥也没有，你编吧
				title="点击编辑个人信息";
		 	}else{//否者,则传递一个hidden的指令给编辑按钮
		 		
				classinfo="hidden";//藏起来，很high
				title="非本人禁止编辑";
		 	} 
	    }else{//否者则显示admin的个人信息，作为编辑提示
		 introduction = shareDao.getintroductionInfo("admin");
		 classinfo="";//否者，啥也没有，你编吧
			title="点击编辑个人信息";
		  }
		//  System.out.println(shuoshuolist.get(0).getUsername());
		//request.setAttribute("videoatt", videoatt);
		request.setAttribute("introduction", introduction);
		request.setAttribute("classinfo", classinfo);//否者，啥也没有，你编吧
 		request.setAttribute("title", title);
 		
 		
 		
 		

     
		
 	//看看这人装了多少bi
		int rowCount = ShareSpaceDao.getInstance().getShuoShuoByPag(introduction.getUsername());
		System.out.println(rowCount);
		PageUtil page =  new PageUtil(Constants.PAGE_SIZE, "1", rowCount);
		request.setAttribute("page", page);
		//List<VideoInfo> videolist = new ArrayList<VideoInfo>();
		  ArrayList<ShareSpaceInfo> shuoshuolist = shareDao.getAllShareInfoByUsername(page.getStartRow(), page.getSize(),introduction.getUsername());
		//  System.out.println(shuoshuolist.get(0).getUsername());
		//request.setAttribute("videoatt", videoatt);
		request.setAttribute("shuoshuolist", shuoshuolist);
 		
		
		/*
		 * 将浏览次数加一
		 */
	//	response.sendRedirect("../bootstrap-fileinput-master/introduction2.jsp");
		CommonsUtil.forward("../bootstrap-fileinput-master/introduction2.jsp", request, response);
	}
	
	
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
		
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
