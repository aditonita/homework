package homework_23_02_2019;

import java.util.Scanner;

public class ATM {

	private String identities;
	private Scanner sc = new Scanner(System.in);
	private Bank bank;
	private Customer customer;

	public ATM(String identities) {
		this.identities = identities;
		bank = new Bank(identities);
	}

	public void start() {
		if (verifyClientIdentity()) {
			mainMenu();
		}
	}

	private void mainMenu() {

		char choice;
		boolean isExit = false;

		while (!isExit) {
			System.out.println("Welcome to " + bank.getName() + " ATM \n" + "1 - Deposit\n" + "2 - Withdraw\n"
					+ "3 - Account information\n" + "4 - change PIN\n" + "x - Exit");
			choice = sc.next().charAt(0);

			switch (choice) {
			case '1':
				System.out.println("Deposit value: ");
				transactDeposit(Double.parseDouble(sc.next()));
				break;
			case '2':
				System.out.println("Withdraw value: ");
				transactWithdraw(Double.parseDouble(sc.next()));
				break;
			case '3':
				displayAccountInformation();
				break;
			case '4':
				System.out.println("Enter new PIN: ");
				cahngePin(sc.next());
				break;
			case 'x':
				saveBankAccounts();
				isExit = true;
				break;
			case 'X':
				saveBankAccounts();
				isExit = true;
				break;
			}
		}

	}

	private void saveBankAccounts() {
		bank.saveAccounts();
	}

	private void cahngePin(String pin) {
		customer.setPin(pin);
		bank.updateCustomer(customer);
	}

	private void displayAccountInformation() {
		System.out.print(customer.getLastName() + " " + customer.getFirstName());
		System.out.println("Account: " + customer.getAcont());
		System.out.println("Amount: " + customer.getAmount() + " lei");
	}

	private void transactWithdraw(double money) {
		double cashBalance = customer.getAmount();
		cashBalance -= money;
		customer.setAmount(cashBalance);
		bank.updateCustomer(customer);
	}

	private void transactDeposit(double money) {
		double cashBalance = customer.getAmount();
		cashBalance += money;
		customer.setAmount(cashBalance);
		bank.updateCustomer(customer);
	}

	private boolean verifyClientIdentity() {
		boolean isValid = true;
		int tries = 0;
		String cardNumber;
		String pin;
		System.out.println("Please enter your card number: ");
		cardNumber = sc.next();

		if(bank.getBankAcounts().getBankCustomers().get(cardNumber)==null) {
		System.out.println("This card number doesn't exist!!!");
		return false;
		}
		
		while (isValid) {
			System.out.println("Enter PIN number: ");
			pin = sc.next();

			
			if (bank.getBankAcounts().getBankCustomers().get(cardNumber)!=null && bank.getBankAcounts().getBankCustomers().get(cardNumber).getPin().equalsIgnoreCase(pin)) {
				isValid = false;
				customer = bank.getBankAcounts().getBankCustomers().get(cardNumber);
				return true;
			} else {
				tries++;
				System.out.println("Invalid PIN Number: ");
			}

			if (tries == 3) {
				isValid = false;
				System.out.println("Account is locked. Please contact Call Center.");
			}
		}
		return false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((identities == null) ? 0 : identities.hashCode());
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
		ATM other = (ATM) obj;
		if (identities == null) {
			if (other.identities != null)
				return false;
		} else if (!identities.equals(other.identities))
			return false;
		return true;
	}

	public String GetIdentities() {
		return identities;
	}

}
