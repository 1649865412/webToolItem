package cn.itcast.hibernate;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * @ProjectName:hibernate
 * @ClassName:HibernateUtil
 * @Description:hibernate������
 * @author: �쿭ǿ
 * @version: V1.0
 * @date:2014-7-6����11:07:42
 */
public final class HibernateUtil {
	private static SessionFactory sessionFactory;

	/** ˽�еĹ��췽�������ܱ�ʵ���� */
	private HibernateUtil() {
	}

	/** ��������������ʱ��ִ�У���ֻ֤����һ�� */
	static {
		/** hibernate��ʼ�� */
		Configuration cfg = new Configuration();
		cfg.configure();
		/** ��ʼ����Ŀ�Ļ�ȡsessionFactory���� */
		sessionFactory = cfg.buildSessionFactory();
	}

	/**
	 *@MethodName:getSessionFactory
	 *@Description:��ȡsessionFactory
	 *@author:�쿭ǿ
	 *@return SessionFactory
	 *@date:2014-7-6����11:04:51
	 */
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 *@MethodName:getSession
	 *@Description:��ȡsession����
	 *@author:�쿭ǿ
	 *@return Session����session����
	 *@date:2014-7-6����11:09:31
	 */
	public static Session getSession() {
		return sessionFactory.openSession();
	}

	/**
	 *@MethodName:save
	 *@Description:����ʵ��
	 *@param entityҪ�����ʵ�����
	 *@author:�쿭ǿ
	 *@return void����ֵ
	 *@date:2014-7-6����04:16:54
	 */
	public static void save(Object entity) {
		/** ����session��transaction���� */
		Session session = null;
		Transaction transaction = null;
		try {
			/** ʹ�ù��������ʵ����Session���� */
			session = HibernateUtil.getSession();
			/** ����session��beginTransaction����ʵ����transaction���� */
			transaction = session.beginTransaction();
			/** ����session��save���������ж�domain����ĳ־û� */
			session.save(entity);
			/** �ύ����������ύ�����ݽ��޷��־û������ݿ��� */
			/** ��������ύ���ɹ���������Զ��ع� */
			transaction.commit();
		} finally {
			/** �ж�session�����Ƿ�Ϊ�գ���Ϊ����ر�session��Դ */
			if (session != null) {
				session.close();
			}
		}
	}

	/**
	 *@MethodName:delete
	 *@Description:ɾ��ʵ��
	 *@param entityҪɾ����ʵ�����
	 *@author:�쿭ǿ
	 *@return void����ֵ
	 *@date:2014-7-6����04:19:15
	 */
	public static void delete(Object entity) {
		/** ����session��transaction���� */
		Session session = null;
		Transaction transaction = null;
		try {
			/** ʹ�ù��������ʵ����Session���� */
			session = HibernateUtil.getSession();
			/** ����session��beginTransaction����ʵ����transaction���� */
			transaction = session.beginTransaction();
			/** ����session��delete���������ж�domain�����ɾ�� */
			session.delete(entity);
			/** �ύ����������ύ�����ݽ��޷��־û������ݿ��� */
			/** ��������ύ���ɹ���������Զ��ع� */
			transaction.commit();
		} finally {
			/** �ж�session�����Ƿ�Ϊ�գ���Ϊ����ر�session��Դ */
			if (session != null) {
				session.close();
			}
		}
	}

	/**
	 *@MethodName:update
	 *@Description:����ʵ��
	 *@param entityҪ���µ�ʵ�����
	 *@author:�쿭ǿ
	 *@return void����ֵ
	 *@date:2014-7-6����04:20:32
	 */
	public static void update(Object entity) {
		/** ����session��transaction���� */
		Session session = null;
		Transaction transaction = null;
		try {
			/** ʹ�ù��������ʵ����Session���� */
			session = HibernateUtil.getSession();
			/** ����session��beginTransaction����ʵ����transaction���� */
			transaction = session.beginTransaction();
			/** ����session��update���������ж�domain����ĸ��� */
			session.update(entity);
			/** �ύ����������ύ�����ݽ��޷��־û������ݿ��� */
			/** ��������ύ���ɹ���������Զ��ع� */
			transaction.commit();
		} finally {
			/** �ж�session�����Ƿ�Ϊ�գ���Ϊ����ر�session��Դ */
			if (session != null) {
				session.close();
			}
		}
	}

	/**
	 *@MethodName:get
	 *@Description:�����������в�ѯ���ݿ��еļ�¼
	 *@param clazz��ʾClass�����
	 *@param id
	 *@author:�쿭ǿ
	 *@return Object����Object����
	 *@date:2014-7-6����04:25:33
	 */
	public static Object get(Class<?> clazz, Serializable id) {
		/** ����session��transaction���� */
		Session session = null;
		Object object = null;
		try {
			/** ʹ�ù��������ʵ����Session���� */
			session = HibernateUtil.getSession();
			/** ͨ�������ȡ�����Ϣ��ͨ�������ҵ����ӳ���ļ�,֪�������ݿ����ű���в�ѯ */
			object = session.get(clazz, id);
		} finally {
			/** �ж�session�����Ƿ�Ϊ�գ���Ϊ����ر�session��Դ */
			if (session != null) {
				session.close();
			}
		}
		return object;
	}
}
