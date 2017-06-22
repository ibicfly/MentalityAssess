package com.xinlipinggu.service;

import java.util.List;

import com.xinlipinggu.dao.User;
import com.xinlipinggu.hibernate.HibernateUtil;
import com.xinlipinggu.temp.AddMannager;

public class UserService {
	//添加用户
	public void add(Object object)
	{
		HibernateUtil.save(object);
	}
	//通过用户名搜索用户，返回用户对象
	public User search(String username)
	{
		String[] temp={username};
		User user=(User) HibernateUtil.uniqueQuery("from User where username=?",temp);
		return user;
	}
	public void del(String username)
	{
		String[] temp={username};
		HibernateUtil.executeUpdate("Delete from User where username=?",temp);
	}
	public List queryByPage(int pagenow,int pagesize)
	{
		String[] temp={"administrator","manager"};
		return HibernateUtil.executeQueryByPage("from User where username not in(?,?)",temp, pagenow, pagesize);
	}
	public int count()
	{
		String[] temp={"administrator","manager"};
		return HibernateUtil.count("from User where username not in(?,?)",temp);
	}
	static
	{			
		if(HibernateUtil.executeQuery("from User where username='administrator'",null)==null)
		{
			AddMannager.addAdmin();
		}
		if(HibernateUtil.executeQuery("from User where username='manager'",null)==null)
		{
			AddMannager.addMannager();
		}
	}
}