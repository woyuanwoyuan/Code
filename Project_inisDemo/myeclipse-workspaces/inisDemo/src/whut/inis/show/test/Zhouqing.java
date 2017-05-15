package whut.inis.show.test;
import com.mathworks.toolbox.javabuilder.*;

import AboutUsPck.*;
public class Zhouqing {

public static void main(String args[]){
	Object[] result = null;
	AboutUsCls test;
	try {
		test = new AboutUsCls();
		
		result = test.AboutUs();
		System.out.println(result[0].toString());
	} catch (MWException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	
}

}
