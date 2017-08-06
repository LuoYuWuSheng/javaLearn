package site.luoyu.IO.BIO;


import java.io.*;
import java.net.Socket;

/**
 * Computer user xd
 * Created by 张洋 on 2017/5/31.
 */
public class ServerHandler implements Runnable {
    private Socket socket;
    //    private InputStream inputStream;
    private BufferedReader reader;
    private BufferedWriter writer;

    public ServerHandler(Socket socket) throws IOException {
        this.socket = socket;
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
    }

    @Override
    public void run() {
        try {
            System.out.println("<<<<<<<<<<<< Message from Client :" + reader.readLine());
            //阻塞客户端一分钟，此时客户端应该会有20（每3000ms创建一个）个模拟的客户端在等待响应
            Thread.sleep(10000);
            writer.write("I am Server happy to know you! I block your for 10000ms\n");
            writer.flush();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
