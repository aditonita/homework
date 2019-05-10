package homework_06_04_2019.movie;

import java.util.*;

import javafx.scene.chart.PieChart.Data;

public class Solution {

	private static Scanner sc = new Scanner(System.in);
	private static final int cid = getClientCid();

	public static void main(String[] args) {
		boolean isExit = false;
		char action;
		String movie;
//		listClients();

		while (!isExit) {
			sc.useDelimiter("\n");
			action = sc.next().charAt(0);
			switch (action) {
			case 's':
				movie = sc.next();
				searchMovie(movie);
				break;
			case 'p':
				setClientPlan();
				break;
			case 'r':
				rentMovie();
				break;
			case 'x':
				isExit = true;
				break;
			case 'X':
				isExit = true;
				break;
			default:
				System.out.println(
						"press:\n    - s to search movie\n    - p to change customer plan\n    - r to rent a movie\n"
								+ "    - x to exit");
			}
		}

	}

	private static void rentMovie() {
		sc.reset();
		sc.useDelimiter("\n");
		System.out.print("enter movie name: ");
		String movieName = sc.next().trim();
		listMovieIds(movieName);
		System.out.print("enter movie Id: ");
		String movieId = sc.next().trim();
		rentMovie(movieId);
	}

	private static void listMovieIds(String movieName) {
		Database db = new Database();
		List<Movie> movies = db.getMovieIds(movieName);
		movies.forEach(m -> System.out.format("%-20s    %-20s%n", m.getMovieId(), m.getMovieName()));
	}

	private static void rentMovie(String movieId) {
		Movie movie = getMovie(movieId);
		if (isRented(movie.getMovieId())) {
				System.out.println("Movie '" + movie.getMovieName() + "' is already rented");
			return;
		}else if (isFirstRent(movie.getMovieId())) {
			rentMovie(cid, movie.getMovieId(), true);
			return;
		} else {
			rentMovie(cid, movie.getMovieId(), false);
		}
	}

	private static void rentMovie(int cid, String movieId, boolean actionInsertUpdate) {
		Database db = new Database();
		Rental rental = new Rental();
		rental = db.getRental(movieId);
		if (actionInsertUpdate) {
			if (db.insertMovieRental(cid, movieId) > 0) {
				System.out.println("Movie '" + movieId + "' is rented to client Id " + cid);
			}
		}
		if (!actionInsertUpdate) {
			if (db.updateMovieRental(cid, rental) > 0) {
				System.out.println("Movie '" + rental.getMovieId() + "' is rented to client Id " + cid);
			}
		}
	}

	private static boolean isFirstRent(String movieId) {
		Database db = new Database();
		return db.rentalStatus(movieId, true);
	}

	private static boolean isRented(String movieId) {
		Database db = new Database();
		return db.rentalStatus(movieId, false);
	}

	private static Movie getMovie(String movieId) {
		Database db = new Database();
		return db.getMovie(movieId);
	}

	private static int getClientCid() {
		listClients();
		sc.reset();
		System.out.print("Enter your CID number: ");
		return sc.nextInt();
	}

	private static void setClientPlan() {
		List<Plan> plans = getPlans();
		System.out.format("%-20s    %-20s    %-20s    %-20s%n", "PLAN_ID", "NAME", "MAX_RENTALS", "MONTHLY_FEE");
		plans.forEach(p -> System.out.format("%-20s    %-20s    %-20s    %-20s%n", p.getPlanId(), p.getPlanName(),
				p.getMaxRentals(), p.getMonthlyFee()));
		System.out.print("Enter your plan Id: ");
		sc.reset();
		int planId = sc.nextInt();
		if (containsId(plans, planId)) {
			setClientPlanId(planId);
		}

	}

	private static void setClientPlanId(int planId) {
		Database db = new Database();
		int rows = db.updateClientPlanId(cid, planId);
		if (rows > 0) {
			System.out.println("Customer " + getClient(cid).getFirstName() + "," + getClient(cid).getLastName()
					+ " has new plan: " + getPlan(planId).getPlanName());
		}
	}

	private static Plan getPlan(int planId) {
		Database db = new Database();
		return db.getPlan(planId);
	}

	private static Client getClient(int customerCid) {
		Database db = new Database();
		return db.getClient(customerCid);
	}

	private static void listClients() {
		List<Client> clients = getClients();
		System.out.format("%-20s    %-20s    %-20s%n", "CID", "FIRST_NAME", "LAST_NAME");
		clients.forEach(
				c -> System.out.format("%-20s    %-20s    %-20s%n", c.getCid(), c.getFirstName(), c.getLastName()));
	}

	private static List<Client> getClients() {
		Database db = new Database();
		return db.getClients();
	}

	private static boolean containsId(List<Plan> plans, int planId) {
		for (Plan p : plans) {
			if (planId == p.getPlanId()) {
				return true;
			}
		}
		return false;
	}

	private static List<Plan> getPlans() {
		Database db = new Database();
		return db.getPlans();
	}

	private static void searchMovie(String movieName) {
		List<Movie> movies = new ArrayList<>();
		List<Producer> producers = new ArrayList<>();
		List<Actor> actors = new ArrayList<>();
		String movie_id;

		Database db = new Database();

		movies = db.getMovies(movieName);
		for (Movie m : movies) {
			movie_id = m.getMovieId();
			producers = db.getProducers(movie_id);
			actors = db.getActors(movie_id);
			System.out.format("MOVIE: %s%n", m.getMovieName());
			System.out.println("    PRODUCERS:");
			producers.forEach(p -> System.out.format("        %s%n", p.getProducer_name()));
			System.out.println("    ACTORS:");
			actors.forEach(a -> System.out.format("        %s%n", a.getActor_name()));
		}

	}

}
