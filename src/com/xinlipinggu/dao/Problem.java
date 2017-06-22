package com.xinlipinggu.dao;

import java.util.Set;

public class Problem {
	private int pId;
	private String pTitle;
	private Set answers;
	private Set questions;
	public Set getquestions() {
		return questions;
	}
	public void setquestions(Set questions) {
		this.questions = questions;
	}
	public Set getAnswers() {
		return answers;
	}
	public void setanswers(Set answers) {
		this.answers = answers;
	}
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
	
}
