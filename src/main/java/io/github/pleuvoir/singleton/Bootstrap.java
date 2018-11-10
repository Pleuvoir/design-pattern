package io.github.pleuvoir.singleton;

public class Bootstrap {

	private static class LoaderHelper {

		private static ApplicationContext CONTEXT;

		static {
			init();
		}

		private static void init() {
			CONTEXT = new ApplicationContext();
		}
	}

	public static ApplicationContext getApplicationContext() {
		return LoaderHelper.CONTEXT;
	}

	public static void unpark() {
		LoaderHelper.CONTEXT.unpark();
	}
}
