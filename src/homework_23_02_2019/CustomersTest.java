package homework_23_02_2019;

import static org.junit.Assert.*;

import org.junit.Test;

public class CustomersTest {

	private Customer setCustomer() {
		return new Customer(1234567812345678L, "Adi", "Tonita", "RO90BTRL000678945", 93.25d, 1234);

	}

	@Test
	public void testaddCustomer() {
		Customer customer = setCustomer();
		Customers bankCustomers = new Customers();
		bankCustomers.addCustomer(customer);
		assertEquals(customer, bankCustomers.getBankCustomers().get(customer.getCardNumber()));
	}

	@Test
	public void testsetCustomer() {
		Customer customer = setCustomer();
		Customers bankCustomers = new Customers();
		bankCustomers.addCustomer(customer);
		System.out.println(customer.getAmount());
		customer.setAmount(12d);
		bankCustomers.setCustomer(customer);
		System.out.println(customer.getAmount() + " "
				+ bankCustomers.getBankCustomers().get(customer.getCardNumber()).getAmount());
		assertEquals(customer.getAmount(), bankCustomers.getBankCustomers().get(customer.getCardNumber()).getAmount(),
				0.05d);
	}

}
