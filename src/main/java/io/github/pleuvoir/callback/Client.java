package io.github.pleuvoir.callback;

@SuppressWarnings("unused")
public class Client {

	public static void main(String[] args) {

		// 回调方法，配合模板方法使用
		DefaultRedisTemplate redisTemplate = new DefaultRedisTemplate();
		
		String result = redisTemplate.excute(new RedisCallBack<String>() {

			@Override
			public String doInRedis(Object whatYouNedd) {
				System.out.println(whatYouNedd);
				return (String) whatYouNedd;
			}
		});

		System.out.println("执行完毕以后返回结果：" + result);
	
		RedisCallBack<String> callBack = (Object l) -> "返回结果是" + String.valueOf(l);
		
		String a = (String) redisTemplate.excute((Object l) -> "返回结果是" + String.valueOf(l));
		System.out.println(a);
		

		
	}
}
