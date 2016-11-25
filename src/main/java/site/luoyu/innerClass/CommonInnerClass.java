package site.luoyu.innerClass;

/**
 * Created by xd on 2016/11/22.
 * 非静态内部类不能通过调用new直接创建
 * 换句话说，非静态内部类只能被外部创建。(准确来说，造成这种状况的原因是创建非静态内部类需要传入this指针)
 * 可以通过外部类返回自己创建的内部类，从而使得在外部类的作用域外也能使用非晶态内部类
 */
public class CommonInnerClass {

    private  String outerClassField = "outerClassField";
    /**
     * 外部类与内部类的公共域
     */
    private  String conmonField = "OuterClassField";

    /**
     * 将内部类释放出去
     * @return 创建的内部类
     */
    public InnerClass releaseInner(){
        return new InnerClass();
    }

    private class InnerClass {
        /**
         * 与外部类的名称相同
         */
        private String commonField = "InnerClassField";

        public void getOuterClassField(){
            System.out.println("Print outer Class Field :" +outerClassField);
            System.out.println("Common Field from Inner Class :"+conmonField);
        }
    }

    public static void main(String[] args) {
        CommonInnerClass commonInnerClass = new CommonInnerClass();
        //通过外部类创建一个内部类实例，并且释放到外部类的作用域之外，让其他人使用！这不是使用内部类的正确实践
        CommonInnerClass.InnerClass innerClass = commonInnerClass.releaseInner();
        //在外部类的作用域外无法创建内部类，缺少this指针。不知道有没有显示的方法可以创建
//        CommonInnerClass.InnerClass testCreate = new CommonInnerClass.InnerClass(commonInnerClass);
    }
}
