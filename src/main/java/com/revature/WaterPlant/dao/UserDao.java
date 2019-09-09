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



public class UserDao implements UserInterface {
	
	
public boolean findByNameAndPassword(String Uname,String Pwd) throws DBException  {
        
        Connection con = ConnectionUtil.getConnection();
        String sql = "select * from AdminLogin where Name = ? and Pwd = ?";
        PreparedStatement pst;
        boolean isValid = false;
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1,Uname);
	        pst.setString(2, Pwd);
	        ResultSet rs = pst.executeQuery();
	       
	     
	           if(rs.next()){
	               isValid=true;
	           }
	           else
	           {
	               isValid = false;
	           }
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Cannot find",e);
		}
        
           return isValid;
    }

public  boolean findByUNameAndPassword(long mobileno,String Pwd) throws DBException  {
    
    Connection con = ConnectionUtil.getConnection();
    String sql = "select * from User_Details where Mobile_no = ? and Pwd = ?";
    PreparedStatement pst;
    boolean isValid = false;
	try {
		pst = con.prepareStatement(sql);
		pst.setLong(1,mobileno);
	    pst.setString(2, Pwd);
	    ResultSet rs = pst.executeQuery();
	   
	   
	       if(rs.next()){
	           isValid=true;
	       }
	       else
	       {
	           isValid = false;
	       }
	} catch (SQLException e) {
		e.printStackTrace();
		throw new DBException("Cannot find",e);
	}
    
       return isValid;
       	   
       }

public  User getUser(long mobileno, String Pwd) throws DBException  {
	
	Connection con = ConnectionUtil.getConnection();
    String sql = "select * from User_Details where Mobile_no = ? and Pwd = ?";
    PreparedStatement pst;
    User user = new User();
	try {
		pst = con.prepareStatement(sql);
		 pst.setLong(1,mobileno);
		    pst.setString(2, Pwd);
		    ResultSet rs = pst.executeQuery();
			
		    if(rs.next()) {
		    	user.setId(rs.getInt("User_id"));
		    	user.setName(rs.getString("User_name"));
		    	user.setAddress(rs.getString("Address"));
		    	user.setMobileno(rs.getLong("Mobile_no"));
		    	user.setPwd(rs.getString("Pwd"));
		    		
	}} catch (SQLException e) {
		
		e.printStackTrace();
		throw new DBException("Error",e);
	}
   
    
   
   return user;
	
}


public void AddUser(String name, String pwd, long mobileno, String address) throws DBException  {
	

	 Connection con = ConnectionUtil.getConnection();
	 String sql = "insert into User_Details(User_name,Pwd,Mobile_no, Address) values(?,?,?,?) ";
	 PreparedStatement pst;
	try {
		pst = con.prepareStatement(sql);
		pst.setString(1,name);
		 pst.setString(2,pwd);
		 pst.setLong(3, mobileno);
		 pst.setString(4, address);
		 pst.executeUpdate();
	} catch (SQLException e) {
		
		e.printStackTrace();
		throw new DBException("Unable to adduser",e);
	}
     
} 
	 
public  List<User> viewUser() throws DBException{
	

	 Connection con = ConnectionUtil.getConnection();
       String sql = "select * from User_Details";
       PreparedStatement pst;
      ResultSet rs;
      List<User> list=new ArrayList<User>();
	try {	
		pst = con.prepareStatement(sql);
		rs = pst.executeQuery();
		while(rs.next()) {
			User user = new User();
			user.setId(rs.getInt("User_id"));
			user.setName(rs.getString("User_name"));
			user.setMobileno(rs.getLong("Mobile_no"));
			user.setAddress(rs.getString("Address"));
			user.setStatus(rs.getString("Status"));
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




