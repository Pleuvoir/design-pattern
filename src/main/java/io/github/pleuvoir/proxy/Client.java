package io.github.pleuvoir.proxy;

import java.lang.reflect.Proxy;

import io.github.pleuvoir.proxy.dynamicproxy.cjlib.HelloServiceCglibProxy;
import io.github.pleuvoir.proxy.dynamicproxy.jdk.HelloServiceJdkProxyHandler;
import io.github.pleuvoir.proxy.staticproxy.HelloServiceProxy;

public class Client {

	public static void main(String[] args) {
		String name = "pleuvoir";
		// 默认实现
		HelloService helloService = new HelloServiceImpl();
		helloService.sayHello(name);
		System.out.println("========================");
		
		// 1. 静态代理
		HelloServiceProxy helloServiceProxy = new HelloServiceProxy();
		helloServiceProxy.setTarget(helloService);
		HelloServiceProxy helloServiceProxy2 = new HelloServiceProxy(helloService);
		helloServiceProxy.sayHello(name);
		helloServiceProxy2.sayHello(name);
		System.out.println("========================");
		
		// 2. jdk 动态代理
		HelloService jdkHelloServiceProxy = (HelloService) Proxy.newProxyInstance(HelloService.class.getClassLoader(),
				new Class[] { HelloService.class }, new HelloServiceJdkProxyHandler(helloService));
		jdkHelloServiceProxy.sayHello(name);
		System.out.println("========================");
		
		// 3. cglib 动态代理
		HelloServiceCglibProxy proxy = new HelloServiceCglibProxy();
		// 注意这里使用的是真实实现类，而不是接口，所以说 cglib 是基于类的
		HelloService targetClass = (HelloService) proxy.getProxy(HelloServiceImpl.class); 
		targetClass.sayHello(name);
	}
	
}
