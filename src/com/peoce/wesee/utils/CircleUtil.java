package com.peoce.wesee.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.peoce.wesee.constant.Const;
import com.peoce.wesee.model.Pic;

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
			int[] friend_array = new int[friend_list.size()];
			int count = 0;
			for (int i : friend_list) {
				friend_array[count++] = i;
			}
			return friend_array;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<Pic> getFridenShare(int id) {
		String sql = "SELECT u." + Const.users.USERS_NICKNAME + ",u_f.* FROM "
				+ Const.users.TABLE_NAME_USERS + " AS u RIGHT JOIN ("
				+ "SELECT p.* FROM " + Const.pic.TABLE_NAME_PIC + " p WHERE p."
				+ Const.pic.PIC_CREATEBY + " IN (SELECT u_p."
				+ Const.user_pic.USER_PIC_ID + " FROM "
				+ Const.user_pic.TABLE_NAME_USER_PIC + " u_p WHERE u_p."
				+ Const.user_pic.USER_PIC_ID + " IN (SELECT u_r."
				+ Const.user_relation.USER_RELATION_FRIENDID + " FROM "
				+ Const.user_relation.TABLE_NAME_USER_RELATION
				+ " u_r WHERE u_r." + Const.user_relation.USER_RELATION_ID
				+ "=" + id + " AND u_r."+ Const.user_relation.USER_RELATION_ISBLOCK
				+ " <> 1))) AS u_f ON u_f." + Const.pic.PIC_CREATEBY + " = u."
				+ Const.users.USERS_ID + " ORDER BY u_f."
				+ Const.pic.PIC_CREATETIME + " DESC";
		return friendShare(statement, sql);
	}

	private ArrayList<Pic> friendShare(Statement state, String sql) {
		ArrayList<Pic> pic_list = new ArrayList<Pic>();
		try {
			ResultSet rs = state.executeQuery(sql);
			while (rs.next()) {
				String photoid = rs.getString(Const.pic.PIC_PHOTOID);
				String descript = rs.getString(Const.pic.PIC_PHOTODESC);
				String url = rs.getString(Const.pic.PIC_PHOTOURL);
				int upcount = rs.getInt(Const.pic.PIC_UPCOUNT);
				int createby = rs.getInt(Const.pic.PIC_CREATEBY);
				String createtime = rs.getString(Const.pic.PIC_CREATETIME);
				String tag = rs.getString(Const.pic.PIC_TAG);
				String nickname = rs.getString(Const.users.USERS_NICKNAME);
				pic_list.add(new Pic(photoid, descript, url, upcount, createby,
						createtime, tag, nickname));
			}
			rs.close();
			return pic_list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
