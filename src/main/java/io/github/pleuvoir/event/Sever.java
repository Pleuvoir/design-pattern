package io.github.pleuvoir.event;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import io.github.pleuvoir.event.listener.EventListener;

public class Sever {

	private final EventListener<Message> eventListener;

	public Sever(EventListener<Message> eventListener) {
		this.eventListener = eventListener;
	}

	public void accept() throws InterruptedException {
		while (true) {
			if (ThreadLocalRandom.current().nextBoolean()) {
				Message message = new Message();
				message.setPayload(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss").format(LocalDateTime.now()));
				eventListener.onEvent(message);
			}
			TimeUnit.SECONDS.sleep(2);
		}
	}

}
