package io.github.pleuvoir.event.listener;

import io.github.pleuvoir.event.Message;
import io.github.pleuvoir.event.hander.EventHandler;
import io.github.pleuvoir.event.hander.MessageEventHandler;

public class NewMessageEventListener extends AbstractEventListener<Message> {

	private MessageEventHandler messageEventHandler;

	public NewMessageEventListener(MessageEventHandler messageEventHandler) {
		this.messageEventHandler = messageEventHandler;
	}

	@Override
	protected EventHandler<Message> getEventHandler(Message event) {
		return messageEventHandler;
	}

}
