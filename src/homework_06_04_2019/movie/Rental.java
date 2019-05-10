package homework_06_04_2019.movie;

public class Rental {
	int cid;
	String movieId;
	String status;
	int rentedTime;

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getRentedTime() {
		return rentedTime;
	}

	public void setRentedTime(int rentedTime) {
		this.rentedTime = rentedTime;
	}

}
