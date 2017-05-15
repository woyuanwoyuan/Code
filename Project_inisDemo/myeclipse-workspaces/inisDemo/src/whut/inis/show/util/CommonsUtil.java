package whut.inis.show.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommonsUtil {
	/**
	 * @param path:��ת��·��url  Ϊjsp������servlet��web.xml�ļ��ж�Ӧ��url-pattern
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
	 * @param content ָ���������ҳ���õ�javascript�еĴ���
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
