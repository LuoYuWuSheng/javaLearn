package site.luoyu.GenericCode;

/**
 * Created by xd on 2016/11/21.
 */
public class GenericMethod {
    /**
     * 只需要在方法的前面声明泛型类型即可
     * @param arg1
     * @param <T>
     */
    public static  <T> void  printGenericMethod(T arg1){
        System.out.println(arg1.toString());
    }
}
