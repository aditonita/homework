package homework_06_04_2019.atm;

import java.util.*;

public class Atm {
	private static Scanner sc = new Scanner(System.in);

	public static void start() {
		System.out.println("Enter card number: ");
		String cardNumber = sc.nextLine();
		Customer client = Customers.getClientByCardNumber(cardNumber);
		Account account = Accounts.getAccountByCardNumber(cardNumber);
		Card card = Cards.getCardByCardNumber(cardNumber);
		char choice;
		boolean isExit = false;
		System.out.println("Welcome " + client.getLastName() + " " + client.getFirstName() + "\n" + "Press: \n"
				+ "1 - Deposit\n" + "2 - Withdraw\n" + "3 - Account information\n" + "4 - change PIN\n" + "x - Exit");
		while (!isExit) {
			choice = sc.next().charAt(0);
			switch (choice) {
			case '1':
				cardDeposit(account);
				break;
			case '2':
				cardWithdraw(account);
				break;
			case '3':
				accountInformation(account);
				break;
			case '4':
				cangePinNumber(card);
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

	private static void cangePinNumber(Card card) {
		System.out.println("Enter new PIN number: ");
		sc.nextLine();
		card.update();
	}

	private static void accountInformation(Account account) {
		System.out.println("Available: " + account.getAmount());
	}

	private static void cardWithdraw(Account account) {
		System.out.println("Enter money: ");
		double money = sc.nextDouble();
		double exist = account.getAmount();
		account.setAmount(exist - money);
		account.update();
	}

	private static void cardDeposit(Account account) {
		System.out.println("Enter money: ");
		double money = sc.nextDouble();
		double exist = account.getAmount();
		account.setAmount(exist + money);
		Accounts.updateAccount(account);
	}
}
