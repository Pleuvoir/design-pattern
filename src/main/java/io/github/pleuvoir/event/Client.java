package io.github.pleuvoir.event;

import io.github.pleuvoir.event.hander.MessageEventHandler;
import io.github.pleuvoir.event.listener.MessageEventListener;
import io.github.pleuvoir.event.listener.NewMessageEventListener;

public class Client {

	public static void main(String[] args) throws InterruptedException {

		Sever sever = new Sever(new MessageEventListener());
	//	Sever sever = new Sever(new NewMessageEventListener(new MessageEventHandler()));

		sever.accept();
	}
}
