package com.xinlipinggu.temp;

import com.xinlipinggu.dao.User;
import com.xinlipinggu.hibernate.HibernateUtil;

public class AddMannager {
	//添加管理员和最高管理员
	public static void addMannager()
	{
		User mannager=new User();
		mannager.setUsername("manager");
		mannager.setPassword("cyhcyh");
		HibernateUtil.save(mannager);
	}
	public static void addAdmin()
	{
		User admin=new User();
		admin.setUsername("administrator");
		admin.setPassword("cyhcyh");
		HibernateUtil.save(admin);
	}
}
