package homework_23_02_2019;

import static org.junit.Assert.*;

import org.junit.Test;

public class BankTest {

	@Test
	public void testgetBankAcounts() {
		Bank bank = new Bank("ING");
//		bank.getBankAcounts().getCustomers().forEach(c -> System.out.println(c));
		assertEquals("test",bank.getBankAcounts().getCustomer("0000000000000000").getFirstName());
	}

	@Test
	public void testupdateCustomer() {
		Bank bank = new Bank("ING");
		String newPin = "9999";
		Customer customer = bank.getBankAcounts().getCustomer("0000000000000000");
		
		customer.setPin(newPin);
		bank.updateCustomer(customer);
		customer=bank.getBankAcounts().getCustomer("0000000000000000");
		
		assertEquals(newPin,customer.getPin());
	}

}
;