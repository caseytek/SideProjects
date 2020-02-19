package sideprojects.dog_match_maker;

public class YorkshireTerrier extends Dog {

	public YorkshireTerrier() {
		super("long", "low", "small", "low", true, false, false, true, false, true);
	}

	@Override
	public String getSound() {
		return "Yap Yap!";
	}

	@Override
	public void getInfo() {
	}

	@Override
	public String getName() {
		return "Yorkshire Terrier";
	}

	
}
