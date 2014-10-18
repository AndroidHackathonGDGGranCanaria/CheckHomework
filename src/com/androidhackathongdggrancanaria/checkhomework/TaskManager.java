package com.androidhackathongdggrancanaria.checkhomework;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

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
		database.insert(MySQLHelper.CHECK_TABLE_NAME, null, values);
}
	
	public void removeUntilDate(Date date) {
		String dateString = this.parseDate(date);
		database.execSQL("DELETE FROM " 
				+ MySQLHelper.CHECK_TABLE_NAME 
				+ " WHERE " 
				+ "Date(" + MySQLHelper.CHECK_TABLE_LIMIT_COLUMN + ") <" 
				+ "Date(" + dateString + ")");
		}
	public void removeAll() {
		
		database.delete(MySQLHelper.CHECK_TABLE_NAME, null, null);
	}
	
	public void update(Task task){
		ContentValues values = getTaskContentValues(task);
		database.update(MySQLHelper.CHECK_TABLE_NAME, values, "_id=?", new String[]{task.getId() + ""});
	}
	
	public ArrayList<Task> getTasks(){ 
		Cursor cursor = database.query(MySQLHelper.CHECK_TABLE_NAME, columns, null, null, null, null, null);
		return getTasksFromCursos(cursor);
	}

	private ArrayList<Task> getTasksFromCursos(Cursor cursor) {
		ArrayList<Task> res = new ArrayList<Task>();
		Log.e("TaskMain", "getTasksFromCursos" );
		cursor.moveToFirst();
		while ( ! cursor.isAfterLast()) {
			
			res.add(this.createTaskFromCursos(cursor));
			cursor.moveToNext();
		}
		cursor.close();
		return res;
	}

	private Task createTaskFromCursos(Cursor cursor) {
		Task res = new Task();
		res.set_id(cursor.getLong(0));
		res.setSubject(cursor.getString(1));
		res.setLimit(cursor.getString(2));
		res.setDescription(cursor.getString(3));
		res.setSonId(cursor.getLong(4));
		res.setDone(parseIntToBoolean(cursor.getInt(5)));
		return res;
	}

	protected Date parseStringToDate(String string) {
		try {
			return new SimpleDateFormat("yyyy-MM-dd").parse(string);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private ContentValues getTaskContentValues(Task task) {
		// TODO Auto-generated method stub
		ContentValues values = new ContentValues();
		values.put(this.columns[0], task.getId() );
		values.put(this.columns[1], task.getSubject());
		values.put(this.columns[2], task.getSonId());
		values.put(this.columns[3], task.getLimit());
		values.put(this.columns[4], parseBoolean(task.isDone()));
		values.put(this.columns[5], task.getDescription());
		return values;
	}

	private int parseBoolean(boolean done) {
		return (done)?1:0;
	}
	
	private boolean parseIntToBoolean (int done) {
		return (done == 1)?true:false;
	}
	
	protected String parseDate(Date date){
		return new SimpleDateFormat("yyyy-MM-dd").format(date);
	}
	
}
