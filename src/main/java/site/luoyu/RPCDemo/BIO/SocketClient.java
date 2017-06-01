package site.luoyu.RPCDemo.BIO;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Computer user xd
 * Created by 张洋 on 2017/5/31.
 */
public class SocketClient {
    private static BufferedReader in;
    private static PrintWriter out;

    public void connect() throws InterruptedException {
        Socket socket = null;
        try {
            //这里指定的端口是指要链接的远端地址和端口，指定本地端口需要用bind，否则会自动随机一个端口
            socket = new Socket("localhost", 5050);
            //todo 这里还是有不理解的，如果指定绑定端口，则应该有一个客户端链接成功才对
            socket.bind(new InetSocketAddress(5055));
            System.out.println("Connect seccess");
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream());
            out.write("Hellow I am from client\n");
            out.flush();
            //客户端不休眠，被服务端阻塞
            String ServerData = in.readLine();
            System.out.println(">>>>>>>>>>Message from server" + ServerData);
//            Thread.sleep(60000);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out != null) {
                out.close();
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
