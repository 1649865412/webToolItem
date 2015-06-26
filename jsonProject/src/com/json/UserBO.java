package com.json;


public class UserBO {
	
	private int id;
	private String title;
	private String content;
	private String current;
	private Text text;
	
	
	public Text getText()
	{
		return text;
	}
	public void setText(Text text)
	{
		this.text = text;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCurrent() {
		return current;
	}
	public void setCurrent(String current) {
		this.current = current;
	}
}
