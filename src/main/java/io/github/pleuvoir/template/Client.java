package io.github.pleuvoir.template;

import java.util.concurrent.ThreadLocalRandom;

public class Client {

	public static void main(String[] args) {

		// 模版方法模式的初衷就是定义整体的流程框架，一些特定的实现交给子类去处理，
		WechatNotifyService wechatNotifyService = new WechatNotifyService();
		String result = wechatNotifyService.notifty("SH" + ThreadLocalRandom.current().nextInt(999999999));
		System.out.println(result);
	}
}
