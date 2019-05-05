package homework_06_04_2019.atm;

import java.util.*;

public class Customer {

	private String clientId;
	private String firstName;
	private String lastName;
	private String address;

	/**
	 * 
	 * @author Adi
	 * @param clientId
	 * @param firstName
	 * @param lastName
	 * @param address
	 */
	public Customer(String clientId, String firstName, String lastName, String address) {
		this.clientId = clientId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;

	}

	public String getClientId() {
		return clientId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
}
