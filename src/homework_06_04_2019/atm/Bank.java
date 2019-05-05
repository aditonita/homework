package homework_06_04_2019.atm;

import java.util.*;

public class Bank {
	public static void start(Scanner sc) {
		char choice;
		boolean isExit = false;
		System.out.println("1 - add new Client, his account and card\n" + "2 - add new account for an existing client\n"
				+ "3 - add new card for an existing account\n" + "4 - set inactive an exising card\n"
				+ "5 - set inactive an existing account\n" + "6 - change client adress\n"
				+ "7 - depunere numerar la ghiseu\n" + "8 - extragere numerar la ghiseu\n");
		while (!isExit) {
			choice = sc.next().charAt(0);
			switch (choice) {
			case '1':
				customerAction(sc, "addNew");
				break;
			case '2':
				accountAction(sc, "addNew");
				break;
			case '3':
				cardAction(sc, "addNew");
				break;
			case '4':
				cardAction(sc, "delete");
				break;
			case '5':
				accountAction(sc, "delete");
				break;
			case '6':
				customerAction(sc, "newAddress");
				break;
			case '7':
				cashDeposit(sc);
				break;
			case '8':
				cashWithdraw(sc);
				break;
			case 'x':
				isExit = true;
				break;
			case 'X':
				isExit = true;
				break;
			}
		}
	}

	private static void cashWithdraw(Scanner sc) {
		List<Customer> clients = Customers.getClientsFromDatabase();
		clients.forEach(c -> System.out.println(
				c.getClientId() + " - " + c.getFirstName() + " - " + c.getLastName() + " - " + c.getAddress()));
		System.out.println("Enter client cnp: ");
		String cnp = sc.nextLine();
		Customer customer = Customers.getClientFromDatabase(cnp);
		List<Account> accounts = Accounts.getAccountsFromDatabase(customer);
		accounts.forEach(a -> System.out.format("%s - %s - %s - %s", a.getClientId(), a.getAccountId(),
				a.getAccountNumber(), a.getAmount()));
		System.out.println("Select account ID: ");
		int accountId = sc.nextInt();
		Account account = Accounts.getAccountById(accountId);
		System.out.println("Enter value: ");
		double money = sc.nextDouble();
		double existing = account.getAmount();
		account.setAmount(existing - money - money * 5 / 100);
		account.update();
	}

	private static void cashDeposit(Scanner sc) {
		List<Customer> clients = Customers.getClientsFromDatabase();
		clients.forEach(c -> System.out.println(
				c.getClientId() + " - " + c.getFirstName() + " - " + c.getLastName() + " - " + c.getAddress()));
		System.out.println("Enter client cnp: ");
		String cnp = sc.nextLine();
		Customer customer = Customers.getClientFromDatabase(cnp);
		List<Account> accounts = Accounts.getAccountsFromDatabase(customer);
		accounts.forEach(a -> System.out.format("%s - %s - %s - %s", a.getClientId(), a.getAccountId(),
				a.getAccountNumber(), a.getAmount()));
		System.out.println("Select account ID: ");
		int accountId = sc.nextInt();
		Account account = Accounts.getAccountById(accountId);
		System.out.println("Enter value: ");
		double money = sc.nextDouble();
		double existing = account.getAmount();
		account.setAmount(existing + money - money * 5 / 100);
		account.update();
	}

	private static void cardAction(Scanner sc, String action) {
		List<Account> accounts = new ArrayList<>();
		List<Card> cards = new ArrayList<>();
		Database db = new Database();
		System.out.println("Enter client cnp: ");
		Customer client = db.getClientById(sc.nextLine());
		accounts = db.getCustomerAccounts(client);
		accounts.forEach(a -> System.out.println(a.getAccountId() + " - " + a.getAccountNumber()));
		System.out.println("Enter account ID: ");
		int accountId = sc.nextInt();
		Account account = db.getAccountById(accountId);
		cards = db.getAccountCards(account);
		cards.forEach(c -> System.out.println(c.getCardId() + " - " + c.getCardNumber()));
		if (action == "addNew") {
			System.out.println("Enter card number: ");
			String cardNumber = sc.nextLine();
			Card card = new Card(accountId, cardNumber, "1234", true);
			db.newCustomerCard(account, card);
		}
		if (action == "delete") {
			System.out.println("Enter Card ID: ");
			int cardId = sc.nextInt();
			Card card = db.getCardById(cardId);
			card.setActive(false);
			db.updateCustomerCard(card);
		}
	}

	private static void accountAction(Scanner sc, String action) {
		List<Account> accounts = new ArrayList<>();
		Database db = new Database();
		System.out.println("Enter client cnp: ");
		Customer client = db.getClientById(sc.nextLine());
		accounts = db.getCustomerAccounts(client);
		accounts.forEach(a -> System.out.println(a.getAccountId() + " - " + a.getAccountNumber()));
		if (action == "addNew") {
			System.out.println("Enter account number: ");
			String accountNumber = sc.nextLine();
			Account account = new Account(client.getClientId(), accountNumber, 0, true);
			db.newCustomerAccount(client, account);
		}
		if (action == "delete") {
			System.out.println("Enter account ID: ");
			int accountId = sc.nextInt();
			Account account = db.getAccountById(accountId);
			account.setActive(false);
			db.updateCustomerAccount(account);
		}
	}

	private static void customerAction(Scanner sc, String action) {
		Database db = new Database();
		if (action == "addNew") {
			Customer newClient = readClient(sc);
			Account newAccount = readAccount(newClient, sc);
			Card newCard = readCard(newAccount, sc);
			db.newCustomer(newClient, newAccount, newCard);
		}
		if (action == "newAddress") {
			System.out.println("Enter CNP: ");
			String cnp = sc.nextLine();
			Customer client = db.getClientById(cnp);
			System.out.println("Enter new address: ");
			String address = sc.nextLine();
			client.setAddress(address);
			db.updateCustomerAddress(client);
		}
	}

	private static Customer readClient(Scanner sc) {
		System.out.println("Enter CNP: ");
		String cnp = sc.next();
		System.out.println("Enter first name: ");
		String firstName = sc.next();
		System.out.println("Enter last name: ");
		String lastName = sc.next();
		System.out.println("Enter address: ");
		String address = sc.next();
		return new Customer(cnp, firstName, lastName, address);
	}

	private static Account readAccount(Customer client, Scanner sc) {
		System.out.println("Enter account number: ");
		String accountNumber = sc.next();
		System.out.println(accountNumber);
		int accountId = (new Database()).maxAccountId();
		return new Account(accountId, client.getClientId(), accountNumber, 0, true);
	}

	private static Card readCard(Account account, Scanner sc) {
		System.out.println("Enter card number: ");
		String cardNumber = sc.next();
		System.out.println(cardNumber);
		return new Card(account.getAccountId(), cardNumber, "1234", true);
	}
}

