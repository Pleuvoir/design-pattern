package io.github.pleuvoir.event.hander;

import io.github.pleuvoir.event.Message;

public class TextMessageEventHandler implements EventHandler<Message> {

	@Override
	public void doHandle(Message message) {
		System.out.println("文本事件处理器接收到消息，payload：" + message.getPayload());
	}

}
