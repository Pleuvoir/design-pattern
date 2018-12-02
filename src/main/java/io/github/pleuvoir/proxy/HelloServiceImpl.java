package io.github.pleuvoir.proxy;

public class HelloServiceImpl implements HelloService {

	@Override
	public String sayHello(String name) {
		System.out.println("hello " + name);
		return name;
	}

}
