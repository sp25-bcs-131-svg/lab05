package sp25_bcs_131;

public class Cinema{

	Screen[] screens;
	String cinemaName;
	int noOfScreen;

	public Cinema(String cinemaName,int n){
		this.cinemaName=cinemaName;
		this.screens=new Screen[n];
		this.noOfScreen=0;
		for(int i=0;i<screens.length;i++){
			screens[i]=new Screen("Screen :"+ (i+1));
		}
	}

	public Screen findScreenByName(String cinemaName){
		for(int i=0;i<screens.length;i++){
			if(screens[i].getScreenName().equals(cinemaName)){
				return screens[i];
			}
		}
		return null;
	}

	public String getCinemaName(){
		return this.cinemaName;
	}

	public Screen[] getScreen(){
		return screens;
	}

	public Screen findbyIndex(int index){
		if(index>=0 && index<screens.length){
			return screens[index];
		}
		else{
			System.out.println("Index out of bounds");
			return null;
		}
	}

	public boolean bookScreen(String cinemaName,int row,int col){
		for(int i=0;i<screens.length;i++){
			if(screens[i].getScreenName().equals(cinemaName)){
				screens[i].bookSeat(row,col);
				return true;
			}
		}
		return false;
	}
	
	public boolean cancelScreen(String cinemaName,int row,int col){
		for(int i=0;i<screens.length;i++){
			if(screens[i].getScreenName().equals(cinemaName)){
				screens[i].cancelSeat(row,col);
				return true;
			}
		}
		return false;
	}		

	public int totalSeats(){
		int total=0;
		for(int i=0;i<screens.length;i++){
			total+=screens[i].getTotalSeats();
		}
		return total;
	}

	public int getAvailableSeats(){
		int available=0;
		for(int i=0;i<screens.length;i++){
			available+=screens[i].getAvailableSeatCount();
		}
		return available;
	}

	public int totalSeats(SeatType type){
		int total=0;
		for(int i=0;i<screens.length;i++){
			total+=screens[i].getTotalSeats(type);
		}
		return total;
	}

	public int getAvailableSeats(SeatType type){
		int available=0;
		for(int i=0;i<screens.length;i++){
			available+=screens[i].getAvailableSeatCount(type);
		}
		return available;
	}

	public void addScreen(Screen screen){
		if(noOfScreen==screens.length){
			Screen[] newScreens=new Screen[screens.length*2];
			for(int i=0;i<screens.length;i++){
				newScreens[i]=screens[i];
			}
			this.screens=newScreens;
		}
		screens[noOfScreen]=screen;
		noOfScreen++;
	}
		

	public void display(){
		for(int i=0;i<screens.length;i++){
			System.out.println(" "+ screens[i].getScreenName());
			screens[i].displayLayout();
		}
	}

	public void displayDetails(){
		for(int i=0;i<screens.length;i++){
			System.out.println(" "+ screens[i].getScreenName());
			screens[i].displayDetailed();
		}
	}


	@Override
	public String toString(){
		return String.format("Cinema: %s-----Screens: %d-----Total Seats: %d-----Available Seats: %d-----",cinemaName,screens.length,totalSeats(),getAvailableSeats());
	}
}
	



		

	
			
		

