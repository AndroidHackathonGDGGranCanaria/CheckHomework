package com.androidhackathongdggrancanaria.checkhomework;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLHelper extends SQLiteOpenHelper {
	
	private static MySQLHelper mInstance;
	public static final String CHECK_TABLE_NAME = "check_table";
	public static final String CHECK_TABLE_ID_COLUMN = "_id";
	public static final String CHECK_TABLE_SUBJECT_COLUMN = "subject";
	public static final String CHECK_TABLE_LIMIT_COLUMN = "limitdate";
	public static final String CHECK_TABLE_DESCRIPTION_COLUMN = "description";
	public static final String CHECK_TABLE_SONID_COLUMN = "sonid";
	public static final String CHECK_TABLE_DONE_COLUMN = "done";
	
	public static final String CREATE_CHECK_TABLE = 
			"create table "
						+ CHECK_TABLE_NAME 
						+ "("
						+ CHECK_TABLE_ID_COLUMN + " integer primary key autoincrement, "
						+ CHECK_TABLE_SUBJECT_COLUMN + " text,"
						+ CHECK_TABLE_DESCRIPTION_COLUMN + " text,"
						+ CHECK_TABLE_LIMIT_COLUMN + " text,"
						+ CHECK_TABLE_SONID_COLUMN + " integer,"
						+ CHECK_TABLE_DONE_COLUMN + " integer"
						+ ");";
	

	private static final String DATA_BASE_NAME = "checkhomework.db";
	private static final int DATA_BASE_VERSION = 1;
	

	public MySQLHelper(Context context) {
		super(context, DATA_BASE_NAME, null, DATA_BASE_VERSION);
		
	}
	
	public static MySQLHelper getInstance(Context context){
		if (mInstance == null)
			mInstance = new MySQLHelper(context);
		return mInstance;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		
		db.execSQL(CREATE_CHECK_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE If EXIST " + CHECK_TABLE_NAME);
		

	}

}
