package site.luoyu.Java8;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Computer user xd
 * Created by 张洋 on 2017/3/9.
 * flatMap 的一个示例,去重单词统计
 */
public class MyStream {
    public static void main(String[] args) {
        String[] data = {"hello world","hello man"};
        Stream.of(data).map(a->a.split(" ")).flatMap(Arrays::stream).distinct().forEach(System.out::println);
    }
}
