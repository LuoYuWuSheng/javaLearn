package site.luoyu.Spider;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Computer user xd
 * Created by 张洋 on 2016/12/25.
 */
public class aSpider {

    public static void main(String[] args) {
        try {
            URL pageURL = new URL("http://www.meishij.net/zuofa/heifashimakalong_1.html");
            InputStream inputStream = (InputStream) pageURL.getContent();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);

            //todo user.dir 就是虚拟机启动的路径
            System.out.println(new File("./").getAbsoluteFile());
            System.out.println(System.getProperty("user.dir"));


            File tempHtml = new File("./spiderDown.html");
            tempHtml.createNewFile();
            FileOutputStream outputStream = new FileOutputStream(tempHtml);
            int tempINt;
            while ((tempINt = bufferedInputStream.read()) != -1){
                outputStream.write(tempINt);
            }
//            System.out.println(html);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
