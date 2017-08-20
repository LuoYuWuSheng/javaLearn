package site.luoyu.Concurrent.Thread;

import java.util.concurrent.TimeUnit;

/**
 * Computer user xd
 * Created by 张洋 on 2017/8/16.
 */
public class ThreadLocalDemo {
    private static final ThreadLocal<Long> TIMETHREADLOCAL = new ThreadLocal<Long>();

    protected Long initialValue() {
        return System.currentTimeMillis();
    }

    public static final void begin() {
        TIMETHREADLOCAL.set(System.currentTimeMillis());
    }

    public static final long end() {
        return System.currentTimeMillis() - TIMETHREADLOCAL.get();
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadLocalDemo.begin();
        TimeUnit.SECONDS.sleep(1);
        ThreadLocalDemo.end();
    }
}
