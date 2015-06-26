package cn.itcast.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.itcast.hibernate.domain.User;

/**
 * @ProjectName:hibernate
 * @ClassName:Base
 * @Description:ʹ��HibernateUtil�����������д�����Ż�����
 * @author: �쿭ǿ
 * @version: V1.0
 * @date:2014-7-6����11:21:54
 */
public class Base {
	public static void main(String[] args) {
		/** ����java��ĳ־û����� */
		User user = new User();
		user.setId(3);
		user.setBirthday(new Date());
		user.setName("name1");
		HibernateUtil.delete(user);
		System.out.println("end.....");
	}
}
