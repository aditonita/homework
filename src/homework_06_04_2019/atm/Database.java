package homework_06_04_2019.atm;

import java.sql.*;
import java.util.*;

public class Database {

	public List<Customer> getClientsByName(String firstName, String lastName) {
		List<Customer> clients = new ArrayList<>();
		String clientId;
		String clientFirstName;
		String clientLastName;
		String clientAddress;
		String[] names;
		String clientName = lastName + "," + firstName;
		String query = "SELECT * FROM clients c WHERE c.client_name = ?";

		try (Connection connection = getConnection()) {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, clientName);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				clientId = rs.getString("client_id");
				names = rs.getString("client_name").split(",");
				clientFirstName = names[1];
				clientLastName = names[0];
				clientAddress = rs.getString("client_address");
				Customer customer = new Customer(clientId, clientFirstName, clientLastName, clientAddress);
				clients.add(customer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return clients;
	}

	public Customer getClientById(String clientId) {
		String query = "SELECT c.client_id, c.client_name, c.client_address FROM clients c WHERE c.client_id =  ?";
		try (Connection conn = getConnection()) {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, clientId);
			ResultSet rs = ps.executeQuery();
			if (rs.first()) {
				return new Customer(rs.getString("client_id"), rs.getString("client_name").split(",")[1],
						rs.getString("client_name").split(",")[0], rs.getString("client_address"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Account> getCustomerAccounts(Customer customer) {
		List<Account> accounts = new ArrayList<>();
		String query = "SELECT a.account_id, a.client_id, a.acount_number, a.amount, a.active FROM acounts a WHERE a.client_id = ?";
		try (Connection conn = getConnection()) {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, customer.getClientId());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				accounts.add(new Account(rs.getInt("acount_id"), rs.getString("client_id"),
						rs.getString("acount_number"), rs.getDouble("amount"), rs.getBoolean("active")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return accounts;
	}

	public List<Card> getAccountCards(Account account) {
		List<Card> cards = new ArrayList<>();
		String query = "SELECT ci.card_id, ci.acount_id, ci.card_number, ci.card_pin, ci.active FROM cards_info ci WHERE ci.acount_id = ?";
		try (Connection conn = getConnection()) {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, account.getAccountId());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				cards.add(new Card(rs.getInt("card_id"), rs.getInt("acount_id"), rs.getString("card_number"),
						rs.getString("card_pin"), rs.getBoolean("active")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return cards;
	}

	public Customer getClientByCardNumber(String cardNumber) {
		String query = "SELECT c.client_id, c.client_name, c.client_address FROM clients c WHERE c.client_id IN ("
				+ "  SELECT a.client_id FROM acounts a WHERE a.account_id IN ("
				+ "    SELECT ci.acount_id FROM cards_info ci WHERE ci.card_number = ?))";
		try (Connection conn = getConnection()) {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, cardNumber);
			ResultSet rs = ps.executeQuery();
			if (rs.first()) {
				return new Customer(rs.getString("client_id"), rs.getString("client_name").split(",")[1],
						rs.getString("client_name").split(",")[0], rs.getString("client_address"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Account getAccountByCardNumber(String cardNumber) {
		String query = "SELECT a.account_id, a.client_id, a.acount_number, a.amount, a.active FROM acounts a WHERE a.account_id IN ("
				+ "  SELECT ci.acount_id FROM cards_info ci WHERE ci.card_number = ?)";
		try (Connection conn = getConnection()) {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, cardNumber);
			ResultSet rs = ps.executeQuery();
			if (rs.first()) {
				return new Account(rs.getInt("account_id"), rs.getString("client_id"), rs.getString("acount_number"),
						rs.getDouble("amount"), rs.getBoolean("active"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean newCustomer(Customer customer, Account account, Card card) {
		String query = "INSERT INTO clients (client_id, client_name, client_address) VALUES (? ,? ,? )";
		try (Connection conn = getConnection()) {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, customer.getClientId());
			ps.setString(2, customer.getLastName() + "," + customer.getFirstName());
			ps.setString(3, customer.getAddress());
			int rows = ps.executeUpdate();
			if (rows > 0) {
				if (newAccount(account) == null) {
					deleteCustomer(customer);
					return false;
				} else if (newCard(card) == null) {
					deleteAccount(account);
					deleteCustomer(customer);
					return false;
				}
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	public void updateCustomerAddress(Customer customer) {
		String query = "UPDATE clients c SET c.client_address = ? WHERE c.client_id = ?";
		try (Connection conn = getConnection()) {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, customer.getAddress());
			ps.setString(2, customer.getClientId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void newCustomerAccount(Customer customer, Account account) {
		String query = "INSERT INTO acounts (account_id, client_id, acount_number, amount, active) VALUES (?, ?, ?, ?, ?)";
		try (Connection conn = getConnection()) {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, maxAccountId());
			ps.setString(2, customer.getClientId());
			ps.setString(3, account.getAccountNumber());
			ps.setDouble(4, account.getAmount());
			ps.setBoolean(5, account.isActive());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void newCustomerCard(Account account, Card card) {
		String query = "INSERT INTO cards_info (acount_id, card_number, card_pin, active) VALUES(?, ?, ?, ?)";
		try (Connection conn = getConnection()) {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, account.getAccountId());
			ps.setString(2, card.getCardNumber());
			ps.setString(3, card.getPinNumber());
			ps.setBoolean(4, card.isActive());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateCustomerAccount(Account account) {
//		String query = "UPDATE acounts a SET a.client_id=?, a.account_number=?, a.amount=?, a.active=? WHERE a.account_id=?";
		String query = "UPDATE acounts a SET a.amount=?, a.active=? WHERE a.account_id=?";
		try (Connection conn = getConnection()) {
			PreparedStatement ps = conn.prepareStatement(query);
//			ps.setString(1, account.getClientId());
//			ps.setString(2, account.getAccountNumber());
//			ps.setDouble(3, account.getAmount());
//			ps.setBoolean(4, account.isActive());
//			ps.setInt(5, account.getAccountId());
			ps.setDouble(1, account.getAmount());
			ps.setBoolean(2, account.isActive());
			ps.setInt(3, account.getAccountId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateCustomerCard(Card card) {
//		String query = "UPDATE cards_info c SET c.acount_id=?, c.card_number=? c.card_pin=? c.active=? WHERE c.card_id=?";
		String query = "UPDATE cards_info c SET c.card_pin=? c.active=? WHERE c.card_id=?";
		try (Connection conn = getConnection()) {
			PreparedStatement ps = conn.prepareStatement(query);
//			ps.setInt(1, card.getAccountId());
//			ps.setString(2, card.getCardNumber());
//			ps.setString(3, card.getPinNumber());
//			ps.setBoolean(4, card.isActive());
//			ps.setInt(5, card.getCardId());
			ps.setString(1, card.getPinNumber());
			ps.setBoolean(2, card.isActive());
			ps.setInt(3, card.getCardId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public int maxAccountId() {
		String query = "SELECT MAX(a.account_id) FROM acounts a";
		try (Connection conn = getConnection()) {
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			if (rs.first()) {
				return rs.getInt(1) + 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 1;
	}

	private Account newAccount(Account account) {
		String query = "INSERT INTO acounts (account_id, client_id, account_number, amount, active) VALUES (? ,? ,? ,?, ? )";
		try (Connection conn = getConnection()) {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, account.getAccountId());
			ps.setString(2, account.getClientId());
			ps.setString(3, account.getAccountNumber());
			ps.setDouble(4, account.getAmount());
			ps.setBoolean(5, account.isActive());
			int rows = ps.executeUpdate();
			if (rows > 0) {
				return account;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}

	private Card newCard(Card card) {
		String query = "INSERT INTO cards_info (acount_id, card_number, card_pin, active) VALUES (? ,? ,? ,? )";
		try (Connection conn = getConnection()) {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, card.getAccountId());
			ps.setString(2, card.getCardNumber());
			ps.setString(3, card.getPinNumber());
			ps.setBoolean(4, card.isActive());
			int rows = ps.executeUpdate();
			if (rows > 0) {
				return card;
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	private void deleteCustomer(Customer customer) {
		String query = "DELETE FROM clients WHERE client_id = ?";
		try (Connection conn = getConnection()) {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, customer.getClientId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void deleteAccount(Account account) {
		String query = "DELETE FROM acounts WHERE acount_id = ?";
		try (Connection conn = getConnection()) {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, account.getAccountId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private Connection getConnection() {
		DriverManager.setLoginTimeout(10);
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/atm", "root", "password");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Account getAccountById(int accountId) {
		String query = "SELECT account_id, client_id, account_number, amount, active FROM acounts WHERE account_id=?";
		try (Connection conn = getConnection()) {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, accountId);
			ResultSet rs = ps.executeQuery();
			if (rs.first()) {
				return new Account(rs.getInt("account_id"), rs.getString("client_id"), rs.getString("account_number"),
						rs.getDouble("amount"), rs.getBoolean("active"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Card getCardById(int cardId) {
		String query = "SELECT card_id, acount_id, card_number, card_pin, active FROM cards_info WHERE card_id = ?";
		try (Connection conn = getConnection()) {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, cardId);
			ResultSet rs = ps.executeQuery();
			if (rs.first()) {
				return new Card(rs.getInt("card_id"), rs.getInt("acount_id"), rs.getString("card_number"),
						rs.getString("card_pin"), rs.getBoolean("active"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Card getCardByCardNumber(String cardNumber) {
		Database db = new Database();
		return db.getCardByCardNumber(cardNumber);
	}
}
