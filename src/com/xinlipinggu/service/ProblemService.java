package com.xinlipinggu.service;

import java.util.List;

import com.xinlipinggu.dao.Problem;
import com.xinlipinggu.hibernate.HibernateUtil;

public class ProblemService {
	public List showByPage(int pagenow,int pagesize)
	{
		List list=null;
		list=HibernateUtil.executeQueryByPage("from Problem",null,pagenow, pagesize);
		return list;
	}
	public void add(Problem problem)
	{
		HibernateUtil.save(problem);
	}
	public int count()
	{
		int row=0;
		row=HibernateUtil.count("from Problem",null);
		return row;
	}
	public void del(int pId)
	{
		String[] temp={pId+""};
		HibernateUtil.executeUpdate("Delete from Problem where pId=?",temp);
	}
	public void update(Problem problem)
	{
		String[] temp={problem.getpTitle(),problem.getpId()+""};
		HibernateUtil.executeUpdate("Update Problem set pTitle=? where pId=?", temp);
	}
	public boolean search(String pTitle)
	{
		boolean exist=false;
		String[] temp={pTitle};
		if(HibernateUtil.executeQuery("from Problem where pTitle=?", temp)!=null)
		{
			exist=true;
		}
		return exist;
	}
	public Problem search(int pId)
	{
		Problem problem=null;
		String[] temp={pId+""};
		problem=(Problem)HibernateUtil.uniqueQuery("from Problem where pId=?",temp);
		return problem;
	}
}
