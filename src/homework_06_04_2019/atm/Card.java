/**
 * 
 */
package homework_06_04_2019.atm;

/**
 * @author adi
 *
 */
public class Card {
	private int cardId;
	private int accountId;
	private String cardNumber;
	private String pinNumber;
	private boolean active;

	/**
	 * 
	 * @param accountId
	 * @param cardNumber
	 * @param pinNumber
	 * @param active
	 */
	public Card(int accountId, String cardNumber, String pinNumber, boolean active) {
		this.accountId = accountId;
		this.cardNumber = cardNumber;
		this.pinNumber = pinNumber;
		this.active = active;
	}

	/**
	 * 
	 * @param cardId
	 * @param accountId
	 * @param cardNumber
	 * @param pinNumber
	 * @param active
	 */
	public Card(int cardId, int accountId, String cardNumber, String pinNumber, boolean active) {
		this(accountId, cardNumber, pinNumber, active);
		this.cardId = cardId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cardNumber == null) ? 0 : cardNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (cardNumber == null) {
			if (other.cardNumber != null)
				return false;
		} else if (!cardNumber.equals(other.cardNumber))
			return false;
		return true;
	}

	public String getPinNumber() {
		return pinNumber;
	}

	public void setPinNumber(String pinNumber) {
		this.pinNumber = pinNumber;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getCardId() {
		return cardId;
	}

	public int getAccountId() {
		return accountId;
	}

	public void update() {
		Database db = new Database();
		db.updateCustomerCard(this);
	}

}
