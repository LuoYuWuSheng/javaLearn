package site.luoyu.IO.BIO;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Computer user xd
 * Created by 张洋 on 2017/5/31.
 */
public class SocketServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(5050);
        long total = 0;
        while (true) {
            //这是个阻塞方法？直到有链接过来才将请求在后台创建线程？
            Socket socket = server.accept();
            if (socket != null) {
                Thread task = new Thread(new ServerHandler(socket), "taskHandler-" + total++);
                task.start();
            }
        }
    }
}
