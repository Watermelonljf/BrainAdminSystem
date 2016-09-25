package com.adminsystem.UserServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.adminsystem.Service.GoodsService;

public class deleteGoodsServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * 用于删除商品信息
	 * 
	 * 
	 */
		public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String strId = request.getParameter("strId");
			System.out.println(strId);
			GoodsService goods = new GoodsService();
			JSONObject jsonObject = new JSONObject();
			if(goods.deleteRecode(strId)){
				jsonObject.put("code", 1);
			}
			else{
				jsonObject.put("code", 0);
			}
			
			PrintWriter out = response.getWriter();
			out.print(jsonObject);
			out.close();
			
	}	

}
