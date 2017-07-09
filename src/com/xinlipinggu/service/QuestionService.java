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
	public void del(int qId)
	{
		String[] temp={qId+""};
		HibernateUtil.executeUpdate("Delete Question where qId=?", temp);
	}
	public Question getQuestionByqId(int qId)
	{
		String[] temp={qId+""};
		Question question=(Question) HibernateUtil.uniqueQuery("from Question where qId=?", temp);
		return question;
	}
	public void update(Question question)
	{
		
		String[] temp={question.getqTitle(),question.getQindex()+"",question.getqId()+""};
		HibernateUtil.executeUpdate("Update Question set qTitle=?,qindex=? where qId=?", temp);
	}
	public Question queryByqIndex(int qIndex,int pId)
	{
		String[] temp={qIndex+"",pId+""};
		Question question=null;
		if(HibernateUtil.executeQuery("from Question where pId=? and qindex=?",temp)!=null)
		{
			question=(Question) HibernateUtil.executeQuery("from Question where pId=? and qindex=?",temp);
		}
		return question;
	}
}
