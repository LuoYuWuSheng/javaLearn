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
//		volCount++;
		count++;
	}
	
	public static void main(String[] args) {
		testVolatile instance = new testVolatile();
		ArrayList<Thread> pool = new ArrayList<Thread>();
		for (int i = 0; i < 1000 ; i++) {
			countAdd test = new countAdd();
			test.setInstance(instance);
			pool.add(test);
			test.start();
		}
		for(Thread t : pool){
			try {
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println(testVolatile.volCount);
		System.out.println(instance.count);
	}
}
