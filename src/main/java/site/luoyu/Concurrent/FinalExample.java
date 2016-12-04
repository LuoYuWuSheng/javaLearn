package site.luoyu.Concurrent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xd on 2016/12/2.
 */
public class FinalExample {
    int i;
    final int j;
    static FinalExample obj;
    public FinalExample(){
        i = 1;
        j = 2;
    }

    public static void writer(){
        obj = new FinalExample();
    }

    public static void reader(){
        FinalExample object = obj;
        int a = object.i;
        int b = object.j;
    }

    public static void main(){
        List<Thread> pool = new ArrayList();
        Runnable writer = new Runnable() {
            @Override
            public void run() {
                writer();
            }
        };
        Runnable reader = new Runnable() {
            @Override
            public void run() {
                reader();
            }
        };

        for(int i =0 ;i<10;i++){
            pool.add(new Thread(writer));
            pool.add(new Thread(reader));
        }

        for (int i = 0; i < 20; i++) {
            pool.get(i).run();
        }
    }
}
