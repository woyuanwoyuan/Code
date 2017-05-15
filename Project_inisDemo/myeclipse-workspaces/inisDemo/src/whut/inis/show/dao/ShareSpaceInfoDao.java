package whut.inis.show.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import whut.inis.show.po.InisInfo;
import whut.inis.show.po.IntroductionInfo;
import whut.inis.show.po.LunWenInfo;
import whut.inis.show.po.ShareSpaceInfo;
import whut.inis.show.po.UserInfo;
import whut.inis.show.util.DBConnUtil;

public class ShareSpaceInfoDao {
	public ShareSpaceInfoDao(){
		
	}
	
	private static ShareSpaceInfoDao dao = new ShareSpaceInfoDao();
	
	public static ShareSpaceInfoDao getInstance(){
		return dao;
	}
	

	/**
	 * 发表说说
	 * @param ShareSpaceInfo 说说对象
	 */
	public void pubShare(ShareSpaceInfo info){
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			// 获取数据库连接Connection对象
			conn = DBConnUtil.getConn();
			// 插入用户注册信息的SQL语句
			String sql = "insert into sharespace(username,content,purl,picnum,publishtime) values(?,?,?,?,now())";
			// 获取PreparedStatement对象
			ps = conn.prepareStatement(sql);
			// 对SQL语句的占位符参数进行动态赋值
			ps.setString(1, info.getUsername());
			ps.setString(2, info.getContent());
			ps.setString(3, info.getPurl());
			ps.setInt(4, info.getPicnum());
	
			// 执行更新操作
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnUtil.closeAll(null, ps, conn);
		}
		
	}
	
	/**
	 * 发表说说
	 * @param ShareSpaceInfo 说说对象
	 */
	public void pubLunwen(LunWenInfo info){
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			// 获取数据库连接Connection对象
			conn = DBConnUtil.getConn();
			// 插入用户注册信息的SQL语句
			String sql = "insert into lunwen(timu,author,beizhu,filename,fileurl,publishtime,uploadtime,leibie,gongkai) values(?,?,?,?,?,?,now(),?,?)";
			// 获取PreparedStatement对象
			ps = conn.prepareStatement(sql);
			// 对SQL语句的占位符参数进行动态赋值
			ps.setString(1, info.getTimu());
			ps.setString(2, info.getAuthor());
			ps.setString(3, info.getBeizhu());
			ps.setString(4, info.getFilename());
			ps.setString(5, info.getFlieurl());
			ps.setString(6, info.getUploadtime());
			ps.setString(7, info.getLeibie());
			ps.setString(8, info.getGongkai());
			// 执行更新操作
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnUtil.closeAll(null, ps, conn);
		}
		
	}
	
	/**
	 * 编辑inis简介
	 * @param ShareSpaceInfo 说说对象
	 */
	public void pubBianjiJianjie(InisInfo info){
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			// 获取数据库连接Connection对象
			conn = DBConnUtil.getConn();
			// 插入用户注册信息的SQL语句
			String sql ="update jianjie  SET jianjie='"+info.getJianjie()+"',yanjiu1='"+info.getYanjiu1()
					+"',yanjiu2='"+info.getYanjiu2()+"',yanjiu3='"+info.getYanjiu3()+"',yanjiu4='"+info.getYanjiu4()+"',yanjiu5='"+info.getYanjiu5()+"' where name='inis'";
			// 获取PreparedStatement对象
			ps = conn.prepareStatement(sql);
			// 对SQL语句的占位符参数进行动态赋值
		
			// 执行更新操作
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnUtil.closeAll(null, ps, conn);
		}
		
	}
	/**
	 *编辑introduction
	 * @param ShareSpaceInfo 说说对象
	 */
	public void bianjiIntroduction(IntroductionInfo info){
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			// 获取数据库连接Connection对象
			conn = DBConnUtil.getConn();
			// 插入用户注册信息的SQL语句
//			String sql = "if exists (select * from introduction where uname='"+info.getUname()+"')"
//					+ " Begin"
//					+ " update introduction  SET uname='"+info.getUname()+"',xingbie='"+info.getXingbie()+"',xuewei='"+info.getXuewei()+"',birthday='"+info.getBirthday()
//					+"',address='"+info.getAddress()+"',email='"+info.getEmail()+"',beizhu='"+info.getBeizhu()+"',filename='"+info.getFilename()+"',fileurl='"+info.getFileurl()
//					+"',tel='"+info.getTel()+"' where uname='"+info.getUname()+"'; "
//					+ " end "
//					+ " else"
//					+ " begin"
//					+ " insert into introduction(uname,xingbie,xuewei,birthday,address,email,beizhu,tel,filename,fileurl) values(?,?,?,?,?,?,?,?,?,?)"
//					+ " end";// SQL语句
			String sql = "insert into introduction(uname,xingbie,xuewei,startyear,birthday,address,email,beizhu,tel,filename,fileurl,username) values(?,?,?,?,?,?,?,?,?,?,?,?)";
	
			// 获取PreparedStatement对象
			ps = conn.prepareStatement(sql);
			// 对SQL语句的占位符参数进行动态赋值
			System.out.println("shuju");
			System.out.println(info.getUname());
			System.out.println(info.getXingbie());
			System.out.println(info.getXuewei());
			System.out.println(info.getBirthday());
			System.out.println(info.getAddress());
			System.out.println(info.getEmail());
			System.out.println(info.getBeizhu());
			System.out.println(info.getTel());
			System.out.println(info.getUsername());
			ps.setString(1, info.getUname());
			ps.setString(2, info.getXingbie());
			ps.setString(3, info.getXuewei());
			ps.setString(4, info.getStartyear());
			ps.setString(5, info.getBirthday());
			ps.setString(6, info.getAddress());
			ps.setString(7, info.getEmail());
			ps.setString(8, info.getBeizhu());
			ps.setString(9, info.getTel());
			ps.setString(10, info.getFilename());
			ps.setString(11, info.getFileurl());
			ps.setString(12, info.getUsername());
			// 执行更新操作
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnUtil.closeAll(null, ps, conn);
		}
		
	}
	

	
	/**
	 *更新introduction
	 * @param ShareSpaceInfo 说说对象
	 */
	public void updateIntroduction(IntroductionInfo info){
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			// 获取数据库连接Connection对象
			conn = DBConnUtil.getConn();
			// 插入用户注册信息的SQL语句
//			String sql = "if exists (select * from introduction where uname='"+info.getUname()+"')"
//					+ " Begin"
//					+ " update introduction  SET uname='"+info.getUname()+"',xingbie='"+info.getXingbie()+"',xuewei='"+info.getXuewei()+"',birthday='"+info.getBirthday()
//					+"',address='"+info.getAddress()+"',email='"+info.getEmail()+"',beizhu='"+info.getBeizhu()+"',filename='"+info.getFilename()+"',fileurl='"+info.getFileurl()
//					+"',tel='"+info.getTel()+"' where uname='"+info.getUname()+"'; "
//					+ " end "
//					+ " else"
//					+ " begin"
//					+ " insert into introduction(uname,xingbie,xuewei,birthday,address,email,beizhu,tel,filename,fileurl) values(?,?,?,?,?,?,?,?,?,?)"
//					+ " end";// SQL语句
			String sql ="update introduction  SET uname='"+info.getUname()+"',xingbie='"+info.getXingbie()+"',xuewei='"+info.getXuewei()+"',startyear='"+info.getStartyear()+info.getXuewei()+"',birthday='"+info.getBirthday()
				+"',address='"+info.getAddress()+"',email='"+info.getEmail()+"',beizhu='"+info.getBeizhu()+"',filename='"+info.getFilename()+"',fileurl='"+info.getFileurl()
				+"',tel='"+info.getTel()+"' where uname='"+info.getUname()+"'";
	
			// 获取PreparedStatement对象
			ps = conn.prepareStatement(sql);
			// 对SQL语句的占位符参数进行动态赋值

			
		
			// 执行更新操作
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnUtil.closeAll(null, ps, conn);
		}
		
	}
	

	/**
	 *更新introduction无图片
	 * @param ShareSpaceInfo 说说对象
	 */
	public void updateIntroductionWithoutPic(IntroductionInfo info){
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			// 获取数据库连接Connection对象
			conn = DBConnUtil.getConn();
			// 插入用户注册信息的SQL语句
//			String sql = "if exists (select * from introduction where uname='"+info.getUname()+"')"
//					+ " Begin"
//					+ " update introduction  SET uname='"+info.getUname()+"',xingbie='"+info.getXingbie()+"',xuewei='"+info.getXuewei()+"',birthday='"+info.getBirthday()
//					+"',address='"+info.getAddress()+"',email='"+info.getEmail()+"',beizhu='"+info.getBeizhu()+"',filename='"+info.getFilename()+"',fileurl='"+info.getFileurl()
//					+"',tel='"+info.getTel()+"' where uname='"+info.getUname()+"'; "
//					+ " end "
//					+ " else"
//					+ " begin"
//					+ " insert into introduction(uname,xingbie,xuewei,birthday,address,email,beizhu,tel,filename,fileurl) values(?,?,?,?,?,?,?,?,?,?)"
//					+ " end";// SQL语句
			String sql ="update introduction  SET uname='"+info.getUname()+"',xingbie='"+info.getXingbie()+"',xuewei='"+info.getXuewei()+"',startyear='"+info.getStartyear()+"',birthday='"+info.getBirthday()
				+"',address='"+info.getAddress()+"',email='"+info.getEmail()+"',beizhu='"+info.getBeizhu()
				+"',tel='"+info.getTel()+"' where uname='"+info.getUname()+"'";
	
			// 获取PreparedStatement对象
			ps = conn.prepareStatement(sql);
			// 对SQL语句的占位符参数进行动态赋值

			
		
			// 执行更新操作
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnUtil.closeAll(null, ps, conn);
		}
		
	}
	
	/**
	 *更新userinfo中的uname
	 * @param ShareSpaceInfo 说说对象
	 */
	public void updateUserInfo(String uname,String username){
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			// 获取数据库连接Connection对象
			conn = DBConnUtil.getConn();
			// 插入用户注册信息的SQL语句
//			String sql = "if exists (select * from introduction where uname='"+info.getUname()+"')"
//					+ " Begin"
//					+ " update introduction  SET uname='"+info.getUname()+"',xingbie='"+info.getXingbie()+"',xuewei='"+info.getXuewei()+"',birthday='"+info.getBirthday()
//					+"',address='"+info.getAddress()+"',email='"+info.getEmail()+"',beizhu='"+info.getBeizhu()+"',filename='"+info.getFilename()+"',fileurl='"+info.getFileurl()
//					+"',tel='"+info.getTel()+"' where uname='"+info.getUname()+"'; "
//					+ " end "
//					+ " else"
//					+ " begin"
//					+ " insert into introduction(uname,xingbie,xuewei,birthday,address,email,beizhu,tel,filename,fileurl) values(?,?,?,?,?,?,?,?,?,?)"
//					+ " end";// SQL语句
			String sql ="update userinfo  SET uname='"+uname+"' where username='"+username+"'";
	
			// 获取PreparedStatement对象
			ps = conn.prepareStatement(sql);
			// 对SQL语句的占位符参数进行动态赋值

			
		
			// 执行更新操作
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnUtil.closeAll(null, ps, conn);
		}
		
	}
	
	
}
