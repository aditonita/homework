/**
 * 
 */
package homework_06_04_2019.atm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * @author Adi
 *
 */
public class Solution {
	private static Scanner sc = new Scanner(System.in);
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		char choice;
		boolean isExit = false;
		System.out.println("Press b - Bank\n" + "Press a - atm\n" + "Press x - Exit");
		
		while (!isExit) {
			choice = sc.next().charAt(0);
			switch (choice) {
			case 'b':
				Bank.start(sc);
				break;
			case 'a':
				Atm.start();
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

}
