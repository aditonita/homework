package homework_19_01_2019;

import java.util.Random;

public class Matrice {

	int[][] matrice = new int[5][5];

	Random random = new Random();

	public static void main(String[] args) {
		Matrice m = new Matrice();
		m.addValueMatrice(); // mai intai apelam metoda addValueMatrice()
								// pentru a initializa matricea cu valori
		m.showMatrice();
		System.out.print("Linia 1 a matricei este: ");
		m.showPrimaLinieMatrice();
		System.out.println("\nMax de pe diag principala este: " + m.maxDiagPrincipala());
		System.out.println("Max de pe diag secundara este: " + m.maxDiagSecundara());
		System.out.println("Suma elementelor de pe diag principala este: " + m.sumDiagPrincipala());
		System.out.println("Suma elementelor de pe diag secundara este: " + m.sumDiagSecundara());

	}

	public void addValueMatrice() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				matrice[i][j] = random.nextInt(100);
				// System.out.println(matrice[i][j]);
			}
		}
	}

	public void showMatrice() { // trebuie sa inceapa cu litera mica
		printHeader();
		for (int i = 0; i < 5; i++) {
			printBar();
			for (int j = 0; j < 5; j++) {
				System.out.print("\t" + matrice[i][j] + "\t");
			}
			if (i != matrice.length - 1) {
				System.out.println("|\n");
			}else {
				System.out.println("|");
			}
		}
		printHeader();
	}

	private void printBar() {
		System.out.print("|");
	}

	private void printHeader() {
		System.out.println(" __ \t\t\t\t\t\t\t\t\t      __\n");
	}

	public void showPrimaLinieMatrice() {
		for (int j = 0; j < 5; j++) {
			//System.out.print(matrice[1][j] + "\t");
			System.out.print(matrice[0][j] + "\t"); //trebuie 0 ca sa fie prima linie
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
			if (matrice[i][j] > max) {
				max = matrice[i][j];
			}
		}
		return max;
	}

	public int maxDiagSecundara() {
		int max = Integer.MIN_VALUE;
		// for (int i = 5, j = 5; i >= 0 || j >= 0; i--, j--) {
		// eroare indexul trebuie sa fie pana la 4
		for (int i = 4, j = 4; i >= 0 || j >= 0; i--, j--) {
			if (matrice[i][j] > max) {
				max = matrice[i][j];
			}
		}
		return max;
	}
}
