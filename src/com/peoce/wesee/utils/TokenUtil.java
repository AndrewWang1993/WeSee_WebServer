package com.peoce.wesee.utils;

import java.util.Calendar;

import com.peoce.wesee.constant.Const;

public class TokenUtil {
	// token = sha1(hash(password)+sha1(System.Minute)+hash("MyFriendListServlet")); OR
	// token = sha1(hash(password)+sha1(System.Minute-1)+hash("MyFriendListServlet"));
	public static String[] serverToken(int id) {
		String key1, key2, passWord = UserUtil.getInstance().getPassWord(id);
		Calendar calendar = Calendar.getInstance();
		int min = calendar.get(Calendar.MINUTE);
		StringBuilder sb = new StringBuilder();
		sb.append(EncryUtil.getHash(passWord));
		sb.append(EncryUtil.getHash(min + "", "SHA1"));
		sb.append(EncryUtil.getHash(Const.token.key));
		key1 = EncryUtil.getHash(sb.toString());
		sb = new StringBuilder();
		sb.append(EncryUtil.getHash(passWord));
		sb.append(EncryUtil.getHash((min == 0 ? 59 : min - 1) + "", "SHA1"));
		sb.append(EncryUtil.getHash(Const.token.key));
		key2 = EncryUtil.getHash(sb.toString());
		return new String[] { key1, key2 };
	}
}
