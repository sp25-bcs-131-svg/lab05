package sp25_bcs_131;

public enum SeatType{
	
	REGULAR("REGULAR"), PREMIUM("PREMIUM"), VIP("VIP"), RECLINER("RECLINER");
	String type;

	SeatType(String type){
		this.type=type;
	}

	@Override
	public String toString(){
		return String.format(" %s",type);
	}
}

