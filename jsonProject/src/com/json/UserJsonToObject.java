package com.json;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

import org.junit.Test;

/**
 * JSON Str TO USER OBJECT
 * 
 * @author alex.yao
 * 
 */
public class UserJsonToObject {

	@SuppressWarnings("all")
	@Test
	public void jsonToObject() {
		String userJson = "{'content':'中国历史上经历了太多主权被侵占、领土被瓜分的屈辱，但那是在积贫积弱的旧中国。今天的中国，正走在和平发展的大路上。我们奉行独立自主的和平外交政策，决不会以大欺小，倚强凌弱，但也决不会任人无理捉弄而一味忍让，何况此事事关中国的领土完整、民族尊严乃至社会稳定。','current':'2012-08-27','id':10023,'title':'休想抢走中国半寸领土'}";
		//String userJson = "{"+"'content':'中国历史上经历了太多主权被侵占、领土被瓜分的屈辱，但那是在积贫积弱的旧中国。今天的中国，正走在和平发展的大路上。我们奉行独立自主的和平外交政策，决不会以大欺小，倚强凌弱，但也决不会任人无理捉弄而一味忍让，何况此事事关中国的领土完整、民族尊严乃至社会稳定。','current':'2015-05-22','id':10023,'text':{'textContent':'b','textName':'a'},'title':'休想抢走中国半寸领土'"+"}";
		JSONObject obj = new JSONObject().fromObject(userJson);
		UserBO user = (UserBO) JSONObject.toBean(obj, UserBO.class);
		System.out.println(user.getTitle());
		System.out.println(user.getContent());
		System.out.println(user.getCurrent());
		System.out.println(user.getText().getTextName());
		System.out.println(user.getText().getTextContent());
	}

	/**
	 * 将json集合转换为java集合对象
	 */
	@Test
	public void jsonToList() {
		String jsons = "[{\"content\":\"java对象转json文件格式！ 1\",\"current\":\"2012-08-27\",\"id\":1,\"title\":\"JSON传输 1\"},{\"content\":\"java对象转json文件格式！ \",\"current\":\"2012-08-27\",\"id\":22,\"title\":\"JSON传输 \"}]";
		List<UserBO> userList = getJavaCollection(new UserBO(), jsons);
		System.out.println(userList.size());
		for (UserBO _user : userList) {
			System.out.println("title: " + _user.getTitle());
			System.out.println("---------------------------");
		}
	}

	/**
	 * * 封装将json对象转换为java集合对象 * *
	 * 
	 * @param <T> *
	 * @param clazz *
	 * @param jsons *
	 * @return
	 */
	@SuppressWarnings("all")
	private <T> List<T> getJavaCollection(T clazz, String jsons) {
		List<T> objs = null;
		JSONArray jsonArray = (JSONArray) JSONSerializer.toJSON(jsons);
		if (jsonArray != null) {
			objs = new ArrayList<T>();
			List list = (List) JSONSerializer.toJava(jsonArray);
			for (Object o : list) {
				JSONObject jsonObject = JSONObject.fromObject(o);
				T obj = (T) JSONObject.toBean(jsonObject, clazz.getClass());
				objs.add(obj);
			}
		}
		return objs;
	}
}
