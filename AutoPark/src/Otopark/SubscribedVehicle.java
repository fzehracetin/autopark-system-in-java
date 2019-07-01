package Otopark;

public class SubscribedVehicle implements Vehicle{
	private String plate;
	private Subscription subscription;
	
	public SubscribedVehicle(String plate, Subscription subscription) {
		this.plate = plate;
		this.subscription = subscription;
	}
	
	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}

	@Override
	public String getPlate() {
		return this.plate;
	}
	@Override
	public Subscription getSubscription() {
		return this.subscription;
	}
	@Override
	public boolean isOfficial() {
		return false;
	}
	@Override
	public String toString() {
		return "SubscribedVehicle [plate=" + plate + ", subscription=" + subscription + "]";
	}
	
	
}
