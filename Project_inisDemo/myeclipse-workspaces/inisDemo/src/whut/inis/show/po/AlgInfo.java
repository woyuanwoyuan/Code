package whut.inis.show.po;

public class AlgInfo {
	private int id;
	private String alg_type;
	private String alg_name;
	private String provider;
	private String addtime;
	private String content;
	private int isdel;
	
	public AlgInfo(){}
	
	
	
	public AlgInfo(int id, String alg_type, String alg_name, String provider,
			String addtime, String content, int isdel) {
		super();
		this.id = id;
		this.alg_type = alg_type;
		this.alg_name = alg_name;
		this.provider = provider;
		this.addtime = addtime;
		this.content = content;
		this.isdel = isdel;
	}



	public int getIsdel() {
		return isdel;
	}


	public void setIsdel(int isdel) {
		this.isdel = isdel;
	}


	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAlg_type() {
		return alg_type;
	}
	public void setAlg_type(String alg_type) {
		this.alg_type = alg_type;
	}
	public String getAlg_name() {
		return alg_name;
	}
	public void setAlg_name(String alg_name) {
		this.alg_name = alg_name;
	}
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	public String getAddtime() {
		return addtime;
	}
	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
