package com.androidhackathongdggrancanaria.checkhomework;

import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;
import android.widget.TextView;


public class MainActivity extends Activity {

	private ArrayList <Task> tasks;
	private GridViewAdapter gvAdapter;
	private GridView taskGridView;
	private TextView tvDate;
	private TaskManager taskManager; 
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);
        this.taskManager = new TaskManager(this.getApplicationContext());
        this.tvDate = (TextView)this.findViewById(R.id.tvDate);
        this.taskGridView = (GridView) this.findViewById(R.id.gvTasks);
        this.paintDate();
        this.taskManager.open();
        this.loadTaskData();
        this.taskManager.close();
        this.paintTasks();
        new LoadDataServer().loadTasks();
    }


    private void loadTaskData() {
    	this.tasks = taskManager.getTasks();
    	Log.e("Tamaño tareas", this.tasks.size() + "");
    }
    
    private void paintTasks() {
    	this.gvAdapter = new GridViewAdapter(this,
    			this.tasks);
    	this.taskGridView.setAdapter(gvAdapter);
    	//this.gvAdapter.notifyDataSetChanged();
    }
    
    private void paintDate() {
    	this.tvDate.setText(this.taskManager.parseDate(new Date()));
    }
    
}
