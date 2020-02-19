package sideprojects.dog_match_maker_application;

import sideprojects.dog_match_maker.Dog;
import sideprojects.dog_match_maker.DreamDog;

public class DogMatchMaker {

	public static void main(String[] args) {
		QuizMethods method = new QuizMethods();
		String dogHairLength = method.hairLengthQuestion();
		String dogSheddingLevel = method.sheddingQuestion();
		String dogSize = method.sizeQuestion();
		String activityLevel = method.activityLevelQuestion();
		boolean wantsHypoallergenic =  method.hypoallergenicQuestion();
		boolean likesPeople = method.goodWithPeopleQuestion();
		boolean likesCats = method.goodWithCatsQuestion();
		boolean likesDogs = method.goodWithDogsQuestion();
		boolean isTrainable = method.isTrainableQuestion();
		boolean isWatchDog = method.isWatchDogQuestion();
		
		Dog dreamDog = new DreamDog(dogHairLength, dogSheddingLevel, dogSize,
				activityLevel, wantsHypoallergenic, likesPeople,
				likesCats, likesDogs, isTrainable, isWatchDog);
	
		DogMatchMakerFormula formula = new DogMatchMakerFormula();
		Dog dogWinner = formula.matchMakerFormula(dreamDog);
		System.out.println(dogWinner.getSound());
		System.out.println("Your dream dog is a " + dogWinner.getName() + "!");
		
	}
	
		
	
	
	
	


}
