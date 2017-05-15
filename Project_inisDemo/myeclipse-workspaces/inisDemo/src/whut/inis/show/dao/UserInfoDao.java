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
	 * ����û�
	 * @param UserInfo �û�����
	 */
	public void regUser(UserInfo info){
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			// ��ȡ���ݿ�����Connection����
			conn = DBConnUtil.getConn();
			// �����û�ע����Ϣ��SQL���
			String sql = "insert into userinfo(username,passwd,email,role_id,isdel,url,regtime) values(?,?,?,?,?,?,now())";
			// ��ȡPreparedStatement����
			ps = conn.prepareStatement(sql);
			// ��SQL����ռλ���������ж�̬��ֵ
			ps.setString(1, info.getUsername());
			ps.setString(2, info.getPasswd());
			ps.setString(3, info.getEmail());
			ps.setInt(4, info.getRole_id());
			ps.setInt(5, info.getIsdel());
			ps.setString(6, info.getUrl());
			// ִ�и��²���
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnUtil.closeAll(null, ps, conn);
		}
		
	}
	/**
	 * �û���¼
	 * @param username �û���
	 * @param password ����
	 * @return �û�����
	 */
	public UserInfo login(String username, String passwd){
		UserInfo user = null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		// ��ȡ���ݿ�����Connection����
		Connection conn = DBConnUtil.getConn();
		// �����û����������ѯ�û���Ϣ
		String sql = "select * from userinfo where username = ? and passwd = ?";
		try {
			// ��ȡPreparedStatement����
			ps= conn.prepareStatement(sql);
			// ��SQL����ռλ���������ж�̬��ֵ
			ps.setString(1, username);
			ps.setString(2, passwd);
			// ִ�в�ѯ��ȡ�����
			rs = ps.executeQuery();
			// �жϽ�����Ƿ���Ч
			if(rs.next()){
				// ʵ����һ���û�����
				user = new UserInfo();
				// ���û��������Ը�ֵ
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
			// �ر����ݿ�����
			DBConnUtil.closeAll(rs, ps, conn);
		}
		return user;
	}
	
	/**
	 * �û���¼
	 * @param username �û���
	 * @param password ����
	 * @return �û�����
	 */
	public UserInfo youkelogin(String youke){
		UserInfo user = null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		// ��ȡ���ݿ�����Connection����
		Connection conn = DBConnUtil.getConn();
		// �����û����������ѯ�û���Ϣ
		String sql = "select * from userinfo where username =?";
		try {
			// ��ȡPreparedStatement����
			ps= conn.prepareStatement(sql);
			// ��SQL����ռλ���������ж�̬��ֵ
			ps.setString(1, youke);
		
			// ִ�в�ѯ��ȡ�����
			rs = ps.executeQuery();
			// �жϽ�����Ƿ���Ч
			if(rs.next()){
				// ʵ����һ���û�����
				user = new UserInfo();
				// ���û��������Ը�ֵ
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
			// �ر����ݿ�����
			DBConnUtil.closeAll(rs, ps, conn);
		}
		return user;
	}
	
	/**
	 * �ж��û��������ݿ����Ƿ����
	 * @param username �û���
	 * @return ����ֵ
	 */
	public boolean userIsExist(String username){
		PreparedStatement ps=null;
		ResultSet rs = null;
		// ��ȡ���ݿ�����Connection����
		Connection conn = DBConnUtil.getConn();
		// ����ָ���û�����ѯ�û���Ϣ
		String sql = "select * from userinfo where username = ?";
		try {
			// ��ȡPreparedStatement����
			ps = conn.prepareStatement(sql);
			// ���û��������Ը�ֵ
			ps.setString(1, username);
			// ִ�в�ѯ��ȡ�����
			rs = ps.executeQuery();
			// �жϽ�����Ƿ���Ч
			if(!rs.next()){
				// �����Ч��֤�����û�������
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			// �ر����ݿ�����
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
