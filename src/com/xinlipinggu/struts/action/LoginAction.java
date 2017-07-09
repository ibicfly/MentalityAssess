package com.xinlipinggu.struts.action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.xinlipinggu.dao.User;
import com.xinlipinggu.service.UserService;
import com.xinlipinggu.struts.form.UserForm;
import com.xinlipinggu.test.HibernateTest;

public class LoginAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception 
	{
		// TODO Auto-generated method stub
		//表单取得用户信息
		UserForm userForm=(UserForm)form;
		//对用户进行查询
		UserService service=new UserService();
		User user=service.search(userForm.getUsername());
//		用户名密码验证成功
		if(user!=null)
		{
			if(userForm.getPassword().equals(user.getPassword()))
			{
				if(userForm.getUsername().equals("administrator"))
				{
					request.getSession().setAttribute("administrator", userForm.getUsername());
					return mapping.findForward("administrator");
				}
				if(userForm.getUsername().equals("manager"))
				{				
					request.getSession().setAttribute("manager", userForm.getUsername());
					return mapping.findForward("manager");	
				}
				//设置会话用户名
				request.getSession().setAttribute("username", user.getUsername());
				//设置自动登录
				if(userForm.remberUser())
				{
					response.addCookie(new Cookie("username",user.getUsername()));
				}
				response.setCharacterEncoding("utf-8");
				return mapping.findForward("success");
			}else
			{
				request.getSession().setAttribute("username",null);
				request.setAttribute("error", "账号密码不匹配");
				response.setCharacterEncoding("utf-8");
				return mapping.findForward("error");
			}
		}else
		{
			System.out.println("进入用户不存在");
			request.getSession().setAttribute("username", null);
			request.setAttribute("error", "账号不存在");
			response.setCharacterEncoding("utf-8");
			return mapping.findForward("error");
		}
	}
}
