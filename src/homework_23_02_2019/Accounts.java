package homework_23_02_2019;

import java.util.*;

public class Accounts {
	private Map<String, Customer> bankAccounts = new HashMap<String, Customer>();

	public void addCustomer(Customer customer) {
		bankAccounts.put(customer.getCardNumber(), customer);
	}

	public Customer getCustomer(String cardNumber) {
		return bankAccounts.get(cardNumber);
	}

	public void setCustomer(Customer customer) {
		bankAccounts.replace(customer.getCardNumber(), customer);
	}

	public List<Customer> getCustomers() {
		List<Customer> customerList = new ArrayList<Customer>();
		bankAccounts.forEach((cardNumber, bankCustomer) -> customerList.add(bankCustomer));
		return customerList;
	}

	public Map<String, Customer> getBankCustomers() {
		return bankAccounts;
	}

}
