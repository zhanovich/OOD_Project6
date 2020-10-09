public class MoviePickImplementation implements MoviePick{
	
	String name;
	String genre;
	String rating;
	
	public String getCustomerName() {
		return name;
	}

	public String getMovieGenre() {
		return genre;
	}
	
	public String getMovieRating() {
		return rating;
	}
	
	public void setCustomerName(String name) {
		this.name = name;	
	}

	public void setMovieGenre(String genre) {
		this.genre = genre;
	}
	
	public void setMovieRating(String rating) {
		this.rating = rating;		
	}
}