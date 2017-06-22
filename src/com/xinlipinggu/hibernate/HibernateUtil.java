package com.xinlipinggu.hibernate;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	
	public  SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public  void setSessionFactory(SessionFactory sessionFactory) {
		HibernateUtil.sessionFactory = sessionFactory;
	}
	//使用线程局部模式
	private static ThreadLocal threadlocal=new ThreadLocal();
	private HibernateUtil(){};
	//获取全新的session
	public static Session openSession(){
		return sessionFactory.openSession();
	}	
	//获取跟线程绑定的session
	public static Session getcurrentSession(){
		Session session=(Session) threadlocal.get();
		System.out.println(session.toString());
		if(session==null){
			session=sessionFactory.getCurrentSession();
	//将session对象设置到ThreadLocal，相当于将该session与线程绑定
			threadlocal.set(session);
		}
		return session;
	}
	//显示查询到的项目的条数
	public static int count(String hql,String[] parameters)
	{
		Session session=null;
		Transaction transaction=null;
		List list=null;
		int  row=0;
		try {
			session=HibernateUtil.openSession();
			transaction=session.beginTransaction();
			Query query=session.createQuery(hql);
			if(parameters!=null&&parameters.length>0){
				for(int i=0;i<parameters.length;i++)
				{
					query.setString(i,parameters[i]);
				}}
			list=query.list();
			if(list==null)
			{
				return 0;
			}else
			{
				row=list.size();
			}
		} catch (Exception e) {
			if(transaction!=null)
			{
				transaction.rollback();
			}
			System.out.println("查询抛错"+e.getMessage());
			return 0;
		}finally{
			try {
				if(session.isOpen()&&session!=null)
				{
					session.close();
				}
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return row;
	}
	public static Object uniqueQuery(String hql,String[] parameters)
	{
		Session session=null;
		Transaction transaction=null;
		List list=null;
		Object result=null;
		try{
			session=HibernateUtil.openSession();
			transaction=session.beginTransaction();
			Query query=session.createQuery(hql);
			if(parameters!=null&&parameters.length>0){
				for(int i=0;i<parameters.length;i++){
					query.setString(i, parameters[i]);
				}
			}
			result=query.uniqueResult();
			if(result==null)
			{
				return null;
			}
		}catch (Exception e) {
			// TODO: handle exception
			if(transaction!=null)
			{
				transaction.rollback();
			}
			System.out.println("查询抛错"+e.getMessage());
			return null;
		}finally{
			try {
				if(session.isOpen()&&session!=null)
				{
					session.close();
				}
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	public static List executeQuery(String hql,String[] paramaters) {
		//在这里要考虑到并发的问题，如果大量进行访问同一个操作，并发问题就很容易发生
		Session session=null;
		Transaction transaction=null;
		List list=null;
		try {
			session=HibernateUtil.openSession();
			transaction=session.beginTransaction();
			Query query=session.createQuery(hql);
			if(paramaters!=null&&paramaters.length>0){
			for(int i=0;i<paramaters.length;i++){
				query.setString(i, paramaters[i]);
			}
			}
			list=query.list();
			//查询到的list为空
			if(list.size()==0)
			{
				return null;
			}
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			if(transaction!=null)
			{
				transaction.rollback();
			}
			System.out.println("查询抛错"+e.getMessage());
			return null;
		}finally{
			try {
				if(session.isOpen()&&session!=null)
				{
					session.close();
				}
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	public static List executeQueryByPage(String hql,String[] paramaters,int pagenow,int pagesize) {
		//在这里要考虑到并发的问题，如果大量进行访问同一个操作，并发问题就很容易发生
		Session session=null;
		Transaction transaction=null;
		List list=null;
		try {
			session=HibernateUtil.openSession();
			transaction=session.beginTransaction();
			Query query=session.createQuery(hql);
			//在这里完成的是分页的算法
			query.setFirstResult((pagenow-1)*pagesize);
			query.setMaxResults(pagesize);
			
			if(paramaters!=null&&paramaters.length>0){
			for(int i=0;i<paramaters.length;i++){
				query.setString(i, paramaters[i]);
			}
			}
			list=query.list();
			if(list.size()==0)
			{
				return null;
			}
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			if(transaction!=null)
			{
				transaction.rollback();
			}
			throw new RuntimeException(e.getMessage());
		}finally{
			if(session.isOpen()&&session!=null)
			{
				session.close();
			}
		}
		return list;
	}
	public static List save(Object object) {
		//这个是统一的添加方法
		Session session=null;
		Transaction transaction=null;
		List list=null;
		try {
			session=openSession();
			transaction=session.beginTransaction();
			//直接将对象交给session进行处理就可以进行添加操作了，无需操心
			session.save(object);
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			if(transaction!=null)
			{
				transaction.rollback();
			}
			throw new RuntimeException(e.getMessage());
		}finally{
			if(session.isOpen()&&session!=null)
			{
				session.close();
			}
		}
		return list;
	}
	public static List addQuestion(Object object) {
		//这个是统一的添加方法
		Session session=null;
		Transaction transaction=null;
		List list=null;
		try {
			session=openSession();
			transaction=session.beginTransaction();
			//直接将对象交给session进行处理就可以进行添加操作了，无需操心
			session.save(object);
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			if(transaction!=null)
			{
				transaction.rollback();
			}
			throw new RuntimeException(e.getMessage());
		}finally{
			if(session.isOpen()&&session!=null)
			{
				session.close();
			}
		}
		return list;
	}
	
	public static void executeUpdate(String hql,String[] parameters) {
		//在这里要考虑到并发的问题，如果大量进行访问同一个操作，并发问题就很容易发生
			Session session=null;
			Transaction transaction=null;
			List list=null;
			try {
				session=HibernateUtil.openSession();
				transaction=session.beginTransaction();
				Query query=session.createQuery(hql);
				if(parameters!=null&&parameters.length>0){
				for(int i=0;i<parameters.length;i++){
					query.setString(i, parameters[i]);
				} 
				}
				//因为这个方法会返回进行更新或者删除后改变的行数，所以要由此进行判断是不容易的，
				//所以还是使用抛运行时异常的方式来判断是否更新或删除成功
				int i=query.executeUpdate();
				transaction.commit();
			} catch (Exception e) {
				// TODO: handle exception
				if(transaction!=null)
				{
					transaction.rollback();
				}
				throw new RuntimeException("执行失败"+e.getMessage());
			}finally{
				if(session.isOpen()&&session!=null)
				{
					session.close();
				}
			}
}	
}
