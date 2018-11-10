
package io.github.pleuvoir.template;

public class WechatNotifyService extends AbstractNotifyService {

	@Override
	public void checkOrder(String orderNo) {
		System.out.println("检查订单通过：" + orderNo);
	}

}
