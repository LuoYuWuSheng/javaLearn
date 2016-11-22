package site.luoyu.RMI.client.javaRMIremote;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javaRMI.remoteInterface;

public class remote {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try { 
			System.getProperty("java.security.policy");
            //在RMI服务注册表中查找名称为RHello的对象，并调用其上的方法 
            remoteInterface rhello = (remoteInterface) Naming.lookup("rmi://localhost:8888/RHello"); 
            System.out.println(rhello.sayhellow());
        } catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        } 

	}
}
