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
			 * չʾ˵˵ҳ
			 */
			findShuoShuoList(request,response);
			break;
		case 2:
			/*
			 * չʾ��ҳ��˵˵��
			 */
			findShuoShuoIndexList(request,response); 
			break;
		case 3:
			/*
			 * չʾ������Ϣ
			 */
			findLunWenList(request,response);
			break;
		case 4:
			/*
			 * չʾ������Ϣ
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
		 * �����������һ
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
		 * �����������һ
		 */
		 
		//CommonsUtil.forward("../bootstrap-fileinput-master/index.jsp", request, response);
	}
	
	
//��ҳչʾ���ģ�������ͨ������������С��Χ
/*
 * ��Ϊ��ҳ�����servlet��û�м��������ģ�����Ӧ����һҳ�ļ�����������session���Ա������һҳʱ���Ի�ȡ��������
 * 
 */
	public void findLunWenList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	//	String videoatt = request.getParameter("att");
		 request.setCharacterEncoding("utf-8");
		   response.setCharacterEncoding("utf-8");
		  HttpSession session = request.getSession();
		String tiaojian="all"; //�����tiaojian����Ϊall����û�м���������£�����Ϊall���������е�����
		String num = request.getParameter("num");
	    ShareSpaceDao shareDao = new ShareSpaceDao(); 
	    if(session.getAttribute("tiaojian")!=null){//���tiaojian��session��Ϊ�գ�˵����ʱ�м����������ڣ�
	    tiaojian=(String) session.getAttribute("tiaojian");
	    }
    if(request.getParameter("tiaojian")!=null){//���request��������tiaojian��˵����ʱ���˷��������
//	tiaojian= new String(request.getParameter("tiaojian").getBytes("ISO-8859-1"),"UTF-8");
	tiaojian=request.getParameter("tiaojian");
    if(tiaojian.equals(new String(tiaojian.getBytes("iso8859-1"), "iso8859-1"))) //���tiaojian��iso-8859-1����Ļ���תΪΪutf-8
    {
    	System.out.println("��ʱ���룺"+new String(tiaojian.getBytes("iso8859-1"), "iso8859-1"));
    	tiaojian=new String(request.getParameter("tiaojian").getBytes("iso8859-1"),"utf-8");
    }
	System.out.println(tiaojian);
    }
  
	session.setAttribute("tiaojian", tiaojian);//����εļ�����������session�У��Ա�����ҳʹ��
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
		 * �����������һ
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
		 * �����������һ
		 */
		 
		//CommonsUtil.forward("../bootstrap-fileinput-master/index.jsp", request, response);
	}
	
	
	public void findintroductionList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	//	String videoatt = request.getParameter("att");
		
		String uname = request.getParameter("uname");
		System.out.println("�ҽ�"+uname);
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
	    if(isexist){ //�ж��Ƿ��ѱ༭��������Ϣ����������ʾ
		  introduction = shareDao.getintroductionInfo(uname);
		
		  System.out.println("��ʱ������Ϊ��"+introduction);
		 if(introduction.getUsername().equals(username)){ //�жϸ��û��Ƿ�����Լ��ĸ��˿ռ䣬���ǣ�
			 classinfo="";//��ɶҲû�У�����
				title="����༭������Ϣ";
		 	}else{//����,�򴫵�һ��hidden��ָ����༭��ť
		 		
				classinfo="hidden";//����������high
				title="�Ǳ��˽�ֹ�༭";
		 	} 
	    }else{//��������ʾadmin�ĸ�����Ϣ����Ϊ�༭��ʾ
		 introduction = shareDao.getintroductionInfo("admin");
		 classinfo="";//���ߣ�ɶҲû�У�����
			title="����༭������Ϣ";
		  }
		//  System.out.println(shuoshuolist.get(0).getUsername());
		//request.setAttribute("videoatt", videoatt);
		request.setAttribute("introduction", introduction);
		request.setAttribute("classinfo", classinfo);//���ߣ�ɶҲû�У�����
 		request.setAttribute("title", title);
 		
 		
 		
 		

     
		
 	//��������װ�˶���bi
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
		 * �����������һ
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
