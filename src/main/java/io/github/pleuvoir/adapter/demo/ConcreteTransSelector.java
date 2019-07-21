package io.github.pleuvoir.adapter.demo;

public class ConcreteTransSelector extends AbstractTransSelectorAdapter {

	@Override
	public boolean isRequest(Message message) {
		if(message.getPayload().equals("request")){
			return true;
		}
		return false;
	}

	@Override
	public boolean isResponse(Message message) {
		return false;
	}

}
