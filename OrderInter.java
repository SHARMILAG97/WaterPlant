package com.revature.WaterPlant.dao;

import com.revature.WaterPlant.exception.DBException;
import com.revature.WaterPlant.model.User;

public interface OrderInter {
	void addOder(User user,int ordercans) throws DBException;

}
