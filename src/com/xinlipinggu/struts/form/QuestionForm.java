package com.xinlipinggu.struts.form;

import org.apache.struts.action.ActionForm;

import com.xinlipinggu.dao.Problem;

public class QuestionForm extends ActionForm {
	private int qId;
	private int qindex;
	private String qTitle;
	private Problem problem;
	private int pId;
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
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
}
