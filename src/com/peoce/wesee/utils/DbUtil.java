package com.peoce.wesee.utils;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;

import com.peoce.wesee.constant.Const;

/**
 * 数据库打开工具
 * 
 * @author wangxm
 */
public class DbUtil {
	private static Connection instance;

	public static Connection openDb() {
		if (null == instance) {
			String url = "jdbc:mysql://"
					+ Const.general.SERVER_URL
					+ ":"
					+ Const.general.SERVER_PORT
					+ "/"
					+ Const.general.DATABASE_NAME
					+ "?Unicode=true&characterEncoding=utf-8&autoReconnect=true&autoReconnectForPools=true";
			try {
				Class.forName(Const.general.JDBC_DRIVER);
				instance = DriverManager.getConnection(url,
						Const.general.DATABASE_USER,
						Const.general.DATABASE_PASSWORD);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		}
		return instance;
	}

	public static String utfString(String oldStr) {
		String newStr = oldStr;
		try {
			newStr = new String(oldStr.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return newStr;
	}

}
