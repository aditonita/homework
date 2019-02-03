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
		matriceTst.addValueMatrice();
		matriceTst.showMatrice();
		int result = matriceTst.sumDiagPrincipala();
		System.out.println(result);
	}

//	public void testSumDiagSecundara() {

//		int result = matriceTst.sumDiagSecundara();
//		System.out.println(result);
//	}
}
