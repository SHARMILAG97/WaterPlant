package com.revature.WatrerPlant.Service;

import java.util.Scanner;

import com.revature.WaterPlant.dao.OrderDao;
import com.revature.WaterPlant.dao.OrderInterface;
import com.revature.WaterPlant.dao.StockDao;
import com.revature.WaterPlant.dao.StockInterface;
import com.revature.WaterPlant.exception.DBException;
import com.revature.WaterPlant.model.User;

public class OrderCans {

	public static void cansOrder(User u)     {
		
		User user = u;
		int Availcans=ViewStock.stockView();
		
		System.out.println("No of Avilable Cans :"+Availcans);
		System.out.println("Enter No of cans to Order");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int Ordercans= sc.nextInt();
		
		
		while(Availcans<Ordercans && Ordercans<50) {
			System.out.println("Insufficient Watercans");
			System.out.println("Please enter cans below :"+Availcans+"or below 50");
		}
		
		int Updatecans= Availcans-Ordercans;
		
		try {
			OrderInterface dao = new OrderDao();
			dao.addOder(user,Ordercans);
			System.out.println("Ordered Successfully");
			StockInterface Sdao = new StockDao();
			Sdao.addStockOrder(Ordercans,Updatecans);
			Sdao.updateStock(Updatecans);
			System.out.println("Updated in stock Successfully");
			
		} catch (DBException e) {
			e.printStackTrace();
		}
		
		
		
		
	}

	

	

}
