package site.luoyu.Concurrent.BankDemo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * Created by xd on 2016/12/4.
 */
public class Bank {
    //add a log
    private Lock bankLock = new ReentrantLock();
    //condition 容易造成死锁
    private Condition sufficientFunds;
    private final double[] accounts;
    public Bank(int n,double initilBalance){
        accounts = new double[n];
        for (int i = 0; i < n; i++) {
            accounts[i] = initilBalance;
        }
        sufficientFunds = bankLock.newCondition();
    }


    private void transfer(int from,int to,double amount) {
//        if(accounts[from]<amount)return;
        //不知道非同步的方法调用这个方法会发生什么问题？
        System.out.println(Thread.currentThread());
        accounts[from]-=amount;
        System.out.printf("%10.2f from %d to %d",amount,from,to);
        accounts[to]+=amount;
        //不会立即执行，需要当前锁被释放，然后重新去跟大家一起竞争。
        sufficientFunds.signalAll();
        System.out.printf(" Total Balance: %10.2f%n",getTotalBalance());
    }

    /**
     * 不加锁转账
     */
    private void transferUnLock(int from,int to,int amount){
        transfer(from,to,amount);
    }

    /**
     * 带锁转账
     * @param from 来源
     * @param to 去向
     * @param amount 数量
     */
    public void transferLock(int from, int to, double amount){
        bankLock.lock();
        try {
            //在这里进行条件检查，释放锁的前一步在进行signalAll
            while (accounts[from]<amount){
                // TODO: 2016/12/4 猜测await方法是释放当前锁，然后去构造另外一个锁来阻塞进程，并且将这些被阻塞的放到一个队列里，以便signalAll
                sufficientFunds.await();
            }
            transfer(from,to,amount);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            bankLock.unlock();
        }
    }

    /**
     * 获得当前账户的金额和，初始情况是每人1000，总共100人
     * @return
     * 返回金钱数量
     */
    private double getTotalBalance() {
        double sum = 0;
        for( double a: accounts){
            sum+=a;
        }
        return sum;
    }

    /**
     * 获取账户个数
     */
    public int size(){
        return accounts.length;
    }
}
