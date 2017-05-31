package site.luoyu.RPCDemo.NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;

/**
 * Computer user xd
 * Created by 张洋 on 2017/5/31.
 */
public class NIOServer {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel server = ServerSocketChannel.open();
        server.socket().bind(new InetSocketAddress("localhost", 5051));
        //设置为非阻塞模式
        server.configureBlocking(false);
    }
}
