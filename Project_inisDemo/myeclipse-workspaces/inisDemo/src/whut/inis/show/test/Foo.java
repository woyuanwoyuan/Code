package whut.inis.show.test;

public class Foo {
	public static String output ="";
	
	
	public static void main(String[] args) {
//		int i=1,j=10;
//		do{
//			if(i++>--j)continue;
//		}while(i<5);
//		System.out.println(i+"..."+j);
		
		
//		int i = 1 ;
//		int foo[] = new int[3];
//		int bar = foo[i];
//		int baz = bar+i;
//		System.out.println(baz);
		
//		int i = 0xFFFFFFF1;
//		int j = ~i;
//		System.out.println(j);
		
//		Integer i = new Integer(0);
//		foo(i);
//		System.out.println(i.intValue());
		
		
		System.out.println(6^3);
		
	}
	
	public static void foo(Integer i ){
//		try {
//			if(i==1){
//				throw new Exception();
//			}
//			output += "1";
//		} catch (Exception e) {
//			output += "2";
//			return;
//		}finally{
//			output += "3";
//		}
//		output += "4";
		
		int val = i.intValue();
		val +=3;
		i = new Integer(val);
	}
	
	
}
