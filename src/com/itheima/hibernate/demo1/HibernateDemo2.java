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
	//����
	public void demo1() {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		Customer customer = new Customer();
		customer.setCust_name("������4");
		
		
		Serializable id = session.save(customer);
		
		tx.commit();
		session.close();
	}
	
	@Test
	//��ѯ
	public void demo2() {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		//ʹ��GET������ѯ
		/*Customer customer= session.get(Customer.class,1l);//����sql���
		System.out.println(customer);*/
		
		
		
		//ʹ��LOAD������ѯ
		Customer customer= session.load(Customer.class,2l);
		System.out.println(customer);
		
		
		tx.commit();
		session.close();
	}
	
	@Test
	//�޸�
	public void demo3() {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		//ֱ�Ӵ������� �����޸�  (���Ƽ�ʹ��)
		/*Customer customer= new Customer();
		customer.setCust_id(1l);
		customer.setCust_name("��ҹ��");
		session.update(customer);*/
		
		//�Ȳ�ѯ����  �ٽ����޸�(�Ƽ�ʹ��)
		Customer customer= session.get(Customer.class,1l);
		customer.setCust_name("����ӳ�");
		session.update(customer);
		
		
		tx.commit();
		session.close();
		
	}
	
	
	@Test
	//ɾ��
	public void demo4() {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		//ֱ�Ӵ�������  ��ɾ��  (���Ƽ�ʹ��)
		/*Customer customer= new Customer();
		customer.setCust_id(1l);
		session.delete(customer);
		*/
		
		//�Ȳ�ѯ����  �ٽ���ɾ��(�Ƽ�ʹ��)---����ɾ�� 
		Customer customer= session.get(Customer.class,2l);
		session.delete(customer);
		
		
		tx.commit();
		session.close();
		
	}
	
	@Test
	//��������
	public void demo5() {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		/*Customer customer= new Customer();
		customer.setCust_name("�����ӳ�");
		session.saveOrUpdate(customer);
		*/
		
		Customer customer= new Customer();
		customer.setCust_id(1l);
		customer.setCust_name("�̾���");
		session.saveOrUpdate(customer);
		
		
		tx.commit();
		session.close();
		
	}
	
	
	@Test
	//HQL��ѯ
	public void demo6() {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		//����HQL  Hibernate Query Language  �������Ĳ�ѯ����
		Query hql_query =session.createQuery("from Customer");
		List<Customer> hql_list = hql_query.list();
		for (Customer customer : hql_list) {
			System.out.println(customer);
		}
		
		//����SQL  
		SQLQuery sql_query = session.createSQLQuery("select * from cst_customer");
		List<Object[]> sql_list =  sql_query.list();
		for (Object[] objects : sql_list) {
			System.out.println(objects);
		}
		
		tx.commit();
		session.close();
		
	}
}
