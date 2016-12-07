package site.luoyu.Concurrent.DBConnectionPool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;

/**
 * Computer user xd
 * Created by 张洋 on 2016/12/7.
 */
public class Worker implements Runnable {

    private BlockingQueue<String> taskQueue;
    private long workTime;

    public Worker(BlockingQueue<String> taskQueue,long workTime) {
        super();
        this.workTime = workTime;
        this.taskQueue = taskQueue;
    }

    @Override
    public void run() {
        if (Thread.currentThread().isInterrupted()) ;
        else {
            while (true){
                try {
                    doJob();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void doJob() throws InterruptedException {
        System.out.println("work thread :"+ Thread.currentThread().getName() +" work result : "+ taskQueue.take());
        //让work线程的工作速度比put线程慢
        Thread.sleep(workTime);
    }
}
