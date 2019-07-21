package io.github.pleuvoir.adapter.demo;

public class MainTest {

	public static void main(String[] args) {
		ConcreteTransSelector concreteTransSelector = new ConcreteTransSelector();
		
		Message message = new Message.MessageBuilder("request")
				//.remark("i am remark")
				.build();
		
		Trans trans = concreteTransSelector.select(message);
		System.out.println(trans); //REQUEST
	}
}
