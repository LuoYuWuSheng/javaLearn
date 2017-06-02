package site.luoyu.RPCDemo.AIO.Server;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * Computer user xd
 * Created by 张洋 on 2017/6/2.
 */
public class WriteCompletionHandler implements CompletionHandler<Integer, ByteBuffer> {
    private AsynchronousSocketChannel channel;

    public WriteCompletionHandler(AsynchronousSocketChannel channel) {
        //todo bugReport，对于自身的private方法，使用this时不提示
        if (this.channel == null) {
            this.channel = channel;
        }
    }

    @Override
    public void completed(Integer result, ByteBuffer attachment) {
        //没有写完接着写，还是将自己传进去
        if (attachment.hasRemaining()) {
            channel.write(attachment, attachment, this);
        }
    }

    @Override
    public void failed(Throwable exc, ByteBuffer attachment) {
        try {
            channel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
