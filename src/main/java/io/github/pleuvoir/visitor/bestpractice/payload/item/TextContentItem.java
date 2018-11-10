package io.github.pleuvoir.visitor.bestpractice.payload.item;

import io.github.pleuvoir.visitor.bestpractice.payload.Content;
import io.github.pleuvoir.visitor.bestpractice.visitor.Visitor;

public class TextContentItem implements Content {

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	@Override
	public String type() {
		return "子类文本";
	}

}
