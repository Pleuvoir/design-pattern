package io.github.pleuvoir.chains.filter;

import io.github.pleuvoir.chains.HttpRequest;

public class HttpRequestFilter implements Filter<HttpRequest> {

	@Override
	public void doFilter(HttpRequest water) {
		System.out.println("第一层处理");
		water.setContent(water.getContent().concat("======1"));
	}

}
