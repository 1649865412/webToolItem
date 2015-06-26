package cn.itcast.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import cn.itcast.hibernate.domain.User;

/**
 * @ProjectName:hibernate
 * @ClassName:QueryTest
 * @Description:HQL的一些简单的查询
 * @author: 徐凯强
 * @version: V1.0
 * @date:2014-7-6下午04:44:03
 */
public class QueryTest {
	public static void main(String[] args) {
		query("name");
	}

	/**
	 *@MethodName:query
	 *@Description:根据名称进行查询
	 *@param name用户的名称
	 *@author:徐凯强
	 *@return void返回空
	 *@date:2014-7-6下午04:42:05
	 */
	@SuppressWarnings("unchecked")
	public static void query(String name) {
		/** 创建session、transaction对象 */
		Session session = null;
		List<User> users = new ArrayList<User>();
		/** Hql语句user是别名 */
		// String hql = "from User as user where user.name=?";
		/** 使用命名参数实现 */
		String hql = "from User as user where user.name=:name";
		try {
			/** 使用工具类进行实例化Session对象 */
			session = HibernateUtil.getSession();
			/** 实例化query对象 */
			Query query = session.createQuery(hql);
			// query.setString(0, name);
			query.setString("name", name);
			/** 调用query的list方法，获取结果集合 */
			users = query.list();
			/** 迭代输出集合 */
			for (User user : users) {
				System.out.println(user.getName());
			}
		} finally {
			/** 判断session对象是否为空，不为空则关闭session资源 */
			if (session != null) {
				session.close();
			}
		}
	}
}
