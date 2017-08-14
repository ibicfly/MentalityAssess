package com.xinlipinggu.service;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import com.xinlipinggu.dao.User;
import com.xinlipinggu.hibernate.HibernateUtil;
public class UserService {
	private HibernateTemplate hibernateTemplate;
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	//添加用户
	public void add(Object object)
	{
//		HibernateUtil.save(object);
		hibernateTemplate.save(object);
	}
	//通过用户名搜索用户，返回用户对象
	public User search(String username)
	{
		String[] temp={username};
//		User user=(User) HibernateUtil.uniqueQuery("from User where username=?",temp);
		User user=null;
		if(hibernateTemplate.find("from User where username=?", username)!=null
				&&hibernateTemplate.find("from User where username=?", username).size()!=0)
		{
			user=(User) hibernateTemplate.find("from User where username=?", username).get(0);
		}
		return user;
	}
	//通过用户id搜索用户
	public User search(int uId)
	{
		String[] temp={uId+""};
//		User user=(User) HibernateUtil.uniqueQuery("from User where uId=?",temp);
		User user=hibernateTemplate.get(User.class, uId);
		return user;
	}
	public void del(String username)
	{
		String[] temp={username};
		hibernateTemplate.update("Delete from User where username=?",temp);
//		HibernateUtil.executeUpdate("Delete from User where username=?",temp);
	}
	public List queryByPage(int pagenow,int pagesize)
	{
		String[] temp={"administrator","manager"};
		return HibernateUtil.executeQueryByPage("from User where username not in(?,?)",temp, pagenow, pagesize);
	}
	public int count()
	{
		String[] temp={"administrator","manager"};
//		 HibernateUtil.count("from User where username not in(?,?)",temp);
		return (Integer) hibernateTemplate.find("select count(*) from User where username not in(?,?)"
				,"administrator","manager").iterator().next();
	}
}