package io.github.pleuvoir.adapter.demo;

public abstract class AbstractTransSelectorAdapter implements TransSelector {

	@Override
	public Trans select(Message message) {
		if (isRequest(message))
			return Trans.REQUEST;
		if (isResponse(message))
			return Trans.RESPONSE;
		return null;
	}

}
