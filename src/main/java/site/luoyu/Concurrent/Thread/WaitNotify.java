package site.luoyu.Concurrent.Thread;

/**
 * Computer user xd
 * Created by 张洋 on 2017/8/16.
 * Object 中关于同步的方法API
 * 1、notify()唤醒在此监视器上等待的单个线程。
 * 2、notifyAll()唤醒等待的所有线程。
 * 3、wait()/wait(long timeout)/wait(long timeout,int nanos)
 * 等待在notify或notifyhAll Wait后会释放在该对象上的锁
 * 调用wait/notify方法必须持有该对象的锁。被其他线程抵用notify后需要重新会的锁
 */
public class WaitNotify {
    static class Inner implements Runnable {
        public boolean condition = false;

        @Override
        public void run() {
            System.out.println("I am working...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Work done!Condition is set");
            condition = true;
            synchronized (this) {
                notify();
            }
        }
    }

    public static void main(String[] args) {
        WaitNotify test = new WaitNotify();
        test.testAPI();
    }

    public void testAPI() {
        Inner inner = new Inner();
        new Thread(inner).start();
        try {
            System.out.println("wait()");
            synchronized (inner) {
                //循环调用wait等待条件
                while (!inner.condition) {
                    System.out.println("Main is wait for inner Condition");
                    inner.wait(1000);
                }
                System.out.println("Condition is accept,Main work done");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
