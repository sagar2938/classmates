package com.classmates.classmates;

import android.provider.BaseColumns;

public class TableData {

	public TableData(){
		
	}
	
	public static abstract class TableInfo implements BaseColumns{
		
		public static final String FIRST_NAME = "first_name";
		public static final String LAST_NAME = "lastt_name";
		public static final String EMAIL_ID = "email_id";
		public static final String USER_PASS = "user_pass";
		public static final String SEQ_QUES = "seq_ques";
		public static final String SEQ_ANS = "seq_ans";
		public static final String CLG_NAME = "clg_name";
		public static final String BATCH = "batch";
		public static final String BRANCH = "branch";
		public static final String GENDER = "gender";
		public static final String IMAGE = "image";
		public static final String DATABASE_NAME = "classmate";
		public static final String TABLE_NAME = "user_info";
		
		
	}
}
