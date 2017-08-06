package site.luoyu.IO.AIO.Server;

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
            this.latch = new CountDownLatch(1);
            this.asynchronousServerSocketChannel = AsynchronousServerSocketChannel.open();
//            asynchronousServerSocketChannel.setOption(StandardSocketOptions.SO_REUSEADDR,true);
            this.asynchronousServerSocketChannel = asynchronousServerSocketChannel.bind(new InetSocketAddress("localhost", this.port), 100);
            System.out.println(asynchronousServerSocketChannel.getLocalAddress().toString());
            System.out.format("============Async Server is Started at port %d!============", this.port).println();
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
        //注册监听处理程序
        asynchronousServerSocketChannel.accept(this, new AcceptCompletionHandler());
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        AsyncServer serverThread = new AsyncServer();
        Thread Server = new Thread(serverThread);
        Server.start();
    }
}
