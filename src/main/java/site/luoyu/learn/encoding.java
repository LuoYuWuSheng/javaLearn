package site.luoyu.learn;

import java.io.UnsupportedEncodingException;

public class encoding {
	public static void main(String[] args) {
		String mystring = "我是中文UTF-8";
		try {
			String gbk = new String(mystring.getBytes(), "gbk");
			System.out.println(gbk);
			System.out.println(mystring);
			byte[] gbbety = gbk.getBytes("utf8");
			String gbutf82utf8 = new String(gbbety,"gbk");
			System.out.println(gbutf82utf8);
			
			//回转为utf8
			System.out.println(new String(gbutf82utf8.getBytes(),"utf8"));
			System.out.println(gbbety);
			System.out.println(mystring.getBytes("utf8"));
			System.out.println(gbk.getBytes("gbk"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
