package com.yi.project.model;

public class Content {
	private int no;
	private String content;
	public Content() {
		// TODO Auto-generated constructor stub
	}
	public Content(int no, String content) {
		super();
		this.no = no;
		this.content = content;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "Content [no=" + no + ", content=" + content + "]";
	}
	
	
	
	
}
