package site.luoyu.innerClass;


/**
 * Created by xd on 2016/11/22.
 * 匿名内部类必须要实现一个接口才行，不然没法引用
 */
public class AnonymousInnerClass {

    public static void createAnonymous(){

        String MethodVariable = "hellow method local variable";

        Runnable anonymousInner = new Runnable(){
            @Override
            public void run() {
                System.out.println(MethodVariable);
            }
        };
        anonymousInner.run();
    }

    public static void main(String[] args) {
        AnonymousInnerClass.createAnonymous();
    }
}
