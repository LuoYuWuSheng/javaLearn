package site.luoyu.RPCDemo.Netty;

import org.jboss.netty.bootstrap.ClientBootstrap;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

/**
 * Computer user xd
 * Created by 张洋 on 2017/6/4.
 */
public class Client {
    // Configure the bootstrap.
    public static void start() throws InterruptedException {
        ClientBootstrap bootstrap = new ClientBootstrap(
                new NioClientSocketChannelFactory(
                        Executors.newCachedThreadPool(),
                        Executors.newCachedThreadPool()));
        try {
            bootstrap.setPipelineFactory(new ChannelPipelineFactory() {
                public ChannelPipeline getPipeline() {
                    ChannelPipeline p = Channels.pipeline();
                    p.addLast("echo", new ClientHandler());
                    return p;

                }
            });
            bootstrap.setOption("tcpNoDelay", true);
            bootstrap.setOption("receiveBufferSize", 48576);
            bootstrap.setOption("sendBufferSize", 1048576);

            // Start the connection attempt.
            ChannelFuture future = bootstrap.connect(new InetSocketAddress(5070));
            System.out.println("Client start !");
            // Wait until the connection is closed or the connection attempt fails.
            future.getChannel().getCloseFuture().sync();

        } finally {
            // Shut down thread pools to exit.
            bootstrap.releaseExternalResources();

        }

    }

    public static void main(String[] args) throws InterruptedException {
        start();
    }
}
