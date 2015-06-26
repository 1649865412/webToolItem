package cn.itcast.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.itcast.hibernate.domain.User;

/**
 * @ProjectName:hibernate
 * @ClassName:Base
 * @Description:使用HibernateUtil工具类来进行代码的优化操作
 * @author: 徐凯强
 * @version: V1.0
 * @date:2014-7-6上午11:21:54
 */
public class Base {
	public static void main(String[] args) {
		/** 进行java类的持久化操作 */
		User user = new User();
		user.setId(3);
		user.setBirthday(new Date());
		user.setName("name1");
		HibernateUtil.delete(user);
		System.out.println("end.....");
	}
}
