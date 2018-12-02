package io.github.pleuvoir.proxy.dynamicproxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * JDK 动态代理
 * @author pleuvoir
 *
 */
public class HelloServiceJdkProxyHandler implements InvocationHandler {

	private Object obj;

	public HelloServiceJdkProxyHandler(Object obj) {
		this.obj = obj;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("Jdk 动态代理前 ..");
		Object result = method.invoke(this.obj, args);
		System.out.println("Jdk 动态代理后 ..");
		return result;
	}

}
