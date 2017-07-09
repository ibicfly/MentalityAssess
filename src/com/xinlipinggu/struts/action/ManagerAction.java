package com.xinlipinggu.struts.action;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.hibernate.Hibernate;
import org.hibernate.Session;

import com.xinlipinggu.dao.Problem;
import com.xinlipinggu.dao.Question;
import com.xinlipinggu.hibernate.HibernateUtil;
import com.xinlipinggu.service.ProblemService;
import com.xinlipinggu.struts.form.ProblemForm;

public class ManagerAction extends DispatchAction {
	public ActionForward addProblem(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		Problem problem=new Problem();
		ProblemService service=new ProblemService();
		ProblemForm problemForm=(ProblemForm) form;
		//查重
		if(service.search(problemForm.getpTitle()))
		{
			request.setAttribute("pTitle", problemForm.getpTitle());
			request.setAttribute("p_exist", "该问题已存在");
			return mapping.findForward("addProblem");
		}else{
		problem.setpTitle(problemForm.getpTitle());
		service.add(problem);
		request.setAttribute("managerSu", "添加成功");
		request.setAttribute("pId",problem.getpId());
		request.setAttribute("pTitle", problem.getpTitle());
		return mapping.findForward("success");
		}
	}	
	public ActionForward showProblems(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		ProblemService service=new ProblemService();
		int pagenow=1;
		int pagesize=3;
		int rowcount=service.count();
		int pagecount=0;
		//判断页数
		if(rowcount%pagesize==0)
		{
			pagecount=rowcount/pagesize;
		}else
		{
			pagecount=rowcount/pagesize+1;
		}
		if(request.getParameter("pagenow")!=null)
		{
			pagenow=Integer.parseInt(request.getParameter("pagenow"));
			if(pagenow<1)
			{
				pagenow=1;
			}
			if(pagenow>pagecount)
			{
				pagenow=pagecount;
			}
			request.setAttribute("pagenow", pagenow);
		}else
		{
			if(request.getAttribute("pagenow")!=null)
			{
				pagenow=(Integer) request.getAttribute("pagenow");
				System.out.println("pagenow");
			}else
			{
				request.setAttribute("pagenow", pagenow);
			}
		}
		if(request.getParameter("pagesize")!=null)
		{
			pagesize=Integer.parseInt(request.getParameter("pagesize"));
			request.setAttribute("pagesize", pagesize);
		}else
		{
			request.setAttribute("pagesize", pagesize);
		}
		List<Problem> list=service.showByPage(pagenow, pagesize);
		request.setAttribute("pagecount",pagecount);
		request.setAttribute("problemList", list);
		return mapping.findForward("showProblems");
	}
	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		ProblemForm problemForm=(ProblemForm) form;
		ProblemService service=new ProblemService();
		int pagenow=problemForm.getPagenow();
		request.setAttribute("pagenow", pagenow);
		try {
			service.del(problemForm.getpId());
		} catch (Exception e) {
			// TODO: handle exception
			request.setAttribute("managerError", "删除失败");
			return mapping.findForward("error");
		}
		request.setAttribute("managerSu", "删除成功");
		return mapping.findForward("success");
	}
	public ActionForward editProblem(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
//		接受要修改的问题，并从数据库中取出
		ProblemForm prForm=(ProblemForm) form;
		ProblemService service=new ProblemService();
		Problem problem=new Problem();
		//从数据库通过pId查找problem
		if(request.getParameter("pId")!=null)
		{
			problem=service.search(Integer.parseInt(request.getParameter("pId")));
		}else
		{
			problem=service.search(prForm.getpId());
		}
		System.out.println(problem.getQuestions().size());
		request.setAttribute("pagenow",prForm.getPagenow());
		request.setAttribute("pId", problem.getpId());
		request.setAttribute("pTitle",problem.getpTitle());
		request.setAttribute("questions", problem.getQuestions());
		
		Set<Question> questions=problem.getQuestions();
		
		for(Question question:questions)
		{
			System.out.println(question.getQindex()+question.getqTitle());
		}
		return mapping.findForward("editProblem");
	}
	public ActionForward saveProblem(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
//		接受页面提交的有关Problem的信息，并进行修改
		System.out.println("进入修改");
		ProblemForm prForm=(ProblemForm) form;
		ProblemService service=new ProblemService();
		Problem problem=new Problem();
		try {
		problem.setpTitle(prForm.getpTitle());
		problem.setpId(prForm.getpId());
		request.setAttribute("pagenow", prForm.getPagenow());
		service.update(problem);
		request.setAttribute("managerSu","修改成功");  
		return mapping.findForward("success");
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("managerError", "修改失败");
			return mapping.findForward("error");
		}
	}
}