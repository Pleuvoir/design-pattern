package io.github.pleuvoir.template;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class AbstractNotifyService implements NotifyService {

	private MerAccService merAccService = new MerAccService.Adapter();
	
	@Override
	public String notifty(String mid) {

		String orderNo = this.getOrderNoByMid(mid);

		this.checkOrder(orderNo); // 需要子类实现

		merAccService.updateBalance(mid);

		return "success";
	}

	@Override
	public String getOrderNoByMid(String mid) {
		return "ZF" + DateTimeFormatter.ofPattern("yyyyMMddHHmmss").format(LocalDateTime.now());
	}

}
