package io.github.pleuvoir.visitor.simple.fruit;

import io.github.pleuvoir.visitor.simple.Seller;

public class Apple extends Fruit {

	public void accept(Seller seller) {
		seller.sell(this);
	}
}
