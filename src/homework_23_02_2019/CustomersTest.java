package homework_23_02_2019;

import static org.junit.Assert.*;

import org.junit.Test;

public class CustomersTest {

	private Customer setCustomer() {
		return new Customer("1234567812345678", "Adi", "Tonita", "RO90BTRL000678945", 93.25d, "1234");

	}

	@Test
	public void testaddCustomer() {
		Customer customer = setCustomer();
		Accounts bankCustomers = new Accounts();
		bankCustomers.addCustomer(customer);
		assertEquals(customer, bankCustomers.getBankCustomers().get(customer.getCardNumber()));
	}

	@Test
	public void testsetCustomer() {
		Customer customer = setCustomer();
		Accounts bankCustomers = new Accounts();
		bankCustomers.addCustomer(customer);
		customer.setAmount(12d);
		bankCustomers.setCustomer(customer);
		assertEquals(customer.getAmount(), bankCustomers.getBankCustomers().get(customer.getCardNumber()).getAmount(),
				0.05d);
	}

	@Test
	public void testgetCustomers() {
		Customer customer = setCustomer();
		Accounts bankCustomers = new Accounts();
		bankCustomers.addCustomer(customer);
		String customerName = bankCustomers.getCustomers().get(0).getFirstName();
		assertEquals("Adi", customerName);
	}

	@Test
	public void testgetBankCustomers() {
		Customer customer = setCustomer();
		Accounts bankCustomers = new Accounts();
		bankCustomers.addCustomer(customer);
		assertEquals("RO90BTRL000678945", bankCustomers.getBankCustomers().get("1234567812345678").getAcont());
	}
}
