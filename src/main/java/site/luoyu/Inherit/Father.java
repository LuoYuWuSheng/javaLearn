package site.luoyu.Inherit;

/**
 * Computer user xd
 * Created by 张洋 on 2017/6/6.
 * 继承静态域，将静态方法
 * 普通域，普通方法
 */
public class Father {
    public static int staField = 0;
    public int field = 0;

    public static void testSta() {
        System.out.println("Father Static Method");
    }

    public void testMethod() {
        field = 2;
    }
}
