package com.peoce.wesee.utils;

public class JsonUtil {
	// public static <T> String generaJsonArray(T[] ts) {
	// StringBuilder sb = new StringBuilder();
	// sb.append("[");
	// for (T t : ts) {
	// sb.append(t.toString() + ",");
	// }
	// sb.append("]");
	//
	// return null;
	// }

	public static String generaJsonArray(int[] ts) {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int t : ts) {
			sb.append(t + ",");
		}
		sb.deleteCharAt(sb.length() - 1);
		sb.append("]");
		return sb.toString();
	}

}
