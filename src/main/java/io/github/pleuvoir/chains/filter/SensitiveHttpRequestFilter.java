package io.github.pleuvoir.chains.filter;

import io.github.pleuvoir.chains.HttpRequest;

public class SensitiveHttpRequestFilter implements Filter<HttpRequest> {

	@Override
	public void doFilter(HttpRequest water) {
		System.out.println("第二层处理");
		water.setContent(water.getContent().concat("======2"));
	}

}
