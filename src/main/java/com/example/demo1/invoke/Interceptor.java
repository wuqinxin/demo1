package com.example.demo1.invoke;


import java.lang.reflect.InvocationTargetException;

/**
 * 拦截器
 */
public interface Interceptor {
    //事前方法
    boolean before();

    //事后方法
    boolean after();

    /**
     * 取代原有事件方法
     * @param invocation 回调参数，可以通过proceed方法，回调原有事件
     * @return 原有事件返回对象
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    Object around(Invocation invocation) throws InvocationTargetException,IllegalAccessException;

    /**
     * 是否返回方法。事件没有发生异常时执行
     */
    void afterReturing();

    /**
     * 事后异常方法，当事件发生异常后执行
     */
    void afterThrowing();

    /**
     * 是否使用around替换原有方法
     * @return
     */
    boolean useAround();

}
