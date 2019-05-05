package homework_06_04_2019.atm;

import java.util.*;

public class Account {
	private int accountId;
	private String clientId;
	private String accountNumber;
	private double amount;
	private boolean active;

	public Account(String clientId, String accountNumber, double amount, boolean active) {
		this.clientId = clientId;
		this.accountNumber = accountNumber;
		this.amount = amount;
		this.active = active;
	}

	public Account(int accountId, String clientId, String accountNumber, double amount, boolean active) {
		this(clientId, accountNumber, amount, active);
		this.accountId = accountId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountNumber == null) ? 0 : accountNumber.hashCode());
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
		Account other = (Account) obj;
		if (accountNumber == null) {
			if (other.accountNumber != null)
				return false;
		} else if (!accountNumber.equals(other.accountNumber))
			return false;
		return true;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getAccountId() {
		return accountId;
	}

	public String getClientId() {
		return clientId;
	}

	public void update() {
		Database db = new Database();
		db.updateCustomerAccount(this);
	}

}
