package io.github.pleuvoir.event.hander;

public interface EventHandler<T> {

	void doHandle(T event);
}
