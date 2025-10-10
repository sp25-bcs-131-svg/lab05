public class Seat{

	String seatId;
	SeatType seattype;
	boolean isAvailable;
	double price;


	Seat(){
	}

	Seat(int row,int col,SeatType seattype,boolean isAvailable,double price){
		seatId=String.format("ROW :%02d - Seat:%03d", row, col); 
		this.seatId=seatId;
		this.seattype=seattype;
		this.isAvailable=isAvailable;
		this.price=price;
	}

	public String getId(){
		return seatId;
	}

	public SeatType getSeattype(){
		return seattype;
	}

	public double getPrice(){
		return price;
	}

	public boolean isAvailable(){
		return isAvailable;
	}

	public void setSeattype(SeatType seattype){
		this.seattype=seattype;
	}

	public void setPrice(double price){
		this.price=price;
	}

	public boolean isCancelled(){
		return false;
	}

	public boolean isBooked(){
		return true;
	}

	public boolean bookSeat(){
		if(isAvailable){
			isAvailable=false;
			System.out.println("seat:" + seatId + "booked.");
			return true;
		}
		else{
			System.out.println("seat:" + seatId + "is already booked.");
			return false;
		}
	}

	public boolean cancelBooking(){
		if(isAvailable){
			isAvailable=false;
			System.out.println("Booking for seat:" + seatId + "is cancelled.");
			return true;
		}
		else{
			System.out.println("seat:" + seatId + "is available.");
			return false;
		}
	}

	@Override
	public String toString(){
		return String.format("Id: %s \t Type: %s \t Price: %.2f \t Is Available: %b",seatId,seattype,price,isAvailable);
	}
}