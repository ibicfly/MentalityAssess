package com.xinlipinggu.struts.action;

import java.util.List;

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
		
		Problem problem=problemService.search(questionForm.getpId());
		List<Question> questions=problem.getQuestions();

		//新建Question并赋值
		Question question=new Question();
		question.setqTitle(questionForm.getqTitle());
		question.setqIndex(questionForm.getQindex());
		//若存在问题
		if(problem!=null)
		{
			//在这里取得problem,并进行设置
			question.setProblem(problem);
			System.out.println("\n\n"+"id"+question.getqId()+"index"+
					question.getqIndex()+"title"+question.getqTitle()+"problem"+question.getProblem());
					
			//如果qindex重复,则将原题更新为现在的题目
			if(problem.getQuestions()!=null&&problem.getQuestions().size()!=0&&
				problem.getQuestions().size()>questionForm.getQindex()&&
				(questionService.queryByqIndex(questionForm.getQindex(), questionForm.getpId()))!=null)
			{
				System.out.println("重复");
				//得到现今存在的question,并删除
				Question exist=questionService.queryByqIndex
						(questionForm.getQindex(), questionForm.getpId());
				exist.setqIndex(question.getqIndex());
				exist.setqTitle(question.getqTitle());
				questionService.update(exist);
			}else
			{
				System.out.println("未重复");
				questionService.add(question);
				questions.add(question);
				problem.setQuestions(questions);
				problemService.update(problem);
			}
			request.setAttribute("pId", problem.getpId());
			request.setAttribute("qindex", question.getqIndex());
			request.setAttribute("qTitle", question.getqTitle());
			request.setAttribute("pTitle", problem.getpTitle());
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
		Problem problem=problemService.search(questionForm.getpId());
		
		Question  question=new Question();
		question.setqId(questionForm.getqId());
		question.setqTitle(questionForm.getqTitle());
		question.setqIndex(questionForm.getQindex());
		question.setProblem(problem);
		problem.getQuestions().set(questionForm.getQindex(),question);
		
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
		
		try {
			service.del(service.search(questionForm.getqId()));

		} catch (NullPointerException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("删除出错");
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("删除出错");
		}
		System.out.println("删除完成");
		request.setAttribute("pId", questionForm.getpId());
		return mapping.findForward("updateSu");
	}
}
