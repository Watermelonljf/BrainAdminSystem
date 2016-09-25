package com.adminsystem.UserServlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.adminsystem.Pojo.Goods;
import com.adminsystem.Service.GoodsService;

public class AddGoodServlet extends HttpServlet {

	
	/**
	 * 解决表单中文乱码问题的过滤器
	 * @param str
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	
	public String toNormalChinese(String str) throws UnsupportedEncodingException{
		return new String(str.getBytes("ISO-8859-1"),"utf-8");
	}
	/**
	 * 
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
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String cname =this.toNormalChinese(request.getParameter("gname"));
			int cclass =Integer.parseInt(request.getParameter("gclass"));
			float cprice = Float.parseFloat(request.getParameter("price"));
			float caprice = Float.parseFloat(request.getParameter("aprice"));
			int ccount =Integer.parseInt(request.getParameter("count"));
			int cscount = Integer.parseInt(request.getParameter("stock"));
			String time = request.getParameter("time");
			System.out.println(time);
			String cinfo =this.toNormalChinese(request.getParameter("info"));
			
			
			Goods goods = new Goods();
			
			goods.setCname(cname);
			goods.setCclass(cclass);
			goods.setCprice(cprice);
			goods.setCaprice(caprice);
			goods.setCcount(ccount);
			goods.setCscount(cscount);
			goods.setOnTime(time);
			goods.setCdep(cinfo);
			
			GoodsService addGoodsService = new GoodsService();
			if(addGoodsService.saveGoods(goods)){
					response.sendRedirect("../Goods/GoodsList.jsp");
			}else{
					System.out.println("错误");
			}
	}
	
	

}


