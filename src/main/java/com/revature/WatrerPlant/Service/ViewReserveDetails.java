package com.revature.WatrerPlant.Service;

import java.util.List;

import com.revature.WaterPlant.dao.OrderDao;
import com.revature.WaterPlant.dao.OrderInterface;
import com.revature.WaterPlant.dao.ReserveDao;
import com.revature.WaterPlant.dao.ReserveInterface;
import com.revature.WaterPlant.exception.DBException;
import com.revature.WaterPlant.model.User;

public class ViewReserveDetails {
	
	public static void showReserveDetails() {

		try {
			ReserveInterface Rdao = new ReserveDao();
			List<User> list = Rdao.viewReserve();
			for (User user : list) {
				System.out.println("\nReserve Id: " + user.getRId());
				System.out.println("\nUser Id: " + user.getId());
				System.out.println("\nUser Name: " + user.getName());
				System.out.println("\nUser MobileNo: " + user.getMobileno());
				System.out.println("\nReserved cans: " + user.getReservecan());
				System.out.println("\nOrdered cans: " + user.getOrdercan());
				System.out.println("\nStatus: " + user.getRstatus());
				System.out.println("\nDate: "+user.getDate());
				System.out.println("****************");
			}
		} catch (DBException e) {
			e.printStackTrace();
		}

	}

}
