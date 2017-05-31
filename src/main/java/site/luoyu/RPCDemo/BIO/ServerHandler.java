package site.luoyu.RPCDemo.BIO;


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
            System.out.println("<<<<<<<<<<<<<<<<<<<< Message from Client :" + reader.readLine());
            writer.write("I am Server happy to know you\n");
            writer.flush();
            Thread.sleep(10000);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
