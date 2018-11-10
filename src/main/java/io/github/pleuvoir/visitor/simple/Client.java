package io.github.pleuvoir.visitor.simple;

import java.util.Arrays;
import java.util.List;

import io.github.pleuvoir.visitor.simple.fruit.Apple;
import io.github.pleuvoir.visitor.simple.fruit.Fruit;
import io.github.pleuvoir.visitor.simple.fruit.Orange;

public class Client {

	static List<Fruit> list;
	static Seller seller;
	static {
		list = Arrays.asList(new Apple(), new Orange(), new Fruit());
		seller = new Seller();
	}

	public static void main(String[] args) {

		// 统计一共多少钱
		before();
		System.out.println("==========");
		after();
	}

	private static void before() {
		
		for (Fruit fruit : list) {
			seller.sell(fruit);
		}
		/**
		 * 结果是： 其他 5 元   		其他 5 元 		其他 5 元
		 * 显然，方法的形参不能正确识别对象的真实类型
		 */
	}
	
	
	private static void after(){
		for (Fruit fruit : list) {
			//seller.sell(fruit);
			fruit.accept(seller);
		}
		
		/**
		 * 利用双重分派机制，弥补 java 多态方法重载时静态化的不足
		 */
	}

}
