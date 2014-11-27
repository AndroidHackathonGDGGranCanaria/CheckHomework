package com.androidhackathongdggrancanaria.checkhomework;

import android.graphics.drawable.Drawable;

public class Subjects {
	
	private String name;
	private int color;
	
	public static final Subjects MATHEMATICS = new Subjects("Matematicas", R.color.matematicas);
	public static final Subjects LANGUAGE = new Subjects("Lengua", R.color.lengua);
	public static final Subjects ENGLISH = new Subjects("Ingles", R.color.ingles);
	public static final Subjects SCIENS = new Subjects("CONO", R.color.ciencias);
	
	private Subjects(String name, int color) {
		
		this.name = name;
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}
	
	
	
	 

}
