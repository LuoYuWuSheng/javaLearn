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

        String g = "中国";
        String h = new String("中国").intern();
        if (g == h) System.out.println("inter 导致相等");

//        String i = new String("我是我");
        String i = new StringBuilder("我是我").append("张洋").toString();
        String j = i.intern();
        if (i == j) System.out.println("java7以后，如果常量池中存在了，则直接返回常量池地址。" +
                "否则在常量池中创建引用指向堆中");

        if (new String("woshi zhongguo") == new String("woshi zhongguo")) System.out.println("new Equal");
    }
}
