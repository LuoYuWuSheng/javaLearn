package site.luoyu.RMI.server.javaRMI;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class mainclass {
	
	public static void main(String[] args){
		 try {
			 	serviceImpl myServiceImplver = new serviceImpl();
			 	LocateRegistry.createRegistry(8888); 
	            //服务器端被额客户端调用
			 	System.out.println("hellow world");
			 	Naming.rebind("rmi://localhost:8888/RHello", myServiceImplver);
			 	System.out.println("registed suessful");
	        } catch (MalformedURLException e) { 
	            e.printStackTrace(); 
	        } catch (RemoteException e) { 
	            e.printStackTrace();   
	        } 
	}

}
