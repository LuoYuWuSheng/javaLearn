package site.luoyu.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class reflect {
	
	public static void main(String[] args) {
//		reflect testname = new reflect();
//		System.out.println(testname.getClass().getName());
		try {

			reflectDemo[] array = new reflectDemo[5];
			Object[] test = new Object[array.length];
			System.arraycopy(array,0,test,0,5);
			array = (reflectDemo[]) test;
			int a =0;
			int b = 1;
			int result = a ;
//			三种方法获得Class 1、Object.getClass() 2.Class.forName() 3.Object.class
			Class Creflect = Class.forName("reflect.reflectDemo");
			Field[] fields = Creflect.getDeclaredFields();
			for (Field field : fields) {
				System.out.println(field.getName());
			}
			Method[] methods = Creflect.getDeclaredMethods();
			for (Method method : methods) {
				System.out.println(method.getName());
				if(method.getName().equals("hello")){
					method.invoke(Creflect.newInstance(), 1);
				}
			}
		} catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
