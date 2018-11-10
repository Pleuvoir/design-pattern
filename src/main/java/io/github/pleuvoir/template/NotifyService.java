package io.github.pleuvoir.template;

public interface NotifyService {

	String notifty(String mid);

	String getOrderNoByMid(String mid);

	void checkOrder(String orderNo);

}
