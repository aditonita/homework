package tema1;

import java.util.Scanner;

public class sumOfDigits {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Sum of the digits of an number [integer] > enter the number");
		int rezultat = 0; 
		int numar = Integer.parseInt(sc.next());
		
		while(numar > 0) {
			rezultat = rezultat + (numar % 10);
			numar = numar / 10;
		}
		
		System.out.println("suma cifrelor este: " + rezultat);
	}

}
