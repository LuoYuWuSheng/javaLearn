package site.luoyu.RPCDemo.AIO.Server;

/**
 * Computer user xd
 * Created by 张洋 on 2017/6/1.
 */
public class ServerStart {
    public static void main(String[] args) {
        AsyncServer serverThread = new AsyncServer();
        Thread Server = new Thread(serverThread);
        Server.start();
    }
}
