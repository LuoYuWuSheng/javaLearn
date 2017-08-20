package site.luoyu.Concurrent.Executor;

import java.util.concurrent.*;

/**
 * Computer user xd
 * Created by 张洋 on 2017/8/12.
 *
 * Executor框架的典型应用场景？？
 * ExecutorService executor = Executors.newFixedThreadPool()等方法创建服务端的线程池
 * 然后通过execute，Submit等方法提交任务。
 * submit 最终会产生一个FutureTask（利用AQS实现）对象，将Runnable封装在里面。‘
 * submit 三种重载
 * 1、submit（Runnable）返回FutureTask<Object>
 * 2、submit（Runnable,T result）返回FutureTask<T>
 * 3、submit（Callable<T>）返回FutureTask<T>
 *     还可以通过Executors.callable(Runnable,T res)将Runnable封装成一个Callable
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
            //submit 总共有3中重载1、Runnable 2、泛型，传入Result 3、callable
//            result = executor.submit(new Task("zy" + i, latch),res);
            Callable<Math> call = Executors.callable(new Task("zy" + i, latch), res);
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
