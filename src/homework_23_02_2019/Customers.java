package homework_23_02_2019;

import java.util.*;

public class Customers {
	private Map<Long, Customer> bankCustomers = new HashMap<Long, Customer>();

	public void addCustomer(Customer customer) {
		bankCustomers.put(customer.getCardNumber(), customer);
	}

	public Customer getCustomer(long cardNumber) {
		return bankCustomers.get(cardNumber);
	}

	public void setCustomer(Customer customer) {
		bankCustomers.replace(customer.getCardNumber(), customer);
	}

	public List<Customer> getCustomers() {
		List<Customer> customerList = new ArrayList<Customer>();
		bankCustomers.forEach((cardNumber, bankCustomer) -> customerList.add(bankCustomer));
		return customerList;
	}

	public Map<Long, Customer> getBankCustomers() {
		return bankCustomers;
	}

}
