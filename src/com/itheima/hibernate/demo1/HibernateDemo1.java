package com.itheima.hibernate.demo1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateDemo1 {
	
	public void demo1() {
		//1�����غ��������ļ�
		Configuration configuration = new Configuration().configure();
		//2������һ��  sessionfactory ���� ������JDBC �����ӳ�
		SessionFactory sessionFactory= configuration.buildSessionFactory();
		//3��ͨ��sessionFactory��ȡ��Session���� ������JDBC��Connection
		Session session = sessionFactory.openSession();
		//4���ֶ���������
		Transaction transaction = session.beginTransaction();
		//5����д����
		Customer customer = new Customer();
		customer.setCust_name("������3");
		
		session.save(customer);
		
		//6�������ύ
		transaction.commit();
		//7����Դ�ͷ�
		session.close();
	}

	public static void main(String[] args) {
		HibernateDemo1 a = new HibernateDemo1();
		a.demo1();
	}
}
