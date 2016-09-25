package com.adminsystem.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.adminsystem.Pojo.UserListBean;
import com.adminsystem.Util.UtilJDBC;

public class UserListService {
	Connection con=null;
    Statement stmt=null; 
    String sql=null;
    PreparedStatement pSql=null;
    ResultSet rs;
	public ArrayList<UserListBean> getUserListInfo(String strWhere, String orderby, int pageSize, int pageIndex){
		//第一步，初始化对象
	 	
	   //连接数据库 
		con=UtilJDBC.getConnection();
		int  intPageSize=pageSize; //一页要显示的记录数
		int  intRowCount;          //记录总数
		int  intPageCount;         //总页数
		int  intPage=pageIndex;    //待显示页码
		int  i;
		ArrayList<UserListBean> userList = new ArrayList<UserListBean>();  //利用数组将查询结果通过
		try{
		Statement stmt=con.createStatement(
				ResultSet.TYPE_SCROLL_SENSITIVE,
				ResultSet.CONCUR_READ_ONLY);
		String sql="select * from  T_WEBDEMO_USER";
		if(strWhere!=""&& strWhere!=null){
			sql+=" where "+strWhere;
		}
		if(orderby.trim()!=""&&orderby.trim()!=null){
			sql+=" order by "+orderby;
		}
		ResultSet rs=stmt.executeQuery(sql);
		rs.last(); 												//将光标移到结果的最后一条记录
		intRowCount=rs.getRow();					//得到记录总数
		intPageCount=(intRowCount+intPageSize-1)/intPageSize;	//计算总页数
		if(intPage>intPageCount) intPage=intPageCount;
		rs.absolute((intPage-1)*intPageSize+1);
		i=0;
		while(i<intPageSize && !rs.isAfterLast()){
			UserListBean uBean=new UserListBean();
			uBean.setUserId(rs.getInt("USERID"));
			uBean.setStrUserName(rs.getString("UNAME"));
			uBean.setStrUserSex(rs.getString("USEX"));
			uBean.setStrUserTel(rs.getString("UTEL"));
			uBean.setStrUserQ(rs.getString("UQQ"));
			uBean.setStrUserEmail(rs.getString("UEMAIL"));
			uBean.setStrAddress(rs.getString("UADDRESS"));
			userList.add(uBean);			
			rs.next();
			i++;		
		}			
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally
       {   
           if(con != null)
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} 
       } 
		return userList;
	}

public int GetRecordCount(String strWhere){
				//第一步，初始化对象
			 	Connection con=null;
			    Statement stmt=null; 
			    String sql=null;
			    ResultSet rs;
			    int count = 0;
			   //连接数据库 
				con=UtilJDBC.getConnection();
				try {
					if(strWhere!=""&&strWhere!=null){
						sql="select * from T_WEBDEMO_USER where "+strWhere;
					}else{
						sql="select * from T_WEBDEMO_USER";
					}
					 stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);//？？
					 rs=stmt.executeQuery(sql);
					 rs.last();
					 count=rs.getRow();
					
				}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					if(con!=null){
						try {
							con.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}				
				}	
				return count;
	}


 	//删除所选记录
 public boolean deleteRecode(String strId){
	 boolean flag=false;
	 con = UtilJDBC.getConnection();
	 try {
		pSql=con.prepareStatement("DELETE FROM T_WEBDEMO_USER WHERE USERID IN ("+strId+")");
		if(pSql.executeUpdate()>0){
			flag = true;
		}else{
			flag = false;
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("删除错误");
	}finally
    {    
        if(pSql!= null)
			try {
				pSql.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} 
        if(con != null)
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} 
    } 
	 return flag;
 }
}
