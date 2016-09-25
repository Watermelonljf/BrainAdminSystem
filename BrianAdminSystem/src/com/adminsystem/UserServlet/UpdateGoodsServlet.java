package com.adminsystem.UserServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.adminsystem.Pojo.Goods;
import com.adminsystem.Service.GoodsService;

public class UpdateGoodsServlet extends HttpServlet {

	/**
	 * 真正修改商品信息
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * @author Watermelon_R（柳建飞）
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
	 * 真正修改商品信息
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * @author Watermelon_R（柳建飞）
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			HttpSession session = request.getSession();
			Goods goods =  (Goods)session.getAttribute("goodsBean");
			String cname =this.toNormalChinese(request.getParameter("gname"));
			int cclass =Integer.parseInt(request.getParameter("gclass"));
			float cprice = Float.parseFloat(request.getParameter("price"));
			float caprice = Float.parseFloat(request.getParameter("aprice"));
			int ccount =Integer.parseInt(request.getParameter("count"));
			int cscount = Integer.parseInt(request.getParameter("stock"));
			String cinfo =this.toNormalChinese(request.getParameter("info"));
			
			
			Goods newGoods = new Goods();
			
			newGoods.setCname(cname);
			newGoods.setCclass(cclass);
			newGoods.setCprice(cprice);
			newGoods.setCaprice(caprice);
			newGoods.setCcount(ccount);
			newGoods.setCscount(cscount);
			newGoods.setCdep(cinfo);
			
			GoodsService updateGoods = new GoodsService();
			if(updateGoods.UpdateRecode(newGoods, goods.getCid())){
				response.sendRedirect("../Goods/GoodsList.jsp");
			}else{
				System.out.println("跳转错往会找");
			}
	}
	
	public String toNormalChinese(String str) throws UnsupportedEncodingException{
		return new String(str.getBytes("ISO-8859-1"),"utf-8");
	}

}
