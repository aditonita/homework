package homework_06_04_2019.atm;

import java.util.List;

public class Cards {

	public static List<Card> getCardsFromDatabase(Account account) {
		Database db = new Database();
		return db.getAccountCards(account);
	}

	public static Card getCardByCardNumber(String cardNumber) {
		Database db = new Database();
		return db.getCardByCardNumber(cardNumber);
	}

}
