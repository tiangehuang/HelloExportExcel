package com.tiange.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.tiange.dao.UserDao;
import com.tiange.model.User;

public class UserServiceImpl implements UserService
{
	@Autowired
	private UserDao dao;
	
	@Override
	public void allUserToExcel(HttpServletResponse response)
	{
		List<User> list = dao.listAll();
		String filename = "allUser.xls";
		
		this.exportToExcel(list, filename, response);
		
	}

	private void exportToExcel(List<User> list, String filename, HttpServletResponse response)
	{
		AjaxResponse.responseName(fileName, response);  
        String[] header = {"用户Id","用户名","密码","真实姓名","手机号码","单位","下属旅游局Id","用户等级",  
                "创建时间","修改时间","状态","区域"};  
        ExportExcel<User> ex = new ExportExcel<User>();  
        OutputStream out = response.getOutputStream();           
        ex.exportExcel(header, listUser, out);  
        out.close(); 
	}

}
