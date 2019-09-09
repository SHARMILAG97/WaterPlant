package com.revature.WaterPlant.dao;

import java.util.List;

import com.revature.WaterPlant.exception.DBException;
import com.revature.WaterPlant.model.User;

public interface ReserveInterface {
	 void addReserve(User user,int Reservecans) throws DBException ;
	 int getReserveId(User user) throws DBException;
	 User findByReserveId(int Rid) throws DBException;
	List<User> viewReserve() throws DBException;

}
