package site.luoyu.javaUtilPackage;

import java.util.*;

/**
 * Computer user xd
 * Created by 张洋 on 2016/12/8.
 */
public class View {
    private Map myMap = new HashMap();
    private List myList = new ArrayList();
    public static final class A{
        public String name;
        public A(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        A aBoy = new A("张洋");
        List<A> Myview = Collections.<A>nCopies(10,aBoy);
        aBoy.name = "我改名了 看你们是不是全都变芯了";
        for (A temp : Myview){
            System.out.println(temp.name);
        }
    }
}
