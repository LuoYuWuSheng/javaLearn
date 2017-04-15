package site.luoyu.jni;

import java.net.URL;

/**
 * Computer user xd
 * Created by 张洋 on 2017/4/12.
 * 1、调用本地方法
 * 2、调用本地静态方法
 * 3、获取，访问域（类、实例）
 * 4、本地方法调用java 方法。
 * 5、访问数组元素
 * 6、错误处理
 * 7、C使用调用api
 */
public class JniHello {

    public int field;
    public String sField;
    public byte[] aField = new byte[100];

    static {
        URL url = JniHello.class.getResource("/JniHelloDLL.dll");
//        System.out.println(url.getPath());
//        System.load(url.getPath());
        System.loadLibrary("JniHelloDLL");
    }

    //    int 示例，double等其他基本类型不在再举例，都是一样的。
    public native int SayHellow(int data);

    //    String 类型示例。这里设计到java与c++字符互相转换的问题
    public native String tellName(String name);

    //    数组示例
    public native byte[] getBytes(byte[] input);

    //    jni获取域并设置
    public native void setField();

    //    c++调用java 方法
    public void javaSayHello(String name) {
        System.out.println("java say hello to " + name);
    }
}
