package site.luoyu.Concurrent.Executor;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * Computer user xd
 * Created by 张洋 on 2017/8/12.
 */
public class ShowFeature {
    static class Task implements Runnable {
        private String name;
        private CountDownLatch latch;

        public Task(String name, CountDownLatch latch) {
            this.latch = latch;
            this.name = name;
        }

        @Override
        public void run() {
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + "'s Tasking is working");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + "'s work done!");
        }
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        CountDownLatch latch = new CountDownLatch(1);
        Future<Math> result = null;
        Math res = null;
        for (int i = 0; i < 5; i++) {
//            result = executor.submit(new Task("zy" + i, latch));
            Callable<Math> call = Executors.callable(new Task("zy" + i, latch));
            result = executor.submit(call);

        }
        try {
            res = result.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("All task created");
        latch.countDown();
        executor.shutdown();
    }
}
