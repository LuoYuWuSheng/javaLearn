package site.luoyu.volatileTest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xd on 2016/11/23.
 * volatile 在JMM中通过内存屏障来实现
 * 在java并发编程的艺术书中的规则表，这是上面的实例，
 * 加深理解volatile是怎么做的。
 */
public class VolatileBarrierExample {
    int a;
    volatile int v1 = 1;
    volatile int v2 = 2;

    void readAndWrite() {
        int i = v1; //第一个volatile读
        int j = v2; //第二个volatile读
        a = i + j;  //普通写
        v1 = i + 1; //第一个volatile写
        v2 = j * 2; // 第二个volatile写
    }

    public static void main(String[] args) {
        class MyThread extends Thread{
            @Override
            public void run() {
                System.out.println();
            }
        }
        List pool = new ArrayList();
        for (int i = 0; i < 10; i++) {
            MyThread temp = new MyThread();
            pool.add(temp);
            temp.start();
        }

        for (int i = 0; i < pool.size(); i++) {

        }
    }
}
