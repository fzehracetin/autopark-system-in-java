package Otopark;

public class ParkRecord {
	private Time enterTime, exitTime;
	private Vehicle vehicle;
	private Date enterDate, exitDate;

	public ParkRecord(Time enterTime, Vehicle vehicle, Date enterDate) {
		this.enterTime = enterTime;
		this.exitTime = null;
		this.vehicle = vehicle;
		this.enterDate = enterDate;
		this.exitDate = null;
	}

	public int getParkingDuration() {
		int dif = 0, diff = 0;
		if(enterTime.getHour()>=exitTime.getHour())
			dif = 1;
		 if ( (this.exitDate.getDifference(this.enterDate) == 0 && (enterTime.getHour() == exitTime.getHour() ) ))
			diff = 1440;
		return this.enterTime.getDifference(this.exitTime)-diff + Math.max(0,(this.exitDate.getDifference(this.enterDate)-dif))*1440;
	}

	public Time getEnterTime() {
		return enterTime;
	}

	public Time getExitTime() {
		return exitTime;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public Date getEnterDate() {
		return enterDate;
	}

	public Date getExitDate() {
		return exitDate;
	}

	public void setExitTime(Time exitTime) {
		this.exitTime = exitTime;
	}

	public void setExitDate(Date exitDate) {
		this.exitDate = exitDate;
	}

	@Override
	public String toString() {
		return "ParkRecord [enterTime=" + enterTime + ", exitTime=" + exitTime + " " +  vehicle.toString()+ ", enterDate="
				+ enterDate + ", exitDate=" + exitDate + "]";
	}






}
