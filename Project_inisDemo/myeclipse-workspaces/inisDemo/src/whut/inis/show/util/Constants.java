package whut.inis.show.util;
/**
 * @author Administrator
 *	该类叫做常量类  用来保存项目中的一些常量的信息
 */
public class Constants {
	
	/*
	 * 登录成功时放到session作用域中保存用户信息的属性名
	 */
	public final static String SESSION_USER_INFO = "userinfo";
	
	
	
	/*
	 * 分页每页显示的条目数
	 */
	public final static int PAGE_SIZE = 5;
	
	
	
	/*
	 * 存放上传成功的成功文件的文件夹  用相对路径（建议放到发布项目的根目录下面）
	 */
	public final static String  REAL_DIRECTORY = "/upload";
	
	/*
	 * 每次上传分配的内容空间大小
	 * 	该值 与服务器的硬件设施(内存)成正比关系
	 * 			与同时上传的人数（一般是注册用户的人数）成反比关系
	 */
	public final static int UPLOAD_SIZE = 64*1024; 
}
