package site.luoyu.Concurrent.Thread;

/**
 * Created by xd on 2016/12/4.
 */
public class ThreadAPI extends Thread{

    @Override
    public void run() {
        System.out.println();
        super.run();
    }

    /**
     * 为什么Runnable不能抛出异常，而在main中可以？
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        Runnable run = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println("Thread is intrruped");
                }
            }
        };
        Thread thread1 = new Thread(run);
        thread1.start();
        Thread.sleep(990);
        thread1.interrupt();
    }
}
