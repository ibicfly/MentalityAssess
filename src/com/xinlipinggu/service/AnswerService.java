package com.xinlipinggu.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.xinlipinggu.dao.Answer;
import com.xinlipinggu.hibernate.HibernateUtil;

public class AnswerService {

	public void save(Answer answer)
	{
		HibernateUtil.save(answer);
//		hibernateTemplate.save(answer);
	}
}
