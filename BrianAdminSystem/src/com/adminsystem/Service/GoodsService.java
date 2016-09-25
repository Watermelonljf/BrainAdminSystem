package com.adminsystem.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.adminsystem.Pojo.Goods;
import com.adminsystem.Util.UtilJDBC;

public class GoodsService {
			public boolean saveGoods(Goods goods){
				 PreparedStatement sql=null;                     
			     Connection con=null;
			     boolean flag=false;
			     
			     con =UtilJDBC.getConnection();
			     try {
					sql = con.prepareStatement("INSERT INTO T_WEBDEMO_COMMODITY(CID,CNAME,CCID,CPRICE,CAPRICE,CAMOUNT,CLEAVENUM,CSTARTIME,CDEPICT) " +
					 		"VALUES(EMP_SEQUENCE.nextval,?,?,?,?,?,?,to_date('"+goods.getOnTime()+"',"+"'yyyy-mm-dd hh24:mi:ss'),?)");

					sql.setString(1, goods.getCname());
					sql.setInt(2, goods.getCclass());
					sql.setFloat(3, goods.getCprice());
					sql.setFloat(4, goods.getCaprice());
					sql.setInt(5, goods.getCcount());
					sql.setInt(6, goods.getCscount());
				//	sql.setString(7, goods.getOnTime());
					sql.setString(7, goods.getCdep());
					
					if(sql.executeUpdate()==1){
						flag = true;
					}else{
						flag=false;
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
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
			
			
			public ArrayList<Goods> getGoodsList(String strWhere, String orderby, int pageSize, int pageIndex){
				//System.out.println("List函数");
				//第一步，初始化对象
			 	Connection con=null;
			   //连接数据库 
				con=UtilJDBC.getConnection();
				int  intPageSize=pageSize; //一页要显示的记录数
				int  intRowCount;          //记录总数
				int  intPageCount;         //总页数
				int  intPage=pageIndex;    //待显示页码
				int  i;
				ArrayList<Goods> goods = new ArrayList<Goods>();
				try {
					Statement stmt=con.createStatement(
							ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_READ_ONLY);
					String sql="select * from  T_WEBDEMO_COMMODITY";
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
						Goods Gd=new Goods();
						Gd.setCid(rs.getInt("CID"));
						Gd.setCname(rs.getString("CNAME"));
						Gd.setCprice(rs.getFloat("CPRICE"));
						Gd.setCaprice(rs.getFloat("CAPRICE"));
						Gd.setCcount(rs.getInt("CAMOUNT"));
						Gd.setCscount(rs.getInt("CLEAVENUM"));
						Gd.setOnTime(rs.getString("CSTARTIME"));
						Gd.setCdep(rs.getString("CDEPICT"));
						goods.add(Gd);			
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
				return goods;
			}
			
			
			
			/**
			 * 
			 * @param strWhere
			 * @return count   返回记录数
			 */
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
						sql="select * from T_WEBDEMO_COMMODITY where "+strWhere;
					}else{
						sql="select * from T_WEBDEMO_COMMODITY";
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
			
			
			public boolean deleteRecode(String strId){
				boolean flag=false;
				PreparedStatement sql=null; 
			    Connection con=null;
			    
			    con = UtilJDBC.getConnection();
			    try {
			    	System.out.println(strId);
					sql = con.prepareStatement("DELETE FROM T_WEBDEMO_COMMODITY WHERE CID IN ("+strId+")");
					 if(sql.executeUpdate()>0){
						 flag=true;
					 }
					 else{
						 flag=false;
					 }
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("删除出错");
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
			
			
			/**
			 * 得到选中的记录信息
			 * @author Watermelon_R（ljf）
			 * @param int cId
			 */
			
			public Goods getRecode(int cId){
				PreparedStatement sql=null; 
			    Connection con=null;
			    ResultSet rs=null;
			    Goods goodBean = new Goods();
			    try {
					
			    	con=UtilJDBC.getConnection();
			    	sql=con.prepareStatement("SELECT * FROM T_WEBDEMO_COMMODITY WHERE CID='"+cId+"'");
			    	rs=sql.executeQuery();
			    	if(rs.next()){
			    		goodBean.setCid(rs.getInt("CID"));
			    		goodBean.setCname(rs.getString("CNAME"));
			    		goodBean.setCclass(rs.getInt("CCID"));
			    		goodBean.setCprice(rs.getFloat("CPRICE"));
			    		goodBean.setCaprice(rs.getFloat("CAPRICE"));
			    		goodBean.setCcount(rs.getInt("CAMOUNT"));
			    		goodBean.setCscount(rs.getInt("CLEAVENUM"));
			    		goodBean.setCdep(rs.getString("CDEPICT"));
			    	}
			    	else{
			    		System.out.println("查询错误");
			    	}
			    } catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				}
			    return goodBean;
			}
			
			/**
			 * 更新记录
			 * @author Watermelon_R
			 * @param cId
			 */
			public boolean UpdateRecode(Goods goods,int cId){
				PreparedStatement sql=null; 
			    Connection con=null;
			    boolean flag=false;
			    try {
					
			    	con=UtilJDBC.getConnection();
			    	sql=con.prepareStatement("UPDATE T_WEBDEMO_COMMODITY SET CNAME=? ,CCID=? ,CPRICE=? ," +
			    			"CAPRICE=? ,CAMOUNT=? ,CLEAVENUM=? ,CDEPICT=? WHERE CID=?");
			    	sql.setString(1, goods.getCname());
			    	sql.setInt(2, goods.getCclass());
			    	sql.setFloat(3, goods.getCprice());
			    	sql.setFloat(4, goods.getCaprice());
			    	sql.setInt(5, goods.getCcount());
			    	sql.setInt(6, goods.getCscount());
			    	sql.setString(7, goods.getCdep());
			    	sql.setInt(8, cId);
			    	
			    	if(sql.executeUpdate()==1){
			    		flag=true;
			    	
			    	}
			    	else{
			    		flag=false;
			    		System.out.println("查询错误");
			    	}
			    } catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				}
			    return flag;
			}
			
			
}
