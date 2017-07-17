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
		HibernateUtil.save(question);
	}
	public void showQuestions(Problem problem)
	{
		
	}
	public Question search(int qId)
	{
		Question question=null;
		String[] temp={qId+""};
		question=(Question) HibernateUtil.uniqueQuery("from Question where qId=?",temp);
		return question;
	}

	public void del(Question question)
	{
		HibernateUtil.delete(question);
	}
	public Question getQuestionByqId(int qId)
	{
		String[] temp={qId+""};
		Question question=(Question) HibernateUtil.uniqueQuery("from Question where qId=? order by qindex", temp);
		return question;
	}
	public void update(Question question)
	{
		HibernateUtil.update(question);
	}
	public Question queryByqIndex(int qIndex,int pId)
	{
		String[] temp={pId+"",qIndex+""};
		Question question=null;
		if(HibernateUtil.executeQuery("from Question where pId=? and qindex=?",temp)!=null)
		{
			question=(Question) HibernateUtil.executeQuery("from Question where pId=? and qindex=?",temp).get(0);
		}
		return question;
	}
}
