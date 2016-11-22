package site.luoyu.RMI.server.javaRMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface remoteInterface extends Remote {
	public String sayhellow() throws RemoteException;
}