package com.adminsystem.UserServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.adminsystem.Pojo.Goods;
import com.adminsystem.Service.GoodsService;

public class getGoodsServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 *得到商品列表信息
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String strWhere=request.getParameter("strSearch");
		if(strWhere!=""&&strWhere!=null){
			strWhere=" CNAME like '%"+strWhere+"%'";
		}
		//System.out.println(strWhere);
		int pageSize=Integer.parseInt(request.getParameter("pageSize"));
		int pageIndex =Integer.parseInt(request.getParameter("pageIndex"));
		ArrayList<Goods> goodsList=null;
		GoodsService getList = new GoodsService();
		goodsList=getList.getGoodsList(strWhere, "CID ASC", pageSize, pageIndex);
		int count=getList.GetRecordCount(strWhere);
		response.setCharacterEncoding("UTF-8");
		JSONObject jsonObject = new JSONObject();
			jsonObject.put("code", 1);
			jsonObject.put("count", count);
			jsonObject.put("GL", goodsList);
		PrintWriter out=response.getWriter();
		out.print(jsonObject);
		out.close();
	}

}
