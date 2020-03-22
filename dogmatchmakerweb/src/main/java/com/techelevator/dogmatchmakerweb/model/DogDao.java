package com.techelevator.dogmatchmakerweb.model;

import java.util.List;


public interface DogDao {

	Dog getDogByType(String dogType);
	
	List <Dog> getAllDogs();
}
