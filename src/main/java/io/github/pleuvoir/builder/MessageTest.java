package io.github.pleuvoir.builder;

import io.github.pleuvoir.adapter.demo.Message;

public class MessageTest {

	public static void main(String[] args) {
		Message message = new Message.MessageBuilder("request")
				//.remark("i am remark")
				.build();
		System.out.println(message.toString());
	}
}
