package io.github.pleuvoir.chains;

public class HttpRequest {

	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "HttpRequest [content=" + content + "]";
	}
	
}
