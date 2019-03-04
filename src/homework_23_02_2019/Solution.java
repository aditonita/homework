package homework_23_02_2019;

import java.io.*;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ATM atm = null;
		
		Atms.getAtm("BT");
		Atms.getAtm("ING");
		Atms.getAtm("BCR");
		Atms.getAtm("Banca Romaneasca");

		System.out.println("Pick up an ATM from the list\n" + "or introduce your bank ATM\n");
		Atms.atmsToString();
		
		atm=Atms.getAtm(sc.nextLine());
		
		atm.start();
	}

}
