package whut.inis.show.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;








import whut.inis.show.po.AlgInfo;
import whut.inis.show.po.UploadInfo;
import whut.inis.show.po.UserInfo;
import whut.inis.show.util.DBConnUtil;

public class UploadInfoDao {
	public UploadInfoDao(){}
	private static UploadInfoDao dao = new UploadInfoDao();
	  	
	public static UploadInfoDao getInstance(){
	  		return dao;
	  	}
	/*
	 * ��ȡ�㷨�����㷨��Ϣ
	 */
	public void addupload(UploadInfo info){
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			// ��ȡ���ݿ�����Connection����
			conn = DBConnUtil.getConn();
			// �����û�ע����Ϣ��SQL���
			String sql = "insert into uploadfile(username,filename,file_introduce,url,filepath,uploadtime) values(?,?,?,?,?,now())";
			// ��ȡPreparedStatement����
			ps = conn.prepareStatement(sql);
			// ��SQL����ռλ���������ж�̬��ֵ
			ps.setString(1, info.getUsername());
			ps.setString(2, info.getFilename());
			ps.setString(3, info.getFile_introduce());
			ps.setString(4, info.getUrl());
			ps.setString(5, info.getFilepath());
			
			// ִ�и��²���
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnUtil.closeAll(null, ps, conn);
		}
		
	}
	public UploadInfo getUserInfoByID(int id){
		UploadInfo info = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from uploadfile where id=?";
		try {
			conn = DBConnUtil.getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				info = new UploadInfo();
				info.setUsername(rs.getString("username"));
				info.setFilename(rs.getString("filename"));
				info.setId(rs.getInt("id"));
				info.setFile_introduce(rs.getString("file_introduce"));
				info.setUploadtime(rs.getString("uploadtime"));
				info.setFilepath(rs.getString("filepath"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnUtil.closeAll(rs, ps, conn);
		}
		return info;
	}
	public List<UploadInfo> getUploadList( ){
		List<UploadInfo> list = new ArrayList<UploadInfo>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM uploadfile ;";
		
		try {
			conn = DBConnUtil.getConn();
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			while(rs.next()){
				UploadInfo info = new UploadInfo();
				
				info.setUsername(rs.getString("username"));
				info.setFilename(rs.getString("filename"));
				info.setId(rs.getInt("id"));
				info.setFile_introduce(rs.getString("file_introduce"));
				info.setUploadtime(rs.getString("uploadtime"));
				info.setUrl(rs.getString("url"));
				info.setFilepath(rs.getString("filepath"));
				list.add(info);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			DBConnUtil.closeAll(rs, ps, conn);
		}
		
		
		return list;
	}
}