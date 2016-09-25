package com.adminsystem.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.adminsystem.Pojo.Admin;
import com.adminsystem.Util.UtilJDBC;

public class AdminLoginService {
	PreparedStatement sql=null; 
    ResultSet rs=null;
    Connection con=null;
    ArrayList<Admin> login=null;
    boolean  uflag =false;
    boolean  pflag =false;
    /**
     * 检查用户登录
     * @param admin
     * @return  
     */
    public ArrayList<Admin> checkLogin(Admin admin)
    {
 /*   	 
    	String db_uname;
    	String db_upassword;
    	String db_usex;*/
		    try{
		    	
		    	con=UtilJDBC.getConnection();//连接数据
		    	 sql = con.prepareStatement("SELECT * FROM T_WEBDEMO_USER WHERE uname=? and upassword=?");
		    	 sql.setString(1, admin.getName());
		    	 sql.setString(2, admin.getPassword());
		    	 rs = sql.executeQuery();
		    	 login=new ArrayList<Admin>();
		 
		    	 while(rs.next()){
		    		Admin loginer = Admin();
		    		 loginer.setName(rs.getString("uname"));
		    		 loginer.setPassword(rs.getString("upassword"));
		    		 login.add(loginer);
		    	
		    	 }
		    }catch (Exception e) { 
				// TODO: handle exception
		    	e.printStackTrace();
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
			return login;
    }
	private Admin Admin() {
		// TODO Auto-generated method stub
		return null;
	}
   
}
