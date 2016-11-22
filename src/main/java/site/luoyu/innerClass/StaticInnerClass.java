package site.luoyu.innerClass;

/**
 * Created by xd on 2016/11/22.
 * 静态内部类可以通过new直接创建
 * 而非静态内部类只能在外部类的作用域内进行new
 */
public class StaticInnerClass {

    private static String outerClassField = "outerClassField";
    /**
     * 外部类与内部类的公共域
     */
    private static String commonField = "OuterClassField";

    public static class InnerClass {
        /**
         * 与外部类的名称相同
         */
        private String commonField = "InnerClassField";

        public void getOuterClassField(){
            System.out.println("Print outer Class Field :" +outerClassField);
            System.out.println("Common Field from Inner Class :"+commonField);
            System.out.println("Common Field from Outer Class :"+StaticInnerClass.commonField);
        }
    }

    public static void main(String[] args) {
        InnerClass innerClass = new InnerClass();
        innerClass.getOuterClassField();
    }
}
