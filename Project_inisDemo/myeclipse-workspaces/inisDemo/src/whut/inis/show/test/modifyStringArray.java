package whut.inis.show.test;

public class modifyStringArray {
	public static void main(String[] args) {
		String[] strs = {"111","222"};
		for(int i=0; i<strs.length; i++){
			strs[i] = "kang"+strs[i];
			System.out.println(strs[i]);
		}
		
	}
}
