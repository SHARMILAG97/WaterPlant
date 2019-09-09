package com.revature.WatrerPlant.Service;

import java.util.Scanner;

import com.revature.WaterPlant.dao.OrderDao;
import com.revature.WaterPlant.dao.ReserveDao;
import com.revature.WaterPlant.dao.ReserveInterface;
import com.revature.WaterPlant.dao.StockDao;
import com.revature.WaterPlant.dao.StockInterface;
import com.revature.WaterPlant.exception.DBException;
import com.revature.WaterPlant.model.User;

public class OrderReserve {

	public static void ReserveOrder(User u)  {
		
		System.out.println("Enter Reserve id");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int Rid = sc.nextInt();
		boolean b = true;
		User u1;
		try {
			ReserveInterface dao = new ReserveDao();
			u1 = dao.findByReserveId(Rid);
			while(u1==null)
			{
				System.out.println("Invalid Reserve Id");
			}
			while(b)
				{
				int reservecan=u.getReservecan();
				System.out.println("Your Reserved Cans: "+reservecan);
			System.out.println("Enter No of Cans to Order");
			int ordercan = sc.nextInt();
			
			if(ordercan <= reservecan) {
				
				ReserveDao.updateReserve(ordercan, Rid);
				OrderDao.updateOrder(u,ordercan, Rid);
				StockInterface Sdao = new StockDao();
				int updatecan=Sdao.findOne();
				int addcan=reservecan-ordercan;
				updatecan+=addcan;
				Sdao.updateStock(updatecan);
				System.out.println("Ordered the Reserved Cans Sucessfully");
				b= false;
			}
			else
			{
				System.out.println("Enter cans below :"+reservecan);
			}
				}
			
			
			
		
		} catch (DBException e) {
			
			e.printStackTrace();
		}
		

	}}
