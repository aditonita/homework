package homework_23_02_2019;

public class Customer {

	private long cardNumber;
	private String firstName;
	private String lastName;
	private String acont;
	private double amount;
	private int pin;

	/**
	 * 
	 * @author adi
	 * 
	 * @param cardNumber
	 * @param firstName
	 * @param lastName
	 * @param acount
	 * @param amount
	 * @param pin
	 */
	public Customer(long cardNumber, String firstName, String lastName, String acount, double amount, int pin) {
		this.cardNumber = cardNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.acont = acount;
		this.amount = amount;
		this.pin = pin;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public long getCardNumber() {
		return cardNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAcont() {
		return acont;
	}

}
