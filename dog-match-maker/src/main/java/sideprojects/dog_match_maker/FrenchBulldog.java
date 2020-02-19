package sideprojects.dog_match_maker;

public class FrenchBulldog extends Dog {
	
	public FrenchBulldog() {
		super( "short", "low", "small", "low",false, true, true, true, false, false);

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
		// TODO Auto-generated method stub
		return "French BullDog";
	}

}
