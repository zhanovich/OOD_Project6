import java.lang.reflect.*;
import java.util.*;

public class MoviePickTestDrive {
	
HashMap<String, MoviePick> MoviePickList = new HashMap<String, MoviePick>();
 	
	public static void main(String[] args) {
		MoviePickTestDrive test = new MoviePickTestDrive();
		test.infoFromDB();
	}
 
	public MoviePickTestDrive() {
		initializeDatabase();
	}

	public void infoFromDB() {
//		First customer
		MoviePick selection = getNameFromDB("Georgy Loriya"); 
		MoviePick ownerProxy = getOwnerProxy(selection);
		System.out.println("Cusotmer name is " + ownerProxy.getCustomerName());
		ownerProxy.setMovieGenre("Thriller");
		System.out.println("Proxy Owner set movie pick to " + ownerProxy.getMovieGenre());
		try {
			ownerProxy.setMovieRating("PG13");
			System.out.println("Proxy Owner set movie rating to " + ownerProxy.getMovieRating());
		} catch (Exception e) {
			System.out.println("Movie rating cannot be set. Please try again");
		}
//		Second customer
		selection = getNameFromDB("Thomas Billion"); 
		MoviePick nonOwnerProxy = getNonOwnerProxy(selection);
		System.out.println("Customer Name is " + nonOwnerProxy.getCustomerName());
		try {
			nonOwnerProxy.setMovieGenre("Comedy");
			System.out.println("Proxy Owner set movie pick to " + nonOwnerProxy.getMovieGenre());
		} catch (Exception e) {
			System.out.println("Movie pick cannot be set. Please try again");
		}
		nonOwnerProxy.setMovieRating("R");
		System.out.println("Non proxy set movie rating to " + nonOwnerProxy.getMovieRating());
//		Third customer
		selection = getNameFromDB("James Toby"); 
		MoviePick nonOwnerProxy2 = getNonOwnerProxy(selection);
		System.out.println("Customer Name is " + nonOwnerProxy2.getCustomerName());
		try {
			nonOwnerProxy2.setMovieGenre("Documentary");
			System.out.println("Non Proxy Owner set movie pick to " + nonOwnerProxy2.getMovieGenre());
		} catch (Exception e) {
			System.out.println("Movie pick cannot be set. Please try again");
		}
		nonOwnerProxy2.setMovieRating("PG");
		System.out.println("Non proxy set movie rating to " + nonOwnerProxy2.getMovieRating());
	}

	MoviePick getOwnerProxy(MoviePick preference) {
 		
        return (MoviePick) Proxy.newProxyInstance( 
            	preference.getClass().getClassLoader(),
            	preference.getClass().getInterfaces(),
                new OwnerProxy(preference));
	}

	MoviePick getNonOwnerProxy(MoviePick preference) {
		
        return (MoviePick) Proxy.newProxyInstance(
            	preference.getClass().getClassLoader(),
            	preference.getClass().getInterfaces(),
                new NonOwnerProxy(preference));
	}

	MoviePick getNameFromDB(String name) {
		return (MoviePick)MoviePickList.get(name);
	}

	void initializeDatabase() {
		MoviePick customer1 = new MoviePickImplementation();
		customer1.setCustomerName("Georgy Loriya");
		customer1.setMovieGenre("Thriller");
		customer1.setMovieRating("PG13");
		MoviePickList.put(customer1.getCustomerName(), customer1);
		
		MoviePick customer2 = new MoviePickImplementation();
		customer2.setCustomerName("Thomas Billion");
		customer2.setMovieGenre("Comedy");
		customer2.setMovieRating("R");
		MoviePickList.put(customer2.getCustomerName(), customer2);
		
		MoviePick customer3 = new MoviePickImplementation();
		customer3.setCustomerName("James Toby");
		customer3.setMovieGenre("Documentary");
		customer3.setMovieRating("PG");
		MoviePickList.put(customer3.getCustomerName(), customer3);
	}

}