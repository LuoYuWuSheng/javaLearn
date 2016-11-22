package site.luoyu.FilePath;

import java.io.File;
import java.net.URL;
import java.nio.file.Path;
import java.util.ResourceBundle;

public class filePath {
	public static void main(String[] args) {
		URL resourceURL =  filePath.class.getResource(".");
		System.out.println(resourceURL.getPath());
		URL classLoaderUrl = filePath.class.getClassLoader().getResource(".");
		System.out.println(classLoaderUrl.getPath());
		
		File  myfile = new File(".");
		System.out.println(myfile.getAbsolutePath());
		if(myfile.exists())System.out.println("file exist");
		
//		System.out.println(resourceURL.getPath());
//		ResourceBundle.getBundle("path.txt");
		
	}
}
