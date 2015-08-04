package com.peoce.wesee.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.peoce.wesee.constant.Const;
import com.peoce.wesee.model.Pic;

public class ContentUtil {
	private static ArrayList<Pic> list_pic;
	public static ContentUtil instance;
	public static Connection conn;
	public static Statement statement;

	private ContentUtil() {
		conn = DbUtil.openDb();
		try {
			statement = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static ContentUtil getInstance() {
		if (null == instance) {
			instance = new ContentUtil();
		}
		list_pic = new ArrayList<Pic>();
		return instance;
	}

	public ArrayList<Pic> getWhatNew(int limitStart, int limitOff) {
		String sql = "SELECT * FROM " + Const.pic.TABLE_NAME_PIC + " ORDER BY "
				+ Const.pic.PIC_CREATETIME + " DESC LIMIT " + limitStart
				+ " , " + (limitOff - limitStart);
		return getInfo(statement, sql);
	}

	public ArrayList<Pic> getWhatNew() {
		String sql = "SELECT * FROM " + Const.pic.TABLE_NAME_PIC + " ORDER BY "
				+ Const.pic.PIC_CREATETIME + " DESC";
		return getInfo(statement, sql);
	}

	public ArrayList<Pic> getWhatHot(int limitStart, int limitOff) {
		String sql = "SELECT * FROM " + Const.pic.TABLE_NAME_PIC + " ORDER BY "
				+ Const.pic.PIC_UPCOUNT + " DESC LIMIT " + limitStart + " , "
				+ (limitOff - limitStart);
		return getInfo(statement, sql);
	}

	public ArrayList<Pic> getWhatHot() {
		String sql = "SELECT * FROM " + Const.pic.TABLE_NAME_PIC + " ORDER BY "
				+ Const.pic.PIC_UPCOUNT + " DESC";
		return getInfo(statement, sql);
	}

	private ArrayList<Pic> getInfo(Statement state, String sql) {
		try {
			ResultSet rs = state.executeQuery(sql);
			while (rs.next()) {
				String photoid = rs.getString(Const.pic.PIC_PHOTOID);
				String photourl = rs.getString(Const.pic.PIC_PHOTOURL);
				int upcount = rs.getInt(Const.pic.PIC_UPCOUNT);
				int createby = rs.getInt(Const.pic.PIC_CREATEBY);
				String createtime = rs.getString(Const.pic.PIC_CREATETIME);
				String tag = rs.getString(Const.pic.PIC_TAG);
				list_pic.add(new Pic(photoid, photourl, upcount, createby,
						createtime, tag));
			}
			rs.close();
			return list_pic;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
