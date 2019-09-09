package com.revature.WaterCan.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.revature.WaterPlant.dao.UserDao;
import com.revature.WaterPlant.dao.UserInterface;
import com.revature.WaterPlant.exception.DBException;
import com.revature.WaterPlant.model.User;


public class UserDaoTest {
	@Test
	public void testValidLogin() {
	
		UserInterface Udao = new UserDao();

		String name = "Naresh";
		String pwd = "naresh";
		try {
			Udao.findByNameAndPassword(name, pwd);
		} catch (DBException e) {
			e.printStackTrace();
		}
		
		assertNotNull(Udao);
	}
	
/*	@Test
	public void testInValidLogin() {
	
		UserInterface Udao = new UserDao();

		String name = null;
		String pwd = null;
		try {
			Udao.findByNameAndPassword(name, pwd);
		} catch (DBException e) {
			e.printStackTrace();
		}
		
		assertNull(Udao);
	}*/
 

	
}
