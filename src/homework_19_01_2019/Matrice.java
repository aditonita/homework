package homework_19_01_2019;

import java.util.Random;

public class Matrice {

	int[][] matrice = new int[5][5];

	Random random = new Random();

	public void addValueMatrice() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				matrice[i][j] = random.nextInt(100);
				System.out.println(matrice[i][j]);
			}
		}
	}

	public void ShowMatrice() {
		for(int i =0 ;i<5;i++) {
			for(int j=0;j<5;j++) {
				System.out.print(matrice[i][j] + "\t");
			}
			System.out.println("");
		}
	}
	
	public void showLiniaMatrice() {
		for (int j = 0; j < 5; j++) {
			System.out.println(matrice[1][j]);
		}
	}

	public int sumDiagPrincipala() {
		int sum = 0;
		for (int i = 0, j = 0; i < 5 || j < 5; i++, j++) {
			sum += matrice[i][j];
		}
		return sum;
	}

	public int sumDiagSecundara() {
		int sum = 0;
		for (int i = 4, j = 4; i >= 0 || j >= 0; i--, j--) {
			sum += matrice[i][j];
		}
		return sum;
	}
	
	public int maxDiagPrincipala() {
		int max = Integer.MIN_VALUE;
		for (int i = 0, j = 0; i < 5 || j < 5; i++, j++) {
			if (matrice[i][j]>max) {
				max = matrice[i][j];
			}
		}
		return max;
	}
	
	public int maxDiagSecundara() {
		int max = Integer.MIN_VALUE;
		for (int i = 5, j = 5; i >= 0 || j >= 0; i--, j--) {
			if(matrice[i][j]>max) {
				max = matrice[i][j];
			}
		}
		return max;
	}
	
	public void MockMatrice(int[][] matriceMock) { //numele metodelor trebuie sa inceapa cu litera mare
		matrice = matriceMock;
	}
}
