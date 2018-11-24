package io.github.pleuvoir.chains;

import io.github.pleuvoir.chains.filter.HttpRequestFilter;
import io.github.pleuvoir.chains.filter.SensitiveHttpRequestFilter;
import io.github.pleuvoir.chains.manager.HttpRequestPipeline;

public class Client {

	public static void main(String[] args) {

		HttpRequestPipeline pipeline = new HttpRequestPipeline();
		
		pipeline.addFilter(new HttpRequestFilter());
		pipeline.addFilter(new SensitiveHttpRequestFilter());
		
		HttpRequest httpRequest = new HttpRequest();
		httpRequest.setContent("原始报文");
		
		pipeline.start(httpRequest);
		
		System.out.println(httpRequest);
	}
}
