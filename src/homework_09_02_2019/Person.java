package homework_09_02_2019;

public class Person {
	private String firstName;
	private String lastName;
	private long cnp;
	private String country;
/**
 * @param firstName
 * @param lastName
 * @param cnp
 * @param country
 */
	public Person(String firstName, String lastName, long cnp, String country) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.cnp = cnp;
		this.country = country;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public double getCnp() {
		return cnp;
	}

	public String getCountry() {
		return country;
	}

}
