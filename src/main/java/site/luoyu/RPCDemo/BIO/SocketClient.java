package site.luoyu.RPCDemo.BIO;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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
            //todo 一个端口可以被多个Socket绑定？
            socket = new Socket("localhost", 5050);
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
