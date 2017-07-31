package site.luoyu.Inherit;

/**
 * Computer user xd
 * Created by 张洋 on 2017/7/30.
 */
public class Test {
    public static void main(String[] args) {
        Father fa = new Son1();
        System.out.println("静态方法调用");
        fa.testSta();
        System.out.println("静态作用域：" + fa.staField);
        Son1 son = new Son1();
        if (son instanceof Father) {
            Father test = new Father();

            Son1 test2 = (Son1) test;
        }
    }
}
