package site.luoyu.Concurrent.BankDemo;

/**
 * Created by xd on 2016/12/4.
 */
public class TransferRunnable implements Runnable{

    private Bank bank;
    private int fromAccount;
    private double maxAmount;
    private int Delay = 10;

    public TransferRunnable(Bank bank, int fromAccount, double max) {
        this.bank = bank;
        this.fromAccount = fromAccount;
        this.maxAmount = max;
    }

    @Override
    public void run() {
        try {
            while (true){
                int toAccount = (int) (bank.size()*Math.random());
                double amount = maxAmount * Math.random();
                bank.transferLock(fromAccount,toAccount,amount);
                Thread.sleep((int) (Delay* Math.random()));
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
