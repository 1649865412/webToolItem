package junit;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.solr.client.solrj.beans.Field;

/**
 * 
 * <b>function:</b> JavaEntity
 * Bean；Index需要添加相关的Annotation注解，便于告诉solr哪些属性参与到index中
 * 
 * @author hoojo
 * 
 * @createDate 2011-10-19 下午05:33:27
 * 
 * @file Index.java
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

public class Index
{
	
	// @Field setter方法上添加Annotation也是可以的
	
	private String id;
	
	@Field
	private String name;
	
	@Field
	private String manu;
	
	@Field
	private String[] cat;
	
	@Field
	private String[] features;
	
	@Field
	private float price;
	
	@Field
	private int popularity;
	
	@Field
	private boolean inStock;
	
	public String getId()
	{
		
		return id;
		
	}
	
	@Field
	public void setId(String id)
	{
		
		this.id = id;
		
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getManu()
	{
		return manu;
	}
	
	public void setManu(String manu)
	{
		this.manu = manu;
	}
	
	public String[] getCat()
	{
		return cat;
	}
	
	public void setCat(String[] cat)
	{
		this.cat = cat;
	}
	
	public String[] getFeatures()
	{
		return features;
	}
	
	public void setFeatures(String[] features)
	{
		this.features = features;
	}
	
	public float getPrice()
	{
		return price;
	}
	
	public void setPrice(float price)
	{
		this.price = price;
	}
	
	public int getPopularity()
	{
		return popularity;
	}
	
	public void setPopularity(int popularity)
	{
		this.popularity = popularity;
	}
	
	public boolean isInStock()
	{
		return inStock;
	}
	
	public void setInStock(boolean inStock)
	{
		this.inStock = inStock;
	}
	
	public String toString()
	{
		
		// return this.id + "#" + this.name + "#" + this.manu + "#" + this.cat;
		return ToStringBuilder.reflectionToString(this);
		
	}
	
}