package com.xinlipinggu.struts.form;

import java.util.Set;

import org.apache.struts.action.ActionForm;

public class ProblemForm extends ActionForm {
	//先进行Problem的设计，将Problem和用户进行联系，用户和problem是多对多的关系
	private int pId;
	private String pTitle;
	private int pagenow;
	private Set answers;
	private Set questions;
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
	public Set getAnswers() {
		return answers;
	}
	public void setAnswers(Set answers) {
		this.answers = answers;
	}
	public Set getQuestions() {
		return questions;
	}
	public void setQuestions(Set questions) {
		this.questions = questions;
	}
	
}
