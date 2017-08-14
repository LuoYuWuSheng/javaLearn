package site.luoyu.Concurrent.Lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Computer user xd
 * Created by 张洋 on 2016/12/27.
 * 自定义锁
 */
public class MyLock implements Lock {
    //实现自AQS
    private static class Sync extends AbstractQueuedSynchronizer {
        //是否处于同步状态
        @Override
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }

        //非阻塞获取锁
        @Override
        protected boolean tryAcquire(int arg) {
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            } else {
                return false;
            }
        }

        //释放锁
//        todo 释放锁也要try？不是一定不会阻塞，很快就会返回？
        @Override
        protected boolean tryReleaseShared(int arg) {
//            todo 为什么要先判断一下状态？
            if (getState() == 0) throw new IllegalMonitorStateException();
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        //      返回一个condition
// todo 每个Condition都包含了一个Condition队列？
        Condition newCondition() {
            return new ConditionObject();
        }
    }

    //集成一个AQS的子类来实现自定义锁的功能
    private final Sync sync = new Sync();

    //Lock接口对比于synchronized的优势如下
    //1、支持中断式，超时，非阻塞获取锁
    //2、支持多个Condition
    @Override
    public void lock() {
        sync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1, unit.toNanos(time));
    }

    @Override
    public void unlock() {
        sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }
}
