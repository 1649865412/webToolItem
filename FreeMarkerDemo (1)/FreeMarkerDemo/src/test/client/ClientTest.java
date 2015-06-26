package test.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import test.freemarker.util.FreeMarkertUtil;

public class ClientTest {
  
	public static void main(String[] args) {
	  
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
		
		FreeMarkertUtil.analysisTemplate("user.ftl", "UTF-8", root);
		
	}
}
