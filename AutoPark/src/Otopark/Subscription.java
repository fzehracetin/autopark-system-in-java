package Otopark;

public class Subscription {
	private Date begin, end;
	private SubscribedVehicle vehicle;

	public Subscription(String plate,Date begin, Date end) {
		this.begin = begin;
		this.end = end;
		vehicle = new SubscribedVehicle(plate,this);
	}

	public boolean isValid() {
		Date date = Date.getToday();
		if ( (this.end.isAfterThan(date)) || (this.end.isEqualsWith(date)) && (this.begin.isBeforeThan(date)) || (this.begin.isEqualsWith(date)) )
			return true;
		return false;
	}

	public Date getBegin() {
		return begin;
	}

	public Date getEnd() {
		return end;
	}

	public void setBegin(Date begin) {
		this.begin = begin;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public SubscribedVehicle getVehicle() {
		return vehicle;
	}



}
