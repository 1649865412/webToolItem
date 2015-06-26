package test.client;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.freemarker.util.FreeMarkertUtil;

/**
 * @author 洪延
 * @E-mail： 805202899#qq.com
 * @Date： 2012-5-31
 * @version 1.0
 * 
 */

@SuppressWarnings("serial")
public class TestServlet extends HttpServlet {
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }
  
  public void init() throws ServletException {
    
  }
  
  public void destroy() {
    super.destroy();
  }
  
  @SuppressWarnings("unchecked")
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    System.out.println("来了");
    response.setCharacterEncoding("utf-8");
    User user=new User();
    user.setUserName("张三");
    user.setUserPassword("123");
    
    User user2=new User();
    user2.setUserName("李四");
    user2.setUserPassword("345");
    
    User user3=new User();
    user3.setUserName("王五");
    user3.setUserPassword("678");
    
    List<User > users=new ArrayList<User>();
    users.add(user);
    users.add(user2);
    users.add(user3);
    
    ClassRoom cRoom=new ClassRoom();
    cRoom.setName("三年级乙班");
    cRoom.setUser(users);
    
    PIG pig=new PIG();
    pig.setAge(2);
    pig.setName("小猪");
    pig.setWeight("200KG");
    
    Book book=new Book();
    book.setAuthor("小明");
    book.setName("语文");
    book.setSubject("文学");
    
    
    Map<String,Object> root=new HashMap<String, Object>();
    root.put("classR", cRoom);
    root.put("pig", pig);
    root.put("book", book);
    
    PrintWriter out = response.getWriter();
    File file=new File("E:/myitem/FreeMarkerDemo(1)/FreeMarkerDemo/src/templates");
    
    FreeMarkertUtil.analysisTemplateTwo(file,"user.ftl", "UTF-8", root, out);
  
  }

}
