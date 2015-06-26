package cn.itcast.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import cn.itcast.hibernate.domain.User;

/**
 * @ProjectName:hibernate
 * @ClassName:QueryTest
 * @Description:HQL��һЩ�򵥵Ĳ�ѯ
 * @author: �쿭ǿ
 * @version: V1.0
 * @date:2014-7-6����04:44:03
 */
public class QueryTest {
	public static void main(String[] args) {
		query("name");
	}

	/**
	 *@MethodName:query
	 *@Description:�������ƽ��в�ѯ
	 *@param name�û�������
	 *@author:�쿭ǿ
	 *@return void���ؿ�
	 *@date:2014-7-6����04:42:05
	 */
	@SuppressWarnings("unchecked")
	public static void query(String name) {
		/** ����session��transaction���� */
		Session session = null;
		List<User> users = new ArrayList<User>();
		/** Hql���user�Ǳ��� */
		// String hql = "from User as user where user.name=?";
		/** ʹ����������ʵ�� */
		String hql = "from User as user where user.name=:name";
		try {
			/** ʹ�ù��������ʵ����Session���� */
			session = HibernateUtil.getSession();
			/** ʵ����query���� */
			Query query = session.createQuery(hql);
			// query.setString(0, name);
			query.setString("name", name);
			/** ����query��list��������ȡ������� */
			users = query.list();
			/** ����������� */
			for (User user : users) {
				System.out.println(user.getName());
			}
		} finally {
			/** �ж�session�����Ƿ�Ϊ�գ���Ϊ����ر�session��Դ */
			if (session != null) {
				session.close();
			}
		}
	}
}
