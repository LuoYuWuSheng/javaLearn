package site.luoyu.RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * RMI的interface 类路径在两边一定要一致
 * 也就是说remote 跟client 需要在同一个jar包下
 * 也可以在两边分别在不同的文件夹下，但是一定要保证类的全限名是正确的
 */
public interface remoteInterface extends Remote {
	String sayhellow() throws RemoteException;
}