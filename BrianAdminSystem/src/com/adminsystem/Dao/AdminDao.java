package com.adminsystem.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.adminsystem.Pojo.Admin;
import com.adminsystem.Util.UtilJDBC;


public class AdminDao implements DAO<Admin>{
	Connection con = (Connection) UtilJDBC.getConnection();
	 PreparedStatement sql=null; 
	 ResultSet rs = null;
	@Override
	public boolean Insert(Admin admin) {
		
		boolean flag = false;
		// TODO Auto-generated method stub
		 try{
				con=UtilJDBC.getConnection();//连接数据	
				sql=con.prepareStatement("select count(admin_id) from t_admin_info where uname='"+admin.getName()+"'");
				rs=sql.executeQuery();
				if(rs.next()){
					int num = rs.getInt(1);
					if(num>0){                                //如果>0说明数据库中已存在
						flag = false;
					}
					else {
						//System.out.println(user);
						if("".equals( admin.getPassword())){
							flag = true;    
						}
					/*	if(user.getUpassword().equals("")){
							           flag=true;        //
						}*/
						
						/**
						 * 修改sql
						 */
						else{
							sql=con.prepareStatement("insert into t_admin_info(userid,uname,upassword,usex) values(users_sequence.nextval,?,?,?)");
						    sql.setString(1, admin.getName());
					        sql.setString(2, admin.getPassword());
					        sql.setString(3,"男");
					        if(sql.executeUpdate()>0){
					        	flag=true;
					        }//执行！
					        else {
								flag = false;
							}
						}
					}
				}
			   
			}catch(SQLException E){
				E.printStackTrace();
				flag=false;
			}finally
		       {    
		           if(sql!= null)
					try {
						sql.close();
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


	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Admin> query(String strWhere, String orderby, int pageSize,
			int pageIndex) {
		// TODO Auto-generated method stub
		return null;
	}

}
