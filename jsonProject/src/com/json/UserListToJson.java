package com.json;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;

import com.util.DateUtil;
 
public class UserListToJson {  
 
    public static void main(String[] args) {  
 
        List<UserBO> list = new ArrayList<UserBO>();  
        for (int i = 1; i < 10; i++) {  
            UserBO _user = new UserBO();  
            _user.setId(i);  
            _user.setTitle("JSON传输 " + i);  
            _user.setContent("java对象转json文件格式！ " + i);  
            _user.setCurrent(DateUtil.getCurrent());  
            list.add(_user);  
        }  
        JSONArray jsonArray = JSONArray.fromObject(list);  
        System.out.println(jsonArray);  
    }  
}  
