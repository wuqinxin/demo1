package com.example.demo1;

import com.example.demo1.invoke.MyInterceptor;
import com.example.demo1.invoke.ProxyBean;
import com.example.demo1.service.HelloService;
import com.example.demo1.service.impl.HelloServiceImpl;
import org.junit.jupiter.api.Test;

public class AOPTest {

    @Test
    public void test1(){
        HelloService helloService = new HelloServiceImpl();
        HelloService proxy = (HelloService)ProxyBean.getProxyBean(helloService, new MyInterceptor());
        proxy.sayHello("张三");
        System.out.println("+++++++++++++++++++++++++++++");
        proxy.sayHello(null);
    }
}
