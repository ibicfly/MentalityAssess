package com.xinlipinggu.struts.form;

import org.apache.struts.action.ActionForm;

import com.xinlipinggu.dao.Problem;
import com.xinlipinggu.dao.User;

public class AnswerForm extends ActionForm{
	
	private int aId;
	private String[] answers;
	private User user;
	private Problem problem;
	private String username;
	private int pId;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public int getaId() {
		return aId;
	}
	public void setaId(int aId) {
		this.aId = aId;
	}
	public String[] getAnswers() {
		return answers;
	}
	public void setAnswers(String[] answers) {
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
