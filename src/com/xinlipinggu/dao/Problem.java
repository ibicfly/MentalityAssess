package com.xinlipinggu.dao;

import java.util.List;
import java.util.Set;

public class Problem {
	private int pId;
	private String pTitle;
	private Set answers;
	private Set questions;
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
