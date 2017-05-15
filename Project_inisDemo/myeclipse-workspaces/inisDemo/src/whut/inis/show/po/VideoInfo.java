package whut.inis.show.po;

public class VideoInfo {
	private int id;
	private String videoname;
	private String url;
	private String file_path;
	private String groundtruth;
	private String addtime;
	private String provider;
	private String code;
	private int cout;
	private int downloadcount;
	
	
	public VideoInfo(){}
	
	

	public VideoInfo(int id, String videoname, String url, String file_path,
			String groundtruth, String addtime, String provider, String code, int cout, int downloadcount) {
		super();
		this.id = id;
		this.videoname = videoname;
		this.url = url;
		this.file_path = file_path;
		this.groundtruth = groundtruth;
		this.addtime = addtime;
		this.provider = provider;
		this.code = code;
		this.cout=cout;
		this.downloadcount=downloadcount;
	}



	public int getDownloadcount() {
		return downloadcount;
	}



	public void setDownloadcount(int downloadcount) {
		this.downloadcount = downloadcount;
	}



	public int getCout() {
		return cout;
	}



	public void setCout(int cout) {
		this.cout = cout;
	}



	public String getProvider() {
		return provider;
	}



	public void setProvider(String provider) {
		this.provider = provider;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVideoname() {
		return videoname;
	}
	public void setVideoname(String videoname) {
		this.videoname = videoname;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getFile_path() {
		return file_path;
	}
	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}
	public String getGroundtruth() {
		return groundtruth;
	}
	public void setGroundtruth(String groundtruth) {
		this.groundtruth = groundtruth;
	}
	public String getAddtime() {
		return addtime;
	}
	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String toString() {
		return "videoname=" +videoname+ " id=" +id+" url="+url+" file_path="+file_path+" groundtruth="+groundtruth+"code="+code+"count="+cout+"downloadcount="+downloadcount;
	}
}
