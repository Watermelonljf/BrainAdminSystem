package com.adminsystem.UserServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import com.adminsystem.Pojo.Goods;
import com.adminsystem.Service.GoodsService;

public class GetGoodsInfoServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * 得到选中的记录给更新用
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int cId = Integer.parseInt(request.getParameter("CID"));
		GoodsService goods = new GoodsService();
		JSONObject jsonObject = new JSONObject();
		Goods goodsBean=null;
		goodsBean = goods.getRecode(cId);
		if(goodsBean!=null){
			jsonObject.put("code", 1);
			HttpSession session = request.getSession();
			session.setAttribute("goodsBean", goodsBean);
		}
		else{
			jsonObject.put("code", 0);
		}
		
		PrintWriter out = response.getWriter();
		out.print(jsonObject);
		out.close();
	}

}
