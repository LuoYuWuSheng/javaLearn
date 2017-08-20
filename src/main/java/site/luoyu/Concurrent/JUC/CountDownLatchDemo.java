package site.luoyu.Concurrent.JUC;

/**
 * Computer user xd
 * Created by 张洋 on 2017/8/16.
 */
public class CountDownLatchDemo {
    public static void main(String[] args) {
        Thread parser1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Parse1 finish");
            }
        });
        Thread parser2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("parse2 finish");
            }
        });
    }
}
