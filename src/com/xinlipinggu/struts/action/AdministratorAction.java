package com.xinlipinggu.struts.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import sun.security.provider.MD5;

import com.xinlipinggu.dao.User;
import com.xinlipinggu.service.UserService;
import com.xinlipinggu.struts.form.UserForm;


public class AdministratorAction extends DispatchAction {
	public ActionForward modify(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		//在这里准备以分页的方式取得所有用户，并通过request提交
		UserService service=new UserService();
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
		//添加现在所在页数，每页大小 使用网址附带的参数传值
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
		List<User> list=service.queryByPage(pagenow, pagesize);
		request.setAttribute("pagecount",pagecount);
		request.setAttribute("userlist", list);
		return mapping.findForward("modify");
	}
	public ActionForward search(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		UserForm userForm=(UserForm) form;
		UserService service=new UserService();
		User user=null;
		if(service.search(userForm.getUsername())!=null)
		{
			user=service.search(userForm.getUsername());
			request.setAttribute("searchRes", user);
			request.setAttribute("noUser", null);
			return mapping.findForward("search");
		}else
		{			
			request.setAttribute("noUser", "未找到对应用户");
			return mapping.findForward("search");	
		}
	}
	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		UserForm userForm=(UserForm) form;
		UserService service=new UserService();
		service.del(userForm.getUsername());
		int pagenow=userForm.getPagenow();
		request.setAttribute("pagenow", pagenow);
		return mapping.findForward("delete");
	}
}
