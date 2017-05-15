package whut.inis.show.po;

public class UploadInfo {
	private int id;
	private String username;
	private String filename;
	private String uploadtime;
	private String url;
	private String file_introduce;
	private String filepath;

	
	public UploadInfo(){}

public UploadInfo(int id, String username, String filename,
			String uploadtime, String url, String file_introduce,
			String filepath) {
		super();
		this.id = id;
		this.username = username;
		this.filename = filename;
		this.uploadtime = uploadtime;
		this.url = url;
		this.file_introduce = file_introduce;
		this.filepath = filepath;
	}

public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
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

public String getFilename() {
	return filename;
}

public void setFilename(String filename) {
	this.filename = filename;
}

public String getUploadtime() {
	return uploadtime;
}

public void setUploadtime(String uploadtime) {
	this.uploadtime = uploadtime;
}

public String getUrl() {
	return url;
}

public void setUrl(String url) {
	this.url = url;
}

public String getFile_introduce() {
	return file_introduce;
}

public void setFile_introduce(String file_introduce) {
	this.file_introduce = file_introduce;
}
public String toString() {
	return "username=" +username+ "  file_introduce="+file_introduce+" filenamer="+filename+"url="+url+"uploadtime="+uploadtime;
}

}