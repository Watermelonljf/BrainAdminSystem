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
import com.adminsystem.Pojo.UserListBean;
import com.adminsystem.Service.GoodsService;
import com.adminsystem.Service.UserListService;

public class GetUserInfoSrevlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 * 得到用户信息列表
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
		    String type = request.getParameter("type");
		    //查询
		    if("1".equals(type)){
				String strWhere=request.getParameter("strSearch");
				if(strWhere!=""&&strWhere!=null){
					strWhere=" UNAME like '%"+strWhere+"%'";
				}
				//System.out.println(strWhere);
				int pageSize=Integer.parseInt(request.getParameter("pageSize"));
				int pageIndex =Integer.parseInt(request.getParameter("pageIndex"));
				ArrayList<UserListBean> userList=null;
				UserListService getList = new UserListService();           
				userList=getList.getUserListInfo(strWhere, "USERID ASC", pageSize, pageIndex);      //得到分页记录
				int count=getList.GetRecordCount(strWhere);
				response.setCharacterEncoding("UTF-8");
				JSONObject jsonObject = new JSONObject();
					jsonObject.put("code", 1);
					jsonObject.put("count", count);
					jsonObject.put("UL", userList);
				PrintWriter out=response.getWriter();
				out.print(jsonObject);
				out.close();
		    }else{   //删除
		    	String strId = request.getParameter("strId");
				System.out.println(strId);
				UserListService goods = new UserListService();
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
	}


