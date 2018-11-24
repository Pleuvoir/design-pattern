package io.github.pleuvoir.callback;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@SuppressWarnings("unused")
public class Client {

	static DefaultRedisTemplate redisTemplate = new DefaultRedisTemplate();

	static CyclicBarrier cyclicBarrier = new CyclicBarrier(5);
	
	public static void main(String[] args) throws InterruptedException, ExecutionException, IOException {

		// 回调方法，配合模板方法使用

		System.out.println("普通同步执行开始 ...");
		String result = redisTemplate.excute(new RedisCallBack<String>() {

			@Override
			public String doInRedis(Object whatYouNedd) {
				sleepWait();
				return (String) whatYouNedd;
			}
		});

		System.out.println("普通同步执行结束，返回结果：" + result);
		System.out.println("=================================");

		RedisCallBack<String> callBack = (Object l) -> "返回结果是" + String.valueOf(l);

		System.out.println("朗姆大 同步执行开始 ...");
		String a = (String) redisTemplate.excute((Object l) -> "返回结果是" + String.valueOf(l));
		System.out.println("朗姆大 同步执行结束，返回结果：" + result);

		System.out.println("=================================");
		System.out.println("异步执行开始 ...");

//		Future<String> asyncExcute = redisTemplate.asyncExcute(new RedisCallBack<String>() {
//
//			@Override
//			public String doInRedis(Object whatYouNeed) {
//				sleepWait();
//				return "卧室异步结果";
//			}
//
//		});
//
//		// 执行一些其他任务
//		System.out.println("你好啊。。。。。。");
//		System.out.println("你好啊。。。。。。");
//		System.out.println("你好啊。。。。。。");
//
//		// 这里会阻塞
//		System.out.println("阻塞获取结果：异步执行结束 返回结果 ..." + asyncExcute.get());
		for(int i = 0;i<5;i++){
			new ExcuteThread().start();
		}

		
		System.out.println("任意输入退出...");
		System.in.read();
		System.exit(-1);
	}

	private static void sleepWait() {
		try {
			TimeUnit.SECONDS.sleep(3L);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
	}

	
	static class ExcuteThread extends Thread{

		@Override
		public void run() {
			try {
				if(new Random().nextBoolean()){
					sleepWait();
					System.out.println(this.getName() + " 运气不好，休息 2 秒");
				}
				
				System.out.println(this.getName() + " 到达屏障前" );
				cyclicBarrier.await();
				
				System.out.println(this.getName() + "准备休息 3 秒，然后一起出发");
				sleepWait();
				
				Future<String> asyncExcute = redisTemplate.asyncExcute(new RedisCallBack<String>() {

					@Override
					public String doInRedis(Object whatYouNeed) {
						sleepWait();
						return "卧室异步结果";
					}

				});

				// 执行一些其他任务
				System.out.println("你好啊。。。。。。");

				// 这里会阻塞
				System.out.println("阻塞获取结果：异步执行结束 返回结果 ..." + asyncExcute.get());
				System.out.println(this.getName() + " 到达位置");
			} catch (InterruptedException | BrokenBarrierException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
	}
}
