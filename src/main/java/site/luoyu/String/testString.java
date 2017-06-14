package site.luoyu.String;

/**
 * Computer user xd
 * Created by 张洋 on 2017/6/14.
 */
public class testString {
    public static void main(String[] args) {
        String a = "abcdef";
        String b = "abc" + "def";
        if (a == b) System.out.println("加法作用于两个常量最后是放在常量池中的");
        String c = "abc";
        String d = c + "def";
        if (a == d) System.out.println("即使其中一个申明为变量(用字面量表示)");
        String e = new String("abc");
        String f = e + "def";
        if (a == f) System.out.println("如果其中一个在堆中，则产生的在堆中");
    }
}
