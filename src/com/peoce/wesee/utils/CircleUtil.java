package com.peoce.wesee.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.peoce.wesee.constant.Const;

public class CircleUtil {
	public static CircleUtil instance;
	public static Connection conn;
	public static Statement statement;

	private CircleUtil() {
		conn = DbUtil.openDb();
		try {
			statement = conn.createStatement();
		} catch (SQLException e) {
			System.out.println("SQL EXCEPTION");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static CircleUtil GetInstance() {
		if (null == instance) {
			instance = new CircleUtil();
		}
		return instance;
	}

	public int[] getFriendList(int id) {
		String sql = "SELECT " + Const.user_relation.USER_RELATION_FRIENDID
				+ " FROM " + Const.user_relation.TABLE_NAME_USER_RELATION
				+ " WHERE " + Const.user_relation.USER_RELATION_ID + " = " + id;
		return friendList(statement, sql);
	}

	private int[] friendList(Statement state, String sql) {
		ArrayList<Integer> friend_list = new ArrayList<Integer>();
		try {
			ResultSet rs = state.executeQuery(sql);
			while (rs.next()) {
				friend_list.add(rs
						.getInt(Const.user_relation.USER_RELATION_FRIENDID));
			}
			rs.close();
          int [] friend_array=new int[friend_list.size()];
          int count=0;
          for(int i:friend_list){
        	  friend_array[count++]=i;
          }
          return friend_array;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
