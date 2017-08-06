package site.luoyu.IO.AIO.Client;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.CountDownLatch;

/**
 * Computer user xd
 * Created by 张洋 on 2017/6/2.
 */
public class CWritecComplHandler implements CompletionHandler<Integer, ByteBuffer> {
    private AsynchronousSocketChannel client;
    private CountDownLatch latch;

    public CWritecComplHandler(AsynchronousSocketChannel client, CountDownLatch latch) {
        //todo bugReport，对于自身的private方法，使用this时不提示
        if (this.client == null) {
            this.client = client;
        }
        this.latch = latch;
    }

    @Override
    public void completed(Integer result, ByteBuffer attachment) {
        if (attachment.hasRemaining()) {
            client.write(attachment, attachment, this);
        } else {
            //想要做到写后再去读之只能这样一层一层的嵌套吗？
            ByteBuffer readBuffer = ByteBuffer.allocate(1024);
            client.read(readBuffer, readBuffer, new CReadComplHandler(client, latch));
        }
    }

    @Override
    public void failed(Throwable exc, ByteBuffer attachment) {
        try {
            client.close();
            latch.countDown();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
