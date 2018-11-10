package io.github.pleuvoir.visitor.bestpractice.payload;

import io.github.pleuvoir.visitor.bestpractice.visitor.Visitor;

/**
 * 如果需要使用访问者模式，这个类不管 3*7=21先创建了再说。
 * @author pleuvoir
 *
 */
public interface Payload {

	void accept(Visitor visitor);
}
