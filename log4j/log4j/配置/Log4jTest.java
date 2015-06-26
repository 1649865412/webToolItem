package net.xdevelop.struts.demo.Servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import org.apache.log4j.Logger;

public class Log4jTest extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html; charset=GBK";

    //Initialize global variables
    public void init() throws ServletException {
    }

    //Process the HTTP Get request
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        response.setContentType(CONTENT_TYPE);

        Logger logger = Logger.getLogger(this.getClass().getName());

        logger.debug("Debug info.");
        logger.info("Info info");
        logger.warn("Warn info");
        logger.error("Error info");
        logger.fatal("Fatal info");

        logger.debug("调试信息.");
        logger.info("一般信息.");
        logger.warn("警告信息.");
        logger.error("错误信息.");
        logger.fatal("致命信息.");

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>Log4jTest</title></head>");
        out.println("<body bgcolor=\"#ffffff\">");
        out.println("<p>The servlet has received a GET. This is the reply.</p>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }

    //Clean up resources
    public void destroy() {
    }
}
