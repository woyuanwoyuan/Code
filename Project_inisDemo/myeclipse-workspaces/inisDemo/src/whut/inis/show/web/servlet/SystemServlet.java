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
			 * 注册新用户
			 */
			regUser(request,response);
			break;
		case 1:
			/*
			 * 用户登录
			 */
			loginUser(request,response);
			break;
		case 2:
			/*
			 * 修改密码中的修改生效按钮
			 */
			modifyPasswd(request,response);
			break;

		case 3:
			/*
			 * 返回首页
			 */
			back2index(request,response);
			break;
		case 4:
			showuserinfo(request,response);
			break;
		case 5:
			/*
			 * 删除单个用户信息  标记删除  将isdel由0变为1  update userinfo set isdel=1 where id=?
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
		// 获取用户名
	//	String username = request.getParameter("username");
		String username= new String(request.getParameter("username").getBytes("ISO-8859-1"),"UTF-8");
		// 获取密码
		String passwd = request.getParameter("passwd");
		
		// 获取电子邮箱
		String email = request.getParameter("email");
		String url= request.getParameter("url");
		String regtime=request.getParameter("regtime");
		// 实例化UserInfoDao对象
		UserInfoDao userDao = new UserInfoDao();
		if(username != null && !username.isEmpty()){
			if(userDao.userIsExist(username)){
				// 实例化一个User对象
				UserInfo user = new UserInfo();		
				// 对用户对象中的属性赋值
				user.setUrl(url);
				user.setUsername(username);	
				user.setPasswd(passwd);
				user.setEmail(email);
				user.setIsdel(0);
				user.setRole_id(2);
				user.setRegtime(regtime);
				// 保存用户注册信息
				userDao.regUser(user);

				request.setAttribute("info", "恭喜，注册成功！<br>");
			}else{
				request.setAttribute("info", "错误：此用户名已存在！");
			}
		}
		request.setAttribute("username", username);
		// 转发到regresult.jsp页面
		request.getRequestDispatcher("upweb/index.jsp").forward(request, response);
		
	}
	
	public void loginUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 登录失败 从哪来回哪去（三个登录页面）
		 */
		 request.setCharacterEncoding("utf-8");
		   response.setCharacterEncoding("utf-8");
	//	String username = request.getParameter("username");
			String username= new String(request.getParameter("username").getBytes("ISO-8859-1"),"UTF-8");
		String passwd = request.getParameter("passwd");
		
		/*获取user文件的路径 */
		System.out.println(username);
		UserInfo userinfo = UserInfoDao.getInstance().login(username, passwd);
		
		/*
		 * 登录成功 将用户的信息放到session作用域中 
		 * 
		 * 跳转到admin/system_index.jsp页面
		 */
		if(userinfo == null){

			CommonsUtil.outByPrintWriter(response, "alert('用户名或密码错误！');window.history.go(-1);");
		}else {
			if(userinfo.getIsdel()==1){
				CommonsUtil.outByPrintWriter(response, "alert('该用户已被冻结');window.history.go(-1);");
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
	      //获取当前日期
			Date day=new Date();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String datetime = df.format(day);
			//以当前日期为文件夹名称，创建新目录
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
		 * 登录失败 从哪来回哪去（三个登录页面）
		 */
		 request.setCharacterEncoding("utf-8");
		   response.setCharacterEncoding("utf-8");
	//	String username = request.getParameter("username");
//			String username= new String(request.getParameter("username").getBytes("ISO-8859-1"),"UTF-8");
	//	String passwd = request.getParameter("passwd");
		
		/*获取user文件的路径 */
//		System.out.println(username);
//		UserInfo userinfo = UserInfoDao.getInstance().login(username, passwd);
//		
//		/*
//		 * 登录成功 将用户的信息放到session作用域中 
//		 * 
//		 * 跳转到admin/system_index.jsp页面
//		 */
//		if(userinfo == null){
//
//			CommonsUtil.outByPrintWriter(response, "alert('用户名或密码错误！');window.history.go(-1);");
//		}else {
//			if(userinfo.getIsdel()==1){
//				CommonsUtil.outByPrintWriter(response, "alert('该用户已被冻结');window.history.go(-1);");
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
//	      //获取当前日期
//			Date day=new Date();
//			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//			String datetime = df.format(day);
//			//以当前日期为文件夹名称，创建新目录
//			String dirName3 = path + "/"+ username + "/pic/"+datetime;  
//		    CreateDirUtil.createDir(dirName3); 
//		    String dirName5 = path + "/"+ username + "/vid/"+datetime;  
//	        CreateDirUtil.createDir(dirName5); 
//			System.out.println(userinfo.toString());
		//    response.sendRedirect("upweb/choose.jsp");
		   UserInfo userinfo = UserInfoDao.getInstance().youkelogin("游客");
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
				alertInfo.setInfoContent("修改成功,下次登录时生效");
				request.setAttribute("alertInfo", alertInfo);
			}else{
				alertInfo.setInfoLei("danger");
				alertInfo.setInfoContent("修改失败,请联系管理员");
				request.setAttribute("alertInfo", alertInfo);
				
			}
			response.sendRedirect("servlet/ShowServlet?flag=4&uname="+username+"&alertInfo"+alertInfo);
	//	CommonsUtil.forward("servlet/ShowServlet?flag=4&uname="+username, request, response);
		}else{
			alertInfo.setInfoLei("danger");
			alertInfo.setInfoContent("旧密码不正确");
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
		CommonsUtil.outByPrintWriter(response, "alert('删除失败');window.history.go(-1)");
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
		CommonsUtil.outByPrintWriter(response, "alert('删除失败');window.history.go(-1)");
		}
		}

		else{
			boolean flag = UserInfoDao.getInstance().updateUserByID(Integer.parseInt(id));
		if(flag){
		CommonsUtil.forward("/SystemServlet?flag=4", request, response);
	}else{
		CommonsUtil.outByPrintWriter(response, "alert('删除失败');window.history.go(-1)");
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
		//CommonsUtil.outByPrintWriter(response, "alert('删除失败');window.history.go(-1)");
	//	}
	//}
	//public void UserByIDdown(HttpServletRequest request, HttpServletResponse response)
		//	throws ServletException, IOException {
	//	String id = request.getParameter("id");
	//	boolean flag = UserInfoDao.getInstance().UserByIDdown(Integer.parseInt(id));
	//	if(flag){
	//		CommonsUtil.forward("/SystemServlet?flag=4", request, response);
	//	}else{
	//	CommonsUtil.outByPrintWriter(response, "alert('删除失败');window.history.go(-1)");
		//}
	//}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
