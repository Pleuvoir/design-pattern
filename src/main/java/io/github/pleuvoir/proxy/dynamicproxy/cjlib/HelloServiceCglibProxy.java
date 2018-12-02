package io.github.pleuvoir.proxy.dynamicproxy.cjlib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * cglib 动态代理，需要额外引入 jar 包
 * @author pleuvoir
 *
 */
public class HelloServiceCglibProxy implements MethodInterceptor {

	private Enhancer enhancer = new Enhancer();

	/**
	 * 获取代理类
	 * @return
	 */
	public Object getProxy(Class<?> cls) {
		enhancer.setSuperclass(cls);
		enhancer.setCallback(this);
		return enhancer.create();
	}

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		System.out.println("cglib 动态代理前 ..");
		Object result = proxy.invokeSuper(obj, args);
		System.out.println("cglib 动态代理前 ..");
		return result;
	}

}
