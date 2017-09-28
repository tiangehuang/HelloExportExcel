package com.tiange.action;


import javax.servlet.http.HttpServletResponse;

import com.tiange.service.UserService;

public class UserAction
{
	private UserService service;
	public void setService(UserService service)
	{
		this.service = service;
	}
	public void exportAllUser(HttpServletResponse response)
	{
		service.allUserToExcel(response);
	}
}
