package site.luoyu.RPCDemo.Netty;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.*;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Computer user xd
 * Created by 张洋 on 2017/6/4.
 */
public class ClientHandler extends SimpleChannelUpstreamHandler {
    private final ChannelBuffer firstMessage;
    private final AtomicLong transferredBytes = new AtomicLong();
    private final int ClientSize = 256;

    /**
     * Creates a client-side handler.
     */
    public ClientHandler() {
        firstMessage = ChannelBuffers.buffer(ClientSize);
        String data = "Hello I am client";
        for (int i = 0; i < data.length(); i++) {
            firstMessage.writeByte(data.charAt(i));
        }
//        for (int i = 0; i < firstMessage.capacity(); i++) {
//        }
    }

    public long getTransferredBytes() {
        return transferredBytes.get();
    }

    @Override
    public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e) {
        // Send the first message.  Server will not send anything here
        // because the firstMessage's capacity is 0.
        e.getChannel().write(firstMessage);
    }

    @Override
    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) {
        // Send back the received message to the remote peer.
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
