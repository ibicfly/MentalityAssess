package com.xinlipinggu.struts.form;

import java.util.Set;

import org.apache.struts.action.ActionForm;

import com.xinlipinggu.dao.Answer;
import com.xinlipinggu.dao.Question;

public class ProblemForm extends ActionForm {
	//先进行Problem的设计，将Problem和用户进行联系，用户和problem是多对多的关系
	private int pId;
	private String pTitle;
	private int pagenow;
	private Set<Answer> answers;
	private Set<Question> questions;
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public String getpTitle() {
		return pTitle;
	}
	public void setpTitle(String pTitle) {
		this.pTitle = pTitle;
	}
	public int getPagenow() {
		return pagenow;
	}
	public void setPagenow(int pagenow) {
		this.pagenow = pagenow;
	}
	public Set<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(Set<Answer> answers) {
		this.answers = answers;
	}
	public Set<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}
}
