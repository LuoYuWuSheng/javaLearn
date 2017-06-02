package site.luoyu.RPCDemo.AIO.Server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.CountDownLatch;

/**
 * Computer user xd
 * Created by 张洋 on 2017/6/1.
 */
public class AsyncServer implements Runnable {
    private int port = 5060;
    CountDownLatch latch;
    AsynchronousServerSocketChannel asynchronousServerSocketChannel;

    public AsyncServer() {
        this(null);
    }

    public AsyncServer(Integer port) {
        try {
            if (port != null) {
                this.port = port;
            }
            this.latch = latch = new CountDownLatch(1);
            this.asynchronousServerSocketChannel = AsynchronousServerSocketChannel.open();
            asynchronousServerSocketChannel.bind(new InetSocketAddress(port));
            System.out.println("============Async Server is Started!============");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (asynchronousServerSocketChannel != null) try {
                asynchronousServerSocketChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        doAccept();
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void doAccept() {
        //注册监听处理程序
        asynchronousServerSocketChannel.accept(this, new AcceptCompletionHandler());
    }
}
