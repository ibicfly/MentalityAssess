package com.xinlipinggu.dao;

import java.util.List;
import java.util.Set;

public class Problem {
	private int pId;
	private String pTitle;
	private Set<Answer> answerSet;
	private List<Question> questions;
	public Set<Answer> getAnswerSet() {
		return answerSet;
	}
	public void setAnswerSet(Set<Answer> answerSet) {
		this.answerSet = answerSet;
	}
	public List<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Question> questions) {
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
