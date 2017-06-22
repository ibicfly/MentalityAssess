package com.xinlipinggu.dao;

public class Question {
	private int qId;
	private int qindex;
	private String qTitle;
	private Problem problem;
	public int getqId() {
		return qId;
	}
	public void setqId(int qId) {
		this.qId = qId;
	}
	public int getQindex() {
		return qindex;
	}
	public void setQindex(int qindex) {
		this.qindex = qindex;
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
