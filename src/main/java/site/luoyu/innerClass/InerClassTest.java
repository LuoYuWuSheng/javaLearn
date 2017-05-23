package site.luoyu.innerClass;

/**
 * Computer user xd
 * Created by 张洋 on 2017/5/23.
 * 该方法用来测试上述四种内部类
 */
public class InerClassTest {
    public static void main(String[] args) {
        //匿名和方法内部类不用说，在外部肯定是无法引用的。
        //1.普通内部类
        CommonInnerClass commonInnerClass = new CommonInnerClass();
        //通过实例创建内部类
        CommonInnerClass.InnerClass inner = commonInnerClass.new InnerClass();

        //2.静态内部类 则可以通过类名加构造函数的方式直接创建
        StaticInnerClass.InnerClass staticInner = new StaticInnerClass.InnerClass();
    }
}
