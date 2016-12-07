package site.luoyu.Concurrent.DBConnectionPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Computer login xd
 * Created by 张洋 on 2016/12/7.
 */
public class ConnectionPool {

    private int poolSize;
    private int blockQueueSize;
    private List<Thread> threadList;
    private BlockingQueue<String> blockingQueue;

    public ConnectionPool(int poolSize, int blockQueueSize) {
        this.poolSize = poolSize;
        this.blockQueueSize = blockQueueSize;
        this.threadList = new ArrayList<>(poolSize);
        this.blockingQueue = new ArrayBlockingQueue(blockQueueSize);
    }

    private void initPool(){
        for (int i = 0; i < poolSize; i++) {
            Thread woker = new Thread(new Worker(blockingQueue,1000));
            threadList.add(woker);
            woker.start();
        }
    }
    public void startWork() {
        long workId = 0;
        while (true){
            try {
                blockingQueue.put(" ===== work id "+workId++);
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ConnectionPool pool = new ConnectionPool(10,20);
        pool.initPool();
        pool.startWork();
    }
}
