package com.xinlipinggu.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.xinlipinggu.dao.Problem;
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
			
			//如果qindex重复,则将原题更新为现在的题目
			if(questionService.queryByqIndex(question.getQindex(),question.getProblem().getpId())!=null)
			{
				questionService.update(question);
			}else
			{
				questionService.add(question);
			}
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

	public ActionForward editQuestion(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("修改question");
		QuestionForm questionForm=(QuestionForm) form;
		QuestionService service=new QuestionService();
		ProblemService problemService=new ProblemService();
		
		Question  question=new Question();
		question.setqId(questionForm.getqId());
		question.setqTitle(questionForm.getqTitle());
		question.setQindex(questionForm.getQindex());
		question.setProblem(problemService.search(questionForm.getpId()));
		service.update(question);
		
		System.out.println("更新完成");
		request.setAttribute("pId", question.getProblem().getpId());
	return mapping.findForward("updateSu");
	}
	public ActionForward showQuestion(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("进入查询显示question具体信息界面");
		System.out.println();
		QuestionForm questionForm=(QuestionForm) form;
		QuestionService service=new QuestionService();
		
		Question  question=new Question();
		if(request.getParameter("qId")!=null)
		{		
			question=service.getQuestionByqId(Integer.parseInt(request.getParameter("qId")));
			request.setAttribute("question", question);
		}
		return mapping.findForward("modifyQuestion");

	}
	public ActionForward delQuestion(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("删除question");
		
		QuestionForm questionForm=(QuestionForm) form;
		QuestionService service=new QuestionService();
		ProblemService problemService=new ProblemService();
		
		service.del(questionForm.getqId());
		
		System.out.println("删除完成");
		request.setAttribute("pId", questionForm.getpId());
		return mapping.findForward("updateSu");
	}
}
