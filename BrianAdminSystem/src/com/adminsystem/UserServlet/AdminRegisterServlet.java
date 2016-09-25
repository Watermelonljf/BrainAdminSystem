package com.adminsystem.UserServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.adminsystem.Pojo.Admin;
import com.adminsystem.Service.AdminRegistService;

public class AdminRegisterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String name = request.getParameter("uname");
			String password = request.getParameter("upassword");
			Admin admin=new Admin(name, password, new Date(), null);
			JSONObject jsonObject = new JSONObject();
			if(new AdminRegistService().Save(admin)){
				jsonObject.put("code", 1);
			}else{
				jsonObject.put("code", 0);
			}
			PrintWriter out = response.getWriter();
			out.print(jsonObject);
			out.close();
			
	
	}

}
