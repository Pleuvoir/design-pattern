package io.github.pleuvoir.singleton.opensourceref;

/**
 * 双重检查锁示例
 * @author pleuvoir
 *
 */
public class DoubleCheckDemo {

	// private static Map<Class<?>, ExtensionLoader<?>> loaderMap = new ConcurrentHashMap<>();
	
	 // 这种没有做判断，直接加锁，不是双重检查
//	private T newSingletonInstance(Class<T> clazz, String serviceName)
//		      throws IllegalAccessException, InstantiationException {
//			synchronized (singletonMap) {
//				T singleton = singletonMap.get(serviceName);
//
//				if (singleton == null) {
//					singleton = clazz.newInstance();
//					singletonMap.put(serviceName, singleton);
//				}
//
//				return singleton;
//			}
//		}
//
	
		//  双重检查
//		public static <T> ExtensionLoader<T> getExtensionLoader(Class<T> clazz) {
//			check(clazz);
//			ExtensionLoader<?> extensionLoader = loaderMap.get(clazz);
//
		// 第一次判断未加锁，可以避免非并发情况下上面例子也加锁的情况，可以认为是为了避免了串行的情况
//			if (extensionLoader == null) {
//				synchronized(loaderMap) {  // 加锁
//					extensionLoader = loaderMap.get(clazz);
//					if(extensionLoader == null) {	// 然后在判断
//						extensionLoader = newExtensionLoader(clazz);
//					}
//				}
//			}
//
//			return (ExtensionLoader<T>) extensionLoader;
//		}
}
