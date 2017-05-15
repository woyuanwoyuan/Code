package whut.inis.show.po;

public class ShareSpaceInfo {
	private int id;
	private String username;
	private String uurl;
	private String publishtime;
	private String content;
	private String purl;
	private String vurl;
	private int picnum;
	
	
	
	
	
	
	
	
	public ShareSpaceInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ShareSpaceInfo(int id, String username, String uurl,
			String publishtime, String content, String purl, String vurl,
			int picnum) {
		super();
		this.id = id;
		this.username = username;
		this.uurl = uurl;
		this.publishtime = publishtime;
		this.content = content;
		this.purl = purl;
		this.vurl = vurl;
		this.picnum = picnum;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUurl() {
		return uurl;
	}
	public void setUurl(String uurl) {
		this.uurl = uurl;
	}
	public String getPublishtime() {
		return publishtime;
	}
	public void setPublishtime(String publishtime) {
		this.publishtime = publishtime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPurl() {
		return purl;
	}
	public void setPurl(String purl) {
		this.purl = purl;
	}
	public String getVurl() {
		return vurl;
	}
	public void setVurl(String vurl) {
		this.vurl = vurl;
	}
	public int getPicnum() {
		return picnum;
	}
	public void setPicnum(int picnum) {
		this.picnum = picnum;
	}
	
	
	
	
}
