package site.luoyu.Grammer;

/**
 * Computer user xd
 * Created by 张洋 on 2016/12/8.
 * 运算符通过优先级和结合性来判断最终的语义
 * 优先级高的先运算，当优先级相同的时候 按照结合顺序运算
 * java中只有 一元运算符 三元运算符 以及赋值运算符(= += >>=等) 是从右向左结合的，
 * 其余都是从左向右结合的
 */
public class CalSignal {

    public void testPriority(){
        int c =1;
//        从右向左结合
        int a = c>0 ? 1 : false ? 4 : 5;

        int b = 1;
        b = b + 1 + 2;
    }
}
