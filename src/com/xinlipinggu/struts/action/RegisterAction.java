package com.xinlipinggu.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.beans.factory.annotation.Autowired;

import com.xinlipinggu.dao.User;
import com.xinlipinggu.service.UserService;
import com.xinlipinggu.struts.form.UserForm;

public class RegisterAction extends Action {
	private UserService userservice;
	public UserService getUserservice() {
		return userservice;
	}
	public void setUserservice(UserService userservice) {
		this.userservice = userservice;
	}
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		UserForm userForm=(UserForm)form;
		if(userForm.getUsername()!=null&&userForm.getPassword()!=null)
		{
			//先搜索是否存在，存在则跳回
			if(userservice.search(userForm.getUsername())!=null)
			{
				System.out.println("查询重复");
				request.setAttribute("username",userForm.getUsername());
				request.setAttribute("exist","用户名重复");
				return mapping.findForward("existUser");
			}
			User user=new User();
			user.setPassword(userForm.getPassword());
			user.setUsername(userForm.getUsername());
			userservice.add(user);
			return mapping.findForward("success");
		}else
		{
			request.setAttribute("error", "用户名密码不满足要求");
			return mapping.findForward("error");
		}
	}
	
}
