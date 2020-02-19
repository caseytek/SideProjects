package sideprojects.dog_match_maker;

public class LabradorRetriever extends Dog {
	
	public LabradorRetriever() {
		super("short", "high", "large", "high", false, true, true, true, true, false);
	}

	@Override
	public String getSound() {
		return "Bork Bork!";
	}

	@Override
	public void getInfo() {
		// TODO Auto-generated method stub

	}

	@Override
	public String getName() {
		return "Labrador Retriever";
	}

}
