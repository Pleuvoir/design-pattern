package io.github.pleuvoir.callback;

public class DefaultRedisTemplate implements RedisTemplate {


	// 这里先定义流程模板
	@Override
	public <T> T excute(RedisCallBack<T> callBack) {

		if (callBack == null) {
			throw new IllegalArgumentException("callBack 不能为空");
		}

		System.out.println("预处理...");

		T result = callBack.doInRedis("我是一个连接对象");

		System.out.println("处理完毕...");
		return result;
	}


}
