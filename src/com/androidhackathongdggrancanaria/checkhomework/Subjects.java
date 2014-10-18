package com.androidhackathongdggrancanaria.checkhomework;

public class Subjects {
	
	private String name;
	private String color;
	
	public final Subjects MATHEMATICS = new Subjects("Matematicas", "#E2001D");
	public final Subjects LANGUAGE = new Subjects("Lengua", "#E0CB00");
	public final Subjects ENGLISH = new Subjects("Ingles", "#0D71B5");
	public final Subjects SCIENS = new Subjects("Conocimiento del medio", "#0D6FB3");
	
	private Subjects(String name, String color) {
		
		this.name = name;
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	
	
	 

}
