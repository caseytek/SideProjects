package sideprojects.dog_match_maker_application;

import java.util.Scanner;

public class QuizMethods {
	
	Scanner input = new Scanner(System.in);
	
	public String hairLengthQuestion() {
		System.out.println("Does your dream dog have (S)hort, " + 
		 "(M)edium, or fluffy (L)ong hair?");
			String answer = input.nextLine().toLowerCase();
			if (answer.equals( "s")) {
				answer = "short";
				System.out.println("Makes grooming easier.");
			} else if (answer.equals("m")) {
				answer = "medium";
				System.out.println("Best of both worlds!");
			} else if (answer.equals("l")) {
				answer = "long";
				System.out.println("Fluffy cloud puppy!");
			} else {
				System.out.println("That is not a valid hair length. Please try again.");
				hairLengthQuestion();
			} return answer;
	}

	public String sheddingQuestion() {
		System.out.println("\nHow much extra fluff do you see in your future?");
		System.out.println("\n1. No shedding please.");
		System.out.println("\n2. A little shedding is okay");
		System.out.println("\n3. Bring on the extra floof!");
			String answer = input.nextLine();
			if (answer.equals( "1")) {
				answer = "low";
				System.out.println("Less clean-up.");
			} else if (answer.equals("2")) {
				answer = "medium";
				System.out.println("A little floof never killed anyone.");
			} else if (answer.equals("3")) {
				answer = "high";
				System.out.println("Fluffy cloud puppy residue!");
			} else {
				System.out.println("That is not a valid option. " + 
			"Please choose 1, 2, or 3.");
				sheddingQuestion();
			} return answer;
	}
	
	public String sizeQuestion() {
		System.out.println("\nWhat size pupper do you desire?");
		System.out.println("\n1. Smol.");
		System.out.println("\n2. Not too smol or big.");
		System.out.println("\n3. Bigger the better!");
			String answer = input.nextLine();
			if (answer.equals( "1")) {
				answer = "small";
				System.out.println("Fun sized pupper!");
			} else if (answer.equals("2")) {
				answer = "medium";
				System.out.println("Still sassy!");
			} else if (answer.equals("3")) {
				answer = "large";
				System.out.println("Large and in charge!");
			} else {
				System.out.println("That is not a valid option. " + 
			"Please choose 1, 2, or 3.");
				sizeQuestion();
			} return answer;
	}
	
	public String activityLevelQuestion() {
		System.out.println("\nHow hyper do you like your furbaby?");
		System.out.println("\n1. Very lazy.");
		System.out.println("\n2. Playful but lazy.");
		System.out.println("\n3. Playtime all the time!");
			String answer = input.nextLine();
			if (answer.equals( "1")) {
				answer = "low";
				System.out.println("Exercise is for losers!");
			} else if (answer.equals("2")) {
				answer = "medium";
				System.out.println("Well rounded doggo!");
			} else if (answer.equals("3")) {
				answer = "high";
				System.out.println("Chew everything in sight!!!!!");
			} else {
				System.out.println("That is not a valid option. " + 
			"Please choose 1, 2, or 3.");
				activityLevelQuestion();
			} return answer;
	}
	
	public boolean hypoallergenicQuestion() {
		System.out.println("\nAre you allergic to furbabies?");
		System.out.println("\n1. Yes, hypoallergetic dogs only.");
		System.out.println("\n2. Yes, but my partner isn't.");
		System.out.println("\n3. No, bring on the dander!");
			String answer = input.nextLine();
			boolean wantsHypoallergenic = false;
			if (answer.equals( "1")) {
				wantsHypoallergenic = true;
				System.out.println("Sniffle free!");
			} else if (answer.equals("2")) {
				wantsHypoallergenic = false;
				System.out.println("Bring on the allergy pills!");
			} else if (answer.equals("3")) {
				wantsHypoallergenic = false;
				System.out.println("Cheers to allergenic puppers!");
			} else {
				System.out.println("That is not a valid option. " + 
			"Please choose 1, 2, or 3.");
				hypoallergenicQuestion();
			} return wantsHypoallergenic;
	}
	
	public boolean goodWithPeopleQuestion() {
		System.out.println("\nIs your dream doggo a people fur-person?");
		System.out.println("\n1. As long as he/she loves his family that's enough.");
		System.out.println("\n2. Like all the people!");
			String answer = input.nextLine();
			boolean likesPeople = false;
			if (answer.equals( "1")) {
				likesPeople = false;
				System.out.println("People suck anyway.");
			} else if (answer.equals("2")) {
				likesPeople = true;
				System.out.println("Party pup!");
			} else {
				System.out.println("That is not a valid option. " + 
			"Please choose 1 or 2.");
				goodWithPeopleQuestion();
			} return likesPeople;
	}
	
	public boolean goodWithCatsQuestion() {
		System.out.println("\nIs your dream doggo a cat fur-person?");
		System.out.println("\n1. We don't say the C word in this house.");
		System.out.println("\n2. Must like all of God's creatures!");
			String answer = input.nextLine();
			boolean likesCats = false;
			if (answer.equals( "1")) {
				likesCats = false;
				System.out.println("Dogs rule cats drool!");
			} else if (answer.equals("2")) {
				likesCats = true;
				System.out.println("Better hide the cat litter.");
			} else {
				System.out.println("That is not a valid option. " + 
			"Please choose 1 or 2.");
				goodWithCatsQuestion();
			} return likesCats;
	}
	
	public boolean goodWithDogsQuestion() {
		System.out.println("\nIs your dream doggo a dog fur-person?");
		System.out.println("\n1. Our pupper doesn't need fur friends.");
		System.out.println("\n2. What kind of stupid question is that?");
			String answer = input.nextLine();
			boolean likesDogs = false;
			if (answer.equals( "1")) {
				likesDogs = false;
				System.out.println("Family is all you need!");
			} else if (answer.equals("2")) {
				likesDogs = true;
				System.out.println("All the dogs!");
			} else {
				System.out.println("That is not a valid option. " + 
			"Please choose 1 or 2.");
				goodWithDogsQuestion();
			} return likesDogs;
	}
	
	public boolean isTrainableQuestion() {
		System.out.println("\nWill there be dog training in your future?");
		System.out.println("\n1. No, my dog will not be a slave.");
		System.out.println("\n2. Yes, I'll teach him/her all the things!");
			String answer = input.nextLine();
			boolean isTrainable = false;
			if (answer.equals( "1")) {
				isTrainable = false;
				System.out.println("Human domination is overrated.");
			} else if (answer.equals("2")) {
				isTrainable = true;
				System.out.println("Dog show quality!");
			} else {
				System.out.println("That is not a valid option. " + 
			"Please choose 1 or 2.");
				isTrainableQuestion();
			} return isTrainable;
	}
	
	public boolean isWatchDogQuestion() {
		System.out.println("\nShould your doggo bork when there is danger?");
		System.out.println("\n1. No, Scruffy will be a pacifist");
		System.out.println("\n2. Stranger Danger!");
			String answer = input.nextLine();
			boolean isWatchDog = false;
			if (answer.equals( "1")) {
				isWatchDog = false;
				System.out.println("Peace on Earth!");
			} else if (answer.equals("2")) {
				isWatchDog = true;
				System.out.println("Bad Boys Furry Edition!");
			} else {
				System.out.println("That is not a valid option. " + 
			"Please choose 1 or 2.");
				isWatchDogQuestion();
			} return isWatchDog;
	}
	
	
	
	
}
