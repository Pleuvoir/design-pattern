package io.github.pleuvoir.singleton;

public enum BootstrapEnum {

	INSTANCE;

	private ApplicationContext CONTEXT;

	BootstrapEnum() {
		CONTEXT = new ApplicationContext();
	}

	public static ApplicationContext getApplicationContext() {
		return BootstrapEnum.INSTANCE.CONTEXT;
	}

	public static void unpark() {
		BootstrapEnum.INSTANCE.CONTEXT.unpark();
	}
}
