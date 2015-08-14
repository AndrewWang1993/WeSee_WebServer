package com.peoce.wesee.utils;

public class JsonUtil {
	public static <T> String generaJsonArray(T[] ts) {
	StringBuilder sb = new StringBuilder();
	sb.append("[");
	for (T t : ts) {
	sb.append(String.valueOf(t) + ",");
	}
	sb.deleteCharAt(sb.length() - 1);
	sb.append("]");

	return sb.toString();
	}

}
