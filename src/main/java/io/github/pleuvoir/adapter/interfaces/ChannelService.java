package io.github.pleuvoir.adapter.interfaces;

public interface ChannelService {
	
	
	//单接口适配器 ，简化代码
	class Adapter implements ChannelService {

		@Override
		public void qq() {}

		@Override
		public void b2b() {}

		@Override
		public void b2c() {}

		@Override
		public void wechat() {}

		@Override
		public void alipay() {}

		@Override
		public void jdwallet() {}

		@Override
		public void wap() {}

		@Override
		public void wechatH5() {}

		@Override
		public void netpay() {}

	}

	void qq();

	void b2b();

	void b2c();

	void wechat();

	void alipay();

	void jdwallet();

	void wap();

	void wechatH5();

	void netpay();

}
