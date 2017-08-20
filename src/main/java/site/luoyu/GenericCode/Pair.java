package site.luoyu.GenericCode;


import java.util.Date;

/**
 * 最早的泛型只是传入Object，这样每次都需要进行类型转换，容易出错。
 * java提供了泛型仅仅是帮助你能提前检查，没有泛型语法，泛型的功能也是都能实现的。
 * 泛型有叫做类型参数，使用的方法有两种：
 * 1、出入一个固定的类型（无限定）
 * 2、传入一类类型通配符？extends A & B，：？super A等（有限定）
 * （思考T extends A 与 ？ extends A 区别！
 *前者只能在定义泛型类或方法的时候出现，而后者主要是为了表示普通方法传入的参数的限制，而不是泛型
 *比如A 类test(? extends B)，表示出入B的子类，这时候就不能用T extends B了，因为test根本不是泛型方法）
 * 使用泛型的位置：
 * 1、泛型类
 * 2、泛型接口
 * 3、泛型方法
 * 所谓泛型只不过是一个语法糖，最后都是要进行类型擦除的，无限定的擦除为Object，有限定查除为右边第一个限定。
 * 这种生成的类型被称为**原始类型**
 * 由此带来的问题1、擦除与方法重写(利用桥方法保持多态性)
 * 泛型方法，利用的是类填填充
 * 如果类型有约束的话填充约束类型，如果类型没有约束的话填充Object
 * 1.如果有多个约束怎么办？ 取第一个进行替换
 * 2.如果约束类型也是泛型怎么办？例如Compareable 按照原始类型算
 *
 */
public class Pair<T> {

    //以下是书上的官方示例
    private T first;
    private T second;

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        this.second = second;
    }

    //以下是自己尝试的泛型编程
    public void testGate() {
        typeConsist("a", "b");
        generalMethod(1, "1", 1.1);
    }

    public void useT(T a) {
        System.out.println("Using type from T");
    }


    /**
     * 单一约束
     *
     * @param <G> 类型参数，这里的T跟泛型类传入的T没有任何关系
     */
    public <G extends Comparable> void typeConsist(G a, G b) {
        System.out.println(a.compareTo(b));
    }

    /**
     * 泛型方法，不显示传入类型，让函数自己判断。
     *
     * @param a
     * @param <E>
     * @return
     */
    public <E> E generalMethod(E... a) {
        return a[a.length / 2];
    }

}

class DataInterval extends Pair<Date> {

    public DataInterval(Date first, Date second) {
        super(first, second);
    }

    /**
     * 这个方法根据继承来说是需要产生多态特性的（重写）
     * 但是遇到泛型擦除后，父类是（Object），子类是Date 如何正确的处理多态的特性？
     * 虚拟机采用桥方法的方式(就是产生一个完全重写父方法的类，然后在这个方法里调用子类的方法，以此来实现重写)
     *
     * @param second
     */
    public void setSecond(Date second) {
        if (second.compareTo(super.getFirst()) > 0) super.setSecond(second);
    }

    public Date getSecond() {
        System.out.println("子类的方法，getSecond");
        return super.getSecond();
    }
}