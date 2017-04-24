package com.classmates.classmates;

import com.classmates.classmates.TableData.TableInfo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseOperations extends SQLiteOpenHelper {

	public static final int database_version=1;
	public String CREATE_QUERY = "CREATE TABLE "+TableInfo.TABLE_NAME+"("+TableInfo.FIRST_NAME+" TEXT,"+TableInfo.LAST_NAME+" TEXT,"+TableInfo.GENDER+" TEXT ,"+TableInfo.EMAIL_ID+" TEXT PRIMARY KEY,"+TableInfo.USER_PASS+" TEXT,"+TableInfo.SEQ_QUES+" TEXT,"+TableInfo.SEQ_ANS+" TEXT,"+TableInfo.CLG_NAME+" TEXT,"+TableInfo.BATCH+" TEXT,"+TableInfo.BRANCH+" TEXT,"+TableInfo.IMAGE+" TEXT );";  
	
	public DatabaseOperations(Context context) {
		super(context, TableInfo.DATABASE_NAME, null, database_version);
		// TODO Auto-generated constructor stub
		Log.d("Database operations", "Database Created");
	}

	@Override
	public void onCreate(SQLiteDatabase sdb) {
		// TODO Auto-generated method stub
		sdb.execSQL(CREATE_QUERY);
		Log.d("Database operations", "Table created");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

	public void putInformaiton(DatabaseOperations dop,String firstname,String lastname,String gender,String email,String password,String seq_ques,String seq_ans,String clg,String batch,String branch,String image){
		
		SQLiteDatabase SQ = dop.getWritableDatabase();
		ContentValues cv = new ContentValues();
		cv.put(TableInfo.FIRST_NAME, firstname);
		cv.put(TableInfo.LAST_NAME, lastname);
		cv.put(TableInfo.GENDER, gender);
		cv.put(TableInfo.EMAIL_ID, email);
		cv.put(TableInfo.USER_PASS, password);
		cv.put(TableInfo.SEQ_QUES, seq_ques);
		cv.put(TableInfo.SEQ_ANS, seq_ans);
		cv.put(TableInfo.CLG_NAME, clg);
		cv.put(TableInfo.BATCH, batch);
		cv.put(TableInfo.BRANCH, branch);
		cv.put(TableInfo.IMAGE, image);
		long k = SQ.insert(TableInfo.TABLE_NAME, null, cv);
		Log.d("Database operations", "One row Inserted");
	}
	public Cursor getInformation(DatabaseOperations dop){
		
		SQLiteDatabase SQ = dop.getReadableDatabase();
		String[] coloumns = {TableInfo.EMAIL_ID,TableInfo.USER_PASS,TableInfo.FIRST_NAME};
		Cursor CR = SQ.query(TableInfo.TABLE_NAME, coloumns, null, null, null, null, null);
		int eIndex=CR.getColumnIndex(TableInfo.EMAIL_ID);
		int nameIndex=CR.getColumnIndex(TableInfo.FIRST_NAME);
		
		return CR;
		
	}
	
	
	
	
	
	
	
	
}
