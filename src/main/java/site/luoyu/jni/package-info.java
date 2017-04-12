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
 * 上述示例中并没有使用jni来传递参数。参数只支持基本类型
 */
package site.luoyu.jni;