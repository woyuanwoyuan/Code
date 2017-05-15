package whut.inis.show.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;





import whut.inis.show.po.AlgInfo;
import whut.inis.show.po.UserInfo;
import whut.inis.show.util.DBConnUtil;

public class AlgInfoDao {
	public AlgInfoDao(){}
	private static AlgInfoDao dao = new AlgInfoDao();
	  	
	public static AlgInfoDao getInstance(){
	  		return dao;
	  	}
	/*
	 * 获取算法库内算法信息
	 */
	
	public List<AlgInfo> findTrackingAlgInfo(){
		List<AlgInfo> alglist = new ArrayList<AlgInfo>();
		AlgInfo info =null;
		String sql = "select * from alg where alg_type='tracking' and isdel=0";
		
		Connection conn = null;
		PreparedStatement ps = null; 
		ResultSet rs = null;
		
		try {
			conn = DBConnUtil.getConn();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				info = new AlgInfo();
				info.setAddtime(rs.getString("addtime"));
				info.setAlg_name(rs.getString("alg_name"));
				info.setAlg_type(rs.getString("alg_type"));
				info.setContent(rs.getString("content"));
				info.setId(rs.getInt("id"));
				info.setProvider(rs.getString("provider"));
				info.setIsdel(rs.getInt("isdel"));
				alglist.add(info);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnUtil.closeAll(rs, ps, conn);
		}
		return alglist;
	}
	public List<AlgInfo> findCheckingAlgInfo(){
		List<AlgInfo> algClist = new ArrayList<AlgInfo>();
		AlgInfo info =null;
		String sql = "select * from alg where alg_type='checking' and isdel=0";
		
		Connection conn = null;
		PreparedStatement ps = null; 
		ResultSet rs = null;
		
		try {
			conn = DBConnUtil.getConn();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				info = new AlgInfo();
				info.setAddtime(rs.getString("addtime"));
				info.setAlg_name(rs.getString("alg_name"));
				info.setAlg_type(rs.getString("alg_type"));
				info.setContent(rs.getString("content"));
				info.setId(rs.getInt("id"));
				info.setProvider(rs.getString("provider"));
				info.setIsdel(rs.getInt("isdel"));
				algClist.add(info);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnUtil.closeAll(rs, ps, conn);
		}
		return algClist;
	}
}
