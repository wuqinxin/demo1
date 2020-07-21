package com.example.demo1.invoke;

import java.lang.reflect.InvocationTargetException;

public class MyInterceptor implements Interceptor{
    //事前方法
    @Override
    public boolean before(){
        System.out.println("before...");
        return true;
    }

    //事后方法
    @Override
    public boolean after(){
        System.out.println("after...");
        return true;
    }

    /**
     * 取代原有事件方法
     * @param invocation 回调参数，可以通过proceed方法，回调原有事件
     * @return 原有事件返回对象
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    @Override
    public Object around(Invocation invocation) throws InvocationTargetException,IllegalAccessException{
        System.out.println("around before...");
        Object object = invocation.proceed();
        System.out.println("around after...");
        return object;
    }

    /**
     * 是否返回方法。事件没有发生异常时执行
     */
    @Override
    public void afterReturing(){
        System.out.println("afterReturing...");
    }

    /**
     * 事后异常方法，当事件发生异常后执行
     */
    @Override
    public void afterThrowing(){
        System.out.println("afterThrowing...");
    }

    /**
     * 是否使用around替换原有方法
     * @return
     */
    @Override
    public boolean useAround(){
        System.out.println("useAround...");
        return true;
    }
}
