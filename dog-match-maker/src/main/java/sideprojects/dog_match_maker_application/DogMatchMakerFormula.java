package sideprojects.dog_match_maker_application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import sideprojects.dog_match_maker.Boxer;
import sideprojects.dog_match_maker.Dog;
import sideprojects.dog_match_maker.FrenchBulldog;
import sideprojects.dog_match_maker.GermanShepherd;
import sideprojects.dog_match_maker.GoldenRetriever;
import sideprojects.dog_match_maker.LabradorRetriever;
import sideprojects.dog_match_maker.SiberianHusky;
import sideprojects.dog_match_maker.YorkshireTerrier;

public class DogMatchMakerFormula {
	
	Dog boxer = new Boxer();
	Dog frenchBullDog = new FrenchBulldog();
	Dog germanShepherd = new GermanShepherd();
	Dog goldenRetriever = new GoldenRetriever();
	Dog labradorRetriever = new LabradorRetriever();
	Dog siberianHusky = new SiberianHusky();
	Dog yorkshireTerrier = new YorkshireTerrier();
	
	
	List <Dog> dogList = new ArrayList <> (Arrays.asList ( boxer, frenchBullDog,
			germanShepherd, goldenRetriever, labradorRetriever, siberianHusky, yorkshireTerrier));
	
	public Dog matchMakerFormula(Dog dreamDog) {
		Dog winner = null;
		int winnerScore = 0;
		String winnerName = null;
		for (Dog dog: dogList) {
			int score = 0;
			if(dog.getHairType().equals(dreamDog.getHairType())) {
				score++;
			} if(dog.getSheddingLevel().equals(dreamDog.getSheddingLevel())) {
				score++;
			} if(dog.getSize().equals(dreamDog.getSize())) {
				score++;
			} if(dog.getActivityLevel().equals(dreamDog.getActivityLevel())) {
				score++;
			} if(dog.isHypoallergenic() == dreamDog.isHypoallergenic()) {
				score++;
			}  if(dog.isGoodWithAllPeople() == dreamDog.isGoodWithAllPeople()) {
				score++;
			}  if(dog.isGoodWithCats() == dreamDog.isGoodWithCats()) {
				score++;
			}  if(dog.isGoodWithDogs() == dreamDog.isGoodWithDogs()) {
				score++;
			}  if(dog.isEasilyTrainable() == dreamDog.isEasilyTrainable()) {
				score++;
			}  if(dog.isWatchDog() == dreamDog.isWatchDog()) {
				score++;
			} if(score > winnerScore) {
				winnerScore = score;
				winnerName = dog.getName();
			}
		} for (Dog dog: dogList) {
			if(winnerName.equals(dog.getName())) {
				winner = dog;
			}
		} return winner;
	}
}
