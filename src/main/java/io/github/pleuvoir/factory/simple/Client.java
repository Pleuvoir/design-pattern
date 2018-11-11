package io.github.pleuvoir.factory.simple;

public class Client {

	public static void main(String[] args) {

		ChannelServiceFactory simpleChannelServiceFactory = new SimpleChannelServiceFactory();
		ChannelService channel = simpleChannelServiceFactory.getChannel("wechat");
		// result：WechatChannelService
		System.out.println(channel);
	}
}
