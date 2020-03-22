package com.techelevator.dogmatchmakerweb.model;

public class Dog {
	
	private String dogType;
	private String hairType;
	private String sheddingLevel;
	private String size; 
	private String activityLevel; 
	private boolean isHypoallergenic;
	private boolean goodWithAllPeople;
	private boolean goodWithCats;
	private boolean goodWithDogs;
	private boolean easilyTrainable;
	private boolean isWatchDog;
	private String description;
	
	public Dog() {
		
	}
	
	public String getDogType() {
		return dogType;
	}
	public void setDogType(String dogType) {
		this.dogType = dogType;
	}
	public String getHairType() {
		return hairType;
	}
	public void setHairType(String hairType) {
		this.hairType = hairType;
	}
	public String getSheddingLevel() {
		return sheddingLevel;
	}
	public void setSheddingLevel(String sheddingLevel) {
		this.sheddingLevel = sheddingLevel;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getActivityLevel() {
		return activityLevel;
	}
	public void setActivityLevel(String activityLevel) {
		this.activityLevel = activityLevel;
	}
	public boolean isHypoallergenic() {
		return isHypoallergenic;
	}
	public void setHypoallergenic(boolean isHypoallergenic) {
		this.isHypoallergenic = isHypoallergenic;
	}
	public boolean isGoodWithAllPeople() {
		return goodWithAllPeople;
	}
	public void setGoodWithAllPeople(boolean goodWithAllPeople) {
		this.goodWithAllPeople = goodWithAllPeople;
	}
	public boolean isGoodWithCats() {
		return goodWithCats;
	}
	public void setGoodWithCats(boolean goodWithCats) {
		this.goodWithCats = goodWithCats;
	}
	public boolean isGoodWithDogs() {
		return goodWithDogs;
	}
	public void setGoodWithDogs(boolean goodWithDogs) {
		this.goodWithDogs = goodWithDogs;
	}
	public boolean isEasilyTrainable() {
		return easilyTrainable;
	}
	public void setEasilyTrainable(boolean easilyTrainable) {
		this.easilyTrainable = easilyTrainable;
	}
	public boolean isWatchDog() {
		return isWatchDog;
	}
	public void setWatchDog(boolean isWatchDog) {
		this.isWatchDog = isWatchDog;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	

}
