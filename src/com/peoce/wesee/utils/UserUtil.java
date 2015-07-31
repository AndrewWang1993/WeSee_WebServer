package com.peoce.wesee.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.peoce.wesee.constant.Const;
import com.peoce.wesee.model.User;

public class UserUtil {

	public static UserUtil instance;
	public static Connection conn;
	public static Statement statement;

	public UserUtil() {
		conn = DbUtil.openDb();
		try {
			statement = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static UserUtil getInstance() {
		if (null == instance) {
				instance = new UserUtil();
		}
		return instance;
	}

	public User loginWithPhone(String phone, String passWord) {
		passWord = EncryUtil.getHash(passWord);
		String sql = "SELECT * FROM " + Const.users.TABLE_NAME_USERS
				+ " WHERE " + Const.users.USERS_PHONENUMBER + " = '" + phone
				+ "' AND " + Const.users.USERS_PASSWORD + " = '" + passWord
				+ "'";
		return getInfo(statement, sql);
	}

	public User loginWithNick(String nickName, String passWord) {
		passWord = EncryUtil.getHash(passWord);
		String sql = "SELECT * FROM " + Const.users.TABLE_NAME_USERS
				+ " WHERE " + Const.users.USERS_NICKNAME + " = '" + nickName
				+ "' AND " + Const.users.USERS_PASSWORD + " = '" + passWord
				+ "'";
		return getInfo(statement, sql);
	}

	public User loginWithId(int id, String passWord) {
		passWord = EncryUtil.getHash(passWord);
		String sql = "SELECT * FROM " + Const.users.TABLE_NAME_USERS
				+ " WHERE " + Const.users.USERS_ID + " = " + id + " AND "
				+ Const.users.USERS_PASSWORD + " = '" + passWord + "'";
		return getInfo(statement, sql);
	}

	private User getInfo(Statement state, String sql) {
		try {
			ResultSet rs = state.executeQuery(sql);
			if (rs.next()) {
				int id = rs.getInt(Const.users.USERS_ID);
				String phoneNumber = rs
						.getString(Const.users.USERS_PHONENUMBER);
				String gender = rs.getString(Const.users.USERS_GENDER);
				String nickName = rs.getString(Const.users.USERS_NICKNAME);
				String city = rs.getString(Const.users.USERS_CITY);
				String email = rs.getString(Const.users.USERS_EMAIL);
				String photoUrl = rs.getString(Const.users.USERS_PHOTO_URL);
				String signTime = rs.getString(Const.users.USERS_SIGNTIME);
				rs.close();
				return new User(id, phoneNumber, "", gender, nickName, city,
						email, photoUrl, signTime);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
