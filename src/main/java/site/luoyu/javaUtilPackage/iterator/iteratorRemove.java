package site.luoyu.javaUtilPackage.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by xd on 2016/12/7.
 * iterator 不能连续调用remove
 */
public class iteratorRemove {
    public static void main(String[] args) {
        List<String> testRemove = new ArrayList<>();
        testRemove.add("hello");
        testRemove.add("my");
        testRemove.add("java");
        testRemove.add("world");
        Iterator<String> it = testRemove.iterator();
        it.next();
        it.next();
        //连续remove应该删除hellow my
        it.remove();
        //连续remove会报illegalStatException
        it.remove();
        //神奇的lambda表达式
        testRemove.forEach(System.out::println);
    }
}
