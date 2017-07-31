package site.luoyu.Inherit;

/**
 * Computer user xd
 * Created by 张洋 on 2017/6/6.
 */
public class Son1 extends Father {
    public static int staField = 1;
    public int field = 1;

    public static void testSta() {
        System.out.println("Son's Static Method");
    }

    public void testMethod() {
        field = 1;
    }
}
