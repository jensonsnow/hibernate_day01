package com.itheima.hibernate.demo1;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.itheima.hibernate.utils.HibernateUtils;

public class HibernateDemo2 {

	@Test
	//新增
	public void demo1() {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		Customer customer = new Customer();
		customer.setCust_name("钢铁侠4");
		
		
		Serializable id = session.save(customer);
		
		tx.commit();
		session.close();
	}
	
	@Test
	//查询
	public void demo2() {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		//使用GET方法查询
		/*Customer customer= session.get(Customer.class,1l);//发送sql语句
		System.out.println(customer);*/
		
		
		
		//使用LOAD方法查询
		Customer customer= session.load(Customer.class,2l);
		System.out.println(customer);
		
		
		tx.commit();
		session.close();
	}
	
	@Test
	//修改
	public void demo3() {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		//直接创建对象 进行修改  (不推荐使用)
		/*Customer customer= new Customer();
		customer.setCust_id(1l);
		customer.setCust_name("暗夜侠");
		session.update(customer);*/
		
		//先查询对象  再进行修改(推荐使用)
		Customer customer= session.get(Customer.class,1l);
		customer.setCust_name("惊奇队长");
		session.update(customer);
		
		
		tx.commit();
		session.close();
		
	}
	
	
	@Test
	//删除
	public void demo4() {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		//直接创建对象  后删除  (不推荐使用)
		/*Customer customer= new Customer();
		customer.setCust_id(1l);
		session.delete(customer);
		*/
		
		//先查询对象  再进行删除(推荐使用)---级联删除 
		Customer customer= session.get(Customer.class,2l);
		session.delete(customer);
		
		
		tx.commit();
		session.close();
		
	}
	
	@Test
	//保存或更新
	public void demo5() {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		/*Customer customer= new Customer();
		customer.setCust_name("美国队长");
		session.saveOrUpdate(customer);
		*/
		
		Customer customer= new Customer();
		customer.setCust_id(1l);
		customer.setCust_name("绿巨人");
		session.saveOrUpdate(customer);
		
		
		tx.commit();
		session.close();
		
	}
	
	
	@Test
	//HQL查询
	public void demo6() {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		//接收HQL  Hibernate Query Language  面向对象的查询语言
		Query hql_query =session.createQuery("from Customer");
		List<Customer> hql_list = hql_query.list();
		for (Customer customer : hql_list) {
			System.out.println(customer);
		}
		
		//接收SQL  
		SQLQuery sql_query = session.createSQLQuery("select * from cst_customer");
		List<Object[]> sql_list =  sql_query.list();
		for (Object[] objects : sql_list) {
			System.out.println(objects);
		}
		
		tx.commit();
		session.close();
		
	}
}
