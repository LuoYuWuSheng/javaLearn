package site.luoyu.jni;

import java.io.UnsupportedEncodingException;

/**
 * Computer user xd
 * Created by 张洋 on 2017/4/12.
 */
public class Main {
    public static void main(String[] args) throws UnsupportedEncodingException {

        JniHello hello = new JniHello();
//          int操作
//        int result = hello.SayHellow(1);
//        System.out.println(result);

        //String操作
        String cName = hello.tellName("张洋");
        System.out.println(cName);

        //数组操作
        byte[] byteRes = hello.getBytes("我是Java数组".getBytes());
//        String fromC = new String(byteRes);
        System.out.println(new String(byteRes));

        //操作域
//        todo String域不赋值会导致虚拟机崩溃。应该是不手动赋值的话c++端获得的应该是一个Null指针
        hello.sField = "java域";
        hello.field = 1;
        byte[] array = new byte[10];
        array[0] = 12;
        hello.aField = array;
        hello.setField();
        System.out.println("C++ 设置的String域 " + hello.sField);
        System.out.println("C++ 设置Array域    " + hello.aField[0]);
    }
}
