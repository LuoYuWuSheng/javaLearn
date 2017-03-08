package site.luoyu.RMI.client;


import site.luoyu.RMI.remoteInterface;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * RMI是如何实现的？利用序列化在网络上传输这个类？
 * 在客户端的的jvm中收到的类虽然声明为 remoteInterface
 * 但是在堆中究竟是怎么存储的呢？
 */

public class RMIClient {

	public static void main(String[] args) {
		try {
            //todo securityManage 有点意思
//          SecurityManager sm = new SecurityManager();
//          System.setSecurityManager(sm);
//			System.getProperty("java.security.policy");
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
