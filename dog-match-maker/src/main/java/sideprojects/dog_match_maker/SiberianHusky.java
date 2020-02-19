package sideprojects.dog_match_maker;

public class SiberianHusky extends Dog {
	
	public SiberianHusky() {
	super( "short", "low", "small", "low",false, true, true, true, false, false);

	}

	@Override
	public String getSound() {
		return "Awoooooooo!";
	}

	@Override
	public void getInfo() {
		// TODO Auto-generated method stub

	}

	@Override
	public String getName() {
		return "Siberian Husky";
	}

}
