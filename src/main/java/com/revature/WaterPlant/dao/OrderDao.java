package com.revature.WaterPlant.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.WaterPlant.exception.DBException;
import com.revature.WaterPlant.model.User;
import com.revature.WaterPlant.util.ConnectionUtil;

public class OrderDao implements OrderInterface{
	public  void addOder(User user,int ordercans) throws DBException   {
		Connection con = ConnectionUtil.getConnection();
		String sql = "insert into Order_Details(User_id,User_name,Mobile_no,Address,Order_cans ) values ( ?,?,?,?,?)";
		
		PreparedStatement pst = null;
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1,user.getId());
			pst.setString(2,user.getName());
			pst.setLong(3, user.getMobileno());
			pst.setString(4,user.getAddress());
			pst.setInt(5, ordercans);
			
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to Reserve",e);
		}
		finally {
			 
			 ConnectionUtil.close(con, pst);
		 }

		
		
	}

	public static void updateOrder(User u,int ordercan, int rid) throws DBException  {
	
		 Connection con = ConnectionUtil.getConnection();
		 
		 String sql = "insert into Order_Details(User_id,Reserve_id,User_name,Mobile_no,Address,Order_cans ) values ( ?,?,?,?,?,?)  ";
		 PreparedStatement pst = null;
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1,u.getId());
		    pst.setInt(2,rid);
			pst.setString(3,u.getName());
			pst.setLong(4, u.getMobileno());
			pst.setString(5,u.getAddress());
			pst.setInt(6, ordercan);
		   
		    pst.executeUpdate();	
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new DBException("Unable to Reserve",e);
		}
		   
		 finally {
			 
			 ConnectionUtil.close(con, pst);
		 }

			
		
	}

	public List<User> viewOrder() throws DBException {
		 Connection con = ConnectionUtil.getConnection();
	       String sql = "select * from Order_Details";
	       PreparedStatement pst;
	      ResultSet rs;
	      List<User> list=new ArrayList<User>();
		try {	
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()) {
				User user = new User();
				user.setOId(rs.getInt("Order_id"));
				user.setRId(rs.getInt("Reserve_id"));
				user.setId(rs.getInt("User_id"));
				user.setName(rs.getString("User_name"));
				user.setMobileno(rs.getLong("Mobile_no"));
				user.setAddress(rs.getString("Address"));
				user.setOrdercan(rs.getInt("Order_cans"));
				Date date=rs.getDate("Date_time");
				user.setDate(date.toLocalDate());
				list.add(user);
			}
		}
			catch (SQLException e) {
				
				e.printStackTrace();
				throw new DBException("Unable to find",e);
			}
		
		return list;
	}
		
		
	}



