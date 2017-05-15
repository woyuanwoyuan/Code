package whut.inis.show.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;




import whut.inis.show.po.UserInfo;
import whut.inis.show.util.DBConnUtil;

public class UserInfoDao {

	public UserInfoDao(){
		
	}
	
	private static UserInfoDao dao = new UserInfoDao();
	
	public static UserInfoDao getInstance(){
		return dao;
	}
	
	/**
	 * 添加用户
	 * @param UserInfo 用户对象
	 */
	public void regUser(UserInfo info){
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			// 获取数据库连接Connection对象
			conn = DBConnUtil.getConn();
			// 插入用户注册信息的SQL语句
			String sql = "insert into userinfo(username,passwd,email,role_id,isdel,url,regtime) values(?,?,?,?,?,?,now())";
			// 获取PreparedStatement对象
			ps = conn.prepareStatement(sql);
			// 对SQL语句的占位符参数进行动态赋值
			ps.setString(1, info.getUsername());
			ps.setString(2, info.getPasswd());
			ps.setString(3, info.getEmail());
			ps.setInt(4, info.getRole_id());
			ps.setInt(5, info.getIsdel());
			ps.setString(6, info.getUrl());
			// 执行更新操作
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnUtil.closeAll(null, ps, conn);
		}
		
	}
	/**
	 * 用户登录
	 * @param username 用户名
	 * @param password 密码
	 * @return 用户对象
	 */
	public UserInfo login(String username, String passwd){
		UserInfo user = null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		// 获取数据库连接Connection对象
		Connection conn = DBConnUtil.getConn();
		// 根据用户名及密码查询用户信息
		String sql = "select * from userinfo where username = ? and passwd = ?";
		try {
			// 获取PreparedStatement对象
			ps= conn.prepareStatement(sql);
			// 对SQL语句的占位符参数进行动态赋值
			ps.setString(1, username);
			ps.setString(2, passwd);
			// 执行查询获取结果集
			rs = ps.executeQuery();
			// 判断结果集是否有效
			if(rs.next()){
				// 实例化一个用户对象
				user = new UserInfo();
				// 对用户对象属性赋值
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPasswd(rs.getString("passwd"));
				user.setEmail(rs.getString("email"));
				user.setRole_id(rs.getInt("role_id"));
				user.setIsdel(rs.getInt("isdel"));
				user.setUrl(rs.getString("url"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			// 关闭数据库连接
			DBConnUtil.closeAll(rs, ps, conn);
		}
		return user;
	}
	
	/**
	 * 用户登录
	 * @param username 用户名
	 * @param password 密码
	 * @return 用户对象
	 */
	public UserInfo youkelogin(String youke){
		UserInfo user = null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		// 获取数据库连接Connection对象
		Connection conn = DBConnUtil.getConn();
		// 根据用户名及密码查询用户信息
		String sql = "select * from userinfo where username =?";
		try {
			// 获取PreparedStatement对象
			ps= conn.prepareStatement(sql);
			// 对SQL语句的占位符参数进行动态赋值
			ps.setString(1, youke);
		
			// 执行查询获取结果集
			rs = ps.executeQuery();
			// 判断结果集是否有效
			if(rs.next()){
				// 实例化一个用户对象
				user = new UserInfo();
				// 对用户对象属性赋值
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPasswd(rs.getString("passwd"));
				user.setEmail(rs.getString("email"));
				user.setRole_id(rs.getInt("role_id"));
				user.setIsdel(rs.getInt("isdel"));
				user.setUrl(rs.getString("url"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			// 关闭数据库连接
			DBConnUtil.closeAll(rs, ps, conn);
		}
		return user;
	}
	
	/**
	 * 判断用户名在数据库中是否存在
	 * @param username 用户名
	 * @return 布尔值
	 */
	public boolean userIsExist(String username){
		PreparedStatement ps=null;
		ResultSet rs = null;
		// 获取数据库连接Connection对象
		Connection conn = DBConnUtil.getConn();
		// 根据指定用户名查询用户信息
		String sql = "select * from userinfo where username = ?";
		try {
			// 获取PreparedStatement对象
			ps = conn.prepareStatement(sql);
			// 对用户对象属性赋值
			ps.setString(1, username);
			// 执行查询获取结果集
			rs = ps.executeQuery();
			// 判断结果集是否有效
			if(!rs.next()){
				// 如果无效则证明此用户名可用
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			// 关闭数据库连接
			DBConnUtil.closeAll(rs, ps, conn);
		}
		return false; 
	}
	
	public boolean deleteUserByID(int id){
		boolean flag = false;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "update userinfo set isdel=1 where id=?";
		
		try {
			conn = DBConnUtil.getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			if(i != 0){
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnUtil.closeAll(null, ps, conn);
		}
		return flag;
	}
	public boolean updateUserByID(int id){
		boolean flag = false;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "update userinfo set role_id=1 where id=?";
		
		try {
			conn = DBConnUtil.getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			if(i != 0){
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnUtil.closeAll(null, ps, conn);
		}
		return flag;
	}
	public boolean UserByIDdown(int id){
		boolean flag = false;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "update userinfo set role_id=2 where id=?";
		
		try {
			conn = DBConnUtil.getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			if(i != 0){
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnUtil.closeAll(null, ps, conn);
		}
		return flag;
	}
	public UserInfo getUserInfoByID(int id){
		UserInfo info = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from userinfo where id=?";
		try {
			conn = DBConnUtil.getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				info = new UserInfo();
				info.setUsername(rs.getString("username"));
				info.setPasswd(rs.getString("passwd"));
				info.setId(rs.getInt("id"));
				info.setRole_id(rs.getInt("role_id"));
				info.setIsdel(rs.getInt("isdel"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnUtil.closeAll(rs, ps, conn);
		}
		return info;
	}
	public List<UserInfo> getUserList( ){
		List<UserInfo> list = new ArrayList<UserInfo>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM userinfo where role_id in (1,2) and isdel=0;";
		
		try {
			conn = DBConnUtil.getConn();
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			while(rs.next()){
				UserInfo info = new UserInfo();
				info.setUsername(rs.getString("username"));
				info.setPasswd(rs.getString("passwd"));
				info.setId(rs.getInt("id"));
				info.setRole_id(rs.getInt("role_id"));
				info.setIsdel(rs.getInt("isdel"));
				info.setEmail(rs.getString("email"));
				info.setUrl(rs.getString("url"));
				info.setRegtime(rs.getString("regtime"));
				list.add(info);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			DBConnUtil.closeAll(rs, ps, conn);
		}
		
		
		return list;
	}
	public boolean checkOldPasswd(String oldPasswd , int id){
		boolean flag = false;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select id from userinfo where passwd=? and id=?";
		
		try {
			conn = DBConnUtil.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, oldPasswd);
			ps.setInt(2, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnUtil.closeAll(rs, ps, conn);
		}
		return flag;
	}
	
	public boolean modifyPasswdByID(String newpasswd,int id){
		boolean flag = false;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "update userinfo set passwd=? where id=?";
		try {
			conn = DBConnUtil.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, newpasswd);
			ps.setInt(2, id);
			int i = ps.executeUpdate();
			if(i != 0){
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnUtil.closeAll(null, ps, conn);
		}
		return flag;
	}
	
}
