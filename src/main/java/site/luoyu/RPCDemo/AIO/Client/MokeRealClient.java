package site.luoyu.RPCDemo.AIO.Client;

/**
 * Computer user xd
 * Created by 张洋 on 2017/5/31.
 * 异步访问的Client
 */
public class MokeRealClient {

    public static void main(String[] args) throws InterruptedException {
        while (true) {
            Thread oneClient = new Thread(new AsynClientHandler("localhost", 5060));
            oneClient.start();
            Thread.sleep(3000);
        }
    }
}
