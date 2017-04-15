/**
 * Computer user xd
 * Created by 张洋 on 2017/4/12.
 * java 的native 方法。
 * 可以直接嗲用dll，但同时也失去了java安全，跨平台的优势
 * .dll是64位的动态链接库。实现了JniHelow的native方法。
 * 步骤
 *      1、先用javah+类路径名 编译生成.h文件。
 *      2、引入jni.h,jawt_md.h,jni_md.h。利用c++实现.h文件中的函数
 *      3、编译生成64位（视jvm位数而定）动态链接库
 *      4、System.load(链接库的绝对路径名)引入动态链接库。
 *      5、new 实例后直接调用方法。
 * 本示例包含
 *      1、参数以及返回值的传递，转换。
 *      2、java域在C++中的获取与设置
 *      3、C++中调用java方法并传递参数
 *      4、数组的使用
 * C++的源码在Resource/CppCode文件夹下
 * 生成的动态库在Resource文件夹下
 * 如何在VS中编译以及引入Jni这里不讲，不懂的可以去看java核心卷II 最后Jni一章
 */
package site.luoyu.jni;