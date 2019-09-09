package com.revature.WatrerPlant.Service;

import java.util.Scanner;

import com.revature.WaterPlant.dao.ReserveDao;
import com.revature.WaterPlant.dao.ReserveInterface;
import com.revature.WaterPlant.dao.StockDao;
import com.revature.WaterPlant.dao.StockInterface;
import com.revature.WaterPlant.exception.DBException;
import com.revature.WaterPlant.model.User;

public class ReserveCans {

	public static void cansReserve(User u)    {
		
		User user = u;
		int Availcans=ViewStock.stockView();
		
		System.out.println("No of Avilable Cans :"+Availcans);
		System.out.println("Enter No of cans to Reserve");
		Scanner sc = new Scanner(System.in);
		int Reservecans= sc.nextInt();
		
		
		while(Availcans<Reservecans && Reservecans<50) {
			System.out.println("Insufficient Watercans");
			System.out.println("Please enter cans below :"+Availcans+"or below 50");
		}
		
		int Updatecans= Availcans-Reservecans;
		
		try {
			ReserveInterface dao = new ReserveDao();
			dao.addReserve(user,Reservecans);
			System.out.println("Reserved Successfully");
			StockInterface Sdao = new StockDao();
			Sdao.addStockReserve(Reservecans,Updatecans);
			Sdao.updateStock(Updatecans);
			System.out.println("Updated in stock Successfully");
			System.out.println("Available cans After Reservation:"+Updatecans);
			
			int Rid=dao.getReserveId(user);
			System.out.println("Your Reserve id :"+Rid);
			
		} catch (DBException e) {
			e.printStackTrace();
		}
		
	}

}
