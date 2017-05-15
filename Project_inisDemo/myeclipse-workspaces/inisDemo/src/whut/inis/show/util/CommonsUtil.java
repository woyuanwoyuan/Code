package whut.inis.show.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommonsUtil {
	/**
	 * @param path:跳转的路径url  为jsp或者是servlet在web.xml文件中对应的url-pattern
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public static void forward(String path,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		request.getRequestDispatcher(path).forward(request, response);
		return;
	}
	
	/**
	 * @param response 
	 * @param content 指的是输出给页面用的javascript中的代码
	 * @throws IOException
	 */
	public static void outByPrintWriter(HttpServletResponse response , String content) throws IOException{
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		StringBuilder str = new StringBuilder();
		str.append("<script type='text/javascript'>");
		str.append(content);
		str.append("</script>");
		out.println(str.toString());
		out.flush();
		out.close();
	}
}
