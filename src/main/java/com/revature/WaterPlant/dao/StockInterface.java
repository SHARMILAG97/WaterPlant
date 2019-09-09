package com.revature.WaterPlant.dao;

import java.sql.ResultSet;
import java.util.List;

import com.revature.WaterPlant.exception.DBException;
import com.revature.WaterPlant.model.User;

public interface StockInterface {
	ResultSet findStock() throws DBException;
	int findOne() throws DBException;
	 void updateStock(int updatecans) throws DBException;
	 List<User> viewStock() throws DBException;
	void addStock(int newcans,int updatecans) throws DBException;
	void addStockOrder(int ordercans, int updatecans) throws DBException;
	void addStockReserve(int reservecans,int updatecans) throws DBException;

}
