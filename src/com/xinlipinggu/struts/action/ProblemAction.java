package com.xinlipinggu.struts.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.xinlipinggu.dao.Problem;
import com.xinlipinggu.service.ProblemService;
import com.xinlipinggu.struts.form.ProblemForm;

public class ProblemAction extends DispatchAction{

	public ActionForward showByPage(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		//现在先还是利用分页的方式将problem呈现出来
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
		return mapping.findForward("problemMain");
	}
	public ActionForward test(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("进入题目");
		ProblemForm problemForm=(ProblemForm) form;
		Problem problem=null;
		
		ProblemService problemService=new ProblemService();
		problem=problemService.search(problemForm.getpId());
		request.setAttribute("problem",problem);
		return mapping.findForward("test");
	}
}
