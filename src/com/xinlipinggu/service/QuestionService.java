package com.xinlipinggu.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.xinlipinggu.dao.Problem;
import com.xinlipinggu.dao.Question;
import com.xinlipinggu.hibernate.HibernateUtil;

public class QuestionService {
	public void add(Question question)
	{
			//这个是统一的添加方法
			Session session=null;
			Transaction transaction=null;
			List list=null;
			try {
				session=HibernateUtil.openSession();
				transaction=session.beginTransaction();
				//直接将对象交给session进行处理就可以进行添加操作了，无需操心
				session.save(question);
				transaction.commit();
			} catch (Exception e) {
				// TODO: handle exception
				if(transaction!=null)
				{
					transaction.rollback();
				}
				e.printStackTrace();
			}finally{
				if(session.isOpen()&&session!=null)
				{
					session.close();
				}
			}
	}
	public void showQuestions(Problem problem)
	{
		
	}
}
