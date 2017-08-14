package com.xinlipinggu.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.Test;

import com.xinlipinggu.dao.User;

@Component
@ContextConfiguration(locations={"file:WebRoot/WEB-INF/applicationContext.xml"})
public class HibernateTemplateTest {
	@Autowired
	private HibernateTemplate HibernateTemplate;
	@Test
	public void test()
	{
		User user=HibernateTemplate.get(User.class,1);
		System.out.println(user.getPassword());
	}
}
