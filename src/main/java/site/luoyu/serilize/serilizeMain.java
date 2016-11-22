package site.luoyu.serilize;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class serilizeMain {
	public static void main(String[] args) {
		Student zy = new Student("zhangyang","man",2);
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("./test.obj"));
			oos.writeObject(zy);
			oos.flush();
			oos.close();
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./test.obj"));
			Student sStu = (Student) ois.readObject();
			System.out.println(sStu.getName());
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
