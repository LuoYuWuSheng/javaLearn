/**
 * Created by xd on 2016/11/22.
 * @Author 张洋
 * 这个包是对java内部类的学习
 * 内部类包括了
 * 1、类内部类
 * 2、静态内部类
 * 3、局部内部类
 * 4、匿名内部类
 * 内部类隐含一个对外部类的引用指针。
 * 如果想使用外部类的域这需要通过 {OuterClass}.this 的方法对外部类引用
 * 如果外部类作用域之外想引用内部类则需要通过 {OuterClass}.{InnerClass}.this来引用
 */
package site.luoyu.innerClass;