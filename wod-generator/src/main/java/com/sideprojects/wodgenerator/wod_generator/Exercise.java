package com.sideprojects.wodgenerator.wod_generator;

public class Exercise {

	private String movement;
	private int reps;
	
	public Exercise(String movement, int reps) {
		this.movement = movement;
		this.reps = reps;
	}

	public String getMovement() {
		return movement;
	}

	public int getReps() {
		return reps;
	}
	 
	//added a to string, so a list could be returned to the main and looped through with syntax included
	@Override
	public String toString() {
		return this.reps +" " + this.movement;
	}
	
	
}
