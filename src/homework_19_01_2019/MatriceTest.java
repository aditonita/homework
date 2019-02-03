package homework_19_01_2019;

import junit.framework.TestCase;

public class MatriceTest extends TestCase {
	Matrice matriceTst = new Matrice();

//	public void testaddValueMatrice() {
//		matriceTst.addValueMatrice();
//	}

//	public void testShowMatrice() {

//		matriceTst.showMatrice();
//	}

	public void testSumDiagPrincipala() {
//		matriceTst.addValueMatrice();
//		matriceTst.ShowMatrice();
//		int result = matriceTst.sumDiagPrincipala();
//		System.out.println(result);
	}

//	public void testSumDiagSecundara() {

//		int result = matriceTst.sumDiagSecundara();
//		System.out.println(result);
//	}
	
	public void testMaxDiagPricipala() {
		int[][] matrice = {{0,1,2,3,4},{0,1,2,3,4},{0,1,2,3,4},{0,1,2,3,4},{0,1,2,3,4}};
		Matrice m = new Matrice();
		m.MockMatrice(matrice);
		System.out.println(m.maxDiagPrincipala());
		System.out.println(m.sumDiagSecundara());
	}
}
