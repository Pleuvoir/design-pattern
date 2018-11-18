package io.github.pleuvoir.event.listener;

public interface EventListener<T> {

	/**
	 * 事件发生时的回调方法
	 * @param event 事件对象
	 */
	void onEvent(T event);
	
}
