package com.revature.WatrerPlant.Service;

import java.util.Scanner;

import com.revature.WaterPlant.model.User;

public class WaterPlant {

	public static boolean b=true;

	public static void main(String[] args) {

	
		boolean input = true;
		while (b) {
			System.out.println("************WELCOME TO WATERPLANT*************");
			System.out.println();
			System.out.print("1.Admin Login	||");
			System.out.print("2.Register OR Create Account	||	");
			System.out.println("3.User Login");
			System.out.println();

			while(input) {
			System.out.println("~~~~~~~~~~~~SELECT 1 FOR ADMIN~~~~~~~~~~~~~");
			System.out.println("~~~~~~~~~~~~SELECT 2 FOR New USER~~~~~~~~~~~");
			System.out.println("~~~~~~~~~~~~SELECT 3 FOR EXISTING USER~~~~~~~~~~~");
			System.out.println();
			System.out.println("Please Enter Your Option to Proceed");
			int choice = 0;
			Scanner sc = new Scanner(System.in);
			String S;
			
			boolean bl = true;
			while(bl) {
			try {
				S = sc.next();
				choice = Integer.parseInt(S);
				bl = false;
				break;
			} catch (Exception e) {
				System.out.println(".......Invalid Option.....\n\nPlease Enter an Integer value");
				bl = true;
			}
			}
			
			if (choice == 1)
				LoginAdmin.Login();

			else if (choice == 2) {
				UserRegister.RegisterUser();
				LoginUser.userLogin();
			}

			else if (choice == 3) {
				LoginUser.userLogin();

			}

			else {
				System.out.println(".......Invalid Option.....\n\nPlease enter a valid option");
				System.out.println("\nRe enter your option correctly");
			}
			input = true;
			}
				b = true;
			}
		}

	}

