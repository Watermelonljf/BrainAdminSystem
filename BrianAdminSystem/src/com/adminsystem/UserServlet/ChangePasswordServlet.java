package com.adminsystem.UserServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.adminsystem.Pojo.Admin;
import com.adminsystem.Pojo.ChangeData;
import com.adminsystem.Service.ChangePassService;

public class ChangePasswordServlet extends HttpServlet {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request, response);                        //让doGet做doPost方法
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			JSONObject jsonObject = new JSONObject();
			ChangeData data = new ChangeData();
			ChangePassService changePass = new ChangePassService();
		
			Admin admin = (Admin)request.getSession().getAttribute("loginuser");
			String oldPass = request.getParameter("txtOldPassword");
			String newPass = request.getParameter("txtNewPassword");
			if(oldPass.equals(admin.getPassword())){
				 if(changePass.saveChange(admin,newPass)){
					 jsonObject.put("code", 1);
				 }else{
					 jsonObject.put("code", 0);
				 }
			}else{
				 jsonObject.put("code", 0);
			}
			 PrintWriter out = response.getWriter();
			 out.print(jsonObject);
			 out.close();
	}

}
