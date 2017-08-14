package com.xinlipinggu.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.hibernate.Hibernate;

import com.xinlipinggu.dao.Answer;
import com.xinlipinggu.dao.Problem;
import com.xinlipinggu.dao.User;
import com.xinlipinggu.service.AnswerService;
import com.xinlipinggu.service.ProblemService;
import com.xinlipinggu.service.UserService;
import com.xinlipinggu.struts.form.AnswerForm;

public class AnswerAction extends DispatchAction {
	private UserService userservice;
	public UserService getUserservice() {
		return userservice;
	}

	public void setUserservice(UserService userservice) {
		this.userservice = userservice;
	}

	public ActionForward upAnswer(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("成功进入提交答案界面");
		AnswerForm answerForm=(AnswerForm) form;
		ProblemService problemService=new ProblemService();
		AnswerService answerService=new AnswerService();
		
		Answer answer=new Answer();
		Problem problem=null;
		User user=null;
		
		String[] answers=answerForm.getAnswers();
		try
		{
			answer.setAnswers(answers);
			System.out.println(answerForm.getpId());
			problem=problemService.search(answerForm.getpId());
			answer.setProblem(problem);
			if(userservice.search(answerForm.getUsername())!=null)
			{
				user=userservice.search(answerForm.getUsername());
				System.out.println("找到用户"+user.getUsername());
				answer.setUser(user);
				user.getAnswers().add(answer);
			}else
			{
				answer.setUser(null);
			}
		}finally
		{
			answerService.save(answer);
			problem.getAnswerSet().add(answer);
		}
		
		request.setAttribute("answer",answer);
		request.setAttribute("problem", problem);
		
		return mapping.findForward("showResult");
	}
}