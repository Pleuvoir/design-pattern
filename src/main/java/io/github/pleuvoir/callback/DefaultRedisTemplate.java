package io.github.pleuvoir.callback;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class DefaultRedisTemplate implements RedisTemplate {

	ThreadPoolExecutor executor = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors() * 2, 200, 60L,
			TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(60));
	{
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
			@Override
			public void run() {
				shutdownAndAwaitTermination(executor);
			}
		}));
	}

	// 这里先定义流程模板，这种使用方式其实是模版方式的优化
	@Override
	public <T> T excute(RedisCallBack<T> callBack) {

		checkCallBack(callBack);

		// ... 其他

		T result = callBack.doInRedis("我是一个连接对象");

		return result;
	}

	@Override
	public <T> Future<T> asyncExcute(RedisCallBack<T> callBack) {

		checkCallBack(callBack);

		Future<T> result = executor.submit(new Callable<T>() {

			@Override
			public T call() throws Exception {
				return callBack.doInRedis("我是一个连接对象");
			}
		});

		// executor.shutdown();

		return result;
	}

	private <T> void checkCallBack(RedisCallBack<T> callBack) {
		if (callBack == null) {
			throw new IllegalArgumentException("callBack 不能为空");
		}
	}

	private void shutdownAndAwaitTermination(ExecutorService pool) {
		System.out.println("优雅关闭线程池..");
		
		// 模拟
		try {
			Thread.sleep(3000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		pool.shutdown(); // Disable new tasks from being submitted
		try {
			// Wait a while for existing tasks to terminate
			if (!pool.awaitTermination(30, TimeUnit.SECONDS)) {
				pool.shutdownNow(); // Cancel currently executing tasks
				// Wait a while for tasks to respond to being cancelled
				if (!pool.awaitTermination(30, TimeUnit.SECONDS))
					System.err.println("Pool did not terminate");
			}
		} catch (InterruptedException ie) {
			// (Re-)Cancel if current thread also interrupted
			pool.shutdownNow();
			// Preserve interrupt status
			Thread.currentThread().interrupt();
		}
	}
}
