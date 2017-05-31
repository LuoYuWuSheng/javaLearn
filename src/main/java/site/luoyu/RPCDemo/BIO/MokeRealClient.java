package site.luoyu.RPCDemo.BIO;

/**
 * Computer user xd
 * Created by 张洋 on 2017/5/31.
 */
public class MokeRealClient {
    private static class task extends Thread {
        @Override
        public void run() {
            SocketClient task = new SocketClient();
            try {
                task.connect();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        while (true) {
            Thread oneClient = new task();
            oneClient.start();
            Thread.sleep(3000);
        }
    }
}
