package com.revature.WatrerPlant.Service;

import java.util.List;

import com.revature.WaterPlant.dao.UserDao;
import com.revature.WaterPlant.dao.UserInterface;
import com.revature.WaterPlant.exception.DBException;
import com.revature.WaterPlant.model.User;

public class ListUsers {

public static void showUser() {
		
		try {
			UserInterface Udao = new UserDao();
			List <User> list = Udao.viewUser();
			for(User user : list)
			{
			System.out.println("\nUser Id: "+user.getId());
			System.out.println("\nUser Name: "+user.getName());
			System.out.println("\nUser MobileNo: "+user.getMobileno());
			System.out.println("\nUser Address: "+user.getAddress());
			System.out.println("\nStatus: "+user.getStatus());
			System.out.println("****************");
			}
		} catch (DBException e) {
			e.printStackTrace();
		}
		
		
}}
