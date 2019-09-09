package com.revature.WatrerPlant.Service;

import java.util.Scanner;

import com.revature.WaterPlant.dao.UserDao;
import com.revature.WaterPlant.dao.UserInterface;
import com.revature.WaterPlant.exception.DBException;
import com.revature.WaterPlant.exception.InputMismatchException;

public class LoginAdmin {

	public static void Login() {

		System.out.println("Please enter credentials for login");
		System.out.println();
		Scanner sc = new Scanner(System.in);

		boolean b = true;
		boolean bl = false;
		while (b) {
			System.out.println("Enter Name");
			String Name = sc.next();

			System.out.println("Enter Password");
			String Pwd = sc.next();

			try {
				UserInterface Udao = new UserDao();
				bl = Udao.findByNameAndPassword(Name, Pwd);

			} catch (DBException e) {

				e.printStackTrace();
			}
			if (bl == true) {
				System.out.println("Welcome Admin");
				break;
			} else if (b != bl) {
				System.out.println("Invaid Name or Password");
				b = true;

			}
		}
		int choice = 0;
		do {

			System.out.println();
			System.out.println("~~~~~~~~~~SELECT AN ACTION TO PERFORM~~~~~~~~~~~~~");
			System.out.println();
			System.out.print("1.Update Stock	||	");
			System.out.print("2.View Stock Details	||	");
			System.out.println("3.View List of Users	||	");
			System.out.print("4.View Order Details	||	");
			System.out.print("5.View Reserve Details	||	");
			System.out.println("0. Quit");
			System.out.println();
			System.out.println("If you want to continue, then enter your choice");
			Scanner sc1 = new Scanner(System.in);

			String S = null;
			boolean bl1 = true;
			while(bl1) {
			try {
				S = sc.next();
				choice = Integer.parseInt(S);
				bl1 = false;
				break;
			} catch (Exception e) {
				System.out.println(".......Invalid Option.....\n\nPlease Enter an Integer value");
				bl1 = true;
			}
			}

			switch (choice) {

			case 1:

				UpdateStock.StockUpdate();

				break;

			case 2:

				ViewStock.showStock();

				break;

			case 3:

				ListUsers.showUser();
				break;

			case 4:

				ViewOrderDetails.showOrderDetails();
				break;

			case 5:

				ViewReserveDetails.showReserveDetails();
				break;

			case 0:
				System.out.println("((((((((((((((((((((THANK YOU))))))))))))))))))))");
				WaterPlant.b = true;
				break;

			default:
				System.out.println(".......Invalid Option.....");
				b = false;
				break;
			}

		} while (choice != 0);

	}
}