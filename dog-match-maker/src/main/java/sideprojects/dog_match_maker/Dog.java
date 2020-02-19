package sideprojects.dog_match_maker;

public abstract class Dog {
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
	private String name;
	
	
	public Dog(String hairType, String sheddingLevel, String size,
			String activityLevel, boolean isHypoallergenic, boolean goodWithAllPeople,
			boolean goodWithCats, boolean goodWithDogs, boolean easilyTrainable, boolean isWatchDog) {
	this.hairType = hairType;
	this.sheddingLevel = sheddingLevel;
	this.size = size;
	this.activityLevel = activityLevel;
	this.isHypoallergenic = isHypoallergenic;
	this.goodWithAllPeople = goodWithAllPeople;
	this.goodWithCats = goodWithCats;
	this.goodWithDogs = goodWithDogs;
	this.easilyTrainable = easilyTrainable;
	this.isWatchDog = isWatchDog;
	}
	
	
	
	public String getHairType() {
		return hairType;
	}



	public String getSheddingLevel() {
		return sheddingLevel;
	}



	public String getSize() {
		return size;
	}



	public String getActivityLevel() {
		return activityLevel;
	}



	public boolean isHypoallergenic() {
		return isHypoallergenic;
	}



	public boolean isGoodWithAllPeople() {
		return goodWithAllPeople;
	}



	public boolean isGoodWithCats() {
		return goodWithCats;
	}



	public boolean isGoodWithDogs() {
		return goodWithDogs;
	}



	public boolean isEasilyTrainable() {
		return easilyTrainable;
	}



	public boolean isWatchDog() {
		return isWatchDog;
	}


	public abstract String getName();
	
	public abstract String getSound();
	
	public abstract void getInfo();
	
	@Override 
	public String toString() {
		return "Hair type: " + hairType + "\nShedding level: " + sheddingLevel + 
		"\nSize: " + size + "\nActivity level: " + activityLevel + 
		"\nIs hypoallergenic: " + isHypoallergenic + "\nIs good with people: " +
		goodWithAllPeople + "\nIs good with cats: " + goodWithCats + "\nIs good with other dogs: " +
		goodWithDogs + "\nIs easily trainable: " + easilyTrainable + "\nis a watch dog: " +
		isWatchDog + "\nMakes this sound: " + this.getSound();
	}
}
	
