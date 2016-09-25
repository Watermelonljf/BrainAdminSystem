package com.adminsystem.UserServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import com.adminsystem.Pojo.Admin;
import com.adminsystem.Service.AdminLoginService;

public class AdminLoginServlet extends HttpServlet {


	/**
	 * 
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doPost(request, response);
	
	}

	/**
	 * 
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			//有问题创建时间
			Admin admin = new Admin(name, password,null, new Date());
			AdminLoginService adminLoginService = new AdminLoginService();
			ArrayList<Admin> admins = null;
			try{
				admins = adminLoginService.checkLogin(admin);
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			response.setCharacterEncoding("UTF-8");
			JSONObject jb = new JSONObject();
			if(admins!=null && admins.size()>0){
				HttpSession session=request.getSession();
				Admin db_userUser = new Admin();
				db_userUser.setName(admins.get(0).getName());
				db_userUser.setPassword(admins.get(0).getPassword());
				session.setAttribute("loginuser", db_userUser);    //
				jb.put("code", 1);
			}else {
				jb.put("code", 0);
			}
			PrintWriter out=response.getWriter();
			out.print(jb);
			out.close();
	}
}
