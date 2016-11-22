package site.luoyu.GenericCode;

/**
 * 泛型方法，利用的是类填填充
 * 如果类型有约束的话填充约束类型，如果类型没有约束的话填充Object
 * 1.如果有多个约束怎么办？ 取第一个进行替换
 * 2.如果约束类型也是泛型怎么办？例如Compareable
 */
public class GenericClass<T>{

    public void testGate(){
        typeConsist("a","b");
        generalMethod(1,"1",1.1);
    }

    /**
     * 单一约束
     * @param a
     * @param b
     * @param <T>
     */
    public <T extends Comparable> void typeConsist(T a, T b) {
        System.out.println(a.compareTo(b));
    }

    /**
     * 泛型方法，不显示传入类型，让函数自己判断。
     * @param a
     * @param <E>
     * @return
     */
    public <E> E generalMethod(E... a){
        return a[a.length/2];
    }

}
