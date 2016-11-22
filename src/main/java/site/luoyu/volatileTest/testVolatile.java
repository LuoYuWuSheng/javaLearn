package site.luoyu.volatileTest;

import java.util.ArrayList;

public class testVolatile {

	//这里没能证明即使synchrized 不加volatile 也会有可见性问题
	//理解错误，synchronized 能保证释放锁之前将所有的修改刷新到主内存
	public static int volCount = 0;
	public int count = 0;
	
	public static void classLockAdd() {
		synchronized (testVolatile.class) {
			volCount++;
		}
	}

	//这里是一个实例锁
	/**
	 * 实例锁有两种方式，一种是通过在函数上加上synchronize 另一种是通过
	 * synchronized (this){}方法，两种方式效果相同
	 * 对于static 成员，通过实例锁是没有用的，因为不同的实例依然能冲突的访问static变量
	 */
	//todo 证明实例锁没有用
	public void instaceLockAdd() {
        synchronized (this){
            count++;
        }
//        count++;
	}
	
	public static void main(String[] args) {
		testVolatile instance = new testVolatile();
		ArrayList<Thread> pool = new ArrayList<Thread>();
		for (int i = 0; i < 10000 ; i++) {
			countAdd test = new countAdd(instance);
			pool.add(test);
			test.start();
		}
		for(Thread t : pool){
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("class lock:"+testVolatile.volCount);
		System.out.println("instance lock:"+instance.count);
	}

	public static class countAdd extends Thread{
		testVolatile instance = null;

		public countAdd(testVolatile instance){
            this.instance = instance;
        }

		@Override
		public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            testVolatile.classLockAdd();
            instance.instaceLockAdd();
            //todo 先自增然后再sleep 竟然会导致程序能正常执行 不理解
            //怀疑模拟并发环境模拟的不好，有可能线程创建好后直接执行，并没有产生并发问题
        }
	}
}
