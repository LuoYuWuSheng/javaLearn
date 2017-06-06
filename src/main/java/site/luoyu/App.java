package site.luoyu;

import site.luoyu.Inherit.Father;

/**
 * Hello world!
 *
 */
public class App
{

    private static Father father;

    public static void main(String[] args)
    {
        System.out.println( "Hello World!" );
        String ha1 = "abc";
        String ha2 = "def";
        String a = ha1 + ha2;
        String b = "abcdef";
        System.out.println(a == b);
        father = new Father();
    }
}
