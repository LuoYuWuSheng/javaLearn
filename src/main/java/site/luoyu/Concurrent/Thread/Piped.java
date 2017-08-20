package site.luoyu.Concurrent.Thread;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * Computer user xd
 * Created by 张洋 on 2017/8/16.
 * Pipe 管道示例。关键在于需要connect
 */
public class Piped {
    public static void main(String[] args) throws IOException {
        PipedWriter out = new PipedWriter();
        PipedReader in = new PipedReader();
        out.connect(in);
        Thread printThread = new Thread(new Print(in), "PrintThread");
        printThread.start();
        int receive = 0;
        try {
            while ((receive = System.in.read()) != -1) {
                out.write(receive);
            }
        } finally {
            out.close();
        }
    }

    static class Print implements Runnable {
        private PipedReader in;

        public Print(PipedReader in) {
            this.in = in;
        }

        @Override
        public void run() {
            int receive = 0;
            try {
                while ((receive = in.read()) != -1) {

                }
            } catch (IOException ex) {
            }
        }
    }
}
