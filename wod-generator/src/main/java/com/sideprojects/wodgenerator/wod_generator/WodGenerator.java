package com.sideprojects.wodgenerator.wod_generator;

import java.util.Scanner;

public class WodGenerator {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		
		System.out.println("How many movements do you want on your wod?");
		
		int numberOfMovements = Integer.parseInt(input.nextLine());
		
		System.out.println("AMRAP or rounds?");
		
		String wodType = input.nextLine();
		
		Wod todaysWod = new Wod(numberOfMovements, wodType);
		todaysWod.getWod();
		
		
		
	}
	
	
}
