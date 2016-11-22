package site.luoyu.Classes;

import java.lang.reflect.Array;

public class Main {
	public static void main(String[] args) {
		//先进行instanceof的测试
		//先看调用的是谁的构造方法。
		ChildA childA = new ChildA();
		Parent parent = new Parent();
		if(childA instanceof Parent)System.out.println("子类  instanceof 父类");
		if(parent instanceof ChildA)System.out.println("父类 instance of 子类");
		
		ChildA custChild = (ChildA) parent;
		if(custChild instanceof ChildA)System.out.println("将父类强制转换为子类,instanceof 能识别为子类");
		Parent custParent = (Parent) childA;
		if(custParent instanceof ChildA)System.out.print("将子类转换成父类，然后再调用instanceof 子类  能识别");
	}
}
