package site.luoyu.Proxy;

import org.omg.CORBA.SystemException;
import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.InvokeHandler;
import org.omg.CORBA.portable.OutputStream;
import org.omg.CORBA.portable.ResponseHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Computer user xd
 * Created by 张洋 on 2017/8/20.
 * 通过getProxyClass来获取代理。
 * 创建某一接口 Foo 的代理：
 * 一、先创建动态代理的类型（Class）然后再创建实例
 * InvocationHandler handler = new MyInvocationHandler(...);
 * Class proxyClass = Proxy.getProxyClass(Foo.class.getClassLoader(), new Class[] { Foo.class });
 * Foo f = (Foo) proxyClass.getConstructor(new Class[] { InvocationHandler.class }).newInstance(new Object[] { handler });
 * 二、直接创建被代理的实例
 * Foo f = (Foo) Proxy.newProxyInstance(Foo.class.getClassLoader(),new Class[] { Foo.class },handler);、
 * 参数：1、被代理类型的类加载器 2、代理的接口 3、执行该接口的具体代理功能
 */
interface task {
    public void run();
}

public class DynamicProxy<P> {
    public P getProxy(final Class<?> serviceClass) {
        return (P) Proxy.newProxyInstance(serviceClass.getClassLoader(),
                new Class<?>[]{serviceClass.getInterfaces()[0]},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        return null;
                    }
                }
        );
    }
}
