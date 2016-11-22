package site.luoyu.learn;

import java.io.File;

public class javaFilePath {
	public static void main(String[] args) {
		System.out.println("文件路径");
		javaFilePath pathTest = new javaFilePath();
		pathTest.relativePath(".");
		pathTest.relativePath("./");
	}
	
	private void relativePath(String path){
		File myFile = new File(path);
		System.out.println(myFile.getAbsolutePath());
		myFile = null;
	}
}
