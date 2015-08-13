package com.peoce.wesee.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import sun.org.mozilla.javascript.internal.ast.ForInLoop;

import com.peoce.wesee.constant.Const;
import com.peoce.wesee.model.User;

public class UserUtil {

	public static UserUtil instance;
	public static Connection conn;
	public static Statement statement;

	private UserUtil() {
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

	public User checkIdDupli(int id) {
		String sql = "SELECT * FROM " + Const.users.TABLE_NAME_USERS
				+ " WHERE " + Const.users.USERS_ID + " = " + id;
		return getInfo(statement, sql);
	}

	public String getPassWord(int id) {
		String sql = "SELECT " + Const.users.USERS_PASSWORD + " FROM "
				+ Const.users.TABLE_NAME_USERS + " WHERE "
				+ Const.users.USERS_ID + " = " + id;
		return getField(statement, sql, Const.users.USERS_PASSWORD)[0];
	}

	private String[] getField(Statement state, String sql, String... field) {
		try {
			ResultSet rs = state.executeQuery(sql);
			int fieldCount = field.length;
			String[] fieldValue = new String[fieldCount];
			if (rs.next()) {
				for (int i = 0; i < fieldCount; i++) {
					fieldValue[i] = rs.getString(field[i]);
				}
				rs.close();
				return fieldValue;
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
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

	public int regedit(int id, String phoneNumber, String passWord) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String regeditDate = df.format(new Date());
		String sql = "INSERT INTO " + Const.users.TABLE_NAME_USERS + " ( "
				+ Const.users.USERS_ID + " , " + Const.users.USERS_PHONENUMBER
				+ " , " + Const.users.USERS_PASSWORD + " , "
				+ Const.users.USERS_SIGNTIME + " ) VALUES ( " + id + " , '"
				+ phoneNumber + "','" + passWord + "' , '" + regeditDate + "')";
		try {
			int feekCode = statement.executeUpdate(sql);
			if (feekCode > 0) {
				return Const.sqlresponse.SQL_OK;
			} else {
				return Const.sqlresponse.SQL_FAIL;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Const.error_code.UNKNOW_ERROR;
	}
}
