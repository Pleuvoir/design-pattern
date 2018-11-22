package io.github.pleuvoir.callback;

public interface RedisTemplate {

	<T> T excute(RedisCallBack<T> callBack);

}
