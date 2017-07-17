package com.xinlipinggu.dao;

public class Question {
	private int qId;
	private int qIndex;
	private String qTitle;
	private Problem problem;
	
	public int getqIndex() {
		return qIndex;
	}
	public void setqIndex(int qIndex) {
		this.qIndex = qIndex;
	}
	public int getqId() {
		return qId;
	}
	public void setqId(int qId) {
		this.qId = qId;
	}
	public String getqTitle() {
		return qTitle;
	}
	public void setqTitle(String qTitle) {
		this.qTitle = qTitle;
	}
	public Problem getProblem() {
		return problem;
	}
	public void setProblem(Problem problem) {
		this.problem = problem;
	}
	
}
