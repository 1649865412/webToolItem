package junit;

import java.io.Serializable;

import org.apache.solr.client.solrj.beans.Field;

/**
 * 
 * <b>function:</b> User Entity Bean；所有被添加Annotation @Field 注解的属性将参与index操作
 * 
 * @author hoojo
 * 
 * @createDate 2011-10-19 下午04:16:00
 * 
 * @file User.java
 * 
 * @package com.hoo.entity
 * 
 * @project SolrExample
 * 
 * @blog http://blog.csdn.net/IBM_hoojo
 * 
 * @email hoojo_@126.com
 * 
 * @version 1.0
 */

public class User implements Serializable
{
	/**
	 * 
	 * @author Hoojo
	 */
	
	private static final long serialVersionUID = 8606788203814942679L;
	
	// @Field
	
	private int id;
	
	@Field
	private String name;
	
	@Field
	private int age;
	
	/**
	 * 
	 * 可以给某个属性重命名，likes就是solr index的属性；在solrIndex中将显示like为likes
	 */
	
	@Field("likes")
	private String[] like;
	
	@Field
	private String address;
	
	@Field
	private String sex;
	
	@Field
	private String remark;
	
	public int getId()
	{
		
		return id;
		
	}
	
	// setter 方法上面也可以
	
	@Field
	public void setId(int id)
	{
		
		this.id = id;
		
	}
	
	public String getName()
	{
		
		return name;
		
	}
	
	// getter、setter
	
	@Override
	public String toString()
	{
		
		return this.id + "#" + this.name + "#" + this.age + "#" + this.like + "#" + this.address + "#" + this.sex + "#"
				+ this.remark;
		
	}
	
	public int getAge()
	{
		return age;
	}
	
	public void setAge(int age)
	{
		this.age = age;
	}
	
	public String[] getLike()
	{
		return like;
	}
	
	public void setLike(String[] like)
	{
		this.like = like;
	}
	
	public String getAddress()
	{
		return address;
	}
	
	public void setAddress(String address)
	{
		this.address = address;
	}
	
	public String getSex()
	{
		return sex;
	}
	
	public void setSex(String sex)
	{
		this.sex = sex;
	}
	
	public String getRemark()
	{
		return remark;
	}
	
	public void setRemark(String remark)
	{
		this.remark = remark;
	}
	
	public static long getSerialversionuid()
	{
		return serialVersionUID;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
}