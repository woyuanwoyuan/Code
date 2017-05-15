package whut.inis.show.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 本类用来获得表单请求信息，并根据请求信息转发页面
 */
public class ForwardServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * 构造函数
	 */
	public ForwardServlet()
	{
		super();
	}
	
	/**
	 * 初始化
	 */
	public void init() throws ServletException
	{}
	
	/**
	 * doGet()方法
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request, response);
	}
	
	/**
	 * doPost()方法
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		if((name!=null && !name.equals("")) && (pwd!=null && !pwd.equals("")))
		{
			if(name.equals("mr")&&pwd.equals("123"))
			{
				request.getRequestDispatcher("success.jsp").forward(request, response);
			}
			else
			{
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
		}
	}
	
	/**
	 * 销毁
	 */
	public void destroy()
	{
		super.destroy();
	}
}
