package com.ss.demo;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.webapp.WebAppContext;



public class test {
	public static void main(String[] args) throws Exception {
		Server server=new Server(8888);
		WebAppContext context=new WebAppContext("web", "/web");
		ResourceHandler handler=new ResourceHandler();
		server.setHandler(context);
		server.start();
	}
}
