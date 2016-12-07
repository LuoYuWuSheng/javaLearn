package site.luoyu.Concurrent.BankDemo;

/**
 * Created by xd on 2016/12/4.
 */
public class UnsynchBankTest {
    public static final int NACCONTS = 100;
    public static final double INNITAL_BALNCE = 1000;

    public static void main(String[] args) {
        Bank b = new Bank(NACCONTS,INNITAL_BALNCE);
        for (int j = 0; j < NACCONTS; j++) {
            TransferRunnable r = new TransferRunnable(b,j,INNITAL_BALNCE);
            Thread t = new Thread(r);
            t.start();
        }
    }
}
