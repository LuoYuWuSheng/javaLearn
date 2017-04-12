package site.luoyu.jni;

/**
 * Computer user xd
 * Created by 张洋 on 2017/4/12.
 */
public class Main {
    public static void main(String[] args) {
//        竟然只能使用绝对路径名，好失望。
        System.load("H:\\MyProject\\javaLearn\\src\\main\\java\\site\\luoyu\\jni\\JniHelloDLL.dll");
        JniHello hello = new JniHello();
        hello.SayHellow();
    }
}
