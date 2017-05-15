package whut.inis.show.po;

public class UserInfo {
	private int id;
	private String username;
	private String passwd;
	private String email;
	private String url;
	private int isdel;
	private int role_id;
	private String regtime;
	
	public UserInfo(){}
	
	public UserInfo(int id, String username, String passwd, String email,
			int isdel, int role_id,String url) {
		super();
		this.id = id;
		this.username = username;
		this.passwd = passwd;
		this.email = email;
		this.isdel = isdel;
		this.role_id = role_id;
		this.url=url;
		this.regtime=regtime;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
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
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getIsdel() {
		return isdel;
	}
	public void setIsdel(int isdel) {
		this.isdel = isdel;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getRegtime() {
		return regtime;
	}
	public void setRegtime(String regtime) {
		this.regtime = regtime;
	}
	
	public String toString() {
		return "username=" +username+ " passwd=" +passwd+" role_id="+role_id+" email="+email+" isdel="+isdel+"url="+url+"regtime="+regtime;
	}
}
