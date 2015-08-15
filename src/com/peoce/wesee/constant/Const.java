package com.peoce.wesee.constant;

public class Const {

	public interface avatar {
		public static String AVATAR_PATH = "/home/avatar/";
		public static long MAX_AVATAR_SIZE = 3 * 1024 * 1024;
	}

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
		public static int PHONENUMBER_MISSED_ERROT = 0x0009;
		public static int UNKNOW_ERROR = 0x000A;
		public static int TOKEN_ERROR = 0x000B;
		public static int PHONENUMBER_EXIST_ERROT = 0x000C;		
	}

	public interface general {
		public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		public static final String DATABASE_NAME = "wesee";
		public static final String SERVER_URL = "127.0.0.1";
		public static final String SERVER_PORT = "3306";
		public static final String DATABASE_USER = "root";
//		 public static final String DATABASE_PASSWORD = "linux43032";
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
		public static final String USERS_TOKEN = "Token";
	}

	public interface user_pic {
		public static final String TABLE_NAME_USER_PIC = "user_pic";
		public static final String USER_PIC_ID = "id";
		public static final String USER_PIC_DESC = "Descript";
		public static final String USER_PIC_PHOTOID = "PhotoId";
		public static final String USER_PIC_UPCOUNT = "UpCount";
		public static final String USER_PIC_ISRETWITTER = "IsRetwitter";
		public static final String USER_PIC_PUBLIISHTIME = "PublishTime";
	}

	public interface user_relation {
		public static final String TABLE_NAME_USER_RELATION = "user_relation";
		public static final String USER_RELATION_ID = "Id";
		public static final String USER_RELATION_FRIENDID = "FriendId";
		public static final String USER_RELATION_ISBLOCK = "IsBlock";
		public static final String USER_RELATION_NOTVISIBLE = "NotVisible";
	}

	public interface pic {
		public static final String TABLE_NAME_PIC = "pic";
		public static final String PIC_PHOTOID = "PhotoId";
		public static final String PIC_PHOTODESC = "Descript";
		public static final String PIC_PHOTOURL = "PhotoUrl";
		public static final String PIC_UPCOUNT = "UpCount";
		public static final String PIC_CREATEBY = "CreateBy";
		public static final String PIC_CREATETIME = "PicCreateTime";
		public static final String PIC_TAG = "Tag";
	}

	public interface page {
		public static final String PARA_START = "start";
		public static final String PARA_OFF = "off";

	}

	public interface sqlresponse {
		public static final int SQL_OK = 0x1000;
		public static final int SQL_FAIL = 0x1001;
	}

	public interface token {
		public static final String key = "Fx!O8f%q1%Jg";
	}
}
