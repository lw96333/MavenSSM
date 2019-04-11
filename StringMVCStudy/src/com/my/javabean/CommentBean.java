package com.my.javabean;
/**
 * 评论bean
 * @author 49160
 *
 */
public class CommentBean {

	private String name;
	
	private String content;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "CommentBean [name=" + name + ", content=" + content + "]";
	}
	
	
}
