package com.peoce.wesee.constant;

public class Const {

	public interface error_code {
		public static int SUCCESS = 0x0000;
		public static int PARAM_MALE_FORMAT_ERROT = 0x0001;
		public static int DATABASE_CONNECT_ERROT = 0x0002;
		public static int NO_SUCH_DATABASE_ERROT = 0x0003;
		public static int NO_SUCH_TABLE_ERROT = 0x0004;
		public static int NO_SUCH_FILED_ERROT = 0x0005;
		public static int DATABASE_LOGIN_ERROT = 0x0006;
		public static int PARAM_MISSED_ERROT = 0x0007;
		public static int PASSWORD_MISSED_ERROT = 0x0008;
	}

	public interface general {
		public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		public static final String DATABASE_NAME = "wesee";
		public static final String SERVER_URL = "127.0.0.1";
		public static final String SERVER_PORT = "3306";
		public static final String DATABASE_USER = "root";
		public static final String DATABASE_PASSWORD = "123456";
	}

	public interface users {
		public static final String TABLE_NAME_USERS = "users";
		public static final String USERS_ID = "id";
		public static final String USERS_PHONENUMBER = "PhoneNumber";
		public static final String USERS_PASSWORD = "PassWord";
		public static final String USERS_GENDER = "Gender";
		public static final String USERS_NICKNAME = "NickName";
		public static final String USERS_CITY = "City";
		public static final String USERS_EMAIL = "Email";
		public static final String USERS_PHOTO_URL = "PhotoURL";
		public static final String USERS_SIGNTIME = "SignTime";
	}
}
