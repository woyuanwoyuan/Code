package whut.inis.show.dao;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;









import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import whut.inis.show.po.InisInfo;
import whut.inis.show.po.IntroductionInfo;
import whut.inis.show.po.LunWenInfo;
import whut.inis.show.po.ShareSpaceInfo;
import whut.inis.show.util.DBConnUtil;


public class ShareSpaceDao {
	public ShareSpaceDao(){
		
	}
	
	private static ShareSpaceDao dao = new ShareSpaceDao();
	
	public static ShareSpaceDao getInstance(){
		return dao;
	}
		
	// 获得所有的说说信息
	public ArrayList<ShareSpaceInfo> getAllShareInfo( int start,int size) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<ShareSpaceInfo> list = new ArrayList<ShareSpaceInfo>(); // 商品集合
		try {
			conn = DBConnUtil.getConn();
			String sql = "select * from sharespace order by publishtime desc limit ?,? ;"; // SQL语句
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, start);
			stmt .setInt(2, size);
			rs = stmt.executeQuery();
		
			while (rs.next()) {
				ShareSpaceInfo shareinfo = new ShareSpaceInfo();
				shareinfo.setId(rs.getInt("id"));
				shareinfo.setUsername(rs.getString("username"));
				DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				shareinfo.setPublishtime(sdf.format(rs.getTimestamp("publishtime")));
				shareinfo.setContent(rs.getString("content"));
				shareinfo.setPurl(rs.getString("purl"));
				shareinfo.setPicnum(rs.getInt("picnum"));
				list.add(shareinfo);// 把一个说说加入集合
			}
			return list; // 返回集合。
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		} finally {
			// 释放数据集对象
			if (rs != null) {
				try {
					rs.close();
					rs = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			// 释放语句对象
			if (stmt != null) {
				try {
					stmt.close();
					stmt = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}
	
	
	// 根据用户名获取他的所有说说
		public ArrayList<ShareSpaceInfo> getAllShareInfoByUsername( int start,int size,String username) {
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			ArrayList<ShareSpaceInfo> list = new ArrayList<ShareSpaceInfo>(); // 商品集合
			try {
				conn = DBConnUtil.getConn();
				String sql = "select * from sharespace where username='"+ username+"'order by publishtime desc limit ?,? ;"; // SQL语句
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, start);
				stmt .setInt(2, size);
				rs = stmt.executeQuery();
			
				while (rs.next()) {
					ShareSpaceInfo shareinfo = new ShareSpaceInfo();
					shareinfo.setId(rs.getInt("id"));
					shareinfo.setUsername(rs.getString("username"));
					DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
					shareinfo.setPublishtime(sdf.format(rs.getTimestamp("publishtime")));
					shareinfo.setContent(rs.getString("content"));
					shareinfo.setPurl(rs.getString("purl"));
					shareinfo.setPicnum(rs.getInt("picnum"));
					list.add(shareinfo);// 把一个说说加入集合
				}
				return list; // 返回集合。
			} catch (Exception ex) {
				ex.printStackTrace();
				return null;
			} finally {
				// 释放数据集对象
				if (rs != null) {
					try {
						rs.close();
						rs = null;
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
				// 释放语句对象
				if (stmt != null) {
					try {
						stmt.close();
						stmt = null;
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
		}
	
	
	// 获得所有的论文信息
		public ArrayList<LunWenInfo> getAllLunWenInfo( int start,int size,String tiaojian) {
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			ArrayList<LunWenInfo> list = new ArrayList<LunWenInfo>(); // 商品集合
			try {
				conn = DBConnUtil.getConn();
				String sql=null;
				if(tiaojian.equals("all")){
				sql = "select * from lunwen order by publishtime desc limit ?,? ;"; // SQL语句
				
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, start);
				stmt .setInt(2, size);
				}else{
				
					sql = "select * from lunwen where (timu like '%"+tiaojian+"%') or (author like '%"+tiaojian     +"%')  order by publishtime desc limit ?,? ;"; // SQL语句
					stmt = conn.prepareStatement(sql);
				
				
					stmt.setInt(1, start);
					stmt .setInt(2, size);
				}
				rs = stmt.executeQuery();
			
				while (rs.next()) {
					LunWenInfo shareinfo = new LunWenInfo();
					shareinfo.setId(rs.getInt("id"));
					shareinfo.setLeibie(rs.getString("leibie"));
					shareinfo.setTimu(rs.getString("timu"));
					shareinfo.setAuthor(rs.getString("author"));
					DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
					shareinfo.setPublishtime(sdf.format(rs.getTimestamp("publishtime")));
					shareinfo.setUploadtime(sdf.format(rs.getTimestamp("uploadtime")));
					shareinfo.setBeizhu(rs.getString("beizhu"));
					shareinfo.setFilename(rs.getString("filename"));
					shareinfo.setFlieurl(rs.getString("fileurl"));
					shareinfo.setGongkai(rs.getString("gongkai"));
					list.add(shareinfo);// 把一个说说加入集合
				}
				return list; // 返回集合。
			} catch (Exception ex) {
				ex.printStackTrace();
				return null;
			} finally {
				// 释放数据集对象
				if (rs != null) {
					try {
						rs.close();
						rs = null;
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
				// 释放语句对象
				if (stmt != null) {
					try {
						stmt.close();
						stmt = null;
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
		}
	
		// 获得所有的论文信息
				public ArrayList<IntroductionInfo> getAllFamilyInfo() {
					Connection conn = null;
					PreparedStatement stmt = null;
					ResultSet rs = null;
					ArrayList<IntroductionInfo> list = new ArrayList<IntroductionInfo>(); // 商品集合
					try {
						conn = DBConnUtil.getConn();
						String sql=null;
					
						
							sql = "select * from introduction   order by startyear "; // SQL语句
							stmt = conn.prepareStatement(sql);
						
						
						rs = stmt.executeQuery();
					
						while (rs.next()) {
							IntroductionInfo info = new IntroductionInfo();
							info.setUname(rs.getString("uname"));
							info.setFileurl(rs.getString("fileurl"));
							info.setStartyear(rs.getString("startyear"));
							info.setXuewei(rs.getString("xuewei"));
							list.add(info);// 把一个说说加入集合
						}
						return list; // 返回集合。
					} catch (Exception ex) {
						ex.printStackTrace();
						return null;
					} finally {
						// 释放数据集对象
						if (rs != null) {
							try {
								rs.close();
								rs = null;
							} catch (Exception ex) {
								ex.printStackTrace();
							}
						}
						// 释放语句对象
						if (stmt != null) {
							try {
								stmt.close();
								stmt = null;
							} catch (Exception ex) {
								ex.printStackTrace();
							}
						}
					}
				}
		
		
	//查询说说数据的总数
	public int getShuoShuoByPag(){
		int total = 0;
		String sql = "select count(id) from  sharespace";
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
	
	//根据用户名查询该用户说说数据的总数
		public int getShuoShuoByPag(String username){
			int total = 0;
			String sql = "select count(id) from  sharespace where username='"+username+"'";
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
		
	
	
	
	//查询论文数据的总数
	public int getLunWenByPag(String tiaojian){
		int total = 0;
		String sql = null;
		
		if(tiaojian.equals("all")){
			sql = "select count(id) from  lunwen";
			}else{
			
				sql = "select  count(id) from lunwen where (timu like '%"+tiaojian+"%') or (author like '%"+tiaojian+"%') "; // SQL语句

			}
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
	//获取首页的最新说说
	public ArrayList<ShareSpaceInfo> findIndexshoushuo()
			{
	//	String videoatt = request.getParameter("att");
		
		
	    ShareSpaceDao shareDao = new ShareSpaceDao(); 
     
		
		
	//	int rowCount = ShareSpaceDao.getInstance().getShuoShuoByPag();
	//	System.out.println(rowCount);
		//PageUtil page =  new PageUtil(Constants.PAGE_SIZE, num, rowCount);
	//	request.setAttribute("page", page);
		//List<VideoInfo> videolist = new ArrayList<VideoInfo>();
		 // ArrayList<ShareSpaceInfo> shuoshuolist = shareDao.getAllShareInfo(page.getStartRow(), page.getSize());
		  ArrayList<ShareSpaceInfo> shuoshuolist = shareDao.getAllShareInfo(0, 8);
		  System.out.println(shuoshuolist.get(0).getUsername());
		//request.setAttribute("videoatt", videoatt);
		//request.setAttribute("shuoshuolist", shuoshuolist);
		
		return shuoshuolist;
		/*
		 * 将浏览次数加一
		 */
		 
		//CommonsUtil.forward("../bootstrap-fileinput-master/index.jsp", request, response);
	}
	
	//获取首页的最新论文
		public ArrayList<LunWenInfo> findIndexlunwen()
				{
		//	String videoatt = request.getParameter("att");
			
			
		    ShareSpaceDao shareDao = new ShareSpaceDao(); 
	     
			
			
		//	int rowCount = ShareSpaceDao.getInstance().getShuoShuoByPag();
		//	System.out.println(rowCount);
			//PageUtil page =  new PageUtil(Constants.PAGE_SIZE, num, rowCount);
		//	request.setAttribute("page", page);
			//List<VideoInfo> videolist = new ArrayList<VideoInfo>();
			 // ArrayList<ShareSpaceInfo> shuoshuolist = shareDao.getAllShareInfo(page.getStartRow(), page.getSize());
			  ArrayList<LunWenInfo> lunwenlist = shareDao.getAllLunWenInfo(0, 5, "all");
			  System.out.println(lunwenlist.get(0).getTimu());
			//request.setAttribute("videoatt", videoatt);
			//request.setAttribute("shuoshuolist", shuoshuolist);
			
			return lunwenlist;
			/*
			 * 将浏览次数加一
			 */
			 
			//CommonsUtil.forward("../bootstrap-fileinput-master/index.jsp", request, response);
		}
	
		
		//获取首页的成员信息
				public ArrayList<IntroductionInfo> findIndexIntroduction()
						{
				//	String videoatt = request.getParameter("att");
					
					
				    ShareSpaceDao shareDao = new ShareSpaceDao(); 
			     
					
					
				//	int rowCount = ShareSpaceDao.getInstance().getShuoShuoByPag();
				//	System.out.println(rowCount);
					//PageUtil page =  new PageUtil(Constants.PAGE_SIZE, num, rowCount);
				//	request.setAttribute("page", page);
					//List<VideoInfo> videolist = new ArrayList<VideoInfo>();
					 // ArrayList<ShareSpaceInfo> shuoshuolist = shareDao.getAllShareInfo(page.getStartRow(), page.getSize());
					  ArrayList<IntroductionInfo> introductionlist = shareDao.getAllFamilyInfo();
					
					//request.setAttribute("videoatt", videoatt);
					//request.setAttribute("shuoshuolist", shuoshuolist);
					
					return introductionlist;
					/*
					 * 将浏览次数加一
					 */
					 
					//CommonsUtil.forward("../bootstrap-fileinput-master/index.jsp", request, response);
				}
			
				
				
				
			
				
		
		//查询该用户是否已编辑过introduction
		public boolean IsexistIntroduction(IntroductionInfo info) throws UnsupportedEncodingException{
			int total = 0;
			String sql = "select count(id) from  introduction where uname='"+info.getUname()+"'";
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			boolean name=false;
			
			try {
				conn = DBConnUtil.getConn();
				ps = conn.prepareStatement(sql);
		
				
				rs = ps.executeQuery();
				while (rs.next()) {
					total = rs.getInt(1);
					if(total>=1){
					name=true;
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBConnUtil.closeAll(rs, ps, conn);
			}
			
			return name;
		}
		
		
		
		
		//判断数据库中是否有此人的个人介绍
				public boolean IsexistIntroduction2(String uname) throws UnsupportedEncodingException{
					int total = 0;
					String sql = "select count(id) from  introduction where uname='"+uname+"' or username='"+uname+"'";
					Connection conn = null;
					PreparedStatement ps = null;
					ResultSet rs = null;
					boolean name=false;
					
					try {
						conn = DBConnUtil.getConn();
						ps = conn.prepareStatement(sql);
				
						
						rs = ps.executeQuery();
						while (rs.next()) {
							total = rs.getInt(1);
							if(total>=1){
							name=true;
							}
						}
					} catch (SQLException e) {
						e.printStackTrace();
					} finally {
						DBConnUtil.closeAll(rs, ps, conn);
					}
					
					return name;
				}
		
		
		// 获得个人信息
		public IntroductionInfo getintroductionInfo(String uname) {
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			IntroductionInfo info = new IntroductionInfo();
			try {
				conn = DBConnUtil.getConn();
				String sql = "select * from introduction  where uname='"+uname+"' or username='"+uname+"'"; // SQL语句
				stmt = conn.prepareStatement(sql);
			//	stmt.setInt(1, start);
			//	stmt .setInt(2, size);
				rs = stmt.executeQuery();
			
				while (rs.next()) {
					info.setUsername(rs.getString("username"));
					info.setUname(rs.getString("uname"));
					info.setXingbie(rs.getString("xingbie"));
					info.setXuewei(rs.getString("xuewei"));
					info.setStartyear(rs.getString("startyear"));
					info.setBirthday(rs.getString("birthday"));
					info.setAddress(rs.getString("address"));
					info.setEmail(rs.getString("email"));
					info.setTel(rs.getString("tel"));
					info.setFilename(rs.getString("filename"));
					info.setFileurl(rs.getString("fileurl"));
				
				}
				return info; // 返回
			} catch (Exception ex) {
				ex.printStackTrace();
				return null;
			} finally {
				// 释放数据集对象
				if (rs != null) {
					try {
						rs.close();
						rs = null;
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
				// 释放语句对象
				if (stmt != null) {
					try {
						stmt.close();
						stmt = null;
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
		}
		
		// 获得所有的论文信息
		public InisInfo getInisInfo() {
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
		InisInfo info=new InisInfo();
			try {
				conn = DBConnUtil.getConn();
				String sql=null;
			
				
					sql = "select * from jianjie   where name='inis'"; // SQL语句
					stmt = conn.prepareStatement(sql);
				
				
				rs = stmt.executeQuery();
			
				while (rs.next()) {
				
					info.setJianjie(rs.getString("jianjie"));
					info.setYanjiu1(rs.getString("yanjiu1"));
					info.setYanjiu2(rs.getString("yanjiu2"));
					info.setYanjiu3(rs.getString("yanjiu3"));
					info.setYanjiu4(rs.getString("yanjiu4"));
					info.setYanjiu5(rs.getString("yanjiu5"));
					
				
				}
				return info; // 返回集合。
			} catch (Exception ex) {
				ex.printStackTrace();
				return null;
			} finally {
				// 释放数据集对象
				if (rs != null) {
					try {
						rs.close();
						rs = null;
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
				// 释放语句对象
				if (stmt != null) {
					try {
						stmt.close();
						stmt = null;
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
		}

}
