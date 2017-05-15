package whut.inis.show.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ����������ñ�������Ϣ��������������Ϣת��ҳ��
 */
public class ForwardServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * ���캯��
	 */
	public ForwardServlet()
	{
		super();
	}
	
	/**
	 * ��ʼ��
	 */
	public void init() throws ServletException
	{}
	
	/**
	 * doGet()����
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request, response);
	}
	
	/**
	 * doPost()����
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
	 * ����
	 */
	public void destroy()
	{
		super.destroy();
	}
}
