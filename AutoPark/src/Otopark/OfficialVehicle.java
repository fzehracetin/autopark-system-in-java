package Otopark;

public class OfficialVehicle implements Vehicle {
	private String plate;
	
	public OfficialVehicle(String plate) {
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
		return true;
	}

	@Override
	public String toString() {
		return "OfficialVehicle [plate=" + plate + "]";
	}
	
	
	

}
