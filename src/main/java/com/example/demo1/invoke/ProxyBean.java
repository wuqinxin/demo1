package com.example.demo1.invoke;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.nio.channels.InterruptibleChannel;

/**
 * 代理对象
 */
public class ProxyBean implements InvocationHandler {

    private Object target;

    private Interceptor interceptor;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable{
        //异常标识
        boolean exceptionFlag = false;
        Invocation invocation = new Invocation(args,method,target);
        Object obj = null;
        try {
            if(this.interceptor.before()){
                obj = this.interceptor.around(invocation);
            } else{
                obj = method.invoke(target, args);
            }
        } catch (Exception e){
            exceptionFlag = true;
        }
        this.interceptor.after();
        if (exceptionFlag){
            this.interceptor.afterThrowing();
        } else {
            this.interceptor.afterReturing();
            return obj;
        }
        return null;
    }

    public static Object getProxyBean(Object target, Interceptor interceptor){
        ProxyBean proxyBean = new ProxyBean();
        //保存被代理的对象
        proxyBean.target = target;
        //保存拦截器
        proxyBean.interceptor = interceptor;
        Object proxy = Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),proxyBean);
        //返回代理对象
        return proxy;
    }
}
