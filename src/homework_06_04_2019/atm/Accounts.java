package homework_06_04_2019.atm;

import java.util.*;

public class Accounts {
//	private static Scanner sc = new Scanner(System.in);

	public static List<Account> getAccountsFromDatabase(Customer client) {
		Database db = new Database();
		return db.getCustomerAccounts(client);
	}

	public static Account getAccountById(int accountId) {
		Database db = new Database();
		return db.getAccountById(accountId);
	}

	public static Account getAccountByCardNumber(String cardNumber) {
		Database db = new Database();
		return db.getAccountByCardNumber(cardNumber);
	}

	public static void updateAccount(Account account) {
		Database db = new Database();
		db.updateCustomerAccount(account);
	}

}
