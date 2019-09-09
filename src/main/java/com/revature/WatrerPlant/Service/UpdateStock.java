package com.revature.WatrerPlant.Service;

import java.util.Scanner;

import com.revature.WaterPlant.dao.StockDao;
import com.revature.WaterPlant.dao.StockInterface;
import com.revature.WaterPlant.exception.DBException;

public class UpdateStock {
	
 

	public static void StockUpdate() {
		 int Availcans = 0;
		 Availcans=ViewStock.stockView();
		System.out.println("No of Cans Available :"+Availcans);
		System.out.println("Enter No of cans to update stock");
		Scanner sc = new Scanner(System.in);
		int Newcans = sc.nextInt();
		int Addcans=0;
		
		try {
			StockInterface Sdao = new StockDao();
			
			Addcans = Availcans+Newcans;
			 Sdao.updateStock(Addcans);
			System.out.println("Stock Updated Succesfully");
			Addcans = Sdao.findOne();
			Sdao.addStock(Newcans,Addcans);
			System.out.println("No of Cans Available after Stock Update :"+Addcans);
		} catch (DBException e) {
			
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
