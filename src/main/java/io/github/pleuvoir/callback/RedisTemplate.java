package io.github.pleuvoir.callback;

import java.util.concurrent.Future;

public interface RedisTemplate {

	<T> T excute(RedisCallBack<T> callBack);
	
	<T> Future<T>  asyncExcute(RedisCallBack<T> callBack);

}
