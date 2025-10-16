package sp25_bcs_131;

public class Screen {

	Seat[][] seats;
	Seat seat;
	int rows;
	String screenName;

	double PRICE_RECLINER = 1200.0;
	double PRICE_VIP = 1000.0;
	double PRICE_PREMIUM =750.0;
	double PRICE_REGULAR = 500.0;

	public Screen() {
	}

	public Screen(String screenName) {
		this.screenName = screenName;
		initializeSeats();
	}

	public String getScreenName() {
        	return screenName;
    	}

    	public Seat[][] getSeats() {
        	return this.seats;
    	}

	public void initializeSeats() {
        	int rowsLength[]={10, 11, 12, 13, 14, 15};
        	seats=new Seat[rowsLength.length][];

        	for(int i=0;i<rowsLength.length;i++){
            		seats[i]=new Seat[rowsLength[i]];

            	SeatType type;
            	double price;

            		if(i<1){
                		type=SeatType.REGULAR;
                		price=PRICE_REGULAR;
            		}
			else if(i<2){
                		type=SeatType.PREMIUM;
                		price=PRICE_PREMIUM;
            		}
			else if(i<rowsLength.length - 1){
        	        	type=SeatType.VIP;
	                	price=PRICE_VIP;
            		}
			else{
                		type=SeatType.RECLINER;
                		price=PRICE_RECLINER;
            		}

            		for(int j=0;j<seats[i].length;j++){
                		seats[i][j]=new Seat(i, j, type, true, price);
            		}
		}
 	}

	public int getRowLength(int row) {
        	return seats[row].length;
    	}

    	public int getRowCount() {
        	return seats.length;
    	}

    	public Seat getSeat(String seatID) {
        	for(Seat[] row:seats){
            		for(Seat seat : row){
                		if(seat.getId().equals(seatID)) {
                    			return seat;
                		}
            		}
        	}
        	return null;
    	}

    	public Seat getSeat(int row, int col) {
        	if (row>=0 && row<seats.length && col>=0 && col<seats[row].length) {
            		return seats[row][col];
        	}
        	return null;
    	}

    	public int getTotalSeats() {
        	int total=0;
        	for(Seat[] row:seats){
            		total+=row.length;
        	}
		return total;
    	}

    	public int getTotalSeats(SeatType type) {
        	int count=0;
        	for(Seat[] row:seats){
            		for(Seat seat:row){
                		if(seat.getSeattype()==type){
                    			count++;
                		}
            		}
        	}
        	return count;
    	}

    	public int getAvailableSeatCount() {
        	int count=0;
        	for(Seat[] row:seats){
            		for(Seat seat:row){
                		if(seat.isAvailable()){
                    			count++;
                		}
           		 }
        	}
        	return count;
    	}

    	public int getAvailableSeatCount(SeatType type) {
        	int count = 0;
        	for (Seat[] row : seats) {
            		for (Seat seat : row) {
                		if (seat.getSeattype() == type && seat.isAvailable()) {
                    			count++;
                		}
            		}
        	}
        	return count;
    	}

    	public void setRowType(int row, SeatType type, double price) {
        	if (row >= 0 && row < seats.length) {
            		for (Seat seat : seats[row]) {
                		seat.setSeattype(type);
                		seat.setPrice(price);
            		}
            		System.out.println("Row #" + (row + 1) + " updated to " + type + " at PKR " + price);
        	}
    	}

	
   	public boolean bookSeat(String seatID) {
       		for (int i = 0; i < seats.length; i++) {
            		for (int j = 0; j < seats[i].length; j++) {
                		if (seats[i][j].getId().equals(seatID)) {
                    			if(seats[i][j].isAvailable()) {
                        			seats[i][j].bookSeat();
                        			return true;
                    			}
					else{
                        			System.out.println("Seat is already booked!");
                        			return false;
                    			}
                		}
            		}
       		 }
        	System.out.println("Seat not found!");
        	return false;
    	}


    	public boolean bookSeat(int row,int col) {
		if ( seats[row][col].isAvailable()){
		   	seats[row][col].bookSeat();
			return true;
          	}
		else{
     			System.out.println( " Seat is already booked ! " ) ;
   			return false; 
		}
	}

    	public boolean cancelSeat(String seatID) {
       		for (int i = 0; i < seats.length; i++) {
            		for (int j = 0; j < seats[i].length; j++) {
                		if (seats[i][j].getId().equals(seatID)) {
                    			if(seats[i][j].isBooked()) {
                        			seats[i][j].cancelBooking();
                        			return true;
                    			}
					else{
                        			System.out.println("Seat is not booked!");
                        			return false;
                    			}
                		}
            		}
       		 }
        	System.out.println("Seat not found!");
        	return false;
    	}

    	public boolean cancelSeat(int row, int col) {
		if (seats[row][col].isBooked()){
		   	seats[row][col].cancelBooking();
			return true;
          	}
		else{
     			System.out.println( " Seat is not booked ! " ) ;
   			return false; 
		}
    	}

    	public void checkBound(int row, int col) {
        	if (row < 0 || row >= seats.length) {
            		System.out.println("Invalid row position");
        	}
        	if (col < 0 || col >= seats[row].length) {
            		System.out.println("Invalid column position");
        	}
    	}

    	public void checkRow(int row) {
        	if (row >= 0 && row < seats.length) {
            		System.out.println("Row " + row + " found.");
        	}
		else {
           		System.out.println("No such row found.");
        	}
    	}

    	public void displayLayout() {
        	for (int i = 0; i < seats.length; i++) {
            		System.out.print("Row " + (i + 1) + ": ");
            			for (Seat seat : seats[i]) {
                			System.out.print("[" + seat.getSeattype() + "]");
            			}
            		System.out.println();
        	}
    	}

    	public void displayDetailed() {
        	System.out.println("--------------------------- Detailed printing of seats (" + screenName + ")----------------------------\n");
        		for (Seat[] row : seats) {
            			for (Seat seat : row) {
                			System.out.println(seat);
            			}
        		}
    	}
}