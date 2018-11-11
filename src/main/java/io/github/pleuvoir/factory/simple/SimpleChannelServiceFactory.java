package io.github.pleuvoir.factory.simple;

import java.util.Objects;

public class SimpleChannelServiceFactory implements ChannelServiceFactory {

	private ChannelService wechatChannelService = new WechatChannelService();
	private ChannelService alipayChannelService = new AlipayChannelService();

	@Override
	public ChannelService getChannel(String code) {
		if (Objects.equals("wechat", code)) {
			return wechatChannelService;
		} else if (Objects.equals("alipay", code)) {
			return alipayChannelService;
		}
		return null;
	}

}
