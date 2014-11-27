package com.androidhackathongdggrancanaria.checkhomework;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ExecutionException;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
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
	private static ProgressDialog pDialog;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);
        updateTask();
        this.taskManager = new TaskManager(this.getApplicationContext());
        this.tvDate = (TextView)this.findViewById(R.id.tvDate);
        this.taskGridView = (GridView) this.findViewById(R.id.gvTasks);
        this.paintDate();
    }


    private void updateTask() {
		try {
			new RequestTaskToserver().execute().get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
	}
    
    public void showGridView() {
    	taskManager.open();
    	loadTaskData();
    	taskManager.close();
    	paintTasks();
		
	}

   
	public void iniciarDialogoCargando() {
		pDialog = new ProgressDialog(this.getApplicationContext());
		pDialog.setMessage("Cargando...");
		pDialog.setIndeterminate(true);
		pDialog.setCancelable(false);
		pDialog.show();
	}
	
	public void ocultarDialogoCargando() {
		if (pDialog != null) {
			pDialog.dismiss();
		}
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
    
    private class RequestTaskToserver extends AsyncTask<String, Void, String> {

        
        ArrayList<Task> currData;

        @Override
        protected void onPreExecute() {
        	//iniciarDialogoCargando();
        	TaskManager tm = new TaskManager(getApplicationContext());
        	tm.open();
        	currData = tm.getTasks();
        	tm.removeAll();
        	tm.close();
        	Log.e("MAIN", "OnPre");
        }
        
        @Override
        protected String doInBackground(String... params) {
        	tasks = new LoadDataServer().loadTasks();
            return "";
        }

        


		@Override
        protected void onPostExecute(String result) {
			TaskManager tm = new TaskManager(getApplicationContext());
			tm.open();
			for (Task task : tasks) {
				for (Task currTask : currData) {
					if (currTask.getId() == task.getId())
						task.setDone(currTask.isDone());
					
				}
			}
			for (Task task : tasks) {
				tm.save(task);
			}
			
			tm.close();
			//ocultarDialogoCargando();
			showGridView();
        }

        @Override
        protected void onProgressUpdate(Void... values) {}
    }

	
    
}
