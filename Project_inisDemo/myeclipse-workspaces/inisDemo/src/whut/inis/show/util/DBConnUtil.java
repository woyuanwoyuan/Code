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
 *	��ʵ�ʿ���������  �û���Ӧ�Ŀ��Ըı��һЩ������Ϣ �������ݿ��������Ϣ  �����������������Ϣ��
 *		��ʱ�����������Ϣ�ŵ�java���б���  ���û��ǲ������޸ĵ�   Ŀ����Ϊ�����û����������޸���Ӧ����Ϣ
 *			�������������Ӧ��������Ϣ ���浽һЩ�û����Խ����޸ĵ��ļ���  �������ڳ�ʼ��ʱȥ��ȡ���ļ� ��ȡ�û���������Ϣ����
 *			����properties�ļ����б������ݿ��������Ϣ
 *		
 */
public class DBConnUtil {
	
	private static String jdbcDriver = "";	
	private static String jdbcUrl = "";	
	private static String jdbcUser = "";	
	private static String jdbcPasswd = "";
	
	static {
		/**
		 * �ڳ������ʱֻ��Ҫ��ȡ�����ļ�һ��  �������ļ������ݿ�������Ϣ  ��Ӧ�ĸ�������ı�������
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
	
	//�������ݿ���������
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
	
	//�ر����ݿ�����
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
