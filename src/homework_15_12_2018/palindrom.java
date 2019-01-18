package tema1;

import java.util.Scanner;

public class palindrom {

	static Scanner sc = new Scanner(System.in);
	
	public static void main (String[] args) {
		System.out.println("Verify if your string/number is a palindrom > enter string");
		
		String word = sc.nextLine();
		
		int lengthWord;
		lengthWord = word.length();
		boolean isPalindrom = true;
		int k = 0;
		
		char[] wordChars = new char[lengthWord];
		
		for(int i=0;i<lengthWord;i++) {
			wordChars[i] = word.charAt(i);
		}
		
		while((isPalindrom) && (k < lengthWord/2)) {
			//System.out.println(wordChars[k] + " - " + wordChars[lengthWord-1-k]);
			if(wordChars[k] != wordChars[lengthWord-1-k]) {
				isPalindrom = false;
			}
			k++;
		}
		if(isPalindrom) {
			System.out.println("Este palindrom");
		}else {
			System.out.println("NU ESTE PALINDROM");
		}
	}
}
