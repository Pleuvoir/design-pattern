package io.github.pleuvoir.visitor.bestpractice.visitor;

import io.github.pleuvoir.visitor.bestpractice.payload.Content;
import io.github.pleuvoir.visitor.bestpractice.payload.item.ImageContentItem;
import io.github.pleuvoir.visitor.bestpractice.payload.item.TextContentItem;

public class ConcretVisitor extends Visitor.Adatper {

	@Override
	public void visit(Content content) {
		System.out.println(content.type() + " Content 被访问了 ..");
	}

	@Override
	public void visit(ImageContentItem content) {
		System.out.println(content.type() + " ImageContentItem 被访问了 ..");
	}

	@Override
	public void visit(TextContentItem content) {
		System.out.println(content.type() + " TextContentItem 被访问了 ..");
	}

}
