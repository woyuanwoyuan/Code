package whut.inis.show.util;

import whut.inis.show.test.deleteJpg;

public class addZeroForString {

	 /**
     * ���벻�㳤��
     * @param strLength �涨�ĳ���
     * @param str �ַ���
     * @return
     */
public static String addZeroForNum(String str, int strLength) {
    int strLen = str.length();
    StringBuffer sb = null;
    while (strLen < strLength) {
          sb = new StringBuffer();
          sb.append("0").append(str);// ��(ǰ)��0
       // sb.append(str).append("0");//��(��)��0
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
