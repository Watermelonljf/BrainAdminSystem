package com.adminsystem.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.adminsystem.Pojo.Admin;
import com.adminsystem.Pojo.ChangeData;
import com.adminsystem.Util.UtilJDBC;

public class ChangePassService {
	PreparedStatement sql=null; 
    ResultSet rs=null;
    Connection con=null;
    
    public boolean saveChange(Admin data,String newPassword){
    	boolean flag = false;
    	con = UtilJDBC.getConnection();
    	try {
			sql=con.prepareStatement("Update T_WEBDEMO_USER SET UPASSWORD=? WHERE UNAME=? AND UPASSWORD=?");
			sql.setString(1,newPassword);
			sql.setString(2,data.getName());
			sql.setString(3, data.getPassword());
			int cout = 0;
			cout=sql.executeUpdate();
			if(cout ==1){
				flag = true;
			}
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}{    
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
    
}
