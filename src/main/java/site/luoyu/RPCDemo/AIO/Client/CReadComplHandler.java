package site.luoyu.RPCDemo.AIO.Client;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.CountDownLatch;

/**
 * Computer user xd
 * Created by 张洋 on 2017/6/2.
 */
public class CReadComplHandler implements CompletionHandler<Integer, ByteBuffer> {

    private AsynchronousSocketChannel channel;
    private CountDownLatch latch;

    public CReadComplHandler(AsynchronousSocketChannel channel, CountDownLatch latch) {
        this.channel = channel;
        this.latch = latch;
    }

    @Override
    public void completed(Integer result, ByteBuffer attachment) {
        //半包读情况
        byte[] res = new byte[attachment.remaining()];
        String resString = null;
        try {
            attachment.get(res);
            resString = new String(res, "UTF8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(">>> Ans from Server is :" + resString);

    }

    @Override
    public void failed(Throwable exc, ByteBuffer attachment) {
        try {
            channel.close();
            latch.countDown();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
