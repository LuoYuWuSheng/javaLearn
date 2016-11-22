package site.luoyu.properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class readProper {
	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("test.properties");
			Properties pro = new Properties();
			pro.load(fis);
			System.out.print(pro.getProperty("student.name"));
			System.out.print(pro.getProperty("student"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
