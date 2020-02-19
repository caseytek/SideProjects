package sideprojects.dog_match_maker;

public class GoldenRetriever extends Dog {
	
	public GoldenRetriever() {
		super("long", "high", "large", "high", false, true, true, true, true, false);
	}

	@Override
	public void getInfo() {
		// TODO Auto-generated method stub

	}

	@Override
	public String getSound() {
		return "Bork Bork!";
	}

	@Override
	public String getName() {
		return "Golden Retriever";
	}

}
