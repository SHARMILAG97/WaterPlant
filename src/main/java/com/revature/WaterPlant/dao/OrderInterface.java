package com.revature.WaterPlant.dao;

import java.util.List;

import com.revature.WaterPlant.exception.DBException;
import com.revature.WaterPlant.model.User;

public interface OrderInterface {

	void addOder(User user,int ordercans) throws DBException ;

	public List<User> viewOrder() throws DBException;
}
