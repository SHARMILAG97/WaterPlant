package com.revature.WatrerPlant.Service;

import java.util.Scanner;

import com.revature.WaterPlant.Validator.UserValidator;
import com.revature.WaterPlant.dao.UserDao;
import com.revature.WaterPlant.dao.UserInterface;
import com.revature.WaterPlant.exception.DBException;
import com.revature.WaterPlant.exception.ValidatorException;
import com.revature.WaterPlant.model.User;

public class UserRegister {
	
	public static void RegisterUser() {
		
		System.out.println("Enter User Credentials for Register");
		System.out.println();
		
		User user = new User();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter UserName");
		user.getName();
		String name = sc.next();
		user.setName(name);

		System.out.println("Enter User Pasword");
		user.getPwd();
		String pwd = sc.next();
		user.setPwd(pwd);

		System.out.println("Enter User MobileNo");
		long mobileno=0;
		boolean b=true;
		String S =null;
		while(b=true) {
		try {
			user.getMobileno();
			// mobileno = sc.nextLong();
			boolean bl = true;
			while(bl) {
			try {
				S = sc.next();
				mobileno =Long.parseLong(S);
				bl = false;
				break;
			} catch (Exception e) {
				System.out.println(".......Invalid Value.....\n\nPlease Enter an Valid Mobile Number");
				bl = true;
			}
			}
			
			UserValidator.validateMobileNo(mobileno);
			user.setMobileno(mobileno);
			b=false;
			break;
		} catch (ValidatorException e1) {
			System.out.println("Please enter a Valid Mobile Number");
			b=true;
		}}

		System.out.println("Enter User Address");
		user.getAddress();	
		String address = sc.next();
		user.setAddress(address);
		
		UserInterface Udao = new UserDao();
		try {
			Udao.AddUser(name,pwd,mobileno,address);
		} catch (DBException e) {
			e.printStackTrace();
		}
		System.out.println("Registration completed Successfully");
		
	}

}
