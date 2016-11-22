package site.luoyu.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class reflect {
	
	public static void main(String[] args) {
//		reflect testname = new reflect();
//		System.out.println(testname.getClass().getName());
		try {
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
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
