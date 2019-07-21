package io.github.pleuvoir.builder;

public class UserBuilder {

	private String name;
	private int age;

	public static UserBuilder create(String name) {
		UserBuilder u = new UserBuilder();
		u.name = name;
		return u;
	}

	public UserBuilder age(int age) {
		this.age = age;
		return this;
	}

	public void print() {
		System.out.println(String.format("UserBuilder [name=%s, age=%s]", name, age));
	}
}
