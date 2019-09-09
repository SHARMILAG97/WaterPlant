package com.revature.WatrerPlant.Service;

import java.util.Scanner;

import com.revature.WaterPlant.Validator.UserValidator;
import com.revature.WaterPlant.dao.UserDao;
import com.revature.WaterPlant.dao.UserInterface;
import com.revature.WaterPlant.exception.DBException;
import com.revature.WaterPlant.model.User;

public class LoginUser {

	public static User userLogin() {
		int choice = 0;
		User user = null;
		System.out.println("Please Enter Credentials for Login");
		System.out.println();
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Mobile no");
		//long mobileno = sc.nextLong();
		
		String S;
		Long mobileno = null; 
		boolean bl = true;
		while(bl) {
		try {
			S = sc.next();
			 mobileno = Long.parseLong(S);
			UserValidator.validateMobileNo(mobileno);
			bl = false;
			break;
		} catch (Exception e) {
			System.out.println(".......Invalid Mobile Number.....\n\nPlease Enter an Valid Mobile Number");
			bl = true;
		}
		}
		System.out.println("Enter Password");
		String Pwd = sc.next();

		try {
			UserInterface Udao = new UserDao();
			boolean bl1 = Udao.findByUNameAndPassword(mobileno, Pwd);

			if (bl1 == true) {

				user = Udao.getUser(mobileno, Pwd);
				int Uid = user.getId();
				String name = user.getName();
				System.out.println("Welcome " + name);
				System.out.println("Your User id is :" + Uid);
				do {

					System.out.println();

					System.out.println("~~~~~~~~~~SELECT AN ACTION TO PERFORM~~~~~~~~~~~~~");
					System.out.println();

					System.out.print("1.Order Cans	||	");
					System.out.print("2.Reserve Cans	||	");
					System.out.print("3.Order Reserved Cans 	||");
					System.out.println("0. Quit");
					System.out.println();
					System.out.println("If you want to continue, then enter your choice");

				
					Scanner sc1 = new Scanner(System.in);

					String S1 = null;
					boolean bl11 = true;
					while (bl11) {
						try {
							S1 = sc.next();
							choice = Integer.parseInt(S1);
							bl11 = false;
							break;
						} catch (Exception e) {
							System.out.println(".......Invalid Option.....\n\nPlease Enter an Integer value");
							bl11 = true;
						}
					}

					switch (choice) {

					case 1:

						OrderCans.cansOrder(user);

						break;

					case 2:

						ReserveCans.cansReserve(user);

						break;

					case 3:

						OrderReserve.ReserveOrder(user);
						break;

					case 0:
						System.out.println("((((((((((((((((((((THANK YOU))))))))))))))))))))");
						WaterPlant.b = true;
						break;

					default:
						System.out.println(".......Invalid Option.....");

					}

				} while (choice != 0);

			}

			else
				System.out.println("Invaid Name or Password");
		} catch (DBException e) {

			e.printStackTrace();
		}

		return user;

	}
		
}
