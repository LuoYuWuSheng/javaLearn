package site.luoyu.RMI.server;

import site.luoyu.RMI.remoteInterface;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class serviceImpl extends UnicastRemoteObject implements remoteInterface {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected serviceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String sayhellow() throws RemoteException {
		// TODO Auto-generated method stub
		return "hellow this is server said from remote";
	}


}
