package site.luoyu.IO.AIO.Server;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * Computer user xd
 * Created by 张洋 on 2017/6/1.
 * 一个链接成功的处理器
 */
public class AcceptCompletionHandler implements CompletionHandler<AsynchronousSocketChannel, AsyncServer> {

    @Override
    public void completed(AsynchronousSocketChannel result, AsyncServer attachment) {
        //这个必须有，去手动的循环，让服务端能异步继续监听
        attachment.asynchronousServerSocketChannel.accept(attachment, this);
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        result.read(buffer, buffer, new ReadCompletionHandler(result));
        System.out.println(">>>handle result complete >>>");
    }

    @Override
    public void failed(Throwable exc, AsyncServer attachment) {
//        attachment.latch.countDown();
        System.out.println("----- get result error ----");
//        attachment.asynchronousServerSocketChannel.accept(attachment, this);
    }
}
