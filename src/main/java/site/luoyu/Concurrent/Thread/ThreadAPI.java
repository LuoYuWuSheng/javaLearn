package site.luoyu.Concurrent.Thread;

/**
 * Created by xd on 2016/12/4.
 */
public class ThreadAPI extends Thread {

    @Override
    public void run() {
        System.out.println();
    }

    /**
     * 线程的run方法不能抛出任何被检测异常，
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        Runnable run = () -> {
            System.out.println("amaous Thread");
        };
        Thread thread1 = new Thread(run);
        thread1.start();
        Thread.sleep(990);
        thread1.interrupt();
    }
}
