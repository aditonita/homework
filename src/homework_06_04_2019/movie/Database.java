package homework_06_04_2019.movie;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {

	public List<Movie> getMovies(String movieName) {
		List<Movie> movies = new ArrayList<>();
		String sql = "SELECT m.movie_id, m.movie_name, m.YEAR, m.rating FROM movie_info m WHERE UPPER(m.movie_name) LIKE ?";
		try (Connection cn = getConnection()) {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, '%' + movieName.trim().toUpperCase() + '%');
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Movie movie = new Movie();

				movie.setMovieId(rs.getString("movie_id"));
				movie.setMovieName(rs.getString("movie_name"));
				movie.setRating(rs.getInt("year"));
				movie.setRating(rs.getInt("rating"));

				movies.add(movie);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return movies;
	}

	public List<Producer> getProducers(String movie_id) {
		List<Producer> producers = new ArrayList<>();
		String sql = "SELECT DISTINCT p.producer_id, p.producer_name FROM producer_ids p, producer_movies pm "
				+ "WHERE p.producer_id = pm.producer_id AND pm.movie_id = ? ";

		try (Connection cn = getConnection()) {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, movie_id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Producer producer = new Producer();

				producer.setProducer_id(rs.getString("producer_id"));
				producer.setProducer_name(rs.getString("producer_name"));

				producers.add(producer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return producers;
	}

	public List<Actor> getActors(String movie_id) {
		List<Actor> actors = new ArrayList<>();
		String sql = "SELECT DISTINCT  a.actor_id, a.actor_name, a.gender FROM  actor_ids a, actor_movies am "
				+ "WHERE a.actor_id = am.actor_id AND am.movie_id = ?";
		try (Connection cn = getConnection()) {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, movie_id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Actor actor = new Actor();

				actor.setActorId(rs.getString("actor_id"));
				actor.setActorName(rs.getString("actor_name"));
				actor.setGender(rs.getString("gender"));

				actors.add(actor);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actors;
	}

	public List<Plan> getPlans() {
		List<Plan> plans = new ArrayList<>();
		String sql = "SELECT p.plan_id, p.NAME, p.max_rentals, p.monthly_fee FROM plan p";
		try (Connection cn = getConnection()) {
			Statement statement = cn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				Plan plan = new Plan();

				plan.setPlanId(rs.getInt("plan_id"));
				plan.setPlanName(rs.getString("NAME"));
				plan.setMaxRentals(rs.getInt("max_rentals"));
				plan.setMonthlyFee(rs.getInt("monthly_fee"));

				plans.add(plan);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return plans;
	}

	private Connection getConnection() {
		DriverManager.setLoginTimeout(10);
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/movie", "root", "password");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int updateClientPlanId(int cid, int planId) {
		String sql = "UPDATE customer SET rental_plan = ? WHERE cid = ?";
		try (Connection cn = getConnection()) {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setInt(1, planId);
			ps.setInt(2, cid);
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public List<Client> getClients() {
		List<Client> clients = new ArrayList<>();
		String sql = "SELECT c.login, c.cid, c.PASSWORD, c.first_name, c.last_name, c.rental_plan FROM customer c";
		try (Connection cn = getConnection()) {
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Client client = new Client();

				client.setLogin(rs.getString("login"));
				client.setCid(rs.getInt("cid"));
				client.setPassword(rs.getString("PASSWORD"));
				client.setFirstName(rs.getString("first_name"));
				client.setLastName(rs.getString("last_name"));
				client.setRentalPlan(rs.getInt("rental_plan"));

				clients.add(client);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clients;
	}

	public Plan getPlan(int planId) {
		Plan plan = new Plan();
		String sql = "SELECT p.plan_id, p.NAME, p.max_rentals, p.monthly_fee FROM plan p WHERE p.plan_id = ?";
		try (Connection cn = getConnection()) {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setInt(1, planId);
			ResultSet rs = ps.executeQuery();
			if (rs.first()) {
				plan.setPlanId(rs.getInt("plan_id"));
				plan.setPlanName(rs.getString("NAME"));
				plan.setMaxRentals(rs.getInt("max_rentals"));
				plan.setMonthlyFee(rs.getInt("monthly_fee"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return plan;
	}

	public Client getClient(int customerCid) {
		Client client = new Client();
		String sql = "SELECT c.login, c.cid,c.PASSWORD,c.first_name,c.last_name,c.rental_plan FROM customer c WHERE c.cid = ?";
		try (Connection cn = getConnection()) {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setInt(1, customerCid);
			ResultSet rs = ps.executeQuery();
			if (rs.first()) {
				client.setLogin("login");
				client.setCid(rs.getInt("cid"));
				client.setPassword(rs.getString("PASSWORD"));
				client.setFirstName(rs.getString("first_name"));
				client.setLastName(rs.getString("last_name"));
				client.setRentalPlan(rs.getInt("rental_plan"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return client;
	}

	public List<Movie> getMovieIds(String movieName) {
		List<Movie> movies = new ArrayList<>();
		String sql = "SELECT m.movie_id, m.movie_name, m.YEAR, m.rating FROM movie_info m WHERE UPPER(m.movie_name) LIKE ?";
		try (Connection cn = getConnection()) {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, '%' + movieName.trim().toUpperCase() + '%');
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Movie movie = new Movie();
				movie.setMovieId(rs.getString("movie_id"));
				movie.setMovieName(rs.getString("movie_name"));
				movie.setYear(rs.getInt("YEAR"));
				movie.setRating(rs.getInt("rating"));

				movies.add(movie);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return movies;
	}

	public Movie getMovie(String movieId) {
		Movie movie = new Movie();
		String sql = "SELECT m.movie_id, m.movie_name, m.YEAR, m.rating FROM movie_info m WHERE m.movie_id = ?";
		try (Connection cn = getConnection()) {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, movieId);
			ResultSet rs = ps.executeQuery();
			if (rs.first()) {
				movie.setMovieId(rs.getString("movie_id"));
				movie.setMovieName(rs.getString("movie_name"));
				movie.setYear(rs.getInt("YEAR"));
				movie.setRating(rs.getInt("rating"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return movie;
	}

	public boolean rentalStatus(String movieId, boolean firstRent) {
		String sql = "SELECT r.`status` FROM rental r WHERE r.movie_id = ?";
		try (Connection cn = getConnection()) {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, movieId);
			ResultSet rs = ps.executeQuery();
			if (!firstRent && rs.first()) {
				if (rs.getString(1).equals("closed")) {
					return true;
				}
			}
			if (firstRent && !rs.first()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public Rental getRental(String movieId) {
		Rental rent = new Rental();
		String sql = "SELECT r.cid, r.movie_id, r.`status`, r.rented_times FROM rental r WHERE r.movie_id = ?";
		try (Connection cn = getConnection()) {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, movieId);
			ResultSet rs = ps.executeQuery();
			if (rs.first()) {
				rent.setCid(rs.getInt("cid"));
				rent.setMovieId(rs.getString("movie_id"));
				rent.setStatus(rs.getString("status"));
				rent.setRentedTime(rs.getInt("rented_times"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rent;
	}

	public int insertMovieRental(int cid, String movieId) {
		String sql = "INSERT INTO rental (cid, movie_id, `status`, rented_times) VALUES (?, ?, ?, ?)";
		try (Connection cn = getConnection()) {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setInt(1, cid);
			ps.setString(2, movieId);
			ps.setString(3, "closed");
			ps.setInt(4, 1);
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int updateMovieRental(int cid, Rental rental) {
		String sql = "UPDATE rental SET cid=?, `status`=?, rented_times=? WHERE movie_id=?";
		try (Connection cn = getConnection()) {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setInt(1, cid);
			ps.setString(2, "closed");
			ps.setInt(3, rental.getRentedTime() + 1);
			ps.setString(4, rental.getMovieId());
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
