package com.revature.WatrerPlant.Service;

import java.util.List;

import com.revature.WaterPlant.dao.OrderDao;
import com.revature.WaterPlant.dao.OrderInterface;
import com.revature.WaterPlant.exception.DBException;
import com.revature.WaterPlant.model.User;

public class ViewOrderDetails {

	public static void showOrderDetails() {

		try {
			OrderInterface Odao = new OrderDao();
			List<User> list = Odao.viewOrder();
			for (User user : list) {
				System.out.println("\nOrder Id: " + user.getOId());
				System.out.println("\nReserve Id: " + user.getRId());
				System.out.println("\nUser Id: " + user.getId());
				System.out.println("\nUser Name: " + user.getName());
				System.out.println("\nUser MobileNo: " + user.getMobileno());
				System.out.println("\nUser Address: " + user.getAddress());
				System.out.println("\nOrdered cans: " + user.getOrdercan());
				System.out.println("\nDate: "+user.getDate());
				System.out.println("****************");
			}
		} catch (DBException e) {
			e.printStackTrace();
		}

	}
}
