package io.github.pleuvoir.callback;

@FunctionalInterface
public interface RedisCallBack<T> {

	/**
	 * 执行的方法
	 * @param whatYouNeed	这里应该是按照业务来传入实际需要的对象，如 ConnectionFactory
	 * @return
	 */
	T doInRedis(Object whatYouNeed);
}