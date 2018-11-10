package io.github.pleuvoir.singleton;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Client {

	public static void main(String[] args) throws InterruptedException, BrokenBarrierException {

		CyclicBarrier cyclicBarrier = new CyclicBarrier(6);

		ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();

		for (int i = 0; i < 5; i++) {
			newCachedThreadPool.submit(() -> {
				try {
					System.out.println(Thread.currentThread().getName() + "|开始等待");
					cyclicBarrier.await();

					// 静态内部类
					staticInnerClassSingleton();

					// 枚举单例
					// enumSingleton();

				} catch (InterruptedException | BrokenBarrierException e) {
					e.printStackTrace();
				}
			});
		}

		TimeUnit.SECONDS.sleep(3);
		cyclicBarrier.await();
		newCachedThreadPool.shutdown();
		newCachedThreadPool.shutdownNow();

	}

	static void staticInnerClassSingleton() {
		ApplicationContext app = Bootstrap.getApplicationContext();
		System.out.println(Thread.currentThread().getName() + "|" + app);
		app.unpark();
		Bootstrap.unpark();
	}

	static void enumSingleton() {
		ApplicationContext app = BootstrapEnum.getApplicationContext();
		System.out.println(Thread.currentThread().getName() + "|" + app);
		app.unpark();
		BootstrapEnum.unpark();
	}

}
