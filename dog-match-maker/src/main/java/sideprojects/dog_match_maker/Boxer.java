package sideprojects.dog_match_maker;

public class Boxer extends Dog {
	
	public Boxer() {
		super("short", "high", "medium", "high", false, true, true, true, true, true);
	}

	@Override
	public String getSound() {
		return "Snort Snort!";
	}

	@Override
	public void getInfo() {
		// TODO Auto-generated method stub

	}

	@Override
	public String getName() {
		return "Boxer";
	}

}
