package homework_23_02_2019;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Atms {

	private static Set<ATM> atms = new HashSet<>();

	private static void addAtm(String identity) {
		atms.add(new ATM(identity));
	}

	public static ATM getAtm(String identity) {
		ATM atm = new ATM(identity);
		if (!atms.contains(atm)) {
			addAtm(identity);
		}
		return atm;
	}

	public static void atmsToString() {
		Iterator<ATM> it = atms.iterator();
		while (it.hasNext()) {
			System.out.print(it.next().GetIdentities() + "  ");
		}
	}
}
