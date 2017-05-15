package whut.inis.show.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author Administrator
 *	在实际开发过程中  用户相应的可以改变的一些配置信息 比如数据库的连接信息  邮箱服务器的配置信息等
 *		此时如果将配置信息放到java类中保存  则用户是不可以修改的   目的是为了让用户可以自行修改相应的信息
 *			解决方案：将对应的配置信息 保存到一些用户可以进行修改的文件中  而代码在初始化时去读取该文件 获取用户的配置信息即可
 *			利用properties文件进行保存数据库的配置信息
 *		
 */
public class DBConnUtil {
	
	private static String jdbcDriver = "";	
	private static String jdbcUrl = "";	
	private static String jdbcUser = "";	
	private static String jdbcPasswd = "";
	
	static {
		/**
		 * 在程序加载时只需要读取配置文件一次  将配置文件的数据库连接信息  对应的赋给上面的变量即可
		 */
		InputStream is = null;
		try {
			is = DBConnUtil.class.getClassLoader().getResourceAsStream("db.properties");
			Properties p = new Properties();
			p.load(is);
			jdbcDriver = p.getProperty("jdbcDriver");
			jdbcUrl = p.getProperty("jdbcUrl");
			jdbcUser = p.getProperty("jdbcUser");
			jdbcPasswd = p.getProperty("jdbcPasswd");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(is != null){
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	//加载数据库驱动程序
	public static Connection getConn(){
		Connection conn = null;
		try {
			Class.forName(jdbcDriver);
			conn = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPasswd);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	//关闭数据库连接
	public static void closeAll(ResultSet rs , PreparedStatement ps , Connection conn){
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(ps != null){
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void rollback(Connection conn){
		if(conn != null){
			try {
				conn.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println(DBConnUtil.getConn());
	}
}
