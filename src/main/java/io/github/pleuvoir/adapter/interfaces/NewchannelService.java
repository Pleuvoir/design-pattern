package io.github.pleuvoir.adapter.interfaces;

public class NewchannelService extends ChannelService.Adapter {

	@Override
	public void wechat() {
		System.out.println("我只想对接微信扫码。。");
	}

}
