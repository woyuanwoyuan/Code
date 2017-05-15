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
	 * ����˵˵
	 * @param ShareSpaceInfo ˵˵����
	 */
	public void pubShare(ShareSpaceInfo info){
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			// ��ȡ���ݿ�����Connection����
			conn = DBConnUtil.getConn();
			// �����û�ע����Ϣ��SQL���
			String sql = "insert into sharespace(username,content,purl,picnum,publishtime) values(?,?,?,?,now())";
			// ��ȡPreparedStatement����
			ps = conn.prepareStatement(sql);
			// ��SQL����ռλ���������ж�̬��ֵ
			ps.setString(1, info.getUsername());
			ps.setString(2, info.getContent());
			ps.setString(3, info.getPurl());
			ps.setInt(4, info.getPicnum());
	
			// ִ�и��²���
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnUtil.closeAll(null, ps, conn);
		}
		
	}
	
	/**
	 * ����˵˵
	 * @param ShareSpaceInfo ˵˵����
	 */
	public void pubLunwen(LunWenInfo info){
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			// ��ȡ���ݿ�����Connection����
			conn = DBConnUtil.getConn();
			// �����û�ע����Ϣ��SQL���
			String sql = "insert into lunwen(timu,author,beizhu,filename,fileurl,publishtime,uploadtime,leibie,gongkai) values(?,?,?,?,?,?,now(),?,?)";
			// ��ȡPreparedStatement����
			ps = conn.prepareStatement(sql);
			// ��SQL����ռλ���������ж�̬��ֵ
			ps.setString(1, info.getTimu());
			ps.setString(2, info.getAuthor());
			ps.setString(3, info.getBeizhu());
			ps.setString(4, info.getFilename());
			ps.setString(5, info.getFlieurl());
			ps.setString(6, info.getUploadtime());
			ps.setString(7, info.getLeibie());
			ps.setString(8, info.getGongkai());
			// ִ�и��²���
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnUtil.closeAll(null, ps, conn);
		}
		
	}
	
	/**
	 * �༭inis���
	 * @param ShareSpaceInfo ˵˵����
	 */
	public void pubBianjiJianjie(InisInfo info){
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			// ��ȡ���ݿ�����Connection����
			conn = DBConnUtil.getConn();
			// �����û�ע����Ϣ��SQL���
			String sql ="update jianjie  SET jianjie='"+info.getJianjie()+"',yanjiu1='"+info.getYanjiu1()
					+"',yanjiu2='"+info.getYanjiu2()+"',yanjiu3='"+info.getYanjiu3()+"',yanjiu4='"+info.getYanjiu4()+"',yanjiu5='"+info.getYanjiu5()+"' where name='inis'";
			// ��ȡPreparedStatement����
			ps = conn.prepareStatement(sql);
			// ��SQL����ռλ���������ж�̬��ֵ
		
			// ִ�и��²���
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnUtil.closeAll(null, ps, conn);
		}
		
	}
	/**
	 *�༭introduction
	 * @param ShareSpaceInfo ˵˵����
	 */
	public void bianjiIntroduction(IntroductionInfo info){
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			// ��ȡ���ݿ�����Connection����
			conn = DBConnUtil.getConn();
			// �����û�ע����Ϣ��SQL���
//			String sql = "if exists (select * from introduction where uname='"+info.getUname()+"')"
//					+ " Begin"
//					+ " update introduction  SET uname='"+info.getUname()+"',xingbie='"+info.getXingbie()+"',xuewei='"+info.getXuewei()+"',birthday='"+info.getBirthday()
//					+"',address='"+info.getAddress()+"',email='"+info.getEmail()+"',beizhu='"+info.getBeizhu()+"',filename='"+info.getFilename()+"',fileurl='"+info.getFileurl()
//					+"',tel='"+info.getTel()+"' where uname='"+info.getUname()+"'; "
//					+ " end "
//					+ " else"
//					+ " begin"
//					+ " insert into introduction(uname,xingbie,xuewei,birthday,address,email,beizhu,tel,filename,fileurl) values(?,?,?,?,?,?,?,?,?,?)"
//					+ " end";// SQL���
			String sql = "insert into introduction(uname,xingbie,xuewei,startyear,birthday,address,email,beizhu,tel,filename,fileurl,username) values(?,?,?,?,?,?,?,?,?,?,?,?)";
	
			// ��ȡPreparedStatement����
			ps = conn.prepareStatement(sql);
			// ��SQL����ռλ���������ж�̬��ֵ
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
			// ִ�и��²���
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnUtil.closeAll(null, ps, conn);
		}
		
	}
	

	
	/**
	 *����introduction
	 * @param ShareSpaceInfo ˵˵����
	 */
	public void updateIntroduction(IntroductionInfo info){
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			// ��ȡ���ݿ�����Connection����
			conn = DBConnUtil.getConn();
			// �����û�ע����Ϣ��SQL���
//			String sql = "if exists (select * from introduction where uname='"+info.getUname()+"')"
//					+ " Begin"
//					+ " update introduction  SET uname='"+info.getUname()+"',xingbie='"+info.getXingbie()+"',xuewei='"+info.getXuewei()+"',birthday='"+info.getBirthday()
//					+"',address='"+info.getAddress()+"',email='"+info.getEmail()+"',beizhu='"+info.getBeizhu()+"',filename='"+info.getFilename()+"',fileurl='"+info.getFileurl()
//					+"',tel='"+info.getTel()+"' where uname='"+info.getUname()+"'; "
//					+ " end "
//					+ " else"
//					+ " begin"
//					+ " insert into introduction(uname,xingbie,xuewei,birthday,address,email,beizhu,tel,filename,fileurl) values(?,?,?,?,?,?,?,?,?,?)"
//					+ " end";// SQL���
			String sql ="update introduction  SET uname='"+info.getUname()+"',xingbie='"+info.getXingbie()+"',xuewei='"+info.getXuewei()+"',startyear='"+info.getStartyear()+info.getXuewei()+"',birthday='"+info.getBirthday()
				+"',address='"+info.getAddress()+"',email='"+info.getEmail()+"',beizhu='"+info.getBeizhu()+"',filename='"+info.getFilename()+"',fileurl='"+info.getFileurl()
				+"',tel='"+info.getTel()+"' where uname='"+info.getUname()+"'";
	
			// ��ȡPreparedStatement����
			ps = conn.prepareStatement(sql);
			// ��SQL����ռλ���������ж�̬��ֵ

			
		
			// ִ�и��²���
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnUtil.closeAll(null, ps, conn);
		}
		
	}
	

	/**
	 *����introduction��ͼƬ
	 * @param ShareSpaceInfo ˵˵����
	 */
	public void updateIntroductionWithoutPic(IntroductionInfo info){
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			// ��ȡ���ݿ�����Connection����
			conn = DBConnUtil.getConn();
			// �����û�ע����Ϣ��SQL���
//			String sql = "if exists (select * from introduction where uname='"+info.getUname()+"')"
//					+ " Begin"
//					+ " update introduction  SET uname='"+info.getUname()+"',xingbie='"+info.getXingbie()+"',xuewei='"+info.getXuewei()+"',birthday='"+info.getBirthday()
//					+"',address='"+info.getAddress()+"',email='"+info.getEmail()+"',beizhu='"+info.getBeizhu()+"',filename='"+info.getFilename()+"',fileurl='"+info.getFileurl()
//					+"',tel='"+info.getTel()+"' where uname='"+info.getUname()+"'; "
//					+ " end "
//					+ " else"
//					+ " begin"
//					+ " insert into introduction(uname,xingbie,xuewei,birthday,address,email,beizhu,tel,filename,fileurl) values(?,?,?,?,?,?,?,?,?,?)"
//					+ " end";// SQL���
			String sql ="update introduction  SET uname='"+info.getUname()+"',xingbie='"+info.getXingbie()+"',xuewei='"+info.getXuewei()+"',startyear='"+info.getStartyear()+"',birthday='"+info.getBirthday()
				+"',address='"+info.getAddress()+"',email='"+info.getEmail()+"',beizhu='"+info.getBeizhu()
				+"',tel='"+info.getTel()+"' where uname='"+info.getUname()+"'";
	
			// ��ȡPreparedStatement����
			ps = conn.prepareStatement(sql);
			// ��SQL����ռλ���������ж�̬��ֵ

			
		
			// ִ�и��²���
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnUtil.closeAll(null, ps, conn);
		}
		
	}
	
	/**
	 *����userinfo�е�uname
	 * @param ShareSpaceInfo ˵˵����
	 */
	public void updateUserInfo(String uname,String username){
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			// ��ȡ���ݿ�����Connection����
			conn = DBConnUtil.getConn();
			// �����û�ע����Ϣ��SQL���
//			String sql = "if exists (select * from introduction where uname='"+info.getUname()+"')"
//					+ " Begin"
//					+ " update introduction  SET uname='"+info.getUname()+"',xingbie='"+info.getXingbie()+"',xuewei='"+info.getXuewei()+"',birthday='"+info.getBirthday()
//					+"',address='"+info.getAddress()+"',email='"+info.getEmail()+"',beizhu='"+info.getBeizhu()+"',filename='"+info.getFilename()+"',fileurl='"+info.getFileurl()
//					+"',tel='"+info.getTel()+"' where uname='"+info.getUname()+"'; "
//					+ " end "
//					+ " else"
//					+ " begin"
//					+ " insert into introduction(uname,xingbie,xuewei,birthday,address,email,beizhu,tel,filename,fileurl) values(?,?,?,?,?,?,?,?,?,?)"
//					+ " end";// SQL���
			String sql ="update userinfo  SET uname='"+uname+"' where username='"+username+"'";
	
			// ��ȡPreparedStatement����
			ps = conn.prepareStatement(sql);
			// ��SQL����ռλ���������ж�̬��ֵ

			
		
			// ִ�и��²���
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnUtil.closeAll(null, ps, conn);
		}
		
	}
	
	
}
