package com.sideprojects.wodgenerator.wod_generator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Wod {
	
	private List <Exercise> exerciseList;
	private int numberOfMovements;
	private String amrapOrRounds;
	
	public Wod(int numberOfMovements, String amrapOrRounds) { 
		this.numberOfMovements = numberOfMovements;
		this.amrapOrRounds = amrapOrRounds;
	}
	
	public List<Exercise> getWod() {
		exerciseList = new ArrayList<Exercise>();
		if(amrapOrRounds.equalsIgnoreCase("amrap")) {
			int randomNumberAmrap = (int)(Math.random()*(30-12)+12);
			System.out.println(randomNumberAmrap + " Minute AMRAP of:");
		} else {
			int randomNumberRounds = (int)(Math.random()*(10-3)+3);
			System.out.println(randomNumberRounds + " Rounds of:");
		} Movements movement = new Movements(); 
		for (int x = 0; x <= numberOfMovements; x++) {
			int randomRepNumber = (int)(Math.random()*(30-5)+5);
			Exercise exercise = new Exercise(movement.getSingleMovement(), randomRepNumber);
			exerciseList.add(exercise);
			}
		 return exerciseList;
		}
	}