package whut.inis.show.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.FinderException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import whut.inis.show.dao.ShareSpaceDao;
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

public class SystemServlet extends HttpServlet {
	
	private static final long serialVersionUID = 5280356329609002908L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String flag = request.getParameter("flag");
		switch (Integer.parseInt(flag)) {

		case 0:
			/*
			 * ע�����û�
			 */
			regUser(request,response);
			break;
		case 1:
			/*
			 * �û���¼
			 */
			loginUser(request,response);
			break;
		case 2:
			/*
			 * �޸������е��޸���Ч��ť
			 */
			modifyPasswd(request,response);
			break;

		case 3:
			/*
			 * ������ҳ
			 */
			back2index(request,response);
			break;
		case 4:
			showuserinfo(request,response);
			break;
		case 5:
			/*
			 * ɾ�������û���Ϣ  ���ɾ��  ��isdel��0��Ϊ1  update userinfo set isdel=1 where id=?
			 */
			deleteUserByID(request,response);
			break;
		case 6:
			updateUserByID(request,response);
			
			break;
		case 7:
			YouKelogin(request,response);
			
			break;
		//case 7:
			//updateUserByID(request,response);
			//
		//	break;
	
		
		default:
			break;
		}
		
	}

	
	


	public void regUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 request.setCharacterEncoding("utf-8");
		   response.setCharacterEncoding("utf-8");
		// ��ȡ�û���
	//	String username = request.getParameter("username");
		String username= new String(request.getParameter("username").getBytes("ISO-8859-1"),"UTF-8");
		// ��ȡ����
		String passwd = request.getParameter("passwd");
		
		// ��ȡ��������
		String email = request.getParameter("email");
		String url= request.getParameter("url");
		String regtime=request.getParameter("regtime");
		// ʵ����UserInfoDao����
		UserInfoDao userDao = new UserInfoDao();
		if(username != null && !username.isEmpty()){
			if(userDao.userIsExist(username)){
				// ʵ����һ��User����
				UserInfo user = new UserInfo();		
				// ���û������е����Ը�ֵ
				user.setUrl(url);
				user.setUsername(username);	
				user.setPasswd(passwd);
				user.setEmail(email);
				user.setIsdel(0);
				user.setRole_id(2);
				user.setRegtime(regtime);
				// �����û�ע����Ϣ
				userDao.regUser(user);

				request.setAttribute("info", "��ϲ��ע��ɹ���<br>");
			}else{
				request.setAttribute("info", "���󣺴��û����Ѵ��ڣ�");
			}
		}
		request.setAttribute("username", username);
		// ת����regresult.jspҳ��
		request.getRequestDispatcher("upweb/index.jsp").forward(request, response);
		
	}
	
	public void loginUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * ��¼ʧ�� ����������ȥ��������¼ҳ�棩
		 */
		 request.setCharacterEncoding("utf-8");
		   response.setCharacterEncoding("utf-8");
	//	String username = request.getParameter("username");
			String username= new String(request.getParameter("username").getBytes("ISO-8859-1"),"UTF-8");
		String passwd = request.getParameter("passwd");
		
		/*��ȡuser�ļ���·�� */
		System.out.println(username);
		UserInfo userinfo = UserInfoDao.getInstance().login(username, passwd);
		
		/*
		 * ��¼�ɹ� ���û�����Ϣ�ŵ�session�������� 
		 * 
		 * ��ת��admin/system_index.jspҳ��
		 */
		if(userinfo == null){

			CommonsUtil.outByPrintWriter(response, "alert('�û������������');window.history.go(-1);");
		}else {
			if(userinfo.getIsdel()==1){
				CommonsUtil.outByPrintWriter(response, "alert('���û��ѱ�����');window.history.go(-1);");
			}else{
			HttpSession session = request.getSession();
			session.setAttribute(Constants.SESSION_USER_INFO, userinfo);
			String path = request.getRealPath("/users");
			String dirName1 = path + "/"+ username + "/lunwen";  
	        CreateDirUtil.createDir(dirName1); 
	        String dirName2 = path + "/"+ username + "/pic";  
	        CreateDirUtil.createDir(dirName2); 
	        String dirName4 = path + "/"+ username + "/vid";  
	        CreateDirUtil.createDir(dirName4); 
			String dirName7 = path + "/"+ username + "/touxiang";  
	        CreateDirUtil.createDir(dirName7); 
	      //��ȡ��ǰ����
			Date day=new Date();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String datetime = df.format(day);
			//�Ե�ǰ����Ϊ�ļ������ƣ�������Ŀ¼
			String dirName3 = path + "/"+ username + "/pic/"+datetime;  
		    CreateDirUtil.createDir(dirName3); 
		    String dirName5 = path + "/"+ username + "/vid/"+datetime;  
	        CreateDirUtil.createDir(dirName5); 
//			System.out.println(userinfo.toString());
		//    response.sendRedirect("upweb/choose.jsp");
        ArrayList<ShareSpaceInfo> shuoshuolist= ShareSpaceDao.getInstance().findIndexshoushuo();
        ArrayList<LunWenInfo> lunwenlist= ShareSpaceDao.getInstance().findIndexlunwen();
       ArrayList<IntroductionInfo> introductionlist= ShareSpaceDao.getInstance().findIndexIntroduction();
	        InisInfo InisInfo= ShareSpaceDao.getInstance().getInisInfo();
	       session.setAttribute("shuoshuolist", shuoshuolist);
	        session.setAttribute("lunwenlist", lunwenlist);
	        session.setAttribute("introductionlist", introductionlist);
	        session.setAttribute("inisInfo", InisInfo);
	        System.out.println(shuoshuolist.get(0).getPurl());
	        response.sendRedirect("index.jsp");
			//response.sendRedirect("bootcms/system_index.jsp");
			return;
		}		
	}
	}

	public void YouKelogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * ��¼ʧ�� ����������ȥ��������¼ҳ�棩
		 */
		 request.setCharacterEncoding("utf-8");
		   response.setCharacterEncoding("utf-8");
	//	String username = request.getParameter("username");
