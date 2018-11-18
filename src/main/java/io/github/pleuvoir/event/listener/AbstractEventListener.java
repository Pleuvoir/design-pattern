package io.github.pleuvoir.event.listener;

import io.github.pleuvoir.event.hander.EventHandler;

public abstract class AbstractEventListener<T> implements EventListener<T> {

	/**
     * 事件处理流程模板方法
     * @param event 事件对象
     */
	@Override
	public void onEvent(T event) {
		EventHandler<T> eventHandler = getEventHandler(event);
		eventHandler.doHandle(event);
	}

	/**
     * 返回事件处理器
     * @param event 事件对象
     */
    protected abstract EventHandler<T> getEventHandler(T event);
}
