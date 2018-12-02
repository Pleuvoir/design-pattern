package io.github.pleuvoir.proxy.staticproxy;

import io.github.pleuvoir.proxy.HelloService;

/**
 * 代理类只需要把目标类传进来即可
 * @author pleuvoir
 *
 */
public class HelloServiceProxy implements Proxy<HelloService>, HelloService {
	
	private HelloService helloService;

	public HelloServiceProxy() {
	}

	public HelloServiceProxy(HelloService helloService) {
		this.helloService = helloService;
	}

	@Override
	public void setTarget(HelloService t) {
		this.helloService = t;
	}

	// 这里会做修改
	@Override
	public String sayHello(String name) {
		System.out.println("静态代理前 ..");
		helloService.sayHello(name);
		System.out.println("静态代理后 ..");
		return name;
	}

}
