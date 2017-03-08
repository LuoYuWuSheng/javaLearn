package site.luoyu.Java8.Lambuda;

/**
 * Computer user xd
 * Created by 张洋 on 2017/3/8.
 */
public class RunLambuda {
    public static void main(String[] args) {
        LamInterface lambuda = (String name)->System.out.println(name);
        lambuda.run("zy");
    }
}
