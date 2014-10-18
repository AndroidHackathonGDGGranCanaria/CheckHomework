package com.androidhackathongdggrancanaria.checkhomework;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class LoadDataMock implements LoadData {

	
	@Override
	public ArrayList<Task> loadTasks() {
	 	
		return this.getRandomTaskArrayByLength(5);
	}
	
	private Task getRandomTask(){
		Random randomObject = new Random();
		
		return new Task(
				randomObject.nextLong(),
				"Random String " +randomObject.nextLong(),
				new Date(),
				"Random Description "+randomObject.nextLong(),
				1,
				false
				);
			
	}
	
	private ArrayList<Task> getRandomTaskArrayByLength(int length){
		ArrayList<Task> result = new ArrayList<Task>();
				
		for(int i=0;i<length;i++){
			result.add(getRandomTask());
		}
		return result;
	}

}
