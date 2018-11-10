package io.github.pleuvoir.visitor.bestpractice.visitor;

import io.github.pleuvoir.visitor.bestpractice.payload.Content;
import io.github.pleuvoir.visitor.bestpractice.payload.item.ImageContentItem;
import io.github.pleuvoir.visitor.bestpractice.payload.item.TextContentItem;

/**
 * 访问者，该类所有的方法名称都是一样的，即全部都是重载方法，形参都有一个公共的父类（这是大前提）
 * 该示例中，公共父类为  {Content}
 * @author pleuvoir
 *
 */
public interface Visitor {

	void visit(Content content);

	void visit(ImageContentItem content);

	void visit(TextContentItem content);

	class Adatper implements Visitor {

		@Override
		public void visit(Content content) {

		}

		@Override
		public void visit(ImageContentItem content) {

		}

		@Override
		public void visit(TextContentItem content) {

		}

	}

}
