package com.xinlipinggu.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
