package homework_23_02_2019;

public class Customer {

	private String cardNumber;
	private String firstName;
	private String lastName;
	private String acont;
	private double amount;
	private String pin;

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
	public Customer(String cardNumber, String firstName, String lastName, String acount, double amount, String pin) {
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

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getCardNumber() {
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

	@Override
	public String toString() {
		String row = "";
		row += "| " + cardNumber + " | " + firstName;
		for (int i = 0; i < 25 - firstName.length(); i++) {
			row += " ";
		}
		row += " | " + lastName;
		for (int i = 0; i < 25 - lastName.length(); i++) {
			row += " ";
		}
		row += " | " + acont;
		for (int i = 0; i < 25 -acont.length(); i++) {
			row += " ";
		}
		row += " | ";
		for (int i = 0; i < 25 - ((Double) this.amount).toString().length(); i++) {
			row += " ";
		}
		row += " " + ((Double) this.amount).toString() + " | " + pin + " |\n";

		return row;
	}

}
