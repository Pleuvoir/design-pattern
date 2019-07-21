package io.github.pleuvoir.adapter.demo;

public interface TransSelector {

	Trans select(Message message);

	boolean isRequest(Message message);

	boolean isResponse(Message message);
}
