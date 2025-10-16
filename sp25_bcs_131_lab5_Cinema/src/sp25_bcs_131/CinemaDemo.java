package sp25_bcs_131;

public class CinemaDemo{
	public static void main(String args[]){
		CityCinema cinema  = new CityCinema("Lahore",2);
		Cinema c = new Cinema ("Cinepax",4);
		c.displayDetails();
		cinema.displayCinema();
	}
}