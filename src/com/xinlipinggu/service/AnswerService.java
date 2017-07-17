package com.xinlipinggu.service;

import com.xinlipinggu.dao.Answer;
import com.xinlipinggu.hibernate.HibernateUtil;

public class AnswerService {
	public void save(Answer answer)
	{
		HibernateUtil.save(answer);
	}
}
