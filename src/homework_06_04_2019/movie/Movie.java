package homework_06_04_2019.movie;

public class Movie {
	private String movieId;
	private String movieName;
	private int year;
	private int rating;
	
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movie_id) {
		this.movieId = movie_id;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movie_name) {
		this.movieName = movie_name;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
}
