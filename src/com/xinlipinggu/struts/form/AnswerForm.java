package com.xinlipinggu.struts.form;

import org.apache.struts.action.ActionForm;

import com.xinlipinggu.dao.Problem;
import com.xinlipinggu.dao.User;

public class AnswerForm extends ActionForm{
	private int aId;
	private boolean[] answers;
	private User user;
	private Problem problem;
	public int getaId() {
		return aId;
	}
	public void setaId(int aId) {
		this.aId = aId;
	}
	public boolean[] getAnswers() {
		return answers;
	}
	public void setAnswers(boolean[] answers) {
		this.answers = answers;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Problem getProblem() {
		return problem;
	}
	public void setProblem(Problem problem) {
		this.problem = problem;
	}
}
