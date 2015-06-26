package com.ss.demo;
/**
 * 
 */

import java.io.File;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * @author xiaojun
 * 
 */
public class Application {
	public static int WebPort = 3280;
	public static String WebRoot = (new File("")).getAbsolutePath() + "/web";

	
	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
	//	createServer().start();
		createServerWebRoot() ;
	//	createServerWar();
	}

	
	protected static Server createServer() {
		System.out.println("------Start Server...");
		Server server = new Server(WebPort);
		WebAppContext webContext = new WebAppContext(WebRoot, "/");
		server.setHandler(webContext);
		return server;
	}
	
	
	
	protected static void createServerWebRoot() throws Exception {
	  Server server = new Server(82);  
      WebAppContext context = new WebAppContext("E:\\项目\\CkeditorForJava\\WebRoot", "/");  
      context.setContextPath("/CkeditorForJava");  
   //   context.setWar("E:/share/test/struts2-blank.war");  
      server.setHandler(context);  
      server.start();  
      server.join();  
	}
	
	
	
	protected static void createServerWar() throws Exception {
		  Server server = new Server(8080);  
	      WebAppContext context = new WebAppContext();  
	      context.setContextPath("/myapp");  
	      context.setDescriptor("E:/share/test/struts2-blank/WEB-INF/web.xml");  
	      context.setResourceBase("E:/share/test/struts2-blank");  
	      context.setParentLoaderPriority(true);  
	      server.setHandler(context);  

	      server.start();  
	      server.join(); 
		}
}