//			String username= new String(request.getParameter("username").getBytes("ISO-8859-1"),"UTF-8");
	//	String passwd = request.getParameter("passwd");
		
		/*��ȡuser�ļ���·�� */
//		System.out.println(username);
//		UserInfo userinfo = UserInfoDao.getInstance().login(username, passwd);
//		
//		/*
//		 * ��¼�ɹ� ���û�����Ϣ�ŵ�session�������� 
//		 * 
//		 * ��ת��admin/system_index.jspҳ��
//		 */
//		if(userinfo == null){
//
//			CommonsUtil.outByPrintWriter(response, "alert('�û������������');window.history.go(-1);");
//		}else {
//			if(userinfo.getIsdel()==1){
//				CommonsUtil.outByPrintWriter(response, "alert('���û��ѱ�����');window.history.go(-1);");
//			}else{
//			HttpSession session = request.getSession();
//			session.setAttribute(Constants.SESSION_USER_INFO, userinfo);
//			String path = request.getRealPath("/users");
//			String dirName1 = path + "/"+ username + "/lunwen";  
//	        CreateDirUtil.createDir(dirName1); 
//	        String dirName2 = path + "/"+ username + "/pic";  
//	        CreateDirUtil.createDir(dirName2); 
//	        String dirName4 = path + "/"+ username + "/vid";  
//	        CreateDirUtil.createDir(dirName4); 
//			String dirName7 = path + "/"+ username + "/touxiang";  
//	        CreateDirUtil.createDir(dirName7); 
//	      //��ȡ��ǰ����
//			Date day=new Date();
//			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//			String datetime = df.format(day);
//			//�Ե�ǰ����Ϊ�ļ������ƣ�������Ŀ¼
//			String dirName3 = path + "/"+ username + "/pic/"+datetime;  
//		    CreateDirUtil.createDir(dirName3); 
//		    String dirName5 = path + "/"+ username + "/vid/"+datetime;  
//	        CreateDirUtil.createDir(dirName5); 
//			System.out.println(userinfo.toString());
		//    response.sendRedirect("upweb/choose.jsp");
		   UserInfo userinfo = UserInfoDao.getInstance().youkelogin("�ο�");
		  	HttpSession session = request.getSession();
		   session.setAttribute(Constants.SESSION_USER_INFO, userinfo);
		 
	        ArrayList<ShareSpaceInfo> shuoshuolist= ShareSpaceDao.getInstance().findIndexshoushuo();
	        ArrayList<LunWenInfo> lunwenlist= ShareSpaceDao.getInstance().findIndexlunwen();
	        ArrayList<IntroductionInfo> introductionlist= ShareSpaceDao.getInstance().findIndexIntroduction();
	        InisInfo InisInfo= ShareSpaceDao.getInstance().getInisInfo();
	       session.setAttribute("shuoshuolist", shuoshuolist);
	        session.setAttribute("lunwenlist", lunwenlist);
	        session.setAttribute("introductionlist", introductionlist);
	        session.setAttribute("inisInfo", InisInfo);
	      System.out.println(shuoshuolist.get(0).getPurl());
	        response.sendRedirect("index.jsp");
			//response.sendRedirect("bootcms/system_index.jsp");
			return;
	//	}		
