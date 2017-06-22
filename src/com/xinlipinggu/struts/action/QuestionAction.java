package com.xinlipinggu.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.xinlipinggu.dao.Question;
import com.xinlipinggu.service.ProblemService;
import com.xinlipinggu.service.QuestionService;
import com.xinlipinggu.struts.form.QuestionForm;

public class QuestionAction extends DispatchAction{
	public ActionForward addQuestion(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("成功进入添加页面");
		QuestionForm questionForm=(QuestionForm) form;
		QuestionService questionService=new QuestionService();
		ProblemService problemService=new ProblemService();
		
		//新建Question并赋值
		Question question=new Question();
		question.setQindex(questionForm.getQindex());
		question.setqId(questionForm.getqId());
		question.setqTitle(questionForm.getqTitle());
		if(problemService.search(questionForm.getpId())!=null)
		{
			//在这里取得problem,并进行设置
			question.setProblem(problemService.search(questionForm.getpId()));
			questionService.add(question);
			request.setAttribute("pId", questionForm.getpId());
			request.setAttribute("qindex", questionForm.getQindex());
			request.setAttribute("pTitle", question.getProblem().getpTitle());
			System.out.println("添加"+question.getQindex()+"号question");
			return mapping.findForward("addSu");
		}else
		{
			return mapping.findForward("addError");
		}
	}
}
