package com.len.trans.util;

import java.io.IOException;
import java.util.Properties;

/**
 *加载配置文件 
 *  <code>PropertiesUtil.java</code>
 *  <p>
 *  <p>Copyright  2015 All right reserved.
 *  @author admin 时间 2015-6-11 下午04:22:23	
 *  @version 1.0 
 *  </br>最后修改人 无
 */
public class PropertiesUtil {	

	private static Properties properties=new Properties();
	
	private static PropertiesUtil propertiesUtil;
	
	private PropertiesUtil(){		
	}
	
	private static void loadFile(String filename){
		try {
			properties.load(PropertiesUtil.class.getResourceAsStream("/"+filename));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static synchronized PropertiesUtil createPropertiesUtil(String filename){
		if (propertiesUtil==null) {
			propertiesUtil=new PropertiesUtil();
		}
		loadFile(filename);
		return propertiesUtil;
	}	
	
	public String getProperty(String key){
		return properties.getProperty(key);
	}

	public static void main(String[] args) {
		PropertiesUtil propertiesUtil=PropertiesUtil.createPropertiesUtil("upload.properties");		
		System.out.println(propertiesUtil.getProperty("path"));
	}
}
