package com.xinlipinggu.test;

import com.xinlipinggu.hibernate.HibernateUtil;

public class HibernateTest {
	public static void test()
	{
		System.out.println("enter the test");
		HibernateUtil.openSession();
	}
}
