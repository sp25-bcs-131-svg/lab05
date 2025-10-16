package sp25_bcs_131;

public class CityCinema{

	String cityName;
	Cinema[] cinemas;
	int noOfCinema;

	public CityCinema(String cityName,int n){
		this.cityName=cityName;
		noOfCinema=0;
		cinemas=new Cinema[4];
		for(int i=0;i<cinemas.length;i++){
			cinemas[i]=new Cinema("Cinema :"+(i+1),3);
			noOfCinema++;
		}
	}

	public Cinema findCinema(String screenName){
		for(int i=0;i<cinemas.length;i++){
			if(cinemas[i].getCinemaName().equals(screenName)){
			return  cinemas[i];
			}
		}
		return null;
	}

	public Cinema[] getCinema(){
		Cinema[] currentCinemas=new Cinema[noOfCinema];
		for(int i=0;i<noOfCinema;i++){
			currentCinemas[i]=cinemas[i];
		}
		return currentCinemas;
	}

	public void addCinema(Cinema cinema){
		if(noOfCinema==cinemas.length){
			Cinema[] newCinemas=new Cinema[cinemas.length*2];
			for(int i=0;i<cinemas.length;i++){
				newCinemas[i]=cinemas[i];
			}
			this.cinemas=newCinemas;
		}
		cinemas[noOfCinema]=cinema;
		noOfCinema++;
	}

	public boolean bookCinemaSeat(String cityName,int row,int col){
		for(int i=0;i<cinemas.length;i++){
			if(cinemas[i].getCinemaName().equals(cityName)){
				cinemas[i].bookScreen(cityName,row,col);
				return true;
			}
		}
		return false;
	}

	public boolean cancelCinemaSeat(String cityName,int row,int col){
		for(int i=0;i<cinemas.length;i++){
			if(cinemas[i].getCinemaName().equals(cityName)){
				cinemas[i].cancelScreen(cityName,row,col);
				return true;
			}
		}
		return false;
	}

	public String findFirstVIP(){
		for(int i=0;i<cinemas.length;i++){
			Cinema c1=cinemas[i];
			Screen[] s1=c1.getScreen();
			for(int j=0;j<s1.length;j++){
				Screen s2=s1[j];
				Seat[][] seats=s2.getSeats();
				for(int r=0;r<seats.length;r++){
					for(int k=0;k<seats[r].length;k++){
						Seat seat=seats[r][k];
						if(seat.getSeattype()==SeatType.VIP && seat.isAvailable()){
							return String.format("%s---%s---Seat: %d-%03d(%s,%.2f PKR)",c1.getCinemaName(),s2.getScreenName(),r,k,seat.getSeattype(),seat.getPrice());
						}
					}
				}
			}
		}
		return String.format("No such type of seat is available in "+ this.cityName);
	}

	public void displayCinema(){
		System.out.println("City: " + cityName.toUpperCase());
   		System.out.println("Total Cinemas: " + noOfCinema);
    		System.out.println("\n--- Cinemas Overview ---\n");

    		for (int i = 0; i < noOfCinema; i++) {
       			 Cinema cinema = cinemas[i];
        		 System.out.println("Cinema Name: " + cinema.getCinemaName());
        		 Screen[] screens = cinema.getScreen();
       			 System.out.println("Total Screens: " + screens.length);
       			 System.out.println("Total Seats: " + cinema.totalSeats());
       			 System.out.println("Available Seats: " + cinema.getAvailableSeats());
        		 System.out.println("Screen Details:");

        				for (Screen screen : screens){
            					System.out.println("  - Screen Name: " + screen.getScreenName());
            					System.out.println("    Total Seats: " + screen.getTotalSeats());
            					System.out.println("    Available Seats: " + screen.getAvailableSeatCount());
        				}

       			 System.out.println("\n-----------------------------\n");
		}
	}
}










		

	
