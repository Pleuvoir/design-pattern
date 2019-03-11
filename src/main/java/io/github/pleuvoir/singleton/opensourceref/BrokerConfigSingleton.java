package io.github.pleuvoir.singleton.opensourceref;

import java.util.concurrent.atomic.AtomicBoolean;

public class BrokerConfigSingleton {

	private static AtomicBoolean isInit = new AtomicBoolean(false);

	private static BrokerConfig brokerConfig;

	public static BrokerConfig getBrokerConfig() {
		if (brokerConfig == null) {
			throw new IllegalArgumentException("brokerConfig Cannot be null !");
		}
		return brokerConfig;
	}

	public static void setBrokerConfig(BrokerConfig brokerConfig) {
		if (!isInit.compareAndSet(false, true)) {
			throw new IllegalArgumentException("brokerConfig has already inited !");
		}
		BrokerConfigSingleton.brokerConfig = brokerConfig;
	}
}
