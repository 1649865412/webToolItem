package com.json;

public class Text
{
	private String textName;
	private String textContent;
	
	public Text(){
		
	}
	public Text(String textName, String textContent)
	{
		super();
		this.textName = textName;
		this.textContent = textContent;
	}
	public String getTextName()
	{
		return textName;
	}
	public void setTextName(String textName)
	{
		this.textName = textName;
	}
	public String getTextContent()
	{
		return textContent;
	}
	public void setTextContent(String textContent)
	{
		this.textContent = textContent;
	}
	
	
}
