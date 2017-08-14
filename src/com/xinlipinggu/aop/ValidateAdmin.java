package com.xinlipinggu.aop;

import com.xinlipinggu.dao.User;
import com.xinlipinggu.hibernate.HibernateUtil;
import com.xinlipinggu.temp.AddMannager;

public class ValidateAdmin {
	public static void addMannager()
	{
		if(HibernateUtil.executeQuery("from User where username='administrator'",null)==null)
		{
			User mannager=new User();
			mannager.setUsername("manager");
			mannager.setPassword("cyhcyh");
			HibernateUtil.save(mannager);
		}
	}
	public static void addAdmin()
	{
		if(HibernateUtil.executeQuery("from User where username='manager'",null)==null)
		{
		
		User admin=new User();
		admin.setUsername("administrator");
		admin.setPassword("cyhcyh");
		HibernateUtil.save(admin);
		}
	}
}
