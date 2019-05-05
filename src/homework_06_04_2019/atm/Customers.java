package homework_06_04_2019.atm;

import java.util.*;

public class Customers {
	private static Scanner sc = new Scanner(System.in);

	public static List<Customer> getClientsFromDatabase() {
		Database db = new Database();
		System.out.println("Enter first name: ");
		String firstName = sc.nextLine();
		System.out.println("Enter last name: ");
		String lastName = sc.nextLine();
		return db.getClientsByName(firstName, lastName);
	}

	public static Customer getClientFromDatabase(String cnp) {
		Database db = new Database();
		return db.getClientById(cnp);
	}

	public static Customer getClientByCardNumber(String cardNumber) {
		Database db = new Database();
		return db.getClientByCardNumber(cardNumber);
	}

}
