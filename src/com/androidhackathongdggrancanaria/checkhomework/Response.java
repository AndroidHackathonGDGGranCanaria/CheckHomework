package com.androidhackathongdggrancanaria.checkhomework;

import java.util.ArrayList;

import com.google.gson.annotations.SerializedName;

public class Response {
	@SerializedName("tasks")
	private ArrayList<Task> tasks;

	public ArrayList<Task> getTasks() {
		return tasks;
	}

	public void setTasks(ArrayList<Task> tasks) {
		this.tasks = tasks;
	}
	
}
