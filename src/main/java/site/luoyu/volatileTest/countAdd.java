package site.luoyu.volatileTest;

public class countAdd extends Thread{
	testVolatile instance = null;
	
	public void setInstance(testVolatile instance) {
		this.instance = instance;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
//			testVolatile.classLockAdd();
			instance.instaceLockAdd();
//			instance.instaceLockAdd();
			//先自增然后再sleep 竟然会导致程序能正常执行 不理解
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
