package sideprojects.dog_match_maker;

public class GermanShepherd extends Dog {
	
	public GermanShepherd() {
		super("long", "high", "large", "high", false, false, true, true, true, true);

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
		return "German Shepherd";
	}
	
	

}
