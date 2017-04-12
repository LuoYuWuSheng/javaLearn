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
        /**
         * map 将Stream<String> 转换为Stream<String[]>
         * 然后对这个数组调用扁平化处理，将每个成员String转换为Stream<String>，
         * 然后附加到总的Stream上，形成一个大的Stream。
         * 也就是说flatMap处理的成员是Stream，并将这个Stream增加到父Stream上
         */
        Stream.of(data).map(a->a.split(" ")).flatMap(Arrays::stream).distinct().forEach(System.out::println);
//        下面的这个一样的结果，只不过是创建的过程不一样。
//        Arrays.stream(data).map(a->a.split(" ")).flatMap(Arrays::stream).distinct().forEach(System.out::println);
    }
}
