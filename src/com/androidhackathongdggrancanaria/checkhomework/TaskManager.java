package com.androidhackathongdggrancanaria.checkhomework;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class TaskManager {
	
	private MySQLHelper dbHelper;
	private SQLiteDatabase database;
	private String[] columns = {
		MySQLHelper.CHECK_TABLE_ID_COLUMN,
		MySQLHelper.CHECK_TABLE_SUBJECT_COLUMN,
		MySQLHelper.CHECK_TABLE_SONID_COLUMN,
		MySQLHelper.CHECK_TABLE_LIMIT_COLUMN,
		MySQLHelper.CHECK_TABLE_DONE_COLUMN,
		MySQLHelper.CHECK_TABLE_DESCRIPTION_COLUMN,
	};
	
	public TaskManager(Context context) {
		dbHelper = MySQLHelper.getInstance(context);
	}
	
	public void open(){
		database = dbHelper.getWritableDatabase();
	}
	
	public void close(){
		database.close();
	}
	
	public void save(Task task){
		ContentValues values = getTaskContentValues(task);
		this.open();
		database.insert(MySQLHelper.CHECK_TABLE_NAME, null, values);
		this.close();
	}
	
	public void removeUntilDate(Date date) {
		String dateString = this.parseDate(date);
		this.open();
		database.execSQL("DELETE FROM " 
				+ MySQLHelper.CHECK_TABLE_NAME 
				+ " WHERE " 
				+ "Date(" + MySQLHelper.CHECK_TABLE_LIMIT_COLUMN + ") <" 
				+ "Date(" + dateString + ")");
		this.close();
	}

	private ContentValues getTaskContentValues(Task task) {
		// TODO Auto-generated method stub
		ContentValues values = new ContentValues();
		values.put(this.columns[1], task.getSubject());
		values.put(this.columns[2], task.getSonId());
		values.put(this.columns[3], parseDate(task.getLimit()));
		values.put(this.columns[4], parseBoolean(task.isDone()));
		values.put(this.columns[5], task.getDescription());
		return values;
	}

	private int parseBoolean(boolean done) {
		return (done)?1:0;
	}
	
	private String parseDate(Date date){
		return new SimpleDateFormat("yyyy-MM-dd").format(date);
	}
	
}
