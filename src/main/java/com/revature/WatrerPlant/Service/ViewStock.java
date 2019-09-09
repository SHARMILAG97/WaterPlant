package com.revature.WatrerPlant.Service;

import java.util.List;
import com.revature.WaterPlant.dao.StockDao;
import com.revature.WaterPlant.dao.StockInterface;
import com.revature.WaterPlant.exception.DBException;
import com.revature.WaterPlant.model.User;

public class ViewStock {
	
	
	public static int stockView() {
	int Availcans = 0;
	
	try {
		StockInterface Sdao = new StockDao();
		Availcans = Sdao.findOne();
	} catch (DBException e) {
		
		e.printStackTrace();
	}
	
	
return Availcans;
}
	
	public static void showStock() {
		
		try {
			StockInterface Sdao = new StockDao();
			List <User> list = Sdao.viewStock();
			for(User user : list)
			{
			System.out.println("\nDate:"+user.getDate());
			System.out.println("\nUpdated cans:"+user.getAddcan());
			System.out.println("\nOrdered cans:"+user.getOrdercan());
			System.out.println("\nReserved cans:"+user.getReservecan());
			System.out.println("\nTotal cans:"+user.getCans());
			System.out.println("****************");
			}
		} catch (DBException e) {
			e.printStackTrace();
		}
		
		
		
}}
