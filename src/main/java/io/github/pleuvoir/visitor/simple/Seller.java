package io.github.pleuvoir.visitor.simple;

import io.github.pleuvoir.visitor.simple.fruit.Apple;
import io.github.pleuvoir.visitor.simple.fruit.Fruit;
import io.github.pleuvoir.visitor.simple.fruit.Orange;

public class Seller {

	public int sell(Apple apple) {
		System.out.println("苹果  10  元");
		return 10;
	}

	public int sell(Orange orange) {
		System.out.println("橘子  20  元");
		return 20;
	}

	public int sell(Fruit fruit) {
		System.out.println("其他  5 元");
		return 5;
	}
}
