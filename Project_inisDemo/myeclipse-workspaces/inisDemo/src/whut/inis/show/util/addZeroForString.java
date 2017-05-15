package whut.inis.show.util;

import whut.inis.show.test.deleteJpg;

public class addZeroForString {

	 /**
     * 补齐不足长度
     * @param strLength 规定的长度
     * @param str 字符串
     * @return
     */
public static String addZeroForNum(String str, int strLength) {
    int strLen = str.length();
    StringBuffer sb = null;
    while (strLen < strLength) {
          sb = new StringBuffer();
          sb.append("0").append(str);// 左(前)补0
       // sb.append(str).append("0");//右(后)补0
          str = sb.toString();
          strLen = str.length();
    }
    return str;
}

public static void main(String[] args) {
	addZeroForString test = new addZeroForString();
	 System.out.println(test.addZeroForNum("56", 6));
}
}
