package site.luoyu;

import site.luoyu.Inherit.Father;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main(String[] args)
    {
        int i = 5;
        int s = (i++) + (++i) + (i--) + (--i);
//        System.out.println(i+++++i);
        System.out.println(s);
    }

}
