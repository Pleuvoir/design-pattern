package io.github.pleuvoir.event.listener;

import io.github.pleuvoir.event.Message;

public class MessageEventListener implements EventListener<Message> {

	@Override
	public void onEvent(Message message) {
		System.out.println("接收到消息，payload：" + message.getPayload());
		// 实际上这里的处理可能很复杂，我们可以再抽象一层，事件监听和事件处理分离开，各自责任更加独立。
		// 增加 EventHandler 接口专门进行事件处理
	}

}
