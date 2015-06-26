package cn.itcast.hibernate;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * @ProjectName:hibernate
 * @ClassName:HibernateUtil
 * @Description:hibernate工具类
 * @author: 徐凯强
 * @version: V1.0
 * @date:2014-7-6上午11:07:42
 */
public final class HibernateUtil {
	private static SessionFactory sessionFactory;

	/** 私有的构造方法，不能被实例化 */
	private HibernateUtil() {
	}

	/** 当虚拟机加载类的时候，执行，保证只运行一次 */
	static {
		/** hibernate初始化 */
		Configuration cfg = new Configuration();
		cfg.configure();
		/** 初始化，目的获取sessionFactory对象 */
		sessionFactory = cfg.buildSessionFactory();
	}

	/**
	 *@MethodName:getSessionFactory
	 *@Description:获取sessionFactory
	 *@author:徐凯强
	 *@return SessionFactory
	 *@date:2014-7-6上午11:04:51
	 */
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 *@MethodName:getSession
	 *@Description:获取session对象
	 *@author:徐凯强
	 *@return Session返回session对象
	 *@date:2014-7-6上午11:09:31
	 */
	public static Session getSession() {
		return sessionFactory.openSession();
	}

	/**
	 *@MethodName:save
	 *@Description:保存实体
	 *@param entity要保存的实体参数
	 *@author:徐凯强
	 *@return void返回值
	 *@date:2014-7-6下午04:16:54
	 */
	public static void save(Object entity) {
		/** 创建session、transaction对象 */
		Session session = null;
		Transaction transaction = null;
		try {
			/** 使用工具类进行实例化Session对象 */
			session = HibernateUtil.getSession();
			/** 调用session的beginTransaction方法实例化transaction对象 */
			transaction = session.beginTransaction();
			/** 调用session的save方法，进行对domain对象的持久化 */
			session.save(entity);
			/** 提交事务，如果不提交，数据将无法持久化到数据库中 */
			/** 如果事务提交不成功，会进行自动回滚 */
			transaction.commit();
		} finally {
			/** 判断session对象是否为空，不为空则关闭session资源 */
			if (session != null) {
				session.close();
			}
		}
	}

	/**
	 *@MethodName:delete
	 *@Description:删除实体
	 *@param entity要删除的实体参数
	 *@author:徐凯强
	 *@return void返回值
	 *@date:2014-7-6下午04:19:15
	 */
	public static void delete(Object entity) {
		/** 创建session、transaction对象 */
		Session session = null;
		Transaction transaction = null;
		try {
			/** 使用工具类进行实例化Session对象 */
			session = HibernateUtil.getSession();
			/** 调用session的beginTransaction方法实例化transaction对象 */
			transaction = session.beginTransaction();
			/** 调用session的delete方法，进行对domain对象的删除 */
			session.delete(entity);
			/** 提交事务，如果不提交，数据将无法持久化到数据库中 */
			/** 如果事务提交不成功，会进行自动回滚 */
			transaction.commit();
		} finally {
			/** 判断session对象是否为空，不为空则关闭session资源 */
			if (session != null) {
				session.close();
			}
		}
	}

	/**
	 *@MethodName:update
	 *@Description:更新实体
	 *@param entity要更新的实体参数
	 *@author:徐凯强
	 *@return void返回值
	 *@date:2014-7-6下午04:20:32
	 */
	public static void update(Object entity) {
		/** 创建session、transaction对象 */
		Session session = null;
		Transaction transaction = null;
		try {
			/** 使用工具类进行实例化Session对象 */
			session = HibernateUtil.getSession();
			/** 调用session的beginTransaction方法实例化transaction对象 */
			transaction = session.beginTransaction();
			/** 调用session的update方法，进行对domain对象的更新 */
			session.update(entity);
			/** 提交事务，如果不提交，数据将无法持久化到数据库中 */
			/** 如果事务提交不成功，会进行自动回滚 */
			transaction.commit();
		} finally {
			/** 判断session对象是否为空，不为空则关闭session资源 */
			if (session != null) {
				session.close();
			}
		}
	}

	/**
	 *@MethodName:get
	 *@Description:根据主键进行查询数据库中的记录
	 *@param clazz表示Class类对象
	 *@param id
	 *@author:徐凯强
	 *@return Object返回Object对象
	 *@date:2014-7-6下午04:25:33
	 */
	public static Object get(Class<?> clazz, Serializable id) {
		/** 创建session、transaction对象 */
		Session session = null;
		Object object = null;
		try {
			/** 使用工具类进行实例化Session对象 */
			session = HibernateUtil.getSession();
			/** 通过反射获取类的信息，通过反射找到类的映射文件,知道到数据库那张表进行查询 */
			object = session.get(clazz, id);
		} finally {
			/** 判断session对象是否为空，不为空则关闭session资源 */
			if (session != null) {
				session.close();
			}
		}
		return object;
	}
}
