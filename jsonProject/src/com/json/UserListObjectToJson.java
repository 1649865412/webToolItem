package com.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import com.util.DateUtil;
 
 
public class UserListObjectToJson {  
 
    public static void main(String[] args) {  
          
        UserBO user=new UserBO();  
        user.setId(22);  
        user.setTitle("JSON传输 ");  
        user.setContent("java对象转json文件格式！ ");  
        user.setCurrent(DateUtil.getCurrent());  
 
        List<UserBO> list = new ArrayList<UserBO>();  
        for (int i = 1; i < 1; i++) {  
            UserBO _user = new UserBO();  
            _user.setId(i);  
            _user.setTitle("JSON传输 " + i);  
            _user.setContent("java对象转json文件格式！ " + i);  
            _user.setCurrent(DateUtil.getCurrent());  
            list.add(_user);  
        }  
          
        //当既有对象又有数组的时候   
        Map<String,Object> map = new HashMap<String,Object>();   
        map.put("user",user);  
        map.put("list",list);  
          
        JSONObject jsonObjectFromMap = JSONObject.fromObject(map);   
        System.out.println(jsonObjectFromMap);   
          
    }  
 
}  