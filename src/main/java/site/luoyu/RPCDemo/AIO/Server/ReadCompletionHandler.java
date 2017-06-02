package site.luoyu.RPCDemo.AIO.Server;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * Computer user xd
 * Created by 张洋 on 2017/6/2.
 * 一个读取成功的处理
 */
public class ReadCompletionHandler implements CompletionHandler<Integer, ByteBuffer> {
    private AsynchronousSocketChannel channel;

    public ReadCompletionHandler(AsynchronousSocketChannel channel) {
        if (this.channel == null) {
            this.channel = channel;
        }
    }

    @Override
    public void completed(Integer result, ByteBuffer attachment) {
        attachment.flip();
        byte[] body = new byte[attachment.remaining()];
        attachment.get(body);
        try {
            String req = new String(body, "UTF8");
            System.out.println("Server received is :" + req);
            doAnswer();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private void doAnswer() {
        byte[] bytes = "This is Server's Answer".getBytes();
        ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
        writeBuffer.put(bytes);
        //buffer这一步到底是在做什么？
        writeBuffer.flip();
        channel.write(writeBuffer, writeBuffer, new WriteCompletionHandler(channel));
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
