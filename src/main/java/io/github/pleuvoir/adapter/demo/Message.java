package io.github.pleuvoir.adapter.demo;

/**
 * 流式风格建造者
 * @author pleuvoir
 *
 */
public class Message {

	private final String payload;
	private final String remark;

	private Message(MessageBuilder messageBuilder) {
		this.payload = messageBuilder.payload;
		this.remark = messageBuilder.remark;
	}

	public String getPayload() {
		return payload;
	}

	public String getRemark() {
		return remark;
	}

	public static class MessageBuilder {

		private final String payload;
		private String remark;

		public MessageBuilder(String payload) {
			this.payload = payload;
		}

		public MessageBuilder remark(String remark) {
			this.remark = remark;
			return this;
		}

		public Message build() {
			Message message = new Message(this);
			validate(); //可选的
			return message;
		}
		
		void validate(){
			if(remark == null){
				System.out.println("没有备注");
			}
		}
	}

	@Override
	public String toString() {
		return String.format("Message [payload=%s, remark=%s]", payload, remark);
	}

}
