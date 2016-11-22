package site.luoyu.Concurrent;

/**
 * Created by xd on 2016/11/22.
 */
public class ConcurrentDemo {

    private volatile boolean flag;
    private volatile int count;

    public int getCount() {
        return count;
    }

    /**
     * 验证volatil并不保证并发
     * 原因是读后写，虽然volatile保正写后立即可见
     * 仍然无法避免别的现成读到处理器后再对这个变量写
     */
    public void addCount(){
        count++;
    }

    public void writeFlag(){
        flag = true;
    }

    public void readFlag(){
        if(flag){
            System.out.println("flag is true");
        }
    }
}
