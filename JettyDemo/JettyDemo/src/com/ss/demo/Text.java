package com.ss.demo;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 *  <code>Text.java</code>
 *  <p>
 *  <p>Copyright  2015 All right reserved.
 *  @author 杨荣忠 时间 2015-3-11 下午04:27:07	
 *  @version 1.0 
 *  </br>最后修改人 无
 */
public class Text
{
    public static void main(String[] args) throws Exception {  
    	  Server server = new Server(82);  
          WebAppContext context = new WebAppContext("E:\\项目\\CkeditorForJava\\WebRoot", "/");  
          context.setContextPath("/myapp");  
       //   context.setWar("E:/share/test/struts2-blank.war");  
          server.setHandler(context);  
          server.start();  
          server.join();  
    }  
}
