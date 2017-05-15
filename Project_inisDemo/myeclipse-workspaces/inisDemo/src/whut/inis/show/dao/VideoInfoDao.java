package whut.inis.show.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import whut.inis.show.po.UserInfo;
import whut.inis.show.po.VideoInfo;
import whut.inis.show.util.DBConnUtil;

public class VideoInfoDao {
      public VideoInfoDao(){
		
	}
      private static VideoInfoDao dao = new VideoInfoDao();
  	
  	public static VideoInfoDao getInstance(){
  		return dao;
  	}    
  	public VideoInfo FindInfoByVideoname( String videoname){
		VideoInfo video = null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		// ��ȡ���ݿ�����Connection����
		Connection conn = DBConnUtil.getConn();
		// �����û����������ѯ�û���Ϣ
		String sql = "select * from tracking_lib where videoname=?";
		try {
			// ��ȡPreparedStatement����
			ps= conn.prepareStatement(sql);
			// ��SQL����ռλ���������ж�̬��ֵ
			ps.setString(1, videoname);
			//ps.setString(2, file_path);
			// ִ�в�ѯ��ȡ�����
			rs = ps.executeQuery();
			// �жϽ�����Ƿ���Ч
			if(rs.next()){
				// ʵ����һ���û�����
				video = new VideoInfo();
				// ���û��������Ը�ֵ
				video.setId(rs.getInt("id"));
				video.setVideoname(rs.getString("videoname"));
				video.setUrl(rs.getString("url"));
				video.setFile_path(rs.getString("file_path"));
				video.setGroundtruth(rs.getString("groundtruth"));
				video.setAddtime(rs.getString("addtime"));
				video.setProvider(rs.getString("provider"));
				video.setCode(rs.getString("code"));
				video.setCout(rs.getInt("cout"));
				video.setDownloadcount(rs.getInt("downloadcount"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			// �ر����ݿ�����
			DBConnUtil.closeAll(rs, ps, conn);
		}
		return video;
	}
	public VideoInfo FindcheckInfoByVideoname( String videoname){
		VideoInfo video = null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		// ��ȡ���ݿ�����Connection����
		Connection conn = DBConnUtil.getConn();
		// �����û����������ѯ�û���Ϣ
		String sql = "select * from shipdecdata where videoname=?";
		try {
			// ��ȡPreparedStatement����
			ps= conn.prepareStatement(sql);
			// ��SQL����ռλ���������ж�̬��ֵ
			ps.setString(1, videoname);
			//ps.setString(2, file_path);
			// ִ�в�ѯ��ȡ�����
			rs = ps.executeQuery();
			// �жϽ�����Ƿ���Ч
			if(rs.next()){
				// ʵ����һ���û�����
				video = new VideoInfo();
				// ���û��������Ը�ֵ
				video.setId(rs.getInt("id"));
				video.setVideoname(rs.getString("videoname"));
				video.setUrl(rs.getString("url"));
				video.setFile_path(rs.getString("file_path"));
				video.setGroundtruth(rs.getString("groundtruth"));
				video.setAddtime(rs.getString("addtime"));
				video.setProvider(rs.getString("provider"));
				video.setCode(rs.getString("code"));
				video.setCout(rs.getInt("cout"));
				video.setDownloadcount(rs.getInt("downloadcount"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			// �ر����ݿ�����
			DBConnUtil.closeAll(rs, ps, conn);
		}
		return video;
	}
  	
  	public List<VideoInfo> findInfoListByVideoatt(String videoatt, int start,int size){
  		List<VideoInfo> list = new ArrayList<VideoInfo>();
  		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM tracking_lib where code like '%"+videoatt+"%' order by id asc limit ?,?  ";
		
		try {
			conn = DBConnUtil.getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, size);
			rs = ps.executeQuery();
			while(rs.next()){
				// ʵ����һ���û�����
				VideoInfo video = new VideoInfo();
				// ���û��������Ը�ֵ
				video.setId(rs.getInt("id"));
				video.setVideoname(rs.getString("videoname"));
				video.setUrl(rs.getString("url"));
				video.setFile_path(rs.getString("file_path"));
				video.setGroundtruth(rs.getString("groundtruth"));
				video.setAddtime(rs.getString("addtime"));
				video.setProvider(rs.getString("provider"));
				video.setCode(rs.getString("code"));
				video.setCout(rs.getInt("cout"));
				video.setDownloadcount(rs.getInt("downloadcount"));
				list.add(video);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			DBConnUtil.closeAll(rs, ps, conn);
		}
  		return list;
  	}
  	public int getVideoByPag(String videoatt){
		int total = 0;
		String sql = "select count(id) from tracking_lib where code like '%"+videoatt+"%'; ";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = DBConnUtil.getConn();
			ps = conn.prepareStatement(sql);
	
			
			rs = ps.executeQuery();
			while (rs.next()) {
				total = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnUtil.closeAll(rs, ps, conn);
		}
		
		return total;
	}
  	public boolean addCountByvideoname(String videoname){
		boolean flag = false;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "update tracking_lib set cout=cout+1 where videoname=?";
		try {
			conn = DBConnUtil.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, videoname);
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

	public boolean addDownloadCountByvideoname(String videoname){
		boolean flag = false;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "update tracking_lib set downloadcount=downloadcount+1 where videoname=?";
		try {
			conn = DBConnUtil.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, videoname);
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
  	
	public List<VideoInfo> findcheckInfoListByVideoatt(String videoatt, int start,int size){
  		List<VideoInfo> list = new ArrayList<VideoInfo>();
  		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM shipdecdata where code like '%"+videoatt+"%' order by id asc limit ?,?  ";
		
		try {
			conn = DBConnUtil.getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, size);
			rs = ps.executeQuery();
			while(rs.next()){
				// ʵ����һ���û�����
				VideoInfo video = new VideoInfo();
				// ���û��������Ը�ֵ
				video.setId(rs.getInt("id"));
				video.setVideoname(rs.getString("videoname"));
				video.setUrl(rs.getString("url"));
				video.setFile_path(rs.getString("file_path"));
				video.setGroundtruth(rs.getString("groundtruth"));
				video.setAddtime(rs.getString("addtime"));
				video.setProvider(rs.getString("provider"));
				video.setCode(rs.getString("code"));
				video.setCout(rs.getInt("cout"));
				video.setDownloadcount(rs.getInt("downloadcount"));
				list.add(video);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			DBConnUtil.closeAll(rs, ps, conn);
		}
  		return list;
  	}
  	public int getcheckVideoByPag(String videoatt){
		int total = 0;
		String sql = "select count(id) from shipdecdata where code like '%"+videoatt+"%'; ";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = DBConnUtil.getConn();
			ps = conn.prepareStatement(sql);
	
			
			rs = ps.executeQuery();
			while (rs.next()) {
				total = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnUtil.closeAll(rs, ps, conn);
		}
		
		return total;
	}
  	public boolean addcheckCountByvideoname(String videoname){
		boolean flag = false;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "update shipdecdata set cout=cout+1 where videoname=?";
		try {
			conn = DBConnUtil.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, videoname);
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

	public boolean addcheckDownloadCountByvideoname(String videoname){
		boolean flag = false;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "update shipdecdata set downloadcount=downloadcount+1 where videoname=?";
		try {
			conn = DBConnUtil.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, videoname);
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
