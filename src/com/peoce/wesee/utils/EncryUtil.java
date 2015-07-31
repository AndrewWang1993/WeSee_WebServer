package com.peoce.wesee.utils;

import java.security.MessageDigest;

public class EncryUtil {
	public static String getHash(String message) {
		return getHash(message, "MD5");
	}

	public static String getHash(String message, String type) {
		StringBuilder sBuilder = null;
		try {
			MessageDigest messageDigest = MessageDigest.getInstance(type);
			messageDigest.update(message.getBytes());
			sBuilder = new StringBuilder();
			for (byte b : messageDigest.digest()) {
				sBuilder.append(String.format("%02X", b));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sBuilder.toString();
	}
}
