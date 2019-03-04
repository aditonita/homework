package homework_23_02_2019;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

public class Bank {

	private Accounts bankAcounts = new Accounts();
	private String name;

	
	public Bank(String name) {
		this.name = name;
		String line;
		String[] client;
		String cardNumber;
		String firstName;
		String lastName;
		String acount;
		double amount;
		String pin;

		try (BufferedReader br = new BufferedReader(
				new FileReader("..\\homework\\src\\homework_23_02_2019\\clients.txt"))) {
			while ((line = br.readLine()) != null) {
				client = line.split("[|]");
				cardNumber = client[1].trim();
				firstName = client[2].trim();
				lastName = client[3].trim();
				acount = client[4].trim();
				amount = Double.parseDouble(client[5].trim());
				pin = client[6].trim();
				bankAcounts.addCustomer(new Customer(cardNumber, firstName, lastName, acount, amount, pin));
			}
		} catch (IOException e) {
			e.getStackTrace();
		}
		
		
	}

	public Accounts getBankAcounts() {
		return bankAcounts;
	}

	public String getName() {
		return name;
	}

	public void saveAccounts() {
		try (BufferedWriter bw = new BufferedWriter(
				new FileWriter("..\\homework\\src\\homework_23_02_2019\\clients.txt"))) {
			Iterator<Customer> it = bankAcounts.getCustomers().iterator();
			while(it.hasNext()) {
				bw.write(it.next().toString());
			}
			
		} catch (IOException ex) {
			System.out.println(ex.getStackTrace());
		}
	}

	public void updateCustomer(Customer customer) {
		bankAcounts.setCustomer(customer);
	}
	
}
