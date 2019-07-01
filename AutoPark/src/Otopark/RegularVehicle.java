package Otopark;

public class RegularVehicle implements Vehicle {
	private String plate;
	
	public RegularVehicle(String plate) {
		this.plate = plate;
	}

	@Override
	public String getPlate() {
		return this.plate;
	}

	@Override
	public Subscription getSubscription() {
		return null;
	}

	@Override
	public boolean isOfficial() {
		return false;
	}

	@Override
	public String toString() {
		return "RegularVehicle [plate=" + plate + "]";
	}
	
	

}
