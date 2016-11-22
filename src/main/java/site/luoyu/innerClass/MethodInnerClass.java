package site.luoyu.innerClass;

/**
 * 局部内部类
 */
public class MethodInnerClass {
	
	public void letBTalk() {
		//局部变量
		String localVar = "local hellow";
		class B{

			public String Talk(){
				//需要jdk8才支持访问非final变量(jdk8闭包特性)
				assert localVar == "hello" : "变量不是hello";
				System.out.println(localVar);
				return localVar;
			}
		}
		B b = new B();
		b.Talk();
	}
	public static void main(String[] args) {
		MethodInnerClass a = new MethodInnerClass();
		a.letBTalk();
	}

}
