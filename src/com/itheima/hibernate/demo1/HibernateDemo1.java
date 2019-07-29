package com.itheima.hibernate.demo1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateDemo1 {
	
	public void demo1() {
		//1、加载核心配置文件
		Configuration configuration = new Configuration().configure();
		//2、创建一个  sessionfactory 对象： 类似于JDBC 中连接池
		SessionFactory sessionFactory= configuration.buildSessionFactory();
		//3、通过sessionFactory获取到Session对象： 类似于JDBC中Connection
		Session session = sessionFactory.openSession();
		//4、手动开启事务：
		Transaction transaction = session.beginTransaction();
		//5、编写代码
		Customer customer = new Customer();
		customer.setCust_name("钢铁侠3");
		
		session.save(customer);
		
		//6、事务提交
		transaction.commit();
		//7、资源释放
		session.close();
	}

	public static void main(String[] args) {
		HibernateDemo1 a = new HibernateDemo1();
		a.demo1();
	}
}
