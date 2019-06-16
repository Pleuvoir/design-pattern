package io.github.pleuvoir.visitor.bestpractice;

import java.util.Arrays;
import java.util.List;

import io.github.pleuvoir.visitor.bestpractice.payload.Content;
import io.github.pleuvoir.visitor.bestpractice.payload.item.ImageContentItem;
import io.github.pleuvoir.visitor.bestpractice.payload.item.TextContentItem;
import io.github.pleuvoir.visitor.bestpractice.visitor.ConcretVisitor;
import io.github.pleuvoir.visitor.bestpractice.visitor.Visitor;

public class Client {

	public static void main(String[] args) {

		ConcretVisitor concretVisitor = new ConcretVisitor();
		List<Content> contentList = Arrays.asList(new ImageContentItem(), new TextContentItem(), new Content() {
			@Override
			public void accept(Visitor visitor) {
				System.out.println("呵呵前");
				visitor.visit(this);  // 这里就是每次遍历会被执行的方法
				System.out.println("呵呵后");
			}

			@Override
			public String type() {
				return "父类内容";
			}
		});

		// https://github.com/oops-glory/wechat-test/blob/master/src/main/java/com/tianxin/wechat/platform/manager/impl/XmlMessageParser.java
		// 当有一个集合 里面包含着多态的父子类时  它们对同一个方法又有不同的实现 而又必须循环调用之类的 适合使用访问者模式
		// 或者有个方法每次返回的都是多态对象
		// 其它情况使用访问者模式过于麻烦
		for (Content content : contentList) {
			content.accept(concretVisitor);
		}
		
	}

}