//	}
	}
	
	
	public void modifyPasswd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String oldPasswd = request.getParameter("oldPassword");
		String newPasswd = request.getParameter("newPassword");
		System.out.println(oldPasswd);
		
		String passwd=((UserInfo)request.getSession().getAttribute(Constants.SESSION_USER_INFO)).getPasswd();
		String username=((UserInfo)request.getSession().getAttribute(Constants.SESSION_USER_INFO)).getUsername();
		int id = ((UserInfo)request.getSession().getAttribute(Constants.SESSION_USER_INFO)).getId();
		System.out.println(passwd);
		//boolean oldsuc = UserInfoDao.getInstance().checkOldPasswd(oldPasswd, id);
		
		AlertInfo alertInfo=new AlertInfo();
		if(oldPasswd.equals(passwd)){
			boolean suc = UserInfoDao.getInstance().modifyPasswdByID(newPasswd, id);
			if(suc){
				alertInfo.setInfoLei("success");
				alertInfo.setInfoContent("�޸ĳɹ�,�´ε�¼ʱ��Ч");
				request.setAttribute("alertInfo", alertInfo);
			}else{
				alertInfo.setInfoLei("danger");
				alertInfo.setInfoContent("�޸�ʧ��,����ϵ����Ա");
				request.setAttribute("alertInfo", alertInfo);
				
			}
			response.sendRedirect("servlet/ShowServlet?flag=4&uname="+username+"&alertInfo"+alertInfo);
	//	CommonsUtil.forward("servlet/ShowServlet?flag=4&uname="+username, request, response);
		}else{
			alertInfo.setInfoLei("danger");
			alertInfo.setInfoContent("�����벻��ȷ");
			request.setAttribute("alertInfo", alertInfo);
			response.sendRedirect("servlet/ShowServlet?flag=4&uname="+username+"&alertInfo"+alertInfo);
		//	CommonsUtil.forward("/servlet/ShowServlet?flag=4&uname="+username, request, response);
		}
		
	}
	public void deleteUserByID(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		boolean flag = UserInfoDao.getInstance().deleteUserByID(Integer.parseInt(id));
		if(flag){
			CommonsUtil.forward("/SystemServlet?flag=4", request, response);
		}else{
		CommonsUtil.outByPrintWriter(response, "alert('ɾ��ʧ��');window.history.go(-1)");
		}
	}
	
	public void back2index(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getSession().invalidate();
		response.sendRedirect("/inis_videoProcess/web/index.jsp");
		return;
		
	}
	public void showuserinfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<UserInfo> userlist=UserInfoDao.getInstance().getUserList();
	    request.setAttribute("userlist", userlist);
		CommonsUtil.forward("/admin/userManage.jsp", request, response);
	}
	public void updateUserByID(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		int role_id = Integer.valueOf(request.getParameter("role_id"));
		
		if(role_id==1)
		{boolean flag = UserInfoDao.getInstance().UserByIDdown(Integer.parseInt(id));
		if(flag){
			CommonsUtil.forward("/SystemServlet?flag=4", request, response);
		}else
		{
		CommonsUtil.outByPrintWriter(response, "alert('ɾ��ʧ��');window.history.go(-1)");
		}
		}

		else{
			boolean flag = UserInfoDao.getInstance().updateUserByID(Integer.parseInt(id));
		if(flag){
		CommonsUtil.forward("/SystemServlet?flag=4", request, response);
	}else{
		CommonsUtil.outByPrintWriter(response, "alert('ɾ��ʧ��');window.history.go(-1)");
		}
		}
		
	}
	//public void updateUserByID(HttpServletRequest request, HttpServletResponse response)
		//	throws ServletException, IOException {
		//String id = request.getParameter("id");
	///	boolean flag = UserInfoDao.getInstance().UserByIDdown(Integer.parseInt(id));
		//if(flag){
			//CommonsUtil.forward("/SystemServlet?flag=4", request, response);
	//	}else{
		//CommonsUtil.outByPrintWriter(response, "alert('ɾ��ʧ��');window.history.go(-1)");
	//	}
	//}
	//public void UserByIDdown(HttpServletRequest request, HttpServletResponse response)
		//	throws ServletException, IOException {
	//	String id = request.getParameter("id");
	//	boolean flag = UserInfoDao.getInstance().UserByIDdown(Integer.parseInt(id));
	//	if(flag){
	//		CommonsUtil.forward("/SystemServlet?flag=4", request, response);
	//	}else{
	//	CommonsUtil.outByPrintWriter(response, "alert('ɾ��ʧ��');window.history.go(-1)");
		//}
	//}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
