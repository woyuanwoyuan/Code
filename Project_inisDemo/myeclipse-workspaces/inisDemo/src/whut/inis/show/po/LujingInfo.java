package whut.inis.show.po;

public class LujingInfo {
 private String dirName1;
 private String dirName3;
 private String groundtruthpath;
 private String videocheckname;
 private String dirname2;
 private String zipfilename;
 private String zipnamepath;
 
 
 public LujingInfo(){}
 
 public LujingInfo(String dirName1,String dirName3,String groundtruthpath,String videocheckname,String dirname2,String zipfilename,String zipnamepath){
	
	 this.dirName1=dirName1;
	 this.dirName3=dirName3 ;
			 this.groundtruthpath=groundtruthpath;
			 this.videocheckname=videocheckname;
			 this.dirname2=dirname2;
			 this.zipfilename=zipfilename;
			 this.zipnamepath=zipnamepath;
 }

public String getDirName1() {
	return dirName1;
}

public void setDirName1(String dirName1) {
	this.dirName1 = dirName1;
}

public String getDirName3() {
	return dirName3;
}

public void setDirName3(String dirName3) {
	this.dirName3 = dirName3;
}

public String getGroundtruthpath() {
	return groundtruthpath;
}

public void setGroundtruthpath(String groundtruthpath) {
	this.groundtruthpath = groundtruthpath;
}

public String getVideocheckname() {
	return videocheckname;
}

public void setVideocheckname(String videocheckname) {
	this.videocheckname = videocheckname;
}

public String getDirname2() {
	return dirname2;
}

public void setDirname2(String dirname2) {
	this.dirname2 = dirname2;
}

public String getZipfilename() {
	return zipfilename;
}

public void setZipfilename(String zipfilename) {
	this.zipfilename = zipfilename;
}

public String getZipnamepath() {
	return zipnamepath;
}

public void setZipnamepath(String zipnamepath) {
	this.zipnamepath = zipnamepath;
}

@Override
public String toString() {
	return "LujingInfo [dirName1=" + dirName1 + ", dirName3=" + dirName3
			+ ", groundtruthpath=" + groundtruthpath + ", videocheckname="
			+ videocheckname + ", dirname2=" + dirname2 + ", zipfilename="
			+ zipfilename + ", zipnamepath=" + zipnamepath + "]";
}
 
}
