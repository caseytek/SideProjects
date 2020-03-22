package com.sideprojects.wodgenerator.wod_generator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Movements {
	
	private List <String> movementList;
	
	public Movements() {
		movementList = new ArrayList <> (Arrays.asList("burpees", "situps", "air squats", "double unders", "walking lunges", "push-ups", "v-ups"));
		
	}
	
	public List <String> getBodyWeightMovements(){ 
		return movementList;
	}

	public String getSingleMovement() {
		Collections.shuffle(movementList);
		return movementList.remove(0);
	}
}
