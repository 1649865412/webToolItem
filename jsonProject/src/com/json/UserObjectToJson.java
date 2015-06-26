package com.json;

import net.sf.json.JSONObject;

import com.util.DateUtil;
 


/**  JSON  Demo  (类中包含其它类互转)
 *  
 *  bean转json对象(可点点点出值)
 *  json对象转bean
 *  
 *  <code>UserObjectToJson.java</code>
 *  <p>
 *  <p>Copyright  2015 All right reserved.
 *  @author admin 时间 2015-5-22 下午03:30:53	
 *  @version 1.0 
 *  </br>最后修改人 无
 */
public class UserObjectToJson {  
 
    public static void main(String[] args) {  
        UserBO user = new UserBO();  
        user.setId(10023);  
        user.setTitle("休想抢走中国半寸领土");  
        user.setContent("中国历史上经历了太多主权被侵占、领土被瓜分的屈辱，但那是在积贫积弱的旧中国。今天的中国，正走在和平发展的大路上。我们奉行独立自主的和平外交政策，决不会以大欺小，倚强凌弱，但也决不会任人无理捉弄而一味忍让，何况此事事关中国的领土完整、民族尊严乃至社会稳定。");  
        user.setCurrent(DateUtil.getCurrent());
        Text text  =new Text("a","b");
        user.setText(text);
        //bean转json对象(可点点点出值)
        JSONObject jsonObject = JSONObject.fromObject(user);   
        System.out.println("json : "+ jsonObject);  
        
        //json对象转bean
        UserBO user2 = (UserBO) JSONObject.toBean(jsonObject, UserBO.class);
        System.out.println(user2.getText().getTextContent());
        System.out.println(user2.getText().getTextName());
    }  
 
}  
