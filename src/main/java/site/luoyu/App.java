package site.luoyu;

import java.net.URL;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main(String[] args)
    {
        int i = 0;
        int s = (i++) + (++i) + (i--) + (--i);
        System.out.println(s);
//        System.out.println(i+++++i);
        URL url = App.class.getResource("/SqlTest.sql");
        System.out.println(url.toString());
    }

}
