package site.luoyu.IO.Netty;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelUpstreamHandler;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Computer user xd
 * Created by 张洋 on 2017/6/4.
 */
public class ServerHandler extends SimpleChannelUpstreamHandler {

    private final AtomicLong transferredBytes = new AtomicLong();
    private final ChannelBuffer buffer = ChannelBuffers.buffer(256);

    @Override
    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) {
        // Send back the received message to the remote peer.
        ChannelBuffer buf = (ChannelBuffer) e.getMessage();

        while (buf.readable()) {
            char temp = (char) buf.readByte();
            System.out.println(temp);
            System.out.flush();
        }
        transferredBytes.addAndGet(((ChannelBuffer) e.getMessage()).readableBytes());
        e.getChannel().write(e.getMessage());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) {
        // Close the connection when an exception is raised.
        e.getCause().printStackTrace();
        e.getChannel().close();
    }
}
