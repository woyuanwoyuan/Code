package whut.inis.show.po;

public class Result {

	    private boolean success;
	    private String info;
	    private String data;//也可用来标识错误代码
		public boolean isSuccess() {
			return success;
		}
		public void setSuccess(boolean success) {
			this.success = success;
		}
		public String getInfo() {
			return info;
		}
		public void setInfo(String info) {
			this.info = info;
		}
		public Object getData() {
			return data;
		}
		public void setData(String data) {
			this.data = data;
		}
		public Result() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Result(boolean success, String info, String data) {
			super();
			this.success = success;
			this.info = info;
			this.data = data;
		}
	   
	
}
