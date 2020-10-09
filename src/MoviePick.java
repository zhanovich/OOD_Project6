public interface MoviePick {
	String getCustomerName();
	String getMovieGenre();
	String getMovieRating();
 
    void setCustomerName(String name);
    void setMovieGenre(String genre);
    void setMovieRating(String rating); 
}