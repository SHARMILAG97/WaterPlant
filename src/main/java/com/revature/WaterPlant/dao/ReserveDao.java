package com.revature.WaterPlant.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.WaterPlant.exception.DBException;
import com.revature.WaterPlant.model.Reserve;
import com.revature.WaterPlant.model.User;
import com.revature.WaterPlant.util.ConnectionUtil;

public class ReserveDao implements ReserveInterface {

	public void addReserve(User user, int Reservecans) throws DBException {
		Connection con = ConnectionUtil.getConnection();
		String sql = "insert into Reserve_Details(User_id,User_name,Mobile_no,Reserve_cans ) values ( ?,?,?,?)";

		PreparedStatement pst;
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, user.getId());
			pst.setString(2, user.getName());
			pst.setLong(3, user.getMobileno());
			pst.setInt(4, Reservecans);

			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to Reserve", e);
		}

	}

	public int getReserveId(User user) throws DBException {
		Connection con = ConnectionUtil.getConnection();
		String sql = "select * from Reserve_Details";

		PreparedStatement pst = null;
		int Rid = 0;
		try {
			pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Rid = rs.getInt("Reserve_id");
			}
		} catch (SQLException e) {

			e.printStackTrace();
			throw new DBException("Unable to Reserve", e);
		}

		finally {

			ConnectionUtil.close(con, pst);
		}

		return Rid;

	}

	public User findByReserveId(int Rid) throws DBException {

		Connection con = ConnectionUtil.getConnection();
		String sql = "select * from Reserve_Details where Reserve_id = ? ";
		PreparedStatement pst = null;
		User user = new User();
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, Rid);

			ResultSet rs = pst.executeQuery();

			if (rs.next()) {

				user.setRId(rs.getInt("Reserve_id"));
				user.setId(rs.getInt("User_id"));
				user.setName(rs.getString("User_name"));
				user.setMobileno(rs.getLong("Mobile_no"));
				user.setReservecan(rs.getInt("Reserve_cans"));

			}
		} catch (SQLException e) {

			e.printStackTrace();
			throw new DBException("Unable to Reserve", e);
		} finally {

			ConnectionUtil.close(con, pst);
		}

		return user;
	}

	public static void updateReserve(int ordercans, int Rid) throws DBException {

		Connection con = ConnectionUtil.getConnection();

		String sql = "update Reserve_Details set Status ='Ordered',Ordered_cans=? where Reserve_id = ? ";
		PreparedStatement pst = null;
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, ordercans);
			pst.setInt(2, Rid);

			pst.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
			throw new DBException("Unable to Reserve", e);
		}

		finally {

			ConnectionUtil.close(con, pst);
		}

	}

	public List<User> viewReserve() throws DBException {

		Connection con = ConnectionUtil.getConnection();
		String sql = "select * from Reserve_Details";
		PreparedStatement pst;
		ResultSet rs;
		List<User> list = new ArrayList<User>();
		try {
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setRId(rs.getInt("Reserve_id"));
				user.setId(rs.getInt("User_id"));
				user.setName(rs.getString("User_name"));
				user.setMobileno(rs.getLong("Mobile_no"));
				user.setRstatus(rs.getString("Status"));
				user.setReservecan(rs.getInt("Reserve_cans"));
				user.setOrdercan(rs.getInt("Ordered_cans"));
				Date date = rs.getDate("Date_time");
				user.setDate(date.toLocalDate());
				list.add(user);
			}
		} catch (SQLException e) {

			e.printStackTrace();
			throw new DBException("Unable to find", e);
		}

		return list;

	}
}
